package layoutframework;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.LayoutEvents.LayoutClickEvent;
import com.vaadin.event.LayoutEvents.LayoutClickListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.SelectedTabChangeListener;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.CloseListener;

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
//@Theme("mytheme")
public class LayoutFrameworkUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		MainLayout layout = new MainLayout();
		layout.addMenuOption("Option 1", new Label("Component 1"));
		layout.addMenuOption("Option 2", new Label("Component 2"));
		setContent(layout);

		layout.addMenuOption("Grid layout", getGridLayout());
		layout.addMenuOption("Absolut layout", getAbsolutLayout());
		layout.addMenuOption("Click listener", getClickListener());
		layout.addMenuOption("Form layout", getFormLayout());
		layout.addMenuOption("Panel", getPanel());
		layout.addMenuOption("Tab sheets", getTabSheet());
		layout.addMenuOption("Accordions", getAccordion());
		layout.addMenuOption("Windows", getWindowOpenerButton());
	}

	private GridLayout getGridLayout() {
		int rows = 3, columns = 3;
		GridLayout gridLayout = new GridLayout(columns, rows);
		gridLayout.setSizeFull();

		for (int row = 0; row < rows; row++) {
			for (int column = 0; column < columns; column++) {
				Button button = new Button("-_-");
				button.addClickListener(new ClickListener() {
					@Override
					public void buttonClick(ClickEvent event) {
						event.getButton().setCaption("�_�");
					}
				});

				gridLayout.addComponent(button, column, row);
			}
		}

		return gridLayout;
	}

	private Component getAbsolutLayout() {
		Button button = new Button("I'm whimsically located at 42, 57");

		AbsoluteLayout absoluteLayout = new AbsoluteLayout();
		absoluteLayout.addComponent(button, "left: 42px; top: 57px");

		return absoluteLayout;
	}

	private Component getClickListener() {
		VerticalLayout layout = new VerticalLayout();
		layout.setSizeFull();
		layout.addLayoutClickListener(new LayoutClickListener() {
			@Override
			public void layoutClick(LayoutClickEvent event) {
				String message = "And you did it at " + event.getClientX()
						+ ", " + event.getClientY();
				Notification.show("You clicked me!", message,
						Type.TRAY_NOTIFICATION);
			}
		});

		return layout;
	}

	private FormLayout getFormLayout() {
		TextField tf1 = new TextField("TextField");
		TextField tf2 = new TextField("TextField");
		ComboBox cb = new ComboBox("ComboBox");
		Button b = new Button("Button");

		FormLayout formLayout = new FormLayout(tf1, tf2, cb, b);
		formLayout.setMargin(true);

		return formLayout;
	}

	private Panel getPanel() {
		String someNumbers = "";

		for (int i = 0; i < 2000; i++) {
			someNumbers += " " + i;
		}

		Label content = new Label(someNumbers);
		Panel panel = new Panel("Panel's caption", content);
		panel.setWidth("200px");
		panel.setHeight("100px");

		panel.setScrollTop(3000); // pixels from top

		return panel;
	}

	private TabSheet getTabSheet() {
		TabSheet tabs = new TabSheet();
		tabs.addTab(new Label("Label 1"), "Tabl 1");
		tabs.addTab(new Label("Label 2")).setCaption("Tab 2");
		Tab tab = tabs.addTab(new Label("Label 3"));
		tab.setCaption("Tab 3");
		tab.setClosable(true);

		tabs.addSelectedTabChangeListener(new SelectedTabChangeListener() {
			@Override
			public void selectedTabChange(SelectedTabChangeEvent event) {
				Notification.show("You are watching "
						+ event.getTabSheet().getSelectedTab());
			}
		});

		return tabs;
	}

	private Accordion getAccordion() {
		Accordion accordion = new Accordion();
		accordion.addTab(new Label("Label 1"), "Tabl 1");
		accordion.addTab(new Label("Label 2")).setCaption("Tab 2");
		Tab tab = accordion.addTab(new Label("Label 3"));
		tab.setCaption("Tab 3");
		tab.setClosable(true);

		accordion.addSelectedTabChangeListener(new SelectedTabChangeListener() {
			@Override
			public void selectedTabChange(SelectedTabChangeEvent event) {
				Notification.show("You are watching "
						+ event.getTabSheet().getSelectedTab());
			}
		});

		return accordion;
	}

	private Button getWindowOpenerButton() {
		Button button = new Button("Give me some windows");

		button.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				Window w1 = new Window("Default window");

				Window w2 = new Window("You can't close this window, sorry");
				w2.setClosable(false);

				Window w3 = new Window("You can't resize me, ha-ha");
				w3.setWidth("200px");
				w3.setHeight("100px");
				w3.setResizable(false);

				Window w4 = new Window("I have a Label inside");
				w4.setContent(new Label("I'm that Label."));

				Window w5 = new Window(
						"You can't drag me :( but you can close me :)");
				w5.setDraggable(false);

				Window w6 = new Window("I'm at 300, 5");
				w6.setPositionX(300);
				w6.setPositionY(5);

				Window w7 = new Window("Beware... I can hear when you close me");
				w7.addCloseListener(new CloseListener() {
					@Override
					public void windowClose(CloseEvent e) {
						Notification.show("I hear you!");
					}
				});

				Window w8 = new Window("I'm modal, close me to continue");
				w8.setModal(true);

				addWindow(w8);
				addWindow(w7);
				addWindow(w6);
				addWindow(w5);
				addWindow(w4);
				addWindow(w3);
				addWindow(w2);
				addWindow(w1);
			}
		});

		return button;
	}

	@WebServlet(urlPatterns = "/*", name = "LayoutFrameworkUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = LayoutFrameworkUI.class, productionMode = false)
	public static class LayoutFrameworkUIServlet extends VaadinServlet {
	}
}
