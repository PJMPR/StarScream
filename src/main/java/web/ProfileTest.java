package web;


import Computer.Profile;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/addProfile")
=======
public class ProfileTest extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        String nameSession = request.getParameter("Name");
        String surnameSession = request.getParameter("Surname");
        Profile profile = new Profile();
        profile.setName(nameSession);
        profile.setSurname(surnameSession);

        if (!profile.getName().equals("") && !profile.getSurname().equals("") && !profile.getName().equals(null) && profile.getSurname().equals(null)) {
            session.setAttribute("profile", profile);
        }

        String name = request.getParameter("Name");
        String surname = request.getParameter("Surname");
        PrintWriter out = response.getWriter();
        out.println("Imię: "
                + name
                + "Nazwisko: "
                + surname);
        out.close();
    }
}
