package com.revature.project2SpringBoot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_id_gen")
	@SequenceGenerator(name="movie_id_gen", sequenceName = "movie_id_seq", allocationSize = 1)
	@Column(name="movieid")
	private Integer movieid;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id")
	private User user;
	
	@Column(name="genre")
	private String genre;
	
	@Column(name="favorite")
	private Integer favorite;
	
	@Column(name="watched")
	private Integer watched;
	
	@OneToMany(mappedBy="movie")
	private List<Comment> comments;

	public Movie() {
		super();
	}

	public Integer getMovieid() {
		return movieid;
	}

	public void setMovieid(Integer movieid) {
		this.movieid = movieid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getFavorite() {
		return favorite;
	}

	public void setFavorite(Integer favorite) {
		this.favorite = favorite;
	}

	public Integer getWatched() {
		return watched;
	}

	public void setWatched(Integer watched) {
		this.watched = watched;
	}
	
	public List<Comment> getComments(){
		return this.comments;
	}
	
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Movie [movieid=" + movieid + ", user=" + user + ", genre=" + genre + ", favorite=" + favorite
				+ ", watched=" + watched + "]";
	}

	// add a comment to be associated with a particular movie
	public void addComment(Comment comment) {
		if(this.comments == null) {
			this.comments = new ArrayList<>();
		}
		
		this.comments.add(comment);
		comment.setMovie(this);
	}
	
	
	
	
}
