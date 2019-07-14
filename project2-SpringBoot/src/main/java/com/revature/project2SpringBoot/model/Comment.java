package com.revature.project2SpringBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MOVIECOMMENTS")
public class Comment {
	
//	- commentId
//	- userId
//	- movieId
//	- comment
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id_gen")
	@SequenceGenerator(name="comment_id_gen", sequenceName = "comment_id_seq", allocationSize = 1)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="COMMENTID")
	private Integer commentid;
	
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="USERID")
	@Column(name="USERID")
	private int userid;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="MOVIEID")
	@Column(name="MOVIEID")
	private int movieid;
	
	@Column(name="DESCRIPTION")
	private String commentText;

	public Comment() {
		super();
		
	}

	public Integer getCommentid() {
		return commentid;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}

	public int getUserId() {
		return this.userid;
	}

	public void setUser(int userid) {
		this.userid = userid;
	}

	public int getMovieId() {
		return this.movieid;
	}

	public void setMovieId(int movieid) {
		this.movieid = movieid;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	@Override
	public String toString() {
		return "Comment [commentid=" + commentid + ", user=" + userid + ", movie=" + movieid + ", commentText=" + commentText + "]";
	}	
}
