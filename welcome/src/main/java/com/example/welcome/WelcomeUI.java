package com.example.welcome;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class WelcomeUI extends UI {

	protected void init(VaadinRequest request) {
		
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		final TextField name1 = new TextField("Somebody's name");
		final TextField name2 = new TextField("somebody's name");
		layout.addComponent(name1);
		layout.addComponent(name2);

		Button button = new Button("Click Me");
		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				String phrase = getFunnyPhrase(name1.getValue(),
						name2.getValue());
				layout.addComponent(new Label(phrase));
			}
		});
		layout.addComponent(button);
	}

	public String getFunnyPhrase(String name1, String name2) {
		String[] verbs = new String[] { "eats", "melts", "breaks", "whshes",
				"sells" };
		String[] bodyParts = new String[] { "head", "hands", "waist", "eyes",
				"elbows" };
		return name1 + " " + verbs[(int) (Math.random() * 100 % verbs.length)]
				+ " " + name2 + "'s "
				+ bodyParts[(int) (Math.random() * 100 % verbs.length)];
	}

	@WebServlet(urlPatterns = "/*", name = "WelcomeUI", asyncSupported = true)
	@VaadinServletConfiguration(ui = WelcomeUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}

}
