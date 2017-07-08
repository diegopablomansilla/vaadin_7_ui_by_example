package progressindicator;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ProgressBar;
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
public class ProgressindicatorUI extends UI {

	private ProgressBar mrProgressIndicator = new ProgressBar();

	private class HighTechAlgorithm extends Thread {
		@Override
		public void run() {
			try {

				for (int i = 1; i <= 10; i++) {
					sleep(1000);
					mrProgressIndicator.setValue(i * 0.1f);
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		Button button = new Button("Start awesome algorithm");

		button.addClickListener(new Button.ClickListener() {
			public void buttonClick(ClickEvent event) {
				new HighTechAlgorithm().start();
			}
		});

		layout.addComponent(button);
		layout.addComponent(mrProgressIndicator);
	}

	@WebServlet(urlPatterns = "/*", name = "ProgressindicatorUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = ProgressindicatorUI.class, productionMode = false)
	public static class ProgressindicatorUIServlet extends VaadinServlet {
	}
}
