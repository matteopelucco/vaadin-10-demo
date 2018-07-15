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

    CustomerService customerService;

    // grid
    private Grid<Customer> grid = new Grid<>();

    // search input
    private TextField filterText = new TextField();

    private CustomerForm form = new CustomerForm(this);

    public CustomerView(@Autowired CustomerService customerService) {

        this.customerService = customerService;


        grid.setSizeFull();

        grid.addColumn(Customer::getFirstName).setHeader("First name");
        grid.addColumn(Customer::getLastName).setHeader("Last name");
        grid.addColumn(Customer::getStatus).setHeader("Status");

        filterText.setPlaceholder("Filter by name...");
        filterText.setValueChangeMode(ValueChangeMode.EAGER);
        filterText.addValueChangeListener(e -> updateList());

        Button clearFilterTextBtn = new Button(new Icon(VaadinIcon.CLOSE_CIRCLE));
        clearFilterTextBtn.addClickListener(e -> filterText.clear());

        HorizontalLayout filtering = new HorizontalLayout(filterText, clearFilterTextBtn);

        Button addCustomerBtn = new Button("Add new customer");
        addCustomerBtn.addClickListener(e -> {
            grid.asSingleSelect().clear();
            form.setCustomer(new Customer());
        });


        HorizontalLayout toolbar = new HorizontalLayout(filtering, addCustomerBtn);

        HorizontalLayout main = new HorizontalLayout(grid, form);
        main.setAlignItems(Alignment.START);
        main.setSizeFull();

        // add select event
        grid.asSingleSelect().addValueChangeListener(event -> {
            form.setCustomer(event.getValue());
        });

        add(toolbar, main);
        setHeight("100vh");
        updateList();
    }

    public void updateList() {
        grid.setItems(customerService.findAll(filterText.getValue()));
    }

    public CustomerService getCustomerService() {
        return customerService;
    }
}
