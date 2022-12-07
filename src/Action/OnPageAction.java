//package Action;
//
//import Input.Action;
//import Input.InputData;
//import Input.Movie;
//import Input.User;
//import OutputClasses.OutputAdd;
//import Pages.Login;
//import Pages.Page;
//import Pages.Register;
//import Pages.Site;
//import com.fasterxml.jackson.databind.node.ArrayNode;
//
//import java.util.ArrayList;
//
//public class OnPageAction {
//    public void action(Action action, InputData input, Page currentPage, User currentUser,ArrayNode out){
//        OutputAdd output=new OutputAdd();
//        if(action.getFeature().equals("login"))
//        {
//            if(currentPage instanceof Login)
//            {
//                Login currentPage1 = (Login) currentPage;
//                if(currentPage1.login(action.getCredentials(), input.getUsers())) {
//                    output.add(null, input.getMovies(), currentUser, out, currentPage);
//                    currentPage= Site.getInstance().getSite().get("HomePageAutentificat");
//                }
//                    else
//                {
//                    output.add("Error",input.getMovies(),currentUser,out,currentPage);
//                }
//            }
//            else
//            {
//                output.add("Error",input.getMovies(),currentUser,out,currentPage);
//            }
//        }
//        if(action.getType().equals("register"))
//        {
//            if(currentPage instanceof Register )
//            {
//              Register currentPageCopy=(Register) currentPage;
//              currentPageCopy.register(action.getCredentials(), input.getUsers());
//                output.add(null,input.getMovies(), currentUser, out, currentPage);
//                currentPage=Site.getInstance().getSite().get("HomePageAutentificat");
//
//            }
//            else
//            {
//                output.add("Error",input.getMovies(),currentUser,out,currentPage);
//            }
//        }
//    }
//}
