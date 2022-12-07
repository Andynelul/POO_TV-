package Pages;

import Input.Movie;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;

public class MoviePage extends Page{
    ArrayList<Movie> movies=new ArrayList <Movie>();
    public MoviePage() {
        super();
        setAvailablePages("homePageAutentificat");
        setAvailablePages("see details");
        setAvailablePages("logout");

    }

    public ArrayList <Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList <Movie> movies) {
        this.movies = movies;
    }
}
