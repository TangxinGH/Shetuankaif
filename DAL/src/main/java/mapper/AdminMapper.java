package mapper;

import entity.Admin;
import entity.Comment;
import entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AdminMapper {
    int addAdmin(Admin admin);
    int deleteAdmin(Long adNo);
    int updateAdmin(Admin admin);
     Admin findByAdminNO(Integer adNo);
    Admin  adminLogin(String adName,String adPassword);
    List<Admin> findAllAdmin();

}
