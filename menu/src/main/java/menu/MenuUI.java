package menu;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.MenuBar.Command;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.Notification;
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
public class MenuUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		MenuBar menuBar = new MenuBar();

		MenuItem submenu1 = menuBar.addItem("Submenu 1", null);
		MenuItem submenu2 = menuBar.addItem("Submenu 2", null);

		submenu1.addItem("Option 1", null);
		submenu1.addItem("Option 2", null);

		submenu2.addItem("Option 3", null);
		submenu2.addItem("Option 4", new Command() {
			@Override
			public void menuSelected(MenuItem selectedItem) {
				Notification.show("That was option 4");
			}
		});

		layout.addComponent(menuBar);
	}

    @WebServlet(urlPatterns = "/*", name = "MenuUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MenuUI.class, productionMode = false)
    public static class MenuUIServlet extends VaadinServlet {
    }
}
