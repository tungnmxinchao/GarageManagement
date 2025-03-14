/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.mechanics;

import dal.MechanicsDAO;
import entity.Service;
import entity.ServiceTicket;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author TNO
 */
@WebServlet(name = "ManageServices", urlPatterns = {"/manage-services"})
public class ManageServices extends HttpServlet {

    private static final String MANAGE_SERVICES_PAGE = "manage-services.jsp";
    private static final String ADD_SERVICE_CONTROLLER = "addService";
    private static final String EDIT_SERVICE_CONTROLLER = "editService";
    private static final String DELETE_SERVICE_CONTROLLER = "deleteService";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String url = "Sample";

        try {
            if (action == null) {
                MechanicsDAO mechanicDAO = new MechanicsDAO();

                List<Service> services = mechanicDAO.findAllService();
                request.setAttribute("services", services);

                url = MANAGE_SERVICES_PAGE;

                return;

            }

            switch (action) {
                case "add":
                    url = ADD_SERVICE_CONTROLLER;
                    break;
                case "edit":
                    url = EDIT_SERVICE_CONTROLLER;
                    break;
                case "delete":
                    url = DELETE_SERVICE_CONTROLLER;
                    break;

            }

        } catch (Exception e) {
            response.sendRedirect("error.jsp");
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
