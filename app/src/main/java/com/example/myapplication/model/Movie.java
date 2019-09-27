package com.example.myapplication.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Movie {
    private UUID id;
    private String director;
    private String episodeName;
    private Integer airedSeason;
    private Date firstAired;
    private HashMap<String, Actor> guestStars = new HashMap<String, Actor>();
    private Double rating;

    public Movie() {

    }

    public Movie(String director,
                 String episodeName,
                 Integer airedSeason,
                 Date firstAired,
                 HashMap<String, Actor> guestStars,
                 Double rating
    ) {
        this.director = director;
        this.airedSeason = airedSeason;
        this.episodeName = episodeName;
        this.firstAired = firstAired;
        this.guestStars = guestStars;
        this.rating = rating;
        this.id = UUID.randomUUID();
    }

    public void addGuestStar(Actor actor) {
        guestStars.put(actor.getName(), actor);
    }

    public Date getFirstAired() {
        return firstAired;
    }

    public HashMap<String, Actor> getGuestStars() {
        return guestStars;
    }

    public Double getRating() {
        return rating;
    }

    public Integer getAiredSeason() {
        return airedSeason;
    }

    public String getDirector() {
        return director;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public UUID getId() {
        return id;
    }

    public String getHeader(){
        String guest=new String();
        int i=1;
        for (Map.Entry<String, Actor> a:guestStars.entrySet()
             ) {
            guest+= String.format("%d. ",i++)+a.getKey()+"\n";
        }
        return "Title     : "+getEpisodeName()+
                "\nSeason    : "+getAiredSeason()+
                "\nRating    : "+getRating()+
                "\nGuestStar :\n"+guest;
    }
    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "Error while converting to String";
        }
    }
}
