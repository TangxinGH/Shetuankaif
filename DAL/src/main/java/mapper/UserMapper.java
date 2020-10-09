package mapper;

import entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public User login(String sno, String sname);
//DAO文件 映射数据库
    int register(User user);

}
