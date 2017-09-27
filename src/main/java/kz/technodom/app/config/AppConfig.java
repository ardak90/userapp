package kz.technodom.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by ardak on 9/27/17.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "kz.technodom.app")
public class AppConfig {

}
