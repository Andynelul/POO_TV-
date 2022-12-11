package Action;
import inputFiles.Contains;
import inputFiles.Movie;
import inputFiles.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FilterOptions {
    public void Sort(Sort sort , ArrayList<Movie> movies)
    {
        if(movies!=null)
    {
            Comparator <Movie> movieComparatorByDuration=
                    Comparator.comparing(Movie::getDuration);
            Comparator <Movie> movieComparatorByRating=
                    Comparator.comparing(Movie::getRating);

            if(sort.getRating()!=null&&sort.getDuration()!=null)
            {   Comparator <Movie> movieComparator;
                if(sort.getRating().equals("increasing")&&sort.getDuration().equals("increasing")){
                     movieComparator=
                             movieComparatorByDuration.thenComparing(movieComparatorByRating);
                }
                else if(sort.getRating().equals("decreasing")&&sort.getDuration().equals("decreasing")){

                     movieComparator=
                             movieComparatorByDuration.reversed().thenComparing(movieComparatorByRating.reversed());
                }
               else if(sort.getRating().equals("increasing")&&sort.getDuration().equals("decreasing")){
                    movieComparator=
                            movieComparatorByDuration.reversed().thenComparing(movieComparatorByRating);
                }
                else{
                    movieComparator=
                            movieComparatorByDuration.thenComparing(movieComparatorByRating.reversed());
                }
                Collections.sort(movies,movieComparator);
                movies.sort(movieComparator);
            }
            else if(sort.getRating()!=null)
            {Collections.sort(movies, movieComparatorByRating);
                if(sort.getRating().equals("increasing")) {

                    movies.sort(movieComparatorByRating);
                }
                else {
                    movies.sort(movieComparatorByRating.reversed());
                }
            }
            else{
                Collections.sort(movies,movieComparatorByDuration);
                if(sort.getRating().equals("increasing"))
                    movies.sort(movieComparatorByDuration);
                else
                movies.sort(movieComparatorByDuration.reversed());

            }


    }
    }
    public ArrayList<Movie> contains(Contains contains, ArrayList<Movie> movies)
    {   ArrayList<Movie> newMovies=new ArrayList<>();
         if(contains.getActors()!=null)
        {
            for(int i=0;i< movies.size();i++)
            {   for(int j=0;j< contains.getActors().size();j++) {
                if ( movies.get(i).getActors().contains(contains.getActors().get(j)) ) {
                    newMovies.add(movies.get(i));
                }
            }
            }
        }
        else if(contains.getGenre()!=null)
        {
            for(int i=0;i< movies.size();i++)
            {   for(int j=0;j< contains.getActors().size();j++) {
                if ( movies.get(i).getGenres().contains(contains.getGenre().get(i)) ) {
                    newMovies.add(movies.get(i));
                }
            }
            }
        }
        return newMovies;
    }
}
