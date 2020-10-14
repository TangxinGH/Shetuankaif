package mapper;

import entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public User login(String Sno, String Password);

    int register(User user);
    User findBySno(String sno);
    List<User> findAll();
    int  update(User user);
    int deleteUser(String sno);

}
