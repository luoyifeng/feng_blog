package com.jd.popc;

import com.jd.popc.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class Swagger2Configurer {

    @Bean
    public Docket systemSummaryRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("系统概览")
                .apiInfo(apiInfo("系统概览 RESTFul API 接口调用详情"))
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(SystemSummaryAnno.class))
                .paths(PathSelectors.ant("/system/summary/**"))
                .build();
    }

    @Bean
    public Docket waterUseInfoRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用水异常判断")
                .apiInfo(apiInfo("用水异常判断 RESTFul API 接口调用详情"))
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(WaterUseInfoAnno.class))
                .paths(PathSelectors.ant("/water/use/**"))
                .build();
    }

    @Bean
    public Docket residentInfoRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("人口信息查询")
                .apiInfo(apiInfo("人口信息查询 RESTFul API 接口调用详情"))
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(ResidentInfoAnno.class))
                .paths(PathSelectors.ant("/resident/info/**"))
                .build();
    }

    @Bean
    public Docket surveyVisitRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("调查走访管理")
                .apiInfo(apiInfo("调查走访管理 RESTFul API 接口调用详情"))
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(SurveyVisitAnno.class))
                .paths(PathSelectors.ant("/survey/visit/**"))
                .build();
    }

    @Bean
    public Docket houseInfoRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("房屋信息查询")
                .apiInfo(apiInfo("房屋信息查询 RESTFul API 接口调用详情"))
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(HouseInfoAnno.class))
                .paths(PathSelectors.ant("/house/info/**"))
                .build();
    }

    @Bean
    public Docket communityOfficerRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("小区信息管理")
                .apiInfo(apiInfo("小区警员维护 RESTFul API 接口调用详情"))
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(CommunityOfficerAnno.class))
                .paths(PathSelectors.ant("/community/officer/**"))
                .build();
    }

    @Bean
    public Docket userRightRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户权限管理")
                .apiInfo(apiInfo("用户权限管理 RESTFul API 接口调用详情"))
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(UserRightAnno.class))
                .paths(PathSelectors.ant("/user/right/**"))
                .build();
    }

    private ApiInfo apiInfo(String titleDes) {
        return new ApiInfoBuilder()
                .title(titleDes)
                .description("宿迁公安人口管控系统")
                .termsOfServiceUrl("http://popc.jd.com/")
                .contact(new Contact("yangsong", "https://swagger.io/", "yangsong6@jd.com"))
                .version("1.0")
                .build();
    }
}