package OutputClasses;

import Site.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import inputFiles.Movie;
import inputFiles.User;

import java.util.ArrayList;

public class OutputAdd {
    public void add(String error, ArrayList<Movie> movies, User currentUser, ArrayNode out, Page currentPage)
    {
        ObjectMapper obj=new ObjectMapper();
        if (error!=null)
            out.add(obj.valueToTree(new Output(error, new ArrayList<>(),currentUser)));
        else if(currentPage.getPageType().equals("movie")) {
            ArrayList<Movie> newMovie=new ArrayList<>();
            newMovie.addAll(movies);
            out.add(obj.valueToTree(new Output(error, newMovie, currentUser)));
        }
        else if(currentPage.getPageType().equals("see details")){
            ArrayList<Movie> newMovie=new ArrayList<>();
            newMovie.addAll(movies);
            out.add(obj.valueToTree(new Output(error, newMovie, currentUser)));
        }
        else out.add(obj.valueToTree(new Output(error, new ArrayList<>(),currentUser)));
    }
}
