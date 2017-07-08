package layoutframework;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class MainLayout extends VerticalLayout {

	private VerticalLayout upperSection = new VerticalLayout();
	private HorizontalSplitPanel lowerSection = new HorizontalSplitPanel();
	private VerticalLayout menuLayout = new VerticalLayout();
	private VerticalLayout contentLayout = new VerticalLayout();

	public MainLayout() {
		lowerSection.setSizeFull();
		contentLayout.setSizeFull();
//		menuLayout.setSizeFull();

		upperSection.addComponent(new Label("Header"));
		menuLayout.addComponent(new Label("Menu"));
		contentLayout.addComponent(new Label("Content"));

		lowerSection.setSplitPosition(30);
		lowerSection.addComponent(menuLayout);
		lowerSection.addComponent(contentLayout);

		addComponent(upperSection);
		addComponent(lowerSection);

		// setExpandRatio(upperSection, 2);
		setExpandRatio(lowerSection, 1);

		showBorders();
		setSizeFull();
	}

	@SuppressWarnings("unused")
	private void showBorders() {
		String style = "v-ddwrapper-over";
		setStyleName(style);
		upperSection.setStyleName(style);
		lowerSection.setStyleName(style);
		menuLayout.setStyleName(style);
		contentLayout.setStyleName(style);
	}

	public void addMenuOption(String caption, final Component component) {
		Button button = new Button(caption);
		menuLayout.addComponent(button);

		button.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				contentLayout.removeAllComponents();
				contentLayout.addComponent(component);
			}
		});
	}

}
