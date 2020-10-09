package service;

import entity.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    //public User login(String username, String password){return userMapper.login(sno,sname);}


    public int register(User user){return userMapper.register(user);}
}
