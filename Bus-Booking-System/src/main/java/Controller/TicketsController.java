package Controller;

import Model.BusTickets;
import Service.TicketsService;
import jakarta.servlet.http.HttpServlet;

import java.util.List;

public class TicketsController  {

        TicketsService ticketsService = new TicketsService();

        public void addTickets(BusTickets busTickets){
            ticketsService.addTickets(busTickets);
        }
        public void deleteTickets(BusTickets busTickets){
            ticketsService.deleteTickets(busTickets);
        }


}
