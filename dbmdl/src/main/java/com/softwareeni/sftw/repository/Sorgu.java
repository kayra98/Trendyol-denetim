package com.softwareeni.sftw.repository;

import com.softwareeni.sftw.ProgramData.data;

import java.sql.*;

public class Sorgu {
    data dat = new data();

    ResultSet sorgu(String query) {
        try {
            Connection connection = DriverManager.getConnection(
                dat.getSQL_URL(),
                dat.getSQL_USERNAME(),
                dat.getSQL_PASSWORD()
            );
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}