package outputclasses;

import inputfiles.Movie;
import inputfiles.User;

import java.util.ArrayList;

public final class Output {
    private String error;
    private ArrayList<Movie> currentMoviesList;
    private User currentUser;

    public Output(final String error, final ArrayList<Movie> currentMoviesList,
                  final User currentUser) {
        this.error = error;
        this.currentMoviesList = currentMoviesList;
        this.currentUser = currentUser;
    }

    public String getError() {
        return error;
    }

    public void setError(final String error) {
        this.error = error;
    }

    public ArrayList<Movie> getCurrentMoviesList() {
        return currentMoviesList;
    }

    public void setCurrentMoviesList(final ArrayList<Movie> currentMoviesList) {
        this.currentMoviesList = currentMoviesList;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(final User currentUser) {
        this.currentUser = currentUser;
    }
}
