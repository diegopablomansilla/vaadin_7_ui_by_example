package table;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.FooterClickEvent;
import com.vaadin.ui.Table.FooterClickListener;
import com.vaadin.ui.Table.HeaderClickEvent;
import com.vaadin.ui.Table.HeaderClickListener;
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
public class MyFirstTableUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		final Table table = new Table();

		table.addContainerProperty("Column 1", String.class, "(default 1)");
		table.addContainerProperty("Column 2", String.class, "(default 2)");

		table.addItem(new Object[] { "Hi", "There" }, "item ID 1");
		table.addItem(new Object[] { "Well", "Hello!" }, "item ID 2");
		table.addItem();

		table.setColumnFooter("Column 1", "Footer 1");
		table.setFooterVisible(true);

		table.addHeaderClickListener(new HeaderClickListener() {
			@Override
			public void headerClick(HeaderClickEvent event) {
				Notification.show("Header clicked: " + event.getPropertyId());
			}
		});

		table.addFooterClickListener(new FooterClickListener() {
			@Override
			public void footerClick(FooterClickEvent event) {
				Notification.show("Footer clicked: " + event.getPropertyId());
			}
		});

		layout.addComponent(table);
	}

	@WebServlet(urlPatterns = "/*", name = "MyFirstTableUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyFirstTableUI.class, productionMode = false)
	public static class MyFirstTableUIServlet extends VaadinServlet {
	}
}
