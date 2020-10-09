package mapper;

import entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User login(String sno, String sname);

    int register(User user);

}
