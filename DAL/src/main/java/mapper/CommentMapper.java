package mapper;

import entity.Comment;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> getAllComments();
    List<Comment> getCommentBySno(Integer Sno);
    List<Comment> getCommentByActivityID(Integer ActID);
    int addAComment(Comment Comment);
    int deleteACommentBySno(Integer Sno);
    int deleteACommentByCommentID(Integer CmtID);
    int updateACommentBySno(Comment Comment);
}
