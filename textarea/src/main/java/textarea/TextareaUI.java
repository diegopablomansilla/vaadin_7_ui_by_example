package textarea;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
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
public class TextareaUI extends UI implements ValueChangeListener {

	@Override
	protected void init(VaadinRequest request) {
		// our TextArea component
		TextArea textArea = new TextArea(
				"Enter some multi-lined text and press TAB:");
		textArea.addValueChangeListener(this);
		textArea.setImmediate(true);

		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(textArea);
		setContent(layout);
	}

	@Override
	public void valueChange(ValueChangeEvent event) {
		String userText = event.getProperty().getValue().toString();
		Notification.show("This is it: " + userText);
	}

	@WebServlet(urlPatterns = "/*", name = "TextareaUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = TextareaUI.class, productionMode = false)
	public static class TextareaUIServlet extends VaadinServlet {
	}
}
