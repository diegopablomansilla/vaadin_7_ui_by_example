package richtextarea;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Label;
import com.vaadin.ui.RichTextArea;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
@SuppressWarnings("serial")
public class RichtextareaUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	RichTextArea richText = new RichTextArea("Rich text area:");
		richText.setImmediate(true);
		Label label = new Label(richText, ContentMode.HTML);

		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(richText);
		layout.addComponent(label);
		setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "RichtextareaUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = RichtextareaUI.class, productionMode = false)
    public static class RichtextareaUIServlet extends VaadinServlet {
    }
}
