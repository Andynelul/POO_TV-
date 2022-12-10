package Action;

import Input.Action;
import Input.Contains;
import Input.Movie;
import Input.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FilterOptions {
    public void Sort(Sort sort , ArrayList<Movie> movies)
    {
//        if(sort.getRating().equals("decreasing"))
//        {
//              Comparator<Movie> MovieRating = new Comparator<Movie>() {
//            public int compare(Movie o2,Movie o1)
//            {   if(o1.getRating()!=o2.getRating())
//               return o1.getRating()-o2.getRating();
//                else return o1.getDuration()-o2.getDuration();
//            }
//            };
//            Collections.sort(movies,MovieRating);
//        }
    }
    public ArrayList<Movie> contains(Contains contains,ArrayList<Movie> movies)
    {   ArrayList<Movie> newMovies=new ArrayList<>();
        if(contains.getGenre()!=null&&contains.getActors()!=null)
        {
            for(int i=0;i< movies.size();i++)
            {
                if(movies.get(i).getActors().contains(contains.getActors()))
                    if(movies.get(i).getGenres().contains(contains.getGenre()))
                        newMovies.add(movies.get(i));
            }
        }
        else if(contains.getActors()!=null)
        {
            for(int i=0;i< movies.size();i++)
            {
                if(movies.get(i).getActors().contains(contains.getActors()))
                {
                    newMovies.add(movies.get(i));
                }
            }
        }
       else if(contains.getGenre()!=null)
        {
            for(int i=0;i< movies.size();i++)
            {
                if(movies.get(i).getGenres().contains(contains.getGenre()))
                {
                    newMovies.add(movies.get(i));
                }
            }
        }
        return newMovies;
    }
}
