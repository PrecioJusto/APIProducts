package app.preciojusto.products.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsConfig implements WebMvcConfigurer {

    @Autowired
    private Environment environment;

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        //All application
        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("http://localhost:8080/", "http://localhost:8080", "https://preciojusto.app")
                .allowedMethods("PUT", "POST", "GET", "DELETE", "OPTIONS");

        //Extractor product
        registry.addMapping("/extractor/product")
                .allowedMethods("POST", "OPTIONS");
    }
}