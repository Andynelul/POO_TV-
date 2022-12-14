package action;

import inputfiles.Contains;
import inputfiles.Movie;
import inputfiles.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * FilterOptions is implementing the filters given at the input
 * To this class there can be added more filters
 * every filter category has its own method and in Getcommands they are called in which order
 * is needed
 */
public class FilterOptions {
    /**
     * Filter option sort
     * It is sorting the movies based on the input received
     *
     * @param sort   is the sorting type wanted
     * @param movies the movies that need to be sorted
     */
    public void sort(final Sort sort, final ArrayList<Movie> movies) {
        if (movies != null) {
            Comparator<Movie> movieComparatorByDuration =
                    Comparator.comparing(Movie::getDuration);
            Comparator<Movie> movieComparatorByRating =
                    Comparator.comparing(Movie::getRating);

            if (sort.getRating() != null && sort.getDuration() != null) {
                Comparator<Movie> movieComparator;
                if (sort.getRating().equals("increasing") && sort.getDuration().equals(
                        "increasing")) {
                    movieComparator =
                            movieComparatorByDuration.thenComparing(movieComparatorByRating);
                } else if (sort.getRating().equals("decreasing") && sort.getDuration().equals(
                        "decreasing")) {

                    movieComparator =
                            movieComparatorByDuration.reversed().thenComparing(
                                    movieComparatorByRating.reversed());
                } else if (sort.getRating().equals("increasing") && sort.getDuration().equals(
                        "decreasing")) {
                    movieComparator =
                            movieComparatorByDuration.reversed().thenComparing(
                                    movieComparatorByRating);
                } else {
                    movieComparator =
                            movieComparatorByDuration.thenComparing(
                                    movieComparatorByRating.reversed());
                }
                Collections.sort(movies, movieComparator);
                movies.sort(movieComparator);
            } else if (sort.getRating() != null) {
                Collections.sort(movies, movieComparatorByRating);
                if (sort.getRating().equals("increasing")) {

                    movies.sort(movieComparatorByRating);
                } else {
                    movies.sort(movieComparatorByRating.reversed());
                }
            } else {
                Collections.sort(movies, movieComparatorByDuration);
                if (sort.getRating().equals("increasing")) {
                    movies.sort(movieComparatorByDuration);
                } else {
                    movies.sort(movieComparatorByDuration.reversed());
                }

            }


        }
    }

    /**
     * Creates an array with the movies that contain some actors or genres
     *
     * @param contains the genres or actors wanted
     * @param movies   the list of movies
     * @return
     */
    public ArrayList<Movie> contains(final Contains contains, final ArrayList<Movie> movies) {
        ArrayList<Movie> newMovies = new ArrayList<>();

        if (!contains.getActors().isEmpty()) {
            if (!contains.getGenre().isEmpty()) {
                ArrayList<Movie> newMovies2 = new ArrayList<>();

                for (int i = 0; i < movies.size(); i++) {
                    for (int j = 0; j < contains.getActors().size(); j++) {
                        if (movies.get(i).getActors().contains(contains.getActors().get(j))) {
                            newMovies2.add(movies.get(i));
                        }
                    }
                }
                for (int i = 0; i < newMovies2.size(); i++) {
                    for (int j = 0; j < contains.getGenre().size(); j++) {
                        if (newMovies2.get(i).getGenres().contains(contains.getGenre().get(j))) {
                            newMovies.add(newMovies2.get(i));
                        }
                    }
                }
            } else {
                for (int i = 0; i < movies.size(); i++) {
                    for (int j = 0; j < contains.getActors().size(); j++) {
                        if (movies.get(i).getActors().contains(contains.getActors().get(j))) {
                            newMovies.add(movies.get(i));
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < movies.size(); i++) {
                for (int j = 0; j < contains.getGenre().size(); j++) {
                    if (movies.get(i).getGenres().contains(contains.getGenre().get(j))) {
                        newMovies.add(movies.get(i));
                    }
                }
            }
        }
        return newMovies;
    }
}
