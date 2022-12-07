package OutputClasses;

import Input.Movie;
import Input.User;
import Pages.MoviePage;
import Pages.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;

public class OutputAdd {
    public void add(String error, ArrayList<Movie> movies, User currentUser, ArrayNode out, Page currentPage)
    {
        ObjectMapper obj=new ObjectMapper();
        if(currentPage instanceof MoviePage )
        out.add(obj.valueToTree(new Output(error, movies, currentUser)));
        else if(currentPage.equals("see details"))
            out.add(obj.valueToTree(new Output(error,movies,currentUser)));
        else out.add(obj.valueToTree(new Output(error, new ArrayList<>(),currentUser)));
    }
}
