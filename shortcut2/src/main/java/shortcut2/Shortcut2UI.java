package shortcut2;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutAction.ModifierKey;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;

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
public class Shortcut2UI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		Panel panel = new Panel();
		panel.setSizeFull();
		setContent(panel);

		Handler handler = new Handler() {

			@Override
			public Action[] getActions(Object target, Object sender) {
				return new Action[] {
						new ShortcutAction("Enter", KeyCode.ENTER, null),
						new ShortcutAction("Shift + U", KeyCode.U,
								new int[] { ModifierKey.SHIFT }) };
			}

			@Override
			public void handleAction(Action action, Object sender, Object target) {
				Notification.show(action.getCaption());
			}

		};

		panel.addActionHandler(handler);

	}

	@WebServlet(urlPatterns = "/*", name = "Shortcut2UIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = Shortcut2UI.class, productionMode = false)
	public static class Shortcut2UIServlet extends VaadinServlet {
	}
}
