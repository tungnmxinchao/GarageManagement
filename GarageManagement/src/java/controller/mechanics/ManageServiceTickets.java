/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.mechanics;

import dal.MechanicsDAO;
import entity.ServiceTicket;
import java.io.IOException;
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
@WebServlet(name = "ManageServiceTickets", urlPatterns = {"/manage-service-tickets"})
public class ManageServiceTickets extends HttpServlet {

    private static final String MANAGE_SERVICE_TICKETS_PAGE = "manage-service-ticket.jsp";
    private static final String FILTER_TICKETS_CONTROLLER = "filterTickets";
    private static final String EDIT_TICKET_CONTROLLER = "editTicket";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        String url = "Sample";

        try {
            if (action == null) {
                MechanicsDAO mechanicDAO = new MechanicsDAO();

                List<ServiceTicket> tickets = mechanicDAO.findAllServiceTickets();

                request.setAttribute("tickets", tickets);
                url = MANAGE_SERVICE_TICKETS_PAGE;

                return;

            }

            switch (action) {
                case "filter":
                    url = FILTER_TICKETS_CONTROLLER;
                    break;
                case "Edit":
                    url = EDIT_TICKET_CONTROLLER;
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
