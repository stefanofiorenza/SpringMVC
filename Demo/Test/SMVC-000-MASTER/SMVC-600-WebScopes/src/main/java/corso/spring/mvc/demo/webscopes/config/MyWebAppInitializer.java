package corso.spring.mvc.demo.webscopes.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

   @Override
   protected Class<?>[] getRootConfigClasses() {// root app config class
      return new Class[] {};
   }

   @Override
   protected Class<?>[] getServletConfigClasses() { //SMVC config class
      return new Class[] { WebConfig.class };
   }

   @Override
   protected String[] getServletMappings() {// DispatcherServlet mapping
      return new String[] { "/" };
   }
}
