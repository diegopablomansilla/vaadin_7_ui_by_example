package navigator;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.BaseTheme;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class Welcome extends VerticalLayout implements View {

	private Navigator navigator;

	public Welcome() {
		ClickListener listener = new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				navigator.navigateTo(event.getButton().getCaption());
			}
		};

		Button goToPage1 = new Button("page1");
		Button goToPage2 = new Button("page2");

		goToPage1.addClickListener(listener);
		goToPage2.addClickListener(listener);

		goToPage1.setStyleName(BaseTheme.BUTTON_LINK);
		goToPage2.setStyleName(BaseTheme.BUTTON_LINK);

		addComponent(new Label("Welcome"));
		addComponent(goToPage1);
		addComponent(goToPage2);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		Notification.show("Showing Welcome page");
		navigator = event.getNavigator();
	}

}
