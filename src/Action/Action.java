package Action;

import Input.Movie;

import java.util.ArrayList;

public class Action {
    public ArrayList<Movie> ban(ArrayList<Movie> movies,String country)
    {
        ArrayList<Movie> newMovies=new ArrayList<>();
        for(int i=0;i< movies.size();i++)
        {
            if(!movies.get(i).getCountriesBanned().contains(country))
            {
                newMovies.add(movies.get(i));
            }
        }
        return newMovies;
    }
    public Movie movieAdd(ArrayList<Movie> movies,String title)
    {
        for(int i=0;i<movies.size();i++)
        {
            if(movies.get(i).getName().equals(title))
            {
                return movies.get(i);
            }
        }
        return null;
    }
}
