package myspring.di.annot.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration //설정 클래스임을 나타내는 어노테이션
@ComponentScan(basePackages = {"myspring.di.annot"})
public class HelloBeanConfig {

}
