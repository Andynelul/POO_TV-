package Site;
import java.util.HashMap;

public class Site {
    private static Site instance;
    private Site(){
        site.put("homePageN" ,new HomePageNeautentificat());
        site.put("login",new Login());
        site.put("register", new Register());
        site.put("homePageA",new HomePageAutentificat());
        site.put("logout",new Logout());
        site.put("movies",new MoviePage());
        site.put("see details",new SeeDetails());
        site.put("upgrades",new Upgrades());
    }

    public static Site getInstance(){
        if(instance==null)
        {
            instance=new Site();
        }
        return instance;
    }
   private HashMap<String , Page> site = new HashMap <>();

    public HashMap <String, Page> getSite() {
        return site;
    }
}
