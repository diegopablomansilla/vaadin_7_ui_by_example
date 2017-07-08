package editabletable;

import java.util.Date;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
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
public class EditabletableUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Table table = new Table();
		table.setPageLength(0);
		table.setEditable(true);
		
		User userDef = new User();
		userDef.setLogin("dmansilla");
		userDef.setPassword("1234");

		table.addContainerProperty("String", String.class, "");
		table.addContainerProperty("Boolean", Boolean.class, false);
		table.addContainerProperty("Date", Date.class, null);
		table.addContainerProperty("Item", Item.class, new BeanItem<User>(userDef));

		table.addItem();
		table.addItem();
		table.addItem();

		User user = new User();
		user.setLogin("mylogin");
		user.setPassword("mypassword");

		BeanItem<User> item = new BeanItem<User>(user);

		table.addItem(new Object[] { "", true, new Date(), item }, 4);

		layout.addComponent(table);
	}

	@WebServlet(urlPatterns = "/*", name = "EditabletableUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = EditabletableUI.class, productionMode = false)
	public static class EditabletableUIServlet extends VaadinServlet {
	}
}
