package Util;

import Constants.MysqlConstants;
import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static Constants.MysqlConstants.*;

public class ConnectionUtil {
@Getter
        private static Connection connection;

    static {
        try {
            Class.forName(MysqlConstants.MYSQL_DRIVER);
connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Not Found");
        } catch (SQLException e) {
            System.out.println("Invalid Credentials");
        }

    }


}
