package Pages;
import java.util.ArrayList;
import java.util.TreeMap;

public class Site {
    private static Site instance;
    private Site(){
        site.put("homePageNeautentificat" ,new HomePageNeAtt());
        site.put("login",new Login());
        site.put("register", new Register());
        site.put("homePageAutentificat",new HomePageAutentificat());
        site.put("logout",new Logout());
        site.put("movies",new MoviePage());
    }

    public static Site getInstance(){
        if(instance==null)
        {
            instance=new Site();
        }
        return instance;
    }
   private TreeMap<String , Page> site = new TreeMap<>();

    public TreeMap <String, Page> getSite() {
        return site;
    }
}
