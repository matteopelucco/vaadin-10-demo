package com.pelucco.vaadin.spring.techfriday;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;

// extending a Div --> HTML component will be a <div>
public class ReindeerComponent extends Composite<Div> implements HasComponents {

    public ReindeerComponent() {

        // images are taken from /src/main/webapp folder, 'webapp' folder should be there at application startup
        add(new Image("hero-reindeer.svg", "alt text can be whatever.."));
        add(new Label("Hello World!"));

    }

}
