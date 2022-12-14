package site;

import java.util.HashMap;

/**
 * Site is a singleton that contains all the pages of the site
 * It is implemented using a hashMap that contains a string with the type of the page
 * and a class that represent an instance of that page
 */
public final class Site {
    private static Site instance;

    private Site() {
        site.put("homePageN", new HomePageNeautentificat());
        site.put("login", new Login());
        site.put("register", new Register());
        site.put("homePageA", new HomePageAutentificat());
        site.put("logout", new Logout());
        site.put("movies", new MoviePage());
        site.put("see details", new SeeDetails());
        site.put("upgrades", new Upgrades());
    }

    public static Site getInstance() {
        if (instance == null) {
            instance = new Site();
        }
        return instance;
    }

    private HashMap<String, Page> site = new HashMap<>();

    public HashMap<String, Page> getSite() {
        return site;
    }
}
