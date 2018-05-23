package com.jdbc;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql?useSSL=false";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Driver drv;

        try {
            drv = new com.mysql.cj.jdbc.Driver();
        } catch (SQLException ex) {
            System.out.println("Произошла ошибка при создании драйвера");
            return;
        }
        try {
            DriverManager.registerDriver(drv);
        } catch (SQLException ex) {
            System.out.println("Неудалось зарегистрировать драйвер");
            return;
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("code.....");
        }
        catch (SQLException ex){
            System.out.println("Неудалось соединение");
            return;
        }
        finally {
            if (connection != null){
                connection.close();
            }
        }

    }
}
