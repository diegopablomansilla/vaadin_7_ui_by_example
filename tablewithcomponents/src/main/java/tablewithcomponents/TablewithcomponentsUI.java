package tablewithcomponents;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
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
public class TablewithcomponentsUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Table table = new Table();
		table.setPageLength(0);

		table.addContainerProperty("Text fields", TextField.class, null);
		table.addContainerProperty("Check boxes", CheckBox.class, null);

		table.addItem(new Object[] { new TextField(), new CheckBox() }, 1);

		layout.addComponent(table);
	}

    @WebServlet(urlPatterns = "/*", name = "TablewithcomponentsUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = TablewithcomponentsUI.class, productionMode = false)
    public static class TablewithcomponentsUIServlet extends VaadinServlet {
    }
}
