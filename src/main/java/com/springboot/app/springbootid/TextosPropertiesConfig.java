package com.springboot.app.springbootid;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

//CONFIG PARA EL USO DE NUEVOS PROPERTIES
@Configuration
@PropertySources({
        @PropertySource("classpath:textos.properties"),
        //@PropertySource("classpath:textos2.properties"),
        //@PropertySource("classpath:textos3.properties"),
})

public class TextosPropertiesConfig {
}

