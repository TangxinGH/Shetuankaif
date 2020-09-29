package kunpeng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pojo.helloword;

import static POJO.ENTIYKt.dao;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        helloword testservice =  new helloword(); //引用同级模块
        testservice.say();
        dao();//kotiln 示例
    }
}
