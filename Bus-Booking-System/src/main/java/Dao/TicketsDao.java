package Dao;

import Model.BusTickets;
import Util.ConnectionUtil;
import lombok.Getter;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static java.lang.System.out;


public class TicketsDao {
    @SneakyThrows
    public void addTickets(BusTickets busTickets)  {
        Connection connection = ConnectionUtil.getConnection();
        String mysqlQuery = "insert into tickets (name, mobile,seats,date) values (?,?,?,?)";
        PreparedStatement preparedStatement =connection.prepareStatement(mysqlQuery);
        preparedStatement.setString(1, busTickets.getName());
        preparedStatement.setString(2, busTickets.getMobile());
        preparedStatement.setInt(3, busTickets.getSeats());
        preparedStatement.setString(4, busTickets.getDate());
        preparedStatement.executeUpdate();
        connection.close();

    }

    @SneakyThrows
    public void deleteTickets(BusTickets busTickets) {
        Connection connection = ConnectionUtil.getConnection();
        String mysqlQuery = "delete from tickets where mobile = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(mysqlQuery);
        preparedStatement.setString(1,busTickets.getMobile());
        preparedStatement.executeUpdate();
        connection.close();
    }


}
