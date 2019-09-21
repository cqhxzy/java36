package com.hxzy.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class Movie implements Serializable {
    /**
     * 电影id自增长
     */
    private Integer movieId;

    /**
     * 电影名称
     */
    private String movieName;

    /**
     * 电影类型
     */
    private String movieType;

    /**
     * 0为未上架，1为已上架
     */
    private Integer state;

    private static final long serialVersionUID = 1L;

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Movie other = (Movie) that;
        return (this.getMovieId() == null ? other.getMovieId() == null : this.getMovieId().equals(other.getMovieId()))
            && (this.getMovieName() == null ? other.getMovieName() == null : this.getMovieName().equals(other.getMovieName()))
            && (this.getMovieType() == null ? other.getMovieType() == null : this.getMovieType().equals(other.getMovieType()))
            && (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMovieId() == null) ? 0 : getMovieId().hashCode());
        result = prime * result + ((getMovieName() == null) ? 0 : getMovieName().hashCode());
        result = prime * result + ((getMovieType() == null) ? 0 : getMovieType().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        return result;
    }

    public Movie() {
    }

    public Movie(Integer movieId, String movieName, String movieType, Integer state) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieType = movieType;
        this.state = state;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", movieId=").append(movieId);
        sb.append(", movieName=").append(movieName);
        sb.append(", movieType=").append(movieType);
        sb.append(", state=").append(state);
        sb.append("]");
        return sb.toString();
    }
}