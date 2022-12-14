package site;

import inputfiles.Movie;

public class SeeDetails extends Page {
    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public SeeDetails() {
        super();
        setPageType("see details");
        setAvailablePages("homePageA");
        setAvailablePages("movies");
        setAvailablePages("upgrades");
        setAvailablePages("logout");
    }
}
