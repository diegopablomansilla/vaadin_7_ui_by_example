package draganddrop;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.event.dd.acceptcriteria.AcceptAll;
import com.vaadin.event.dd.acceptcriteria.AcceptCriterion;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.DragAndDropWrapper;
import com.vaadin.ui.DragAndDropWrapper.DragStartMode;
import com.vaadin.ui.DragAndDropWrapper.WrapperTargetDetails;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Image;
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
public class DraganddropUI extends UI implements DropHandler {

	private AbsoluteLayout canvasLayout = new AbsoluteLayout();
	private HorizontalSplitPanel mainLayout = new HorizontalSplitPanel();

	@Override
	protected void init(VaadinRequest request) {
		// init our main layout
		mainLayout.setSplitPosition(300, Unit.PIXELS);
		setContent(mainLayout);

		// init the left layout where the draggable icons are placed
		GridLayout iconsLayout = new GridLayout();
		iconsLayout.setMargin(true);
		iconsLayout.setWidth("100%");
		iconsLayout.setColumns(3);
		mainLayout.setFirstComponent(iconsLayout);

		String iconNames[] = { "arrow-down.png", "arrow-left.png",
				"arrow-right.png", "arrow-up.png", "calendar.png",
				"document.png", "document-doc.png", "document-image.png",
				"document-pdf.png", "document-ppt.png", "document-web.png",
				"document-xsl.png", "email.png", "globe.png", "reload.png" };

		for (int i = 0, x = 0, y = 0; i < iconNames.length; i++, x++) {
			if (x >= iconsLayout.getColumns()) {
				x = 0;
				iconsLayout.setRows(++y + 1);
			}

			ThemeResource resource = new ThemeResource("../runo/icons/64/"
					+ iconNames[i]);
			Image icon = new Image(null, resource);

			DragAndDropWrapper transferable = new DragAndDropWrapper(icon);
			transferable.setSizeUndefined();
			transferable.setDragStartMode(DragStartMode.WRAPPER);
			transferable.setData(resource);

			iconsLayout.addComponent(transferable, x, y);
		}

		// init the "canvas" where the icons can be dragged to
		canvasLayout.setSizeFull();
		DragAndDropWrapper destiny = new DragAndDropWrapper(canvasLayout);
		destiny.setSizeFull();
		destiny.setDropHandler(this);
		mainLayout.setSecondComponent(destiny);
	}

	@Override
	public void drop(DragAndDropEvent event) {
		AbstractComponent transferable = (AbstractComponent) event
				.getTransferable().getSourceComponent();
		Resource resource = (Resource) transferable.getData();
		Image icon = new Image(null, resource);

		WrapperTargetDetails details = (WrapperTargetDetails) event
				.getTargetDetails();
		int x = details.getMouseEvent().getClientX()
				- (int) mainLayout.getSplitPosition();
		int y = details.getMouseEvent().getClientY();

		canvasLayout.addComponent(icon, "left: " + x + "; top: " + y);
	}

	@Override
	public AcceptCriterion getAcceptCriterion() {
		return AcceptAll.get();
	}

	@WebServlet(urlPatterns = "/*", name = "DraganddropUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = DraganddropUI.class, productionMode = false)
	public static class DraganddropUIServlet extends VaadinServlet {
	}
}
