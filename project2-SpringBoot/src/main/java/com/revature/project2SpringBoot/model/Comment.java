package com.revature.project2SpringBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {
	
//	- commentId
//	- userId
//	- movieId
//	- comment
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id_gen")
	@SequenceGenerator(name="commment_id_gen", sequenceName = "comment_id_seq", allocationSize = 1)
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="commentid")
	private Integer commentid;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id")
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="movieid")
	private Movie movie;
	
	@Column(name="comment")
	private String comment;

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

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Comment [commentid=" + commentid + ", user=" + user + ", movie=" + movie + ", comment=" + comment + "]";
	}
	
	
	
	

}
