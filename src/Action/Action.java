package action;

import inputfiles.Movie;

import java.util.ArrayList;

/**
 * implements some methods to make the flow of the project easier to understand
 */
public class Action {
    /**
     * Method ban is banning the movies from the users country
     *
     * @param movies
     * @param country
     * @return
     */
    public ArrayList<Movie> ban(final ArrayList<Movie> movies, final String country) {
        ArrayList<Movie> newMovies = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            if (!movies.get(i).getCountriesBanned().contains(country)) {
                newMovies.add(movies.get(i));
            }
        }
        return newMovies;
    }

    /**
     * method search is searching the movies that start with a given sequence
     *
     * @param movies
     * @param startsWith
     * @return
     */
    public ArrayList<Movie> search(final ArrayList<Movie> movies, final String startsWith) {
        ArrayList<Movie> tempMovieList = new ArrayList<>();
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().startsWith(startsWith)) {
                tempMovieList.add(movies.get(i));
            }
        }
        return tempMovieList;
    }
}
