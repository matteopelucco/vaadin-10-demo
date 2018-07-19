package com.pelucco.vaadin.spring.techfriday2;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;

public class ReindeerComponent extends Composite<Div> implements HasComponents {

    public ReindeerComponent() {

        add(new Image("hero-reindeer.svg", "This is a reindeer!"));
        add(new Label("Hello World!"));

    }
}
