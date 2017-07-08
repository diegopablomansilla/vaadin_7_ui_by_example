package optiongroup;

import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TwinColSelect;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
@SuppressWarnings("serial")
public class OptiongroupUI extends UI implements ValueChangeListener {

	@Override
	protected void init(VaadinRequest request) {
		// an array with the options
		ArrayList<String> answers = new ArrayList<String>();
		answers.add("Vaadin beans");
		answers.add("Session beans");
		answers.add("Enterprise App for Vaadin beans");
		answers.add("Message-driven beans");

		// our OptionGroup component
		OptionGroup og = new OptionGroup("Two kinds of EJBs in Java EE are:",
				answers);
//		TwinColSelect og = new TwinColSelect("Two kinds of EJBs in Java EE are:",
//				answers);
		og.addValueChangeListener(this);
		og.setImmediate(true);
		// FIXME: og should be multi select!
//		og.setMultiSelect(true);

		// our main layout
		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(og);
		setContent(layout);
	}

	@Override
	public void valueChange(ValueChangeEvent event) {
		String answer = event.getProperty().getValue().toString();
		Notification.show("Your answer: " + answer);
	}

	@WebServlet(urlPatterns = "/*", name = "OptiongroupUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = OptiongroupUI.class, productionMode = false)
	public static class OptiongroupUIServlet extends VaadinServlet {
	}
}
