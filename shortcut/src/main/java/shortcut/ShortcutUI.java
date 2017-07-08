package shortcut;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutAction.ModifierKey;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
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
public class ShortcutUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSpacing(true);
		setContent(layout);

		final TextField tf = new TextField("Your data:");
		layout.addComponent(tf);

		Button button = new Button("Send data (ENTER)");
		button.setClickShortcut(KeyCode.ENTER, ModifierKey.SHIFT);

		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				layout.addComponent(new Label(tf.getValue()));
				tf.setValue("");
				tf.focus();
			}
		});

		layout.addComponent(button);
	}

	@WebServlet(urlPatterns = "/*", name = "ShortcutUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = ShortcutUI.class, productionMode = false)
	public static class ShortcutUIServlet extends VaadinServlet {
	}
}
