package datefield;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.datefield.Resolution;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Label;
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
@SuppressWarnings("serial")
@Theme("mytheme")
public class DatefieldUI extends UI {

	@Override
	protected void init(VaadinRequest vaadinRequest) {

		DateField dateField = new DateField("Select a date");
		// InlineDateField dateField = new InlineDateField("Select a date");

		dateField.setResolution(Resolution.SECOND);
		 dateField.setDateFormat("dd/MM/yyyy");

		Label label = new Label();

		VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.addComponents(dateField, label);
		setContent(layout);
		
		label.setValue(dateField.getDateFormat() + " XXXXXXXXXXXXX");

	}

	@WebServlet(urlPatterns = "/*", name = "DatefieldUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = DatefieldUI.class, productionMode = false)
	public static class DatefieldUIServlet extends VaadinServlet {
	}
}
