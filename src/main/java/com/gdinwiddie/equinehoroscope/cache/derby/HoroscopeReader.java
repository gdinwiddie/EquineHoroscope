package com.gdinwiddie.equinehoroscope.cache.derby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.idiacomputing.jdbc.JdbcReader;

public class HoroscopeReader extends JdbcReader {

    private ConnectionFactory connectionFactory;
    private String horoscope = null;
    private String horsename;
    private String effectiveDate;

    public HoroscopeReader(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public String readHoroscope(String horsename, String effectiveDate)
            throws SQLException {
        this.horsename = horsename;
        this.effectiveDate = effectiveDate;
        readDb();
        return horoscope;
    }

    @Override
    protected Connection fetchConnection() throws SQLException {
        return connectionFactory.getConnection();
    }

    @Override
    protected String fetchSelectStatement() {
        return "SELECT Horoscope from Horoscopes WHERE horsename=? AND effective_date=?";
    }

    @Override
    protected void bindSelectStatement(PreparedStatement preparedStatement)
            throws SQLException {
        preparedStatement.setString(1, horsename);
        preparedStatement.setString(2, effectiveDate);
    }

    @Override
    protected void readRowValue(ResultSet resultSet) throws SQLException {
        horoscope = resultSet.getString(1);
    }

}
