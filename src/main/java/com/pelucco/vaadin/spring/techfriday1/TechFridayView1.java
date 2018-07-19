package com.pelucco.vaadin.spring.techfriday1;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("techfriday1")
public class TechFridayView1 extends VerticalLayout {

    public TechFridayView1() {

        add(new Label("Hello World!"));
        add(new Button("Click me!", evt -> {
            add(new Paragraph("Clicked!"));
        }));

    }
}
