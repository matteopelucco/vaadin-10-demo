package com.pelucco.vaadin.spring.tutorial;

import com.pelucco.vaadin.spring.ExampleTemplate;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@HtmlImport("styles/shared-styles.html")
@Route("tutorial")
public class TutorialView extends VerticalLayout {

    CustomerService customerService;

    // grid definition
    private Grid<Customer> grid = new Grid<>();

    public TutorialView(@Autowired CustomerService customerService) {

        this.customerService = customerService;
        grid.setSizeFull();

        grid.addColumn(Customer::getFirstName).setHeader("First name");
        grid.addColumn(Customer::getLastName).setHeader("Last name");
        grid.addColumn(Customer::getStatus).setHeader("Status");

        add(grid);
        setHeight("100vh");
        updateList();

    }

    public void updateList() {
        grid.setItems(customerService.findAll());
    }
}
