package com.gdinwiddie.equinehoroscope.cache.derby;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.idiacomputing.jdbc.JdbcWriter;

public class HoroscopeWriter extends JdbcWriter {

    private ConnectionFactory connectionFactory;
    private String horsename;
    private String effectiveDate;
    private String horoscope;

    public HoroscopeWriter(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    protected Connection fetchConnection() throws SQLException {
        return connectionFactory.getConnection();
    }

    @Override
    protected String fetchInsertStatement() {
        return "INSERT into Horoscopes (horsename, effective_date, horoscope) VALUES (?, ?, ?)";
    }

    @Override
    protected void bindInsertStatement(PreparedStatement preparedStatement)
            throws SQLException {
        preparedStatement.setString(1, horsename);
        preparedStatement.setString(2, effectiveDate);
        preparedStatement.setString(3, horoscope);
    }

    public void writeHoroscope(String horsename, String effectiveDate,
            String horoscope) throws SQLException {
        this.horsename = horsename;
        this.effectiveDate = effectiveDate;
        this.horoscope = horoscope;
        writeDb();
    }

}
