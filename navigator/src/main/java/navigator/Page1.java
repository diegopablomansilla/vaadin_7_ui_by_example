package navigator;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class Page1 extends VerticalLayout implements View {

	public Page1() {
		addComponent(new Label("Page 1"));
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Showing page 1");
	}

}
