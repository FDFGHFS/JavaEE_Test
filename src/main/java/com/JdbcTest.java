package com;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.sql.*;
import java.util.Date;

public class JdbcTest {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/smbms";
            String user = "root";
            String password = "888888";
            Connection connection = DriverManager.getConnection(url, user, password);
//            System.out.println(connection.getMetaData());
            String sql1 = "select * from smbms_user";
            PreparedStatement preparedStatement = connection.prepareStatement(sql1);
            ResultSet ret = preparedStatement.executeQuery();
            while (ret.next()) {

                String id = ret.getString(1);
                String code = ret.getString(2);
                String name = ret.getString(3);
                String pass = ret.getString(4);
                String gender = ret.getString(5);
                String birthday = ret.getString(6);
                String phone = ret.getString(7);
                String address = ret.getString(8);
                String Role = ret.getString(9);
                String by = ret.getString(10);
                String creat = ret.getString(11);
                String mod = ret.getString(12);
                String dify = ret.getString(13);
                System.out.printf("\n" + "%100s", id + "    " + code + "    " + name + "    " + pass + "    " + gender + "    " +
                        birthday + "    " + phone + "    " + address + "    " + Role + "    " + by + "    " +
                        creat + "    " + mod + "    " + dify);
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
