package com.pelucco.vaadin.spring.techfriday;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("techfriday")
public class TechFridayView extends VerticalLayout {

    public TechFridayView() {

        add(new Paragraph("Hello World!"));
        add(new Button("Click me!", evt -> {
            add(new Label("Button clicked!"));
        }));

    }
}
