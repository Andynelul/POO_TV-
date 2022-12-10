package Input;

import java.util.ArrayList;
import java.util.Comparator;

public class Movie {
    String name;
    int year;
    int duration;
    ArrayList <String> genres;
    ArrayList <String> actors;
    ArrayList <String> countriesBanned;

    int numLikes=0;

    double rating=0;

    int numRatings=0;

    int totalRating=0;

    public int getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(int totalRating) {
        this.totalRating = totalRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duraction) {
        this.duration = duraction;
    }

    public ArrayList <String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList <String> genres) {
        this.genres = genres;
    }

    public ArrayList <String> getActors() {
        return actors;
    }

    public void setActors(ArrayList <String> actors) {
        this.actors = actors;
    }

    public ArrayList <String> getCountriesBanned() {
        return countriesBanned;
    }

    public void setCountriesBanned(ArrayList <String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }

//    public Movie(String name, int year, int duraction, ArrayList <String> genres, ArrayList <String> actors, ArrayList <String> countriesBanned) {
//        this.name = name;
//        this.year = year;
//        this.duraction = duraction;
//        this.genres = genres;
//        this.actors = actors;
//        this.countriesBanned = countriesBanned;
//    }


    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(int numRatings) {
        this.numRatings = numRatings;
    }

    public Movie() {
    }
}
