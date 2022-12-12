package Action;

import OutputClasses.OutputAdd;
import Site.Page;
import com.fasterxml.jackson.databind.node.ArrayNode;
import inputFiles.ActionInput;
import inputFiles.InputData;
import Site.*;
import java.util.ArrayList;
import Site.MoviePage;
import Site.Login;
import inputFiles.Movie;
import inputFiles.User;

public class GetCommands {
    public void execute(InputData input, ArrayNode out) {

        OutputAdd output = new OutputAdd();
        Site site = Site.getInstance();
        MoviePage movPage = new MoviePage();
        User currentUser = null;
        Page currentPage = site.getSite().get("homePageN");
        Action doAction = new Action();
        for (ActionInput action : input.getActions()) {
            if (action.getType().equals("change page")) {
                if (currentPage.getAvailablePages().contains(action.getPage())) {
                    if (action.getPage().equals("movies")) {
                        movPage.setMovies(doAction.ban(input.getMovies(),
                                currentUser.getCredentials().getCountry()));
                    }
                    if (action.getPage().equals("see details")) {
                        ArrayList <Movie> tempMovie = new ArrayList <>();
                        for (int i = 0; i < movPage.getMovies().size(); i++) {

                            if (movPage.getMovies().get(i).getName().equals(action.getMovie())) {
                                tempMovie.add(movPage.getMovies().get(i));
                                movPage.setMovies(tempMovie);
                                currentPage = site.getSite().get("see details");
                                output.add(null, tempMovie, currentUser, out, currentPage);
                                break;
                            }
                        }
                        if (tempMovie.size() != 1) {
                            output.add("Error", movPage.getMovies(), null, out, currentPage);
                        }
                    } else {
                        currentPage = site.getSite().get(action.getPage());
                        if (currentPage.getPageType().equals("logout")) {
                            movPage.setMovies(input.getMovies());
                            currentPage = Site.getInstance().getSite().get("homePageN");
                            currentUser = null;

                        }
                        if (currentUser != null) {
                            if (!currentPage.getPageType().equals("homePageA")
                                    && !action.getPage().equals("upgrades")) {
                                output.add(null, movPage.getMovies(), currentUser, out, currentPage);
                            }
                        }
                    }
                } else {
                    output.add("Error", movPage.getMovies(), null, out, currentPage);
                }
            } else if (action.getType().equals("on page")) {
                if (action.getFeature().equals("login")) {
                    if (currentPage.getPageType().equals("login")) {
                        Login currentPage1 = (Login) currentPage;
                        if (currentPage1.login(action.getCredentials(), input.getUsers()) != null) {
                            currentUser = currentPage1.login(action.getCredentials(),
                                    input.getUsers());
                            output.add(null, input.getMovies(), currentUser, out, currentPage);
                            movPage.setMovies(doAction.ban(input.getMovies(),
                                    currentUser.getCredentials().getCountry()));
                            currentPage = Site.getInstance().getSite().get("homePageA");
                        } else {

                            output.add("Error", movPage.getMovies(), null, out, currentPage);
                            currentPage = Site.getInstance().getSite().get("homePageN");

                        }
                    } else {
                        output.add("Error", movPage.getMovies(), null, out, currentPage);
                    }
                } else if (action.getFeature().equals("register")) {
                    if (currentPage.getPageType().equals("register")) {
                        int cnt = 0;
                        for (int i = 0; i < input.getUsers().size(); i++) {
                            if (input.getUsers().get(i).getCredentials().getName()
                                    .equals(action.getCredentials().getName())) {
                                cnt++;
                            }
                        }
                        if (cnt == 0) {
                            Register currentPageCopy = (Register) currentPage;
                            currentPageCopy.register(action.getCredentials(), input.getUsers());
                            currentUser = input.getUsers().get(input.getUsers().size() - 1);
                            output.add(null, input.getMovies(), currentUser, out, currentPage);
                            currentPage = Site.getInstance().getSite().get("homePageA");
                            movPage.setMovies(doAction.ban(input.getMovies(),
                                    currentUser.getCredentials().getCountry()));
                        } else {
                            output.add("Error", movPage.getMovies(), null, out, currentPage);
                        }
                    } else {
                        output.add("Error", movPage.getMovies(), null, out, currentPage);
                    }
                } else if (action.getFeature().equals("search")) {
                    if (currentPage.getPageType().equals("movies")) {
                        movPage.setMovies(doAction.search(movPage.getMovies(),
                                action.getStartsWith()));
                        output.add(null, movPage.getMovies(), currentUser, out, currentPage);
                    } else {
                        output.add("Error", movPage.getMovies(), null, out, currentPage);
                    }
                } else if (action.getFeature().equals("filter")) {
                    if (currentPage.getPageType().equals("movies")) {
                        movPage.setMovies(doAction.ban(input.getMovies(),
                                currentUser.getCredentials().getCountry()));
                        FilterOptions filter = new FilterOptions();
                        if (action.getFilters().getContains() != null) {
                            movPage.setMovies(filter.contains(action.getFilters().getContains(),
                                    movPage.getMovies()));
                        }
                        if (action.getFilters().getSort() != null) {
                            filter.Sort(action.getFilters().getSort(), movPage.getMovies());
                        }
                        output.add(null, movPage.getMovies(), currentUser, out, currentPage);
                    } else {
                        output.add("Error", movPage.getMovies(), null, out, currentPage);
                    }
                } else if (action.getFeature().equals("buy tokens")) {
                    if (currentPage.getPageType().equals("upgrades")) {
                        int balance = Integer.parseInt(currentUser.getCredentials().getBalance());
                        int count = Integer.parseInt(action.getCount());
                        if (balance >= count) {
                            balance = balance - count;
                            currentUser.setTokensCount(count);
                            currentUser.getCredentials().setBalance(String.valueOf(balance));
                        } else {
                            output.add("Error", movPage.getMovies(), null, out, currentPage);
                        }
                    } else {
                        output.add("Error", movPage.getMovies(), null, out, currentPage);
                    }

                } else if (action.getFeature().equals("buy premium account")) {
                    if (currentPage.getPageType().equals("upgrades")) {
                        if (currentUser.getTokensCount() >= 10) {
                            if (currentUser.getCredentials().getAccountType().equals("standard")) {
                                currentUser.setTokensCount(currentUser.getTokensCount() - 10);
                                currentUser.getCredentials().setAccountType("premium");
                            } else {
                                output.add("Error", movPage.getMovies(), null, out, currentPage);
                            }
                        }
                    } else {
                        output.add("Error", movPage.getMovies(), null, out, currentPage);
                    }
                } else if (action.getFeature().equals("purchase")) {
                    if (currentPage.getPageType().equals("see details")) {
                        if (currentUser.getCredentials().getAccountType().equals("premium")
                                && currentUser.getNumFreePremiumMovies() > 0) {
                            currentUser.setNumFreePremiumMovies(
                                    currentUser.getNumFreePremiumMovies() - 1);
                            currentUser.getPurchasedMovies().add(movPage.getMovies().get(0));
                            output.add(null, movPage.getMovies(), currentUser, out, currentPage);
                        } else if (currentUser.getTokensCount() > 1) {
                            currentUser.setTokensCount(currentUser.getTokensCount() - 2);
                            currentUser.getPurchasedMovies().add(movPage.getMovies().get(0));
                            output.add(null, movPage.getMovies(), currentUser, out, currentPage);

                        } else {
                            output.add("Error", movPage.getMovies(), null, out, currentPage);
                        }
                    } else {
                        output.add("Error", movPage.getMovies(), null, out, currentPage);
                    }
                } else if (action.getFeature().equals("watch")) {
                    if (currentPage.getPageType().equals("see details")) {
                        if (currentUser.getPurchasedMovies().contains(movPage.getMovies().get(0))) {
                            currentUser.getWatchedMovies().add(movPage.getMovies().get(0));
                            output.add(null, movPage.getMovies(), currentUser, out, currentPage);
                        } else {
                            output.add("Error", movPage.getMovies(), null, out, currentPage);
                        }
                    } else {
                        output.add("Error", movPage.getMovies(), null, out, currentPage);
                    }
                } else if (action.getFeature().equals("like")) {
                    if (currentPage.getPageType().equals("see details")) {
                        if (currentUser.getWatchedMovies().contains(movPage.getMovies().get(0))) {
                            currentUser.getLikedMovies().add(movPage.getMovies().get(0));
                            movPage.getMovies().get(0).setNumLikes(
                                    movPage.getMovies().get(0).getNumLikes() + 1);
                            output.add(null, movPage.getMovies(), currentUser, out, currentPage);
                        } else {
                            output.add("Error", movPage.getMovies(), null, out, currentPage);
                        }
                    } else {
                        output.add("Error", movPage.getMovies(), null, out, currentPage);
                    }
                } else if (action.getFeature().equals("rate")) {
                    if (currentPage.getPageType().equals("see details")) {
                        if (action.getRate() > 0 && action.getRate() < 6) {
                            if (currentUser.getWatchedMovies().contains(movPage.getMovies().get(0))) {
                                double rate = action.getRate() +
                                        (movPage.getMovies().get(0).getRating() *
                                                movPage.getMovies().get(0).getNumRatings());
                                movPage.getMovies().get(0).setNumRatings(
                                        movPage.getMovies().get(0).getNumRatings() + 1);
                                movPage.getMovies().get(0).setRating(rate /
                                        movPage.getMovies().get(0).getNumRatings());
                                currentUser.getRatedMovies().add(movPage.getMovies().get(0));
                                output.add(null, movPage.getMovies(), currentUser, out, currentPage);

                            } else {
                                output.add("Error", movPage.getMovies(), null, out, currentPage);
                            }
                        } else {
                            output.add("Error", movPage.getMovies(), null, out, currentPage);
                        }

                    } else {
                        output.add("Error", movPage.getMovies(), null, out, currentPage);
                    }

                }
            }
        }
    }
}