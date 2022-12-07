package Input;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class InputData {
    ArrayList<User> users = new ArrayList <>();
    ArrayList<Movie> movies = new ArrayList <>();
    ArrayList<Action> actions = new ArrayList <>();

    public ArrayList <User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList <User> users) {
        this.users = users;
    }

    public ArrayList <Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList <Movie> movies) {
        this.movies = movies;
    }

    public ArrayList <Action> getActions() {
        return actions;
    }

    public void setActions(ArrayList <Action> actions) {
        this.actions = actions;
    }

//    public InputData(ArrayList <User> users, ArrayList <Movie> movies, ArrayList <Action> actions) {
//        this.users = users;
//        this.movies = movies;
//        this.actions = actions;
//    }

    public InputData() {
    }

    @Override
    public String toString() {
        return "InputData{" +
                "users=" + users +
                ", movies=" + movies +
                ", actions=" + actions +
                '}';
    }
}
