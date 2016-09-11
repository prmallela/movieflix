package com.prmallela.app.entity;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.*;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Movie.findAll", query = "SELECT m from Movie m ORDER BY m.title"),
	@NamedQuery(name = "Movie.findByTitle", query = "SELECT m from Movie m where m.title=:ptitle"),
		@NamedQuery(name = "Movie.findByYear", query = "SELECT m from Movie m where m.year=:pyear"),
		@NamedQuery(name = "Movie.findByImdbId", query = "SELECT m from Movie m where m.imdbid=:pimdbid"),

})
public class Movie {
	
	@Id
	private String mid;
	@Column(unique = true)
	private String title;
	private int year;
	private String rated;
	private Date released;
	private String runtime;
	private String genre;
	private String plot;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private String type;
	private String metascore;
	@Column(unique = true)
	private String imdbid;
    private String imdbrating;
    private String imdbvotes;
	private String director;
	private String writer;
	private String actors;

	@OneToMany(cascade = CascadeType.REMOVE)
	private List<RatingComment> ratingComments;

     public Movie(){
	   mid = UUID.randomUUID().toString();
   }
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getRated() {
		return rated;
	}
	public void setRated(String rated) {
		this.rated = rated;
	}
	public Date getReleased() {
		return released;
	}
	public void setReleased(Date released) {
		this.released = released;
	}
	public String getRuntime() {
		return runtime;
	}
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getAwards() {
		return awards;
	}
	public void setAwards(String awards) {
		this.awards = awards;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMetascore() {
		return metascore;
	}
	public void setMetascore(String metascore) {
		this.metascore = metascore;
	}
    public String getImdbid() {
        return imdbid;
    }
    public void setImdbid(String imdbid) {
        this.imdbid = imdbid;
    }
    public String getImdbrating() {
        return imdbrating;
    }
    public void setImdbrating(String imdbrating) {
        this.imdbrating = imdbrating;
    }
    public String getImdbvotes() {
        return imdbvotes;
    }
    public void setImdbvotes(String imdbvotes) { this.imdbvotes = imdbvotes; }
	public List<RatingComment> getRatingComments() { return ratingComments; }
	public void setRatingComments(RatingComment ratingComments) { this.ratingComments.add(ratingComments); }

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}
}

