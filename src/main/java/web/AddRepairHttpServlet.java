package web;

import Computer.Profile;
import Computer.Repair;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/addProfile")
public class AddRepairHttpServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException{
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        String nameOfDevice = request.getParameter("Name of device");
        String price = request.getParameter("price");
        //sprawdzić parametry URL
        if (nameOfDevice == null || nameOfDevice.equals("")){
            response.sendRedirect("/addRepair.html");
        }
        Profile profile = (Profile) session.getAttribute("profile");

        if (profile == null){
            response.sendRedirect("/addProfile.html");
        }

        Repair repair = new Repair();
        repair.setPrice(Integer.parseInt(price));
        repair.setNameOfDeviceInRepair(nameOfDevice);
        repair.setProfile(profile);

        List<Repair> repairs = new ArrayList<Repair>();
        if(session.getAttribute("repairs") != null)
            repairs = (List<Repair>) session.getAttribute("repairs");
        repairs.add(repair);
        session.setAttribute("repairs", repairs);
        response.sendRedirect("/addRepair.html");
    }
}
