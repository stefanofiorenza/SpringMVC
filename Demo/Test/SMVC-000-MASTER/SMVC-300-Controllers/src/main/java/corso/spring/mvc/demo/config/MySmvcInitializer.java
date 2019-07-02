package corso.spring.mvc.demo.config;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

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
@ComponentScan(value={"corso.spring.mvc.demo.controllers","corso.spring.mvc.user.api.services"})
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
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		if(converters.isEmpty()){
			log.info("[configureMessageConverters]: No Converters found");
		}		
		// add converters here
	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		for (HttpMessageConverter<?>defaultMsgConverter : converters){
			log.info("[extendMessageConverters]: Configured MessageConverter: {} supported media types: {} ",defaultMsgConverter.getClass().getName(),defaultMsgConverter.getSupportedMediaTypes().toString() );
		}
	}
	
	

	
	
}
