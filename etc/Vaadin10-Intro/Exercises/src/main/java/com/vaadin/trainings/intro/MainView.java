package com.vaadin.trainings.intro;


import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;

@Route("")
@Theme(Lumo.class)
@BodySize(height = "100vh", width = "100vw")
public class MainView extends VerticalLayout {

	public MainView() {
		setMargin(true);
		// TODO Add your code here
	}

}
