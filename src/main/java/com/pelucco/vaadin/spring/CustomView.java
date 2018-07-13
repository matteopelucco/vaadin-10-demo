package com.pelucco.vaadin.spring;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The main view contains a simple label element and a template element.
 */
@HtmlImport("styles/shared-styles.html")
@Route("custom")
public class CustomView extends VerticalLayout {

    public CustomView(@Autowired ExampleTemplate template) {
        // This is just a simple label created via Elements API
        Button button = new Button("Click me", event -> template.setValue("Clicked!"));
        // This is a simple template example
        add(button, template);
        setClassName("main-layout");

    }

}
