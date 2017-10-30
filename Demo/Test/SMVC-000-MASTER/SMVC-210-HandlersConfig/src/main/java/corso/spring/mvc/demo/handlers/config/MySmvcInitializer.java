package corso.spring.mvc.demo.handlers.config;

import java.util.List;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import corso.spring.mvc.demo.handlers.controllers.HelloWorldController;
import corso.spring.mvc.demo.handlers.controllers.ProcessController;
import corso.spring.mvc.demo.handlers.controllers.WelcomeController;

@Configuration //abilita la classe a costruire ed iniettare beans nel contesto
@EnableWebMvc //abilita la classe ad essere un contesto web utilizzabile per costruire la DispatchetServlet
@ComponentScan(value={"corso.spring.mvc.demo.handlers.controllers"})
public class MySmvcInitializer extends WebMvcConfigurerAdapter {

	/**
	 * Qui vengono definiti i bean di Spring MVC attraverso metodi.
	 * @return
	 */
	
	
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setOrder(2);
		internalResourceViewResolver.setPrefix("/WEB-INF/pages/");
		internalResourceViewResolver.setSuffix(".jsp");		
		return internalResourceViewResolver;
	}

	
	@Bean
	public BeanNameUrlHandlerMapping beanNameUrlHandlerMapping(){
		BeanNameUrlHandlerMapping handler =new BeanNameUrlHandlerMapping();
		handler.setOrder(1);
		return handler;
	}
	
	@Bean
	public SimpleUrlHandlerMapping simpleUrlHandlerMapping(){
		SimpleUrlHandlerMapping handler =new SimpleUrlHandlerMapping();
		Properties mappings = new Properties();
		mappings.put("helloSH.htm", helloWorldController());
		mappings.put("welcomeSH.htm", welcomeController());
		mappings.put("processSH.htm", processController());
		handler.setMappings(mappings);
		handler.setOrder(2);
		return handler;
	}
	
	
	@SuppressWarnings("deprecation")
	@Bean
	public ControllerClassNameHandlerMapping controllerClassNameHandlerMapping(){
		ControllerClassNameHandlerMapping handler =new ControllerClassNameHandlerMapping();
		handler.setOrder(3);
		return handler;
	}
	
	
	@Bean(name={"/welcomeControllerName.htm"})
	public WelcomeController welcomeController(){
		return new WelcomeController();		
	}
	
	@Bean(name={"/processControllerName.htm"})
	public ProcessController processController(){
		return new ProcessController();		
	}
	
	@Bean(name={"/helloWorldControllerName.htm"})
	public HelloWorldController helloWorldController(){
		return new HelloWorldController();		
	}
	
	
	
}
