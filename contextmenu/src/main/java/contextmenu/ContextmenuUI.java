package contextmenu;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
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
public class ContextmenuUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Table table = new Table("A table:");
		table.setSizeFull();

		final Action action = new Action("Say hello");

		table.addActionHandler(new Handler() {

			@Override
			public void handleAction(Action action, Object sender, Object target) {
				Notification.show("Ok, here I go... Hello.");
			}

			@Override
			public Action[] getActions(Object target, Object sender) {
				return new Action[] { action };
			}
		});

		layout.addComponent(table);
	}

	@WebServlet(urlPatterns = "/*", name = "ContextmenuUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = ContextmenuUI.class, productionMode = false)
	public static class ContextmenuUIServlet extends VaadinServlet {
	}
}
