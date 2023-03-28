
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/addfood") // sub ce denumire vreau sa fie cunoscut servletul meu de catre browser
public class PrimulServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("ce faci ma servere 11 ");

        //citirea de pe req
        String foodName = req.getParameter("foodname");
        System.out.println(foodName);

        // zici codul mirelei de salvare in db

        //afisarea pe browser
        PrintWriter pw = resp.getWriter();
        if(foodName==null || foodName.equals("null"))
            pw.println("error, foodname is missing");
        else
            pw.println(foodName.toUpperCase());
        //
        //
        pw.close();



    }
}