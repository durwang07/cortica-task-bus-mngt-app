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
import lombok.SneakyThrows;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/AddTickets")
public class AddTicketsServlet extends HttpServlet {

   @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String mobile = req.getParameter("mobile");
        int seats = Integer.parseInt(req.getParameter("seats"));
        String date = req.getParameter("date");

        System.out.println(mobile);
        BusTickets busTickets = BusTickets.builder()
                .name(name)
                .mobile(mobile)
                .seats(seats)
                .date(date)
                .build();

        try (Connection connection = ConnectionUtil.getConnection()) {

            String countQuery = "select count(*) from tickets where date = ?";
            try (PreparedStatement countStmt = connection.prepareStatement(countQuery)) {
                countStmt.setString(1, date);
                ResultSet rs = countStmt.executeQuery();
                rs.next();
                int bookingCount = rs.getInt(1);

                if (bookingCount >= 10) {
                    resp.getWriter().println("Booking limit reached for the selected date.");
                    return;
                }


                TicketsDao ticketsDao = new TicketsDao();
                ticketsDao.addTickets(busTickets);

                TicketsController ticketsController = new TicketsController();
                resp.getWriter().println("Tickets Added");
            }
        }
    }
}
