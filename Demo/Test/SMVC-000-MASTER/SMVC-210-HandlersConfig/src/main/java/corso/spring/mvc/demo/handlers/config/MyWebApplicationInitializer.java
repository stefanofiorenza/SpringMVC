package corso.spring.mvc.demo.handlers.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

	/**
	 * Qui vengono definite le classi da caricare nel WebContainer (equivalente web.xml)
	 * @return
	 */
	
	@Override
	public void onStartup(final ServletContext servletContext)
			throws ServletException {
		registerDispatcherServlet(servletContext);
	}

	private void registerDispatcherServlet(final ServletContext servletContext) {
		WebApplicationContext dispatcherContext = createContext(MySmvcInitializer.class);
		DispatcherServlet dispatcherServlet = new DispatcherServlet(
				dispatcherContext);		
		
		ServletRegistration.Dynamic dispatcher =  servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("*.htm");
	}

	private WebApplicationContext createContext(
			final Class<?>... annotatedClasses) {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(annotatedClasses);
		return context;
	}

}
