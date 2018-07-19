package com.pelucco.vaadin.spring.techfriday3;

import com.vaadin.flow.templatemodel.TemplateModel;

public interface SmartButtonModel extends TemplateModel {

    String getValue();

    void setValue(String value);

}
