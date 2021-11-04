package com.rgobj.generalproblemdemo;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.thymeleaf.TemplateEngine;

@SpringBootApplication
@MapperScan("com.rgobj.generalproblemdemo.mapper")
public class GeneralproblemdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneralproblemdemoApplication.class, args);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.addDialect(new LayoutDialect());
    }

}
