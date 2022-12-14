package site;

import inputfiles.Credentials;
import inputfiles.User;

import java.util.ArrayList;

public class Register extends Page {
    public Register() {
        setPageType("register");
    }

    public void register(Credentials credentials, ArrayList<User> users) {
        users.add(new User(credentials));
    }
}
