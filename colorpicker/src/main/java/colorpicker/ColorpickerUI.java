package colorpicker;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.ColorPicker;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@SuppressWarnings("serial")
@Theme("mytheme")
public class ColorpickerUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);
		
		ColorPicker picker = new ColorPicker("Select a color");
		picker.setHeight("100%");

		layout.addComponent(picker);
	}

    @WebServlet(urlPatterns = "/*", name = "ColorpickerUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = ColorpickerUI.class, productionMode = false)
    public static class ColorpickerUIServlet extends VaadinServlet {
    }
}
