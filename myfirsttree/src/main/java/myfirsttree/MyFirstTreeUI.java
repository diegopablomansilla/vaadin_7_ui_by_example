package myfirsttree;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Tree;
import com.vaadin.ui.Tree.CollapseEvent;
import com.vaadin.ui.Tree.CollapseListener;
import com.vaadin.ui.Tree.ExpandEvent;
import com.vaadin.ui.Tree.ExpandListener;
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
public class MyFirstTreeUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Tree familyTree = new Tree();

		familyTree.addItem("Families");
		familyTree.addItem("The Jackson");
		familyTree.addItem("The Simpsons");
		familyTree.addItem("The Rothschilds");
		familyTree.addItem("The Hapsburgs");
		familyTree.addItem("The Addams");

		familyTree.setParent("The Jackson", "Families");
		familyTree.setParent("The Simpsons", "Families");
		familyTree.setParent("The Rothschilds", "Families");
		familyTree.setParent("The Hapsburgs", "Families");
		familyTree.setParent("The Addams", "Families");

		familyTree.setChildrenAllowed("The Jackson", false);
		familyTree.setChildrenAllowed("The Simpsons", false);
		familyTree.setChildrenAllowed("The Rothschilds", false);
		familyTree.setChildrenAllowed("The Hapsburgs", false);
		familyTree.setChildrenAllowed("The Addams", false);

		familyTree.addItemClickListener(new ItemClickListener() {
			@Override
			public void itemClick(ItemClickEvent event) {
				Notification.show(event.getItemId() + " clicked.");
			}
		});

		familyTree.addExpandListener(new ExpandListener() {
			@Override
			public void nodeExpand(ExpandEvent event) {
				Notification.show(event.getItemId() + " expanded.");
			}
		});

		familyTree.addCollapseListener(new CollapseListener() {
			@Override
			public void nodeCollapse(CollapseEvent event) {
				Notification.show(event.getItemId() + " collapsed.");
			}
		});

		layout.addComponent(familyTree);
	}

	@WebServlet(urlPatterns = "/*", name = "MyFirstTreeUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyFirstTreeUI.class, productionMode = false)
	public static class MyFirstTreeUIServlet extends VaadinServlet {
	}
}
