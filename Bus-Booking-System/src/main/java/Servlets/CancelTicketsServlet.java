package Servlets;

import Controller.TicketsController;
import Dao.TicketsDao;
import Model.BusTickets;
import Util.ConnectionUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/CancelTickets")
public class CancelTicketsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String mobile = req.getParameter("mobile");

        BusTickets busTickets = BusTickets.builder()
                .mobile(mobile)
                .build();

        TicketsDao ticketsDao = new TicketsDao();
        ticketsDao.deleteTickets(busTickets);

        TicketsController ticketsController = new TicketsController();
        resp.getWriter().println("Tickets Canceled" );
}
}
