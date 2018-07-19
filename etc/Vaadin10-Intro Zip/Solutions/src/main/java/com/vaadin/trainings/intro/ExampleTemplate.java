package com.vaadin.trainings.intro;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.polymertemplate.EventHandler;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.AllowClientUpdates;
import com.vaadin.trainings.intro.ExampleTemplate.ExampleModel;
import com.vaadin.flow.templatemodel.TemplateModel;

/**
 * Simple template example.
 */
@Tag("example-template")
@HtmlImport("example-template.html")
public class ExampleTemplate extends PolymerTemplate<ExampleModel> {

	/**
	 * Template model which defines the single "value" property.
	 */
	public interface ExampleModel extends TemplateModel {

		void setValue(String value);

		String getValue();
	}

	/**
	 * Public setter to use from other Java classes. Not mandatory, but useful.
	 */
	public void setValue(String value) {
		getModel().setValue(value);
	}

	@EventHandler
	private void handleClick() {
		try {
			Thread.sleep(2000);
			getModel().setValue("Vaadin!");
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}
	}
}
