package Site;

import inputFiles.Movie;

import java.util.ArrayList;

public class MoviePage extends Page{
    ArrayList<Movie> movies=new ArrayList <Movie>();
    public MoviePage() {
        setPageType("movies");
        setAvailablePages("homePageA");
        setAvailablePages("see details");
        setAvailablePages("logout");
        setAvailablePages("movies");

    }

    public ArrayList <Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList <Movie> movies) {
        this.movies = movies;
    }
}
