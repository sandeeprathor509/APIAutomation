package com.free.now.configs;

import com.free.now.utilities.CustomUtils;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Data
@Component
@Configuration
@ComponentScan(basePackages = "com.free.now")
@PropertySources({
        @PropertySource("classpath:custom.properties")
})
public class CustomConfig implements ApplicationContextAware {

    private static ApplicationContext context;

    @Autowired
    private Environment environment;

    @Value("${app.env}")
    private String env;

    @Bean
    public CustomUtils getCustomUtils() {
        return new CustomUtils();
    }

    public String getBaseURI(){
        return environment.getProperty("base.URI");
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CustomConfig.context = applicationContext;
    }

    public static <T extends Object> T getBean(Class<T> beanClass) {
        return context.getBean(beanClass);
    }
}
