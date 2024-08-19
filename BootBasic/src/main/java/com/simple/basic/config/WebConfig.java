package com.simple.basic.config;

import com.simple.basic.command.TestVO;
import com.simple.basic.controller.HomeController;
import com.simple.basic.interceptor.UserAuthHandler;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration //의미: 스프링 설정 파일이다
//@PropertySource("classpath:/hello.properties") //특정 properties 파일을 참조받고 싶다면..
public class WebConfig implements WebMvcConfigurer {

    //userAuthHandler를 자바 빈으로 등록
    @Bean
    public UserAuthHandler userAuthHandler() {
        return new UserAuthHandler();
    }

    //인터셉터로 userAuthHandler를 등록
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userAuthHandler())
                //.addPathPatterns("/user/mypage") //어떤 경로에 인터셉터를 등록할 것인지
                //.addPathPatterns("/user/success")
                .addPathPatterns("/user/*") //user로 시작하는 모든 경로에
                .excludePathPatterns(Arrays.asList("/user/login", "/user/loginForm", "/user/logout")) //제외할 경로
                ;
        //만약 종류별로 다양한 인터셉터를 추가할 것이라면 아래처럼 추가하면 된다.
        //registry.addInterceptor(~~~)
    }



    /*
    @Value("${server.port}") //application.properties 파일의 키 값을 읽어서 받아온다
    String port;

    @Value("${hello}")
    String hello;

    @Value("${bye}")
    String bye;
    @Autowired
    ApplicationContext applicationContext;

    //자바코드로 빈생성
    @Bean
    public TestVO testVO() {
        return new TestVO(); //bean등록
    }

    @Bean //스프링이 이 코드를 실행시켜서 return에 담기는 값을 bean으로 등록시킨다.
    public void test() {


//        System.out.println("스프링 설정파일 실행됨");
//
//        int result = applicationContext.getBeanDefinitionCount();
//        System.out.println("context안에 bean의 개수:" + result);
//
//        HomeController home = applicationContext.getBean(HomeController.class);
//        System.out.println("context안에 home컨트롤러:" + home);

        TestVO vo = applicationContext.getBean(TestVO.class);
        System.out.println("context안에 testVO빈:" + vo);


        System.out.println("application.properties server.port값:" + port);
        System.out.println("hello값:" + hello);
        System.out.println("bye값:" + bye);
    } */

}
