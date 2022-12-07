package Action;

import Input.Action;
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
      MovPage.setMovies(input.getMovies());
        User currentUser=null;
        Page currentPage=site.getSite().get("homePageNeautentificat");
        for( Action action: input.getActions() )
        {
            if(action.getType().equals("change page"))
            {
                if(currentPage.getAvailablePages().contains(action.getPage()))
                {
                    currentPage=site.getSite().get(action.getPage());
                    if(currentPage instanceof Logout )
                    {   MovPage.setMovies(input.getMovies());
                        currentPage= Site.getInstance().getSite().get("homePageNeautentificat");
                        currentUser=null;

                    }
                    if(currentUser!=null)
                  output.add(null, input.getMovies(), currentUser, out, currentPage);
                } else
                    output.add("Error",input.getMovies(),null,out,currentPage);
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
                            currentPage= Site.getInstance().getSite().get("homePageAutentificat");
                        }
                        else
                        {

                            output.add("Error",input.getMovies(),currentUser,out,currentPage);
                            currentPage= Site.getInstance().getSite().get("homePageNeautentificat");

                        }
                    }
                    else
                    {
                        output.add("Error",input.getMovies(),null,out,currentPage);
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
                        }
                        else
                        {
                            output.add("Error",input.getMovies(),currentUser,out,currentPage);
                            // currentPage= Site.getInstance().getSite().get("homePageNeautentificat");

                        }
                    }
                    else
                    {
                        output.add("Error",input.getMovies(),currentUser,out,currentPage);
                       // currentPage= Site.getInstance().getSite().get("homePageNeautentificat");

                    }
                }
                else if(action.getFeature().equals("search"))
                {
                    ArrayList<Movie> TempMovieList=new ArrayList<>();
                    for(int i=0;i<MovPage.getMovies().size();i++) {
                    if(MovPage.getMovies().get(i).getName().contains(action.getStartsWith()))
                        TempMovieList.add(MovPage.getMovies().get(i));
                }
                    MovPage.setMovies(TempMovieList);
                    output.add(null,MovPage.getMovies(),currentUser,out,currentPage);
                }
                else if(action.getFeature().equals("filter"))
                {

                }
            }
        }

    }
}
