package com.hxzy.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Release implements Serializable {
    /**
     * 上映信息编号
     */
    private Integer id;

    /**
     * 放映厅编号
     */
    //private Integer room;
    private Room room;

    /**
     * 电影编号
     */
    private Movie movie;

    /**
     * 上映时间
     */
    private Date time;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
        Release other = (Release) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRoom() == null ? other.getRoom() == null : this.getRoom().equals(other.getRoom()))
            && (this.getMovie() == null ? other.getMovie() == null : this.getMovie().equals(other.getMovie()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRoom() == null) ? 0 : getRoom().hashCode());
        result = prime * result + ((getMovie() == null) ? 0 : getMovie().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        return result;
    }

    public Release() {
    }

    public Release(Integer id, Room room, Movie movie, Date time) {
        this.id = id;
        this.room = room;
        this.movie = movie;
        this.time = time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(", id=").append(id);
        sb.append(", room=").append(room);
        sb.append(", movie=").append(movie);
        sb.append(", time=").append(time);
        sb.append("]");
        return sb.toString();
    }
}