package service;

import entity.User;
import mapper.UerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {

    @Autowired
    private UerMapper userMapper; //抽象类不能实例化
public  void  login(){
    System.out.println("登录中");
}

/*
String sno="143";
String sname="234";
    public User login(String username, String password){
        return userMapper.login(sno,sname);
    }
*/


    public User login(Integer Sno, String Password){return userMapper.login(Sno,Password);}


    public int register(User user){return userMapper.register(user);}
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
    public List<User> findAll(){
        return userMapper.findAll();
    }
}
