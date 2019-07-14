package com.revature.project2SpringBoot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="movie")
public class Movie {
	
	
//	- userId
//	- movieId
//	-genre
//	- boolean favorite
//	- boolean watched

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_id_gen")
	//@SequenceGenerator(name="movie_id_gen", sequenceName = "movie_id_seq", allocationSize = 1)
	@Column(name="movieid")
	private Integer movieid;

	//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="userid")
	@ManyToMany
	@JoinTable(
			name="MOVIECOMMENTS",
			joinColumns=@JoinColumn(name="movieid"),
			inverseJoinColumns = @JoinColumn(name="userid")
			)
	private List<User> users;

	@Column(name="userid")
	private Integer userid;
	
	@Column(name="genre")
	private String genre;
	
	@Column(name="favorited")
	private Integer favorited;
	
	@Column(name="watched")
	private Integer watched;
	
//	@OneToMany(mappedBy="movie")
//	private List<Comment> comments;

	public Movie() {
		super();
	}
	
	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getMovieid() {
		return movieid;
	}

	public void setMovieid(Integer movieid) {
		this.movieid = movieid;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getFavorited() {
		return favorited;
	}

	public void setFavorited(Integer favorite) {
		this.favorited = favorite;
	}

	public Integer getWatched() {
		return watched;
	}

	public void setWatched(Integer watched) {
		this.watched = watched;
	}
	
//	public List<Comment> getComments(){
//		return this.comments;
//	}
//	
//	public void setComments(List<Comment> comments) {
//		this.comments = comments;
//	}

	@Override
	public String toString() {
		return "Movie [movieid=" + movieid + ", userid=" + userid + ", genre=" + genre + ", favorite=" + favorited
				+ ", watched=" + watched + "]";
	}

	// add a comment to be associated with a particular movie
//	public void addComment(Comment comment) {
//		if(this.comments == null) {
//			this.comments = new ArrayList<>();
//		}
//		
//		this.comments.add(comment);
//		comment.setMovie(this);
//	}
}
