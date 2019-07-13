package com.revature.project2SpringBoot.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.revature.project2SpringBoot.model.Comment;

public interface CommentDAO extends JpaRepository<Comment,Integer>{
	
//	CommentDAO
//	-findOne
//	-save
//	-delete
	
	
	
//	@Query("select c from MOVIECOMMENTS c where c.MOVIEID = :movieid and c.ID = :id")
//	Comment findCommentByMovieIdAndUserId(@Param("movieid") Integer movieid, @Param("userid") Integer id);

//	@Modifying
//	@Query("delete from MOVIECOMMENTS where commentid = :commentid")
//	void delete(@Param("commentid") Integer commentid);
	

}
