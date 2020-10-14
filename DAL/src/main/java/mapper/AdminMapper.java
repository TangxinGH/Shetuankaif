package mapper;

import entity.Admin;
import entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AdminMapper {
    int addAdmin(Admin admin);
    int deleteAdmin(Integer adNo);
    int updateAdmin(Admin admin);
     Admin findByAdminInfo();
    Admin  adminLogin(String adName,String adPassword);
}
