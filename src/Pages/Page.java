package Pages;

import java.util.ArrayList;

public class Page {
    private ArrayList<String> availablePages=new ArrayList<>();

    public ArrayList <String> getAvailablePages() {
        return availablePages;
    }

    public void setAvailablePages(String s) {
        availablePages.add(s);
    }

    public Page() {
    }
}
