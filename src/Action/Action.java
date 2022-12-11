package Action;

import Site.Page;
import Site.Site;
import inputFiles.ActionInput;
import inputFiles.Movie;

import java.lang.management.MonitorInfo;
import java.util.ArrayList;

public class Action {
    public Page changePage(Page currentPage, ActionInput action)
    {
        if(currentPage.getAvailablePages().contains(action.getPage()))
        {
            currentPage= Site.getInstance().getSite().get(action.getPage());
        }
        else return null;
        return currentPage;
    }
    public ArrayList <Movie> ban(ArrayList<Movie> movies, String country)
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
    public ArrayList <Movie> search(ArrayList<Movie> movies,String startsWith)
    {
        ArrayList <Movie> TempMovieList = new ArrayList <>();
        for ( int i = 0; i < movies.size(); i++ ) {
            if ( movies.get(i).getName().startsWith(startsWith) )
                TempMovieList.add(movies.get(i));
        }
        return TempMovieList;
    }
}
