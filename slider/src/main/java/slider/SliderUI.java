package slider;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Slider;
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
public class SliderUI extends UI {

	  @Override
	  protected void init(VaadinRequest request) {
	    final VerticalLayout layout = new VerticalLayout();
	    layout.setMargin(true);
	    setContent(layout);

	    Slider slider = new Slider("Drag the point");
	    slider.setWidth("100%");
	    slider.setMin(0.0);
	    slider.setMax(100.0);
	    slider.setValue(30.0);

	    slider.addValueChangeListener(new ValueChangeListener() {
	      @Override
	      public void valueChange(ValueChangeEvent event) {
	        Notification.show("Attention! Slider value has changed to "
	            + event.getProperty().getValue());
	      }
	    });

	    layout.addComponent(slider);
	  }


    @WebServlet(urlPatterns = "/*", name = "SliderUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = SliderUI.class, productionMode = false)
    public static class SliderUIServlet extends VaadinServlet {
    }
}
