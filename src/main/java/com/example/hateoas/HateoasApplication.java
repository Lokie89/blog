package com.example.hateoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HateoasApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(HateoasApplication.class, args);
    }


    // Controller endpoint와 HATEOAS로 제공하는 endpoint를 동일시 하기위함
    // application properties 의 값들을 controller value 에 사용하기 위함.. 위에 설명 왜저럼?
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    // 모든 요청에 대한 cors 이슈 해결
    // 이 방법이 아니면 각 controller 에 cors annotation 추가
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                .allowedOrigins("*");
    }

}
