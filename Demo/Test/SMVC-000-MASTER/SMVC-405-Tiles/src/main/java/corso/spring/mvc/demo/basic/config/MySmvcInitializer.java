package corso.spring.mvc.demo.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;


@Configuration //abilita la classe a costruire ed iniettare beans nel contesto
@EnableWebMvc //abilita la classe ad essere un contesto web utilizzabile per costruire la DispatchetServlet
@ComponentScan(basePackages = { "corso.spring.mvc.demo.controllers" })
public class MySmvcInitializer extends WebMvcConfigurerAdapter {
	
	@Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[] { 
        			"/WEB-INF/tiles-templates.xml",
        		  	"/WEB-INF/tiles-views.xml"});
        tilesConfigurer.setCheckRefresh(true);
         
        return tilesConfigurer;
    }
     
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(new TilesViewResolver());
    }
     
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**") //uri pattern (in views)
          .addResourceLocations("/static/");  // dir from app root
    }
}
