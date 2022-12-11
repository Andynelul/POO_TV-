package OutputClasses;

import inputFiles.Movie;
import inputFiles.User;

import java.util.ArrayList;

public class Output {
    String error;
    ArrayList<Movie> currentMoviesList;
    User currentUser;

    public Output(String error, ArrayList <Movie> currentMoviesList, User currentUser) {
        this.error = error;
        this.currentMoviesList = currentMoviesList;
        this.currentUser = currentUser;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public ArrayList <Movie> getCurrentMoviesList() {
        return currentMoviesList;
    }

    public void setCurrentMoviesList(ArrayList <Movie> currentMoviesList) {
        this.currentMoviesList = currentMoviesList;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
