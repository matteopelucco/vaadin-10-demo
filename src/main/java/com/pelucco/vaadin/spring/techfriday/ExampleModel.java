package com.pelucco.vaadin.spring.techfriday;

import com.vaadin.flow.templatemodel.TemplateModel;

public interface ExampleModel extends TemplateModel {

    String getValue();

    void setValue(String value);

}
