package corso.spring.mvc.demo.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

import corso.spring.mvc.demo.controllers.HelloWorldController;
import corso.spring.mvc.demo.views.MyView;

@Configuration //abilita la classe a costruire ed iniettare beans nel contesto
@EnableWebMvc //abilita la classe ad essere un contesto web utilizzabile per costruire la DispatchetServlet
@ComponentScan(basePackages = { "corso.spring.mvc.demo.controllers" })
public class MySmvcInitializer extends WebMvcConfigurerAdapter {


	
	@Bean(name=ViewConsts.CUSTOM_VIEW)
	public MyView customView(){
		return new MyView();
	}
	
	@Bean(name=ViewConsts.JSTL_VIEW)
	public View index() {	
		JstlView view = new JstlView();
		view.setUrl("/WEB-INF/pages/index.jsp");
		return view;
	}
	
	@Bean
	public ViewResolver beanNameViewResolver(){
		BeanNameViewResolver viewResolver = new BeanNameViewResolver();
		viewResolver.setOrder(1);
		return viewResolver;
	}
	
	
	@Bean
	public ViewResolver xmlViewResolver(){
		XmlViewResolver xmlViewResolver= new XmlViewResolver();
		xmlViewResolver.setLocation(new ClassPathResource("views.xml")); //path app
		xmlViewResolver.setOrder(2);
		return xmlViewResolver;
	}
	
	@Bean
	public ViewResolver propertyViewResolver(){
		ResourceBundleViewResolver propertyViewResolver= new ResourceBundleViewResolver();
		propertyViewResolver.setBasename("views"); //classpath
		propertyViewResolver.setOrder(3);
		return propertyViewResolver;
	}
	
	//@Bean //base classe for jsp/template views
	public ViewResolver urlBasedViewResolver(){
		UrlBasedViewResolver urlBasedViewResolver= new UrlBasedViewResolver();
		urlBasedViewResolver.setViewClass(JstlView.class);
		urlBasedViewResolver.setPrefix("/WEB-INF/pages/");
		urlBasedViewResolver.setSuffix(".jsp");		
		urlBasedViewResolver.setOrder(4);
		return urlBasedViewResolver;
	}

	
	@Bean //extension of UrlBasedViewResolver has some more api to handle bean in request (see javadocs)
	public ViewResolver internalViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setOrder(4);
		internalResourceViewResolver.setPrefix("/WEB-INF/pages/");
		internalResourceViewResolver.setSuffix(".jsp");		
		return internalResourceViewResolver;
	}
}
