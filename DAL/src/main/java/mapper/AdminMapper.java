package mapper;

import entity.Admin;
import entity.Comment;
import entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AdminMapper {
    int addAdmin(User user);
    int deleteAdmin(String adNo);
    int updateAdmin(Admin admin);
     Admin findByAdminNO(String adNo);
    Admin  adminLogin(String adName,String adPassword);
    List<Admin> findAllAdmin();

}
