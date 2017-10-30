package corso.spring.mvc.demo.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration //abilita la classe a costruire ed iniettare beans nel contesto
@EnableWebMvc //abilita la classe ad essere un contesto web utilizzabile per costruire la DispatchetServlet
@ComponentScan(value={"corso.spring.mvc.demo.controllers","corso.spring.mvc.crm.services.impl","corso.spring.mvc.crm.dao.impl"})
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

	
	
}
