package website2;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
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
public class Website2UI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		String page = request.getParameter("page");
		page = getPage().getUriFragment();

		if (page == null) {
			layout.addComponent(new Label("Welcome to Simple Web Site"));
			getPage().setTitle("Simple Web Site");

		} else if ("1".equals(page)) {
			layout.addComponent(new Label("Oh yeah! You are watching Page 1!"));
			getPage().setTitle("Simple Web Site - Page 1");

		} else if ("2".equals(page)) {
			layout.addComponent(new Label("Yay! This is Page 2!"));
			getPage().setTitle("Simple Web Site - Page 2");

		} else {
			getPage().setTitle("Simple Web Site - 404!");
			layout.addComponent(new Label(
					"You just got 404'd! The requested page doesn't exist."));
		}

	}

	@WebServlet(urlPatterns = "/*", name = "Website2UIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = Website2UI.class, productionMode = false)
	public static class Website2UIServlet extends VaadinServlet {
	}
}
