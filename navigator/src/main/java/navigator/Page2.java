package navigator;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class Page2 extends VerticalLayout implements View {

	public Page2() {
		addComponent(new Label("Page 2"));
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Showing page 2");
	}

}