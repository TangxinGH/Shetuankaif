package mapper;

import entity.Comment;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface CommentMapper {
    List<Comment> getAllComments();
    List<Comment> getCommentBySno(Integer sno);
    List<Comment> getCommentByActivityID(Integer actID);
    int addAComment(Comment Comment);
    int deleteACommentBySno(Integer cmtID);
    int deleteACommentByCommentID(Integer cmtID);
    int updateACommentBySno(Comment comment);
}
