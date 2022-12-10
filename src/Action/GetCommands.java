package Action;

import Input.InputData;
import Input.Movie;
import Input.User;
import OutputClasses.OutputAdd;
import Pages.*;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;

public class GetCommands {
    public void action(InputData input, ArrayNode out){
        OutputAdd output=new OutputAdd();
        Site site=Site.getInstance();
      MoviePage MovPage=(MoviePage) site.getSite().get("movies");
        User currentUser=null;
        Page currentPage=site.getSite().get("homePageNeautentificat");
        Action Action =new Action();
        for( Input.Action action: input.getActions() )
        {
            if(action.getType().equals("change page"))
            {
                if(currentPage.getAvailablePages().contains(action.getPage())) {
                    if ( action.getMovie() != null ) {
                        int counter=0;
                        for ( int i = 0; i < MovPage.getMovies().size(); i++ ) {

                            if ( MovPage.getMovies().get(i).getName().equals(action.getMovie()) )
                            {  currentPage = site.getSite().get(action.getPage());
                                SeeDetails pg=(SeeDetails) currentPage;
                                pg.setTitle(action.getMovie());
                            counter++;}
                        }
                        if(counter==0)
                        {
                            output.add("Error",MovPage.getMovies(),null,out,currentPage);
                        }
                    } else {
                        currentPage = site.getSite().get(action.getPage());
                        if ( currentPage instanceof Logout ) {
                            MovPage.setMovies(input.getMovies());
                            currentPage = Site.getInstance().getSite().get("homePageNeautentificat");
                            currentUser = null;

                        }
                        if ( currentUser != null )
                            output.add(null, MovPage.getMovies(), currentUser, out, currentPage);
                    }
                }else
                    output.add("Error",MovPage.getMovies(),null,out,currentPage);
            }
            else if(action.getType().equals("on page"))
            {  // OnPageAction onPage=new OnPageAction();
                //onPage.action(action,input,currentPage,currentUser,out);
                if(action.getFeature().equals("login"))
                {
                    if(currentPage instanceof Login )
                    {
                        Login currentPage1 = (Login) currentPage;
                        if(currentPage1.login(action.getCredentials(), input.getUsers())!=null) {
                            currentUser=currentPage1.login(action.getCredentials(), input.getUsers());
                            output.add(null, input.getMovies(), currentUser, out, currentPage);
                            MovPage.setMovies(Action.ban(input.getMovies(),currentUser.getCredentials().getCountry()));
                            currentPage= Site.getInstance().getSite().get("homePageAutentificat");
                        }
                        else
                        {

                            output.add("Error",MovPage.getMovies(),null,out,currentPage);
                            currentPage= Site.getInstance().getSite().get("homePageNeautentificat");

                        }
                    }
                    else
                    {
                        output.add("Error",MovPage.getMovies(),null,out,currentPage);
                       // currentPage= Site.getInstance().getSite().get("homePageNeautentificat");

                    }
                }
                else if(action.getFeature().equals("register"))
                {
                    if(currentPage instanceof Register )
                    {   int cnt=0;
                        for(int i=0;i<input.getUsers().size();i++) {
                            if ( input.getUsers().get(i).getCredentials().getName().equals(action.getCredentials().getName()) )
                                cnt++;
                        }
                        if(cnt==0) {
                            Register currentPageCopy = (Register) currentPage;
                            currentPageCopy.register(action.getCredentials(), input.getUsers());
                            currentUser = input.getUsers().get(input.getUsers().size() - 1);
                            output.add(null, input.getMovies(), currentUser, out, currentPage);
                            currentPage = Site.getInstance().getSite().get("homePageAutentificat");
                            MovPage.setMovies(Action.ban(input.getMovies(),currentUser.getCredentials().getCountry()));
                        }
                        else
                        {
                            output.add("Error",MovPage.getMovies(),null,out,currentPage);
                            // currentPage= Site.getInstance().getSite().get("homePageNeautentificat");

                        }
                    }
                    else
                    {
                        output.add("Error",MovPage.getMovies(),null,out,currentPage);
                       // currentPage= Site.getInstance().getSite().get("homePageNeautentificat");

                    }
                }
                else if(action.getFeature().equals("search")) {
                    if ( currentPage instanceof MoviePage ) {
                        ArrayList <Movie> TempMovieList = new ArrayList <>();
                        for ( int i = 0; i < MovPage.getMovies().size(); i++ ) {
                            if ( MovPage.getMovies().get(i).getName().contains(action.getStartsWith()) )
                                TempMovieList.add(MovPage.getMovies().get(i));
                        }
                        MovPage.setMovies(TempMovieList);
                        output.add(null, MovPage.getMovies(), currentUser, out, currentPage);
                    }
                    else
                    {
                        output.add("Error",MovPage.getMovies(),null,out,currentPage);
                        // currentPage= Site.getInstance().getSite().get("homePageNeautentificat");

                    }
                }

                else if(action.getFeature().equals("filter"))
                {if ( currentPage instanceof MoviePage ) {
                    FilterOptions filter = new FilterOptions();
                    if(action.getFilters().getContains()!=null)
                    MovPage.setMovies(filter.contains(action.getFilters().getContains(), MovPage.getMovies()));
                    if(action.getFilters().getSort()!=null)
                    filter.Sort(action.getFilters().getSort(), MovPage.getMovies());
                    output.add(null, MovPage.getMovies(), currentUser, out, currentPage);
                }
                    else

                    {
                        output.add("Error",MovPage.getMovies(),null,out,currentPage);
                        // currentPage= Site.getInstance().getSite().get("homePageNeautentificat");

                    }
                }
                else if(action.getFeature().equals("buy tokens"))
                {
                    int balance=Integer.parseInt(currentUser.getCredentials().getBalance());
                    int count=Integer.parseInt(action.getCount());
                    if(balance>=count) {
                        balance = balance - count;
                        currentUser.setTokensCount(count);
                        currentUser.getCredentials().setBalance(String.valueOf(balance));
                    }
                    else output.add("Error",MovPage.getMovies(),null,out,currentPage);

                }
                else if(action.getFeature().equals("buy premium account"))
                {
                    if(currentUser.getTokensCount()>=10) {
                        if ( currentUser.getCredentials().getAccountType().equals("standard") ) {
                            currentUser.setTokensCount(currentUser.getTokensCount() - 10);
                            currentUser.getCredentials().setAccountType("premium");
                        }                    else output.add("Error",MovPage.getMovies(),null,out,currentPage);

                    }                    else output.add("Error",MovPage.getMovies(),null,out,currentPage);

                }
                if(action.getFeature().equals("purchase"))
                {   SeeDetails page=(SeeDetails) currentPage;
                    if(page.getTitle().equals(action.getMovie()))
                    {
                        if(currentUser.getNumFreePremiumMovies()>0)
                        {
                            currentUser.setNumFreePremiumMovies(currentUser.getNumFreePremiumMovies()-1);
                           currentUser.getPurchasedMovies().add(Action.movieAdd(MovPage.getMovies(),action.getMovie()));
                        }                    else output.add("Error",MovPage.getMovies(),null,out,currentPage);

                    }                    else output.add("Error",MovPage.getMovies(),null,out,currentPage);

                }
                else if(action.getFeature().equals("watched"))
                { SeeDetails page=(SeeDetails) currentPage;
                    if(page.getTitle().equals(action.getMovie()))
                    {
                        if(Action.movieAdd(currentUser.getPurchasedMovies(),action.getMovie())!=null)
                        {
                            currentUser.getWatchedMovies().add(Action.movieAdd(currentUser.getPurchasedMovies(),action.getMovie()));
                        }
                        else output.add("Error",MovPage.getMovies(),null,out,currentPage);

                    }
                    else output.add("Error",MovPage.getMovies(),null,out,currentPage);

                }
                else if(action.getFeature().equals("like"))
                {SeeDetails page=(SeeDetails) currentPage;
                    if(page.getTitle().equals(action.getMovie())) {
                        if(Action.movieAdd(currentUser.getWatchedMovies(),action.getMovie())!=null)
                            currentUser.getLikedMovies().add(Action.movieAdd(currentUser.getWatchedMovies(), action.getMovie()));
                        }                    else output.add("Error",MovPage.getMovies(),null,out,currentPage);

                    }                    else output.add("Error",MovPage.getMovies(),null,out,currentPage);

                }
                else if(action.getFeature().equals("rate"))
                    {SeeDetails page=(SeeDetails) currentPage;
                        if(Action.movieAdd(currentUser.getPurchasedMovies(),action.getMovie())!=null)
                            if ( currentUser.getWatchedMovies().contains(action.getMovie()) ) {

                            }                    else output.add("Error",MovPage.getMovies(),null,out,currentPage);

                        }                    else output.add("Error",MovPage.getMovies(),null,out,currentPage);

                    }

            }
        }

    }
}
