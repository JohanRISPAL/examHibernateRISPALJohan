package servlets;

import models.Car;
import services.CarService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "GlobalServlet", value = "/")
public class GlobalServlet extends HttpServlet {

    private CarService carService;

    public GlobalServlet(){
        this.carService = new CarService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List marques = this.carService.getMarque();

        HashMap<String, Integer> nbCarsByMarques = new HashMap<String, Integer>();
        for (Integer i = 0; i < marques.size(); i++){
            Integer nbCarsByMarque = this.carService.getNumberOfCarsByMarque(marques.get(i).toString());

            nbCarsByMarques.put(marques.get(i).toString(), nbCarsByMarque);
        }

        request.setAttribute("nbCarsByMarques", nbCarsByMarques);

        Integer nbCars = this.carService.getNumberOfCars();
        request.setAttribute("nbCars", nbCars);

        List tenLastCars = this.carService.getTenLastCarAdded();
        request.setAttribute("tenLastCars", tenLastCars);

        request.getRequestDispatcher("dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
