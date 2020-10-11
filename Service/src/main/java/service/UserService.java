package service;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UserService {

    @Autowired
    private mapper.userMapper userMapper; //抽象类不能实例化
public  void  login(){
    System.out.println("登录中");
}

String sno="143";
String sname="234";
    public User login(String username, String password){
        return userMapper.login(sno,sname);
    }


    public int register(User user){return userMapper.register(user);}
}
