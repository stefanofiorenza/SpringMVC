package corso.spring.mvc.demo.rest.config;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import corso.spring.mvc.demo.views.ContactCsvView;
import corso.spring.mvc.demo.views.ContactExcelView;
import corso.spring.mvc.demo.views.FileFormatConsts;

@Configuration //abilita la classe a costruire ed iniettare beans nel contesto
@EnableWebMvc //abilita la classe ad essere un contesto web utilizzabile per costruire la DispatchetServlet
@ComponentScan(value={"corso.spring.mvc.demo.controllers","corso.spring.mvc.user.api.services","corso.spring.mvc.crm.services.impl"})
@Slf4j
public class MySmvcInitializer extends WebMvcConfigurerAdapter {

	
	
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
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.defaultContentType(MediaType.TEXT_HTML)
				.favorPathExtension(true)
				.favorParameter(false)
				.ignoreAcceptHeader(true);
//				.mediaType("html", MediaType.TEXT_HTML)
//			    .mediaType("xml", MediaType.APPLICATION_XML)
//			    .mediaType("json", MediaType.APPLICATION_JSON);
	}
	
	
	@Bean
	public ContentNegotiatingViewResolver cntNegotiationViewResolver(ContentNegotiationManager cnManager) {

	      ContentNegotiatingViewResolver cnResolver = new ContentNegotiatingViewResolver();
	      cnResolver.setContentNegotiationManager(cnManager);
	    
	      
	      //JSP
	      InternalResourceViewResolver jspResolver = new InternalResourceViewResolver(
	            "/WEB-INF/views/", ".jsp");
	      
	      //CSV
	      UrlBasedViewResolver csvViewResolver= new UrlBasedViewResolver();
	      csvViewResolver.setViewClass(ContactCsvView.class);
	      
	      //Excel
	      UrlBasedViewResolver urlBasedViewResolver= new UrlBasedViewResolver();
	      urlBasedViewResolver.setViewClass(ContactExcelView.class);
	     
	      	      	      
	      cnResolver.getViewResolvers().add(jspResolver);
	      cnResolver.getViewResolvers().add(urlBasedViewResolver);
	      cnResolver.getViewResolvers().add(csvViewResolver);
	      return cnResolver;
	 }
	

	
	
}
