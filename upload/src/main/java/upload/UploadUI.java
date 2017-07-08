package upload;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.Receiver;
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
public class UploadUI extends UI implements Receiver {

	@Override
	protected void init(VaadinRequest request) {
		Upload upload = new Upload(
				"Select a text file and look at the console", this);

		VerticalLayout layout = new VerticalLayout();
		layout.addComponent(upload);
		setContent(layout);
	}

//	@Override
//	public OutputStream receiveUpload(String filename, String mimeType) {
//		return new OutputStream() {
//			@Override
//			public void write(int b) throws IOException {
//				System.out.print((char) b);
//			}
//		};
//	}

	@Override
	public OutputStream receiveUpload(String filename, String mimeType) {
		FileOutputStream output = null;
		try {
			output = new FileOutputStream("D:\\" + filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return output;
	}

	@WebServlet(urlPatterns = "/*", name = "UploadUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = UploadUI.class, productionMode = false)
	public static class UploadUIServlet extends VaadinServlet {
	}
}
