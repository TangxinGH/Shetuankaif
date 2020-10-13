package service;

import entity.Admin;
import mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;
   public Admin  adminLogin(String adName,String adPassword){
       return  adminMapper.adminLogin( adName,adPassword);
   }
   public int addAdmin(Admin admin){
       return adminMapper.addAdmin(admin);
   }
    public int deleteAdmin(Integer adNo){
       return adminMapper.deleteAdmin(adNo);
    }
    public int updateAdmin(Admin admin){
       return adminMapper.updateAdmin(admin);
    }
    public  Admin findByAdminInfo(){
       return adminMapper.findByAdminInfo();
    }
}
