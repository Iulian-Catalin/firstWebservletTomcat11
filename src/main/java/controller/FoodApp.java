package controller;

import db.FoodDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/foodapp") // sub ce denumire vreau sa fie cunoscut servletul meu de catre browser
public class FoodApp extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("ce faci ma servere 11 ");

        String action = req.getParameter("action");
        if (action != null && action.equalsIgnoreCase("C")) {
            addFood(req, resp);
        } else if (action != null && action.equalsIgnoreCase("R")) {
            listFood(req, resp);
        }
//        else if(action!=null  && action.equalsIgnoreCase("U")) {
//            createFood(req, resp);
//        }
//        else if(action!=null  && action.equalsIgnoreCase("D")) {
//            deleteFood(req, resp);
//        }
    }


    private void addFood(HttpServletRequest req, HttpServletResponse resp) {

        String foodName = req.getParameter("foodname");

        FoodDB db = new FoodDB();
        db.insert(foodName);

    }

    private void listFood(HttpServletRequest req, HttpServletResponse resp) {
        try {

            FoodDB db = new FoodDB();
            List<String> myListOFFood = db.listAllFood();

            JSONObject json = new JSONObject();
            json.put("listOfFood", myListOFFood);
            String result = json.toString();
            resp.setContentType("application/json");
            PrintWriter pw = resp.getWriter();
            pw.write(result);
            pw.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}