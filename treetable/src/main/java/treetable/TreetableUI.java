package treetable;

import java.io.File;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Tree;
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
public class TreetableUI extends UI {

	@Override
	  protected void init(VaadinRequest request) {
	    final VerticalLayout layout = new VerticalLayout();
	    layout.setMargin(true);
	    setContent(layout);

	    File folder = VaadinService.getCurrent().getBaseDirectory();
	    FilesystemContainer container = new FilesystemContainer(folder);

//	    TreeTable treeTable = new TreeTable();
	    Tree treeTable = new Tree();
	    treeTable.setContainerDataSource(container);
	    treeTable.setSizeFull();

	    layout.addComponent(treeTable);
	  }

    @WebServlet(urlPatterns = "/*", name = "TreetableUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = TreetableUI.class, productionMode = false)
    public static class TreetableUIServlet extends VaadinServlet {
    }
}
