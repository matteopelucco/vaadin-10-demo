package com.pelucco.vaadin.spring.techfriday3;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("techfriday3")
public class TechFridayView3 extends VerticalLayout {

    public TechFridayView3() {


        add(new Label("Hello World!"));
        add(new SmartButton());
        add(new Button("Click me!", evt -> {
            add(new Paragraph("Clicked!"));
        }));

    }
}
