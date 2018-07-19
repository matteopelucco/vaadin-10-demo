package com.pelucco.vaadin.spring;

import com.pelucco.vaadin.spring.components.MyCustomComponent;
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

    public CustomView() {

        MyCustomComponent comp = new MyCustomComponent("this is my value");

        add(comp);
        setClassName("main-layout");

    }

}
