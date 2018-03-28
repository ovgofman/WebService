package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hofa on 26.03.2018.
 */
public class SignInServlet extends HttpServlet {
    private final AccountService accountService;

    public SignInServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        java.util.logging.Logger.getGlobal().info(request.getParameter("login") + " " + request.getParameter("password"));

        UserProfile usr = new UserProfile(request.getParameter("login"), request.getParameter("password"));
        accountService.addNewUser(usr);
    }
}
