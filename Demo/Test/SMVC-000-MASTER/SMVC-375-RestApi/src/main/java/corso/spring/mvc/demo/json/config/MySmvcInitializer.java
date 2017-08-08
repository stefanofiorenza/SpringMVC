package corso.spring.mvc.demo.json.config;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration //abilita la classe a costruire ed iniettare beans nel contesto
@EnableWebMvc //abilita la classe ad essere un contesto web utilizzabile per costruire la DispatchetServlet
@ComponentScan(basePackages = { "corso.spring.mvc.demo.json.controllers","corso.spring.mvc.demo.json.services","corso.spring.mvc.demo.json.dao" })
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
