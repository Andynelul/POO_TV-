package Site;

import java.util.ArrayList;

public class Page {
    String pageType;
    private ArrayList<String> availablePages=new ArrayList<>();

    public ArrayList <String> getAvailablePages() {
        return availablePages;
    }

    public void setAvailablePages(String s) {
        availablePages.add(s);
    }

    public Page() {
    }

    public void setPageType(String pageType) {
        this.pageType = pageType;
    }

    public String getPageType() {
        return pageType;
    }
}
