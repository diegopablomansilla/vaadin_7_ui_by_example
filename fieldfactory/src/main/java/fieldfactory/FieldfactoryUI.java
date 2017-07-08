package fieldfactory;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Table;
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
public class FieldfactoryUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Table table = new Table("Users");
		table.setPageLength(0);
		table.setEditable(true);
		table.addContainerProperty("Login", String.class, "");
		table.addContainerProperty("Password", String.class, "");

		table.addItem();
		table.addItem();
		table.addItem();

		layout.addComponent(table);

		table.setTableFieldFactory(new UserFieldFactory());
	}

    @WebServlet(urlPatterns = "/*", name = "FieldfactoryUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = FieldfactoryUI.class, productionMode = false)
    public static class FieldfactoryUIServlet extends VaadinServlet {
    }
}
