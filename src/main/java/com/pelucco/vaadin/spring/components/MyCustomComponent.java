package com.pelucco.vaadin.spring.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Synchronize;
import com.vaadin.flow.component.Tag;

@Tag("input")
public class MyCustomComponent extends Component {

    public MyCustomComponent(String value) {
        getElement().setProperty("value", value);
    }

    @Synchronize("change")
    public String getValue() {
        return getElement().getProperty("value");
    }
    public void setValue(String value) {
        getElement().setProperty("value", value);
    }
}
