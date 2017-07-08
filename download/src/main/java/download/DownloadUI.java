package download;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ClassResource;
import com.vaadin.server.FileDownloader;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.BaseTheme;

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
public class DownloadUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		ClassResource resource = new ClassResource("enterprise-app.pdf");

		Button button = new Button("Download the PDF");
		button.setStyleName(BaseTheme.BUTTON_LINK);

		FileDownloader downloader = new FileDownloader(resource);
		downloader.extend(button);

		layout.addComponent(button);
	}

	@WebServlet(urlPatterns = "/*", name = "DownloadUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = DownloadUI.class, productionMode = false)
	public static class DownloadUIServlet extends VaadinServlet {
	}
}
