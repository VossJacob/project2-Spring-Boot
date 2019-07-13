package com.revature.project2SpringBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="USERID")
	private User user;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="MOVIEID")
	private Movie movie;
	
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	@Override
	public String toString() {
		return "Comment [commentid=" + commentid + ", user=" + user + ", movie=" + movie + ", commentText=" + commentText + "]";
	}
	
	
	
	

}
