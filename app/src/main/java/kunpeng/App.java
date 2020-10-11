package kunpeng;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import pojo.helloword;
import static POJO.ENTIYKt.dao;
@MapperScan(value ={"mapper"})//扫描 mapper包
@ComponentScan(value = {"service"}) //需要
@ComponentScan(value = {"kunpeng.controller"})
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
//        kunpeng 作为web 模块
        helloword testservice =  new helloword(); //引用同级模块
        testservice.say();
        dao();//kotiln 示例
    }
}
