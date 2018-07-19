package com.pelucco.vaadin.spring.techfriday2;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("techfriday2")
public class TechFridayView2 extends VerticalLayout {

    public TechFridayView2() {

        add(new ReindeerComponent());
        add(new Button("Click me!", evt -> {
            add(new Paragraph("Clicked!"));
        }));

    }
}
