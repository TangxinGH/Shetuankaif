package mapper;

import entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public User login(Integer Sno, String Password);

  int register(User user);
    User findById(Integer id);
    List<User> findAll();
    Integer  update(User user);

}
