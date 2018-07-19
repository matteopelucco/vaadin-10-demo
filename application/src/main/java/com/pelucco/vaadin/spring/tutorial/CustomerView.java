package com.pelucco.vaadin.spring.tutorial;

import com.pelucco.vaadin.spring.ExampleTemplate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@HtmlImport("styles/shared-styles.html")
@Route("tutorial")
public class CustomerView extends VerticalLayout {

    private CustomerService customerService;
    private Grid<Customer> grid = new Grid<>();
    private TextField filterInput = new TextField();
    private Button clearBtn = new Button();
    private Button addBtn = new Button();

    private CustomerForm form = new CustomerForm(this);

    public CustomerView(@Autowired CustomerService customerService) {

        this.customerService = customerService;

        grid.setSizeFull();
        grid.addColumn(Customer::getFirstName).setHeader("First name");
        grid.addColumn(Customer::getLastName).setHeader("Last name");
        grid.addColumn(Customer::getStatus).setHeader("Status");

        filterInput.setPlaceholder("Filter by name...");
        filterInput.setValueChangeMode(ValueChangeMode.EAGER);
        filterInput.addValueChangeListener(e -> updateList());

        clearBtn.setIcon(new Icon(VaadinIcon.CLOSE_CIRCLE));
        clearBtn.addClickListener(e -> filterInput.clear());

        addBtn.setText("Add new customer");
        addBtn.addClickListener(e -> {
            grid.asSingleSelect().clear();
            form.setCustomer(new Customer());
        });

        // add select event
        grid.asSingleSelect().addValueChangeListener(event -> {
            form.setCustomer(event.getValue());
        });

        // filter text
        HorizontalLayout filtering = new HorizontalLayout(filterInput, clearBtn); // filterInput, clearBtn

        // page main section
        HorizontalLayout main = new HorizontalLayout(grid, form); // grid, form
        main.setAlignItems(Alignment.START);
        main.setSizeFull();

        // page toolbar
        HorizontalLayout toolbar = new HorizontalLayout(filtering, addBtn); // filtering, addBtn

        add(toolbar, main); // toolbar, main

        setHeight("100vh");
        updateList();
    }

    public void updateList() {
        grid.setItems(customerService.findAll(filterInput.getValue()));
    }

    public CustomerService getCustomerService() {
        return customerService;
    }
}
