package mapper;

import entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    public User login(String Sno, String Password);

  int register(User user);
    User findBySno(String sno);
    List<User> findAllUser();
    int  updateUser(User user);
    int deleteUser(String sno);
  List<User> findMembers();
    int  joinCommunity(String sno);
    int acceptJoin(String sno);
    int rejectJoin(String sno);

}
