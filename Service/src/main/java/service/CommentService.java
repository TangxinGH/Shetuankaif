package service;

import entity.Comment;
import mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class CommentService {

    @Autowired
    CommentMapper commentMapper;

    public int addAComment(Comment comment){
        //return 0;
        return commentMapper.addAComment(comment);
    }

    public int deleteACommentBySno(Integer Sno){
        return commentMapper.deleteACommentBySno(Sno);
    }

    public int deleteACommentByCommentID(Integer CmtID){
        return commentMapper.deleteACommentByCommentID(CmtID);
    }

    public List<Comment> getAllComments(){
        return commentMapper.getAllComments();
    }

    public List<Comment> getCommentBySno(Integer Sno){
        return commentMapper.getCommentBySno(Sno);
    }


    public List<Comment> getCommentByActivityID(Integer ActID){
        return commentMapper.getCommentByActivityID(ActID);
    }

    public int updateACommentBySno(Comment comment){
        return commentMapper.updateACommentBySno(comment);
    }

}
