package Pages;

public class SeeDetails extends Page{
    String Title;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public SeeDetails()
    {
        super();
        setAvailablePages("homePageAutentificat");
        setAvailablePages("movies");
        setAvailablePages("upgrades");
        setAvailablePages("purchase");
    }
}
