package servlets;

import accounts.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hofa on 26.03.2018.
 */
public class SignUpServlet extends HttpServlet {
    private final AccountService accountService;

    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {

        java.util.logging.Logger.getGlobal().info(request.getParameter("login") + " " + request.getParameter("password"));

        if (accountService.userExist(request.getParameter("login"))){

            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("Authorized: "+ request.getParameter("login"));
            response.setStatus(HttpServletResponse.SC_OK);

        }else{
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().print("Unauthorized");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
