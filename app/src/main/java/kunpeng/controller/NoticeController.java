package kunpeng.controller;

import entity.Notice;
import kunpeng.bean.CodeMsg;
import kunpeng.bean.Result;
import kunpeng.until.RegexUtil;
import org.omg.CORBA.UNKNOWN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.NoticeService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;


    @RequestMapping(value = "/publishANotice",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> addANotice(@RequestBody Notice notice){
        //noticeService.addANotice(notice);
        /*try {
            noticeService.addANotice(notice);
        }
        catch (Exception e){
            return Result.error(CodeMsg.ADD_NOTICE_FAILED);
        }*/
        return noticeService.addANotice(notice) > 0 ? Result.success(CodeMsg.ADD_NOTICE_SUCCESSFULLY) : Result.error(CodeMsg.ADD_NOTICE_FAILED);
    }


    @RequestMapping(value = "/getAllNoticesTitles")
    @ResponseBody
    public Map<String,Object> getAllNoticesTitles(){//获取公告
        Map<String,Object> resultMap = new HashMap<>();
        try {
            List<String> noticeTitles = noticeService.getAllNoticesTitles();
            resultMap.put("resultCode", CodeMsg.SUCCESS);
            resultMap.put("noticeTitles",noticeTitles);
        }
        catch (Exception e){
            resultMap.put("resultCode", CodeMsg.UNKNOWN_ERROR);
            resultMap.put("noticeTitles",null);
            //resultMap.remove("noticeTitles");
        }
        return resultMap;
    }

    @RequestMapping(value = "/delNotice")
    @ResponseBody
    public Result<Boolean> deleteANotice(@RequestParam String ntID){
        int affected;
        try {
            affected = noticeService.deleteNoticeByID(Integer.parseInt(ntID));
        }
        catch (Exception e){
            return Result.error(CodeMsg.UNKNOWN_ERROR);
        }
        return affected > 0 ? Result.success(CodeMsg.DELETE_NOTICE_SUCCESSFULLY) : Result.error(CodeMsg.DELETE_NOTICE_FAILED);
    }

    @RequestMapping(value = "/updateANotice",method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> updateANotice(Notice notice){
        /*int affected;
        try {
            affected = noticeService.updateNoticeByID(notice);
        }
        catch (Exception e){
            return Result.error(CodeMsg.UNKNOWN_ERROR);
        }
        return affected > 0 ? Result.success(CodeMsg.UPDATE_NOTICE_SUCCESSFULLY) : Result.error(CodeMsg.UPDATE_NOTICE_FAILED);
    */
        notice.setNt_Publish_Time(new Date());
        return noticeService.updateNoticeByID(notice) > 0 ? Result.success(CodeMsg.UPDATE_NOTICE_SUCCESSFULLY) : Result.error(CodeMsg.UPDATE_NOTICE_FAILED);
    }

    @RequestMapping(value = "/getNotices")
    @ResponseBody
    public Map<String,Object> getAllNotices(){
        Map<String,Object> resultMap = new HashMap<>();
        try{
            List<Notice> notices = noticeService.getAllNotices();
            resultMap.put("resultCode", notices.size() > 0 ? Result.success(CodeMsg.QUERY_NOTICE_SUCCESSFULLY) : Result.error(CodeMsg.QUERY_NOTICE_NOT_EXIST));
            resultMap.put("notices",notices);
        }
        catch (Exception e){
            resultMap.put("resultCode", CodeMsg.UNKNOWN_ERROR);
            resultMap.put("notices",null);
        }
        return resultMap;
    }

}
