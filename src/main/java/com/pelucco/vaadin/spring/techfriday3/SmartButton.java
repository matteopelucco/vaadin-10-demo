package com.pelucco.vaadin.spring.techfriday3;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.EventHandler;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

@Tag("smartbutton-template")
@HtmlImport("src/smartbutton-template.html")
public class SmartButton extends PolymerTemplate<SmartButtonModel> {

    @EventHandler
    private void handleClick() {
        try {
            Thread.sleep(2000);
            getModel().setValue("This is the server response!");
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }

}
