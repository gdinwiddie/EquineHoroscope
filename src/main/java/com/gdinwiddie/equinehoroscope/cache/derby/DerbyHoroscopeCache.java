package com.gdinwiddie.equinehoroscope.cache.derby;

import java.sql.SQLException;

import com.gdinwiddie.equinehoroscope.cache.HoroscopeCache;

public class DerbyHoroscopeCache implements HoroscopeCache {

    private ConnectionFactory connectionFactory;

    public DerbyHoroscopeCache(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.gdinwiddie.equinehoroscope.HoroscopeCache#horoscopeFor(java.lang.
     * String, java.lang.String)
     */
    public String horoscopeFor(String horsename, String effectiveDate)
            throws Exception {
        HoroscopeReader reader = new HoroscopeReader(connectionFactory);
        try {
            return reader.readHoroscope(horsename, effectiveDate);
        } catch (SQLException e) {
            throw new Exception("Unable to read horoscope for horse, "
                    + horsename + " effective " + effectiveDate, e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.gdinwiddie.equinehoroscope.HoroscopeCache#putHoroscope(java.lang.
     * String, java.lang.String, java.lang.String)
     */
    public void putHoroscope(String horsename, String effectiveDate,
            String horoscope) throws Exception {
        HoroscopeTableCreator creator = new HoroscopeTableCreator(
                connectionFactory);
        try {
            creator.createTable();
        } catch (SQLException expected) {
            // TODO Create table more efficiently rather than with every put.
        }
        HoroscopeWriter writer = new HoroscopeWriter(connectionFactory);
        try {
            writer.writeHoroscope(horsename, effectiveDate, horoscope);
        } catch (SQLException e) {
            throw new Exception("Unable to record horoscope for horse, "
                    + horsename + " effective " + effectiveDate, e);
        }

    }

    public static HoroscopeCache instance() {
        return new DerbyHoroscopeCache(new ConnectionFactory());
    }

}
