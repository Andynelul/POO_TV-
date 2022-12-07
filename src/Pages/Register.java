package Pages;

import Input.Credentials;
import Input.User;

import java.util.ArrayList;

public class Register extends Page{
    public void register(Credentials credentials, ArrayList <User> users){
        users.add(new User(credentials));
    }
}
