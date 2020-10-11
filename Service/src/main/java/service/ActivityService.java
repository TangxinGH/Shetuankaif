package service;

import entity.Activity;
import entity.User;
import mapper.ActivityMapper;
import mapper.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActivityService {
 @Autowired
    private ActivityMapper activityMapper;
    public List<Activity> findAll(){
        return activityMapper.findAll();

    }
}
