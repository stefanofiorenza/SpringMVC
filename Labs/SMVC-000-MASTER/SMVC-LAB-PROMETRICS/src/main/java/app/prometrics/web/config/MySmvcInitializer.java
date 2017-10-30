package app.prometrics.web.config;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import app.prometrics.config.PrometricsConfig;

@Configuration //abilita la classe a costruire ed iniettare beans nel contesto
@EnableWebMvc //abilita la classe ad essere un contesto web utilizzabile per costruire la DispatchetServlet
@ComponentScan(basePackages = { "app.prometrics.web.controllers"})
@Import(PrometricsConfig.class)
@Slf4j
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
	
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**"); 
        
//        	.allowedOrigins("http://client.cors-api.appspot.com") //http://client.cors-api.appspot.com/client
//        	.allowedMethods("POST", "GET")
//        	.allowedHeaders("X-header1")
//        	.maxAge(3000);

    }
	
	
	
}
