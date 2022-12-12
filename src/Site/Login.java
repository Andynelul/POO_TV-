package Site;

import inputFiles.Credentials;
import inputFiles.User;

import java.util.ArrayList;

public class Login extends Page{
    public Login() {
        setPageType("login");
    }
    /**
     * Method to be called for testing the homework
     *
     * @param users ArrayList<User> users
     */
    public User login(Credentials credentials, ArrayList<User> users){
        for(int i=0;i<users.size();i++) {
            if ( users.get(i).getCredentials().getName().equals(credentials.getName()) )
                if(users.get(i).getCredentials().getPassword().equals(credentials.getPassword()))
                {
                    return users.get(i);
                }
        }
        return null;
    }

}
