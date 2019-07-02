package app.prometrics.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //abilita la classe a costruire ed iniettare beans nel contesto
@ComponentScan(basePackages = { "app.prometrics.services,app.prometrics.dao"})
public class PrometricsConfig {
	
}
