package com.pelucco.vaadin.spring.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Synchronize;
import com.vaadin.flow.component.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Tag("input")
public class MyCustomComponent extends Component {

    Logger log = LoggerFactory.getLogger(MyCustomComponent.class);
    public MyCustomComponent(String value) {
        getElement().setProperty("value", value);
    }

    @Synchronize("change")
    public String getValue() {

        log.info("Get Value");
        return getElement().getProperty("value");

    }
    public void setValue(String value) {
        log.info("Set Value");
        getElement().setProperty("value", value);
    }
}
