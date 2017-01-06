package web;

import Computer.Profile;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/addProfile")
public class AddProfileHttpServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException{
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String nameSession = request.getParameter("name");
        String surnameSession = request.getParameter("surname");

        if (nameSession != null && !nameSession.equals("") && surnameSession != null && !surnameSession.equals("")) {
            Profile profile = new Profile();
            profile.setName(nameSession);
            profile.setSurname(surnameSession);
            session.setAttribute("profile", profile);
            response.sendRedirect("/addRepair.html");
        }
        else {
            response.sendRedirect("/addProfile.html");
        }
    }
}