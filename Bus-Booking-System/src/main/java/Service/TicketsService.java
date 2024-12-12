package Service;

import Dao.TicketsDao;
import Model.BusTickets;

import java.util.List;

public class TicketsService {

    TicketsDao ticketsDao = new TicketsDao();
    public void addTickets(BusTickets busTickets) {
        ticketsDao.addTickets(busTickets);

    }

    public void deleteTickets(BusTickets busTickets) {

        ticketsDao.deleteTickets(busTickets);
    }



}
