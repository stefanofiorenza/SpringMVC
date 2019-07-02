package app.cvonline.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration 
@EnableWebMvc 
public class CvOnlineInitializer extends WebMvcConfigurerAdapter {
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**") //uri pattern (in views)
          .addResourceLocations("/static/");  // dir from app root
    }
}
