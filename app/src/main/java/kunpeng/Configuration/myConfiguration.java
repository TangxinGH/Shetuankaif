package kunpeng.Configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import service.UserService;

@Configuration
@ComponentScan //为什么要这个呢， 也作为
//配置组件扫描指令以与@Configuration类一起使用。提供与Spring XML<context:component-scan>元素平行的支持。
//        可以指定basePackageClasses()或basePackages()（或其别名 value()）来定义要扫描的特定程序包。如果未定义特定的程序包，则将从声明此批注的类的程序包中进行扫描。
public class myConfiguration {
//    @Bean("testBean") //只能方法上
//    public UserService beanUsersevice(){
//        return new UserService(); //会自动实例化实例化成为一个springBean 在springIOC容器里
////
//@Primary
//@Bean(name = "tes") //  必须要用name指定 ，
////    我认为您@Qualifier
////    对文档有误解，“在自动装配时，此注释可以在字段或参数上用作候选bean的限定符。 ”
//
////    在你的情况下@Qualifier是没有意义的。
//    public testB tessstB(){
//        return new testB();
//    }
//
//    @Bean(name = "tesh") //  必须要用name指定 ，
////    我认为您@Qualifier
////    对文档有误解，“在自动装配时，此注释可以在字段或参数上用作候选bean的限定符。 ”
//
////    在你的情况下@Qualifier是没有意义的。
//    public testB tesstB(){
//        return new testB();
//    }


}


