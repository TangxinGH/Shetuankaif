package service;

import entity.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {

    @Autowired
    private UserMapper userMapper; //抽象类不能实例化
/*public  void  login(){
    System.out.println("登录中");
}*/


/*String sno="143";
String sname="234";
    public User login(String username, String password){
        return userMapper.login(sno,sname);
    }*/


    public User login(String Sno, String Password){return userMapper.login(Sno,Password);}

    public   int  update(User user) { return userMapper.update(user); }
    public   int register(User user){return userMapper.register(user);}
    public User findBySno(String sno) {
        return userMapper.findBySno(sno);
    }
    public List<User> findAll(){
        return userMapper.findAll();
    }
    public int deleteUser(String sno){ return  userMapper.deleteUser(sno); }
}
