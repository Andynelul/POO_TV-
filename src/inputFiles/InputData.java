package inputFiles;

import java.util.ArrayList;

final public class InputData {
    ArrayList<User> users = new ArrayList<>();
    ArrayList<Movie> movies = new ArrayList<>();
    ArrayList<ActionInput> actions = new ArrayList<>();

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public ArrayList <ActionInput> getActions() {
        return actions;
    }

    public void setActions(ArrayList<ActionInput> actions) {
        this.actions = actions;
    }
}
