package outputclasses;

import site.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import inputfiles.Movie;
import inputfiles.User;

import java.util.ArrayList;

public class OutputAdd {
    public void add(final String error, final ArrayList<Movie> movies, final User currentUser,
                    final ArrayNode out, final Page currentPage) {
        ObjectMapper obj = new ObjectMapper();
        if (error != null) {
            out.add(obj.valueToTree(new Output(error, new ArrayList<>(), currentUser)));
        } else if (currentPage.getPageType().equals("movies")
                || currentPage.getPageType().equals("upgrades")) {
            ArrayList<Movie> newMovie = new ArrayList<>();
            newMovie.addAll(movies);
            out.add(obj.valueToTree(new Output(error, newMovie, currentUser)));
        } else if (currentPage.getPageType().equals("see details")) {
            ArrayList<Movie> newMovie = new ArrayList<>();
            newMovie.addAll(movies);
            out.add(obj.valueToTree(new Output(error, newMovie, currentUser)));
        } else {
            out.add(obj.valueToTree(new Output(error, new ArrayList<>(), currentUser)));
        }
    }
}
