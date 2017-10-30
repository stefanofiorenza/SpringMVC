package corso.spring.mvc.demo.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import corso.spring.mvc.demo.views.ContactCsvView;
import corso.spring.mvc.demo.views.ContactExcelView;
import corso.spring.mvc.demo.views.FileFormatConsts;

@Configuration //abilita la classe a costruire ed iniettare beans nel contesto
@EnableWebMvc //abilita la classe ad essere un contesto web utilizzabile per costruire la DispatchetServlet
@ComponentScan(basePackages = { "corso.spring.mvc.demo.controllers","corso.spring.mvc.crm.services.impl","corso.spring.mvc.crm.dao.impl" })
public class MySmvcInitializer extends WebMvcConfigurerAdapter {

	
	@Bean
	public ViewResolver beanNameViewResolver(){
		BeanNameViewResolver viewResolver = new BeanNameViewResolver();
		viewResolver.setOrder(1);
		return viewResolver;
	}
	
//	@Bean
//	public ViewResolver internalViewResolver() {
//		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//		internalResourceViewResolver.setOrder(2);
//		internalResourceViewResolver.setPrefix("/WEB-INF/pages/");
//		internalResourceViewResolver.setSuffix(".jsp");		
//		return internalResourceViewResolver;
//	}
	
	@Bean(name=FileFormatConsts.EXPORT_EXCEL)
	public ContactExcelView excelView(){
		return new ContactExcelView();	
	}
	

	@Bean(name=FileFormatConsts.EXPORT_CSV)
	public ContactCsvView csvView(){
		return new ContactCsvView();
	}
}
