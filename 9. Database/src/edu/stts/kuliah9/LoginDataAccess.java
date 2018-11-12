package edu.stts.kuliah9;

import java.sql.*;

public class LoginDataAccess {
    public static boolean login(String name, String password){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String mysqlUrl = "jdbc:mysql://localhost:3306/";
        String mysqlDbname = "kelasenterprise";
        String mysqlDriver = "com.mysql.cj.jdbc.Driver";
        String mysqlUsername = "root";
        String mysqlPassword = "";
        boolean found = false;
        try {
            Class.forName(mysqlDriver).newInstance();
            conn = DriverManager.getConnection(mysqlUrl + mysqlDbname, mysqlUsername, mysqlPassword);
            preparedStatement = conn.prepareStatement("select * from products where productid=?");
            preparedStatement.setString(1, "p0001");
            resultSet = preparedStatement.executeQuery();
            found = resultSet.next();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return found;
    }
}
