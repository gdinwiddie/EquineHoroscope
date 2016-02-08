package com.gdinwiddie.equinehoroscope.cache.derby;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.gdinwiddie.equinehoroscope.cache.HoroscopeCacheTestTemplate;
import com.gdinwiddie.equinehoroscope.cache.derby.ConnectionFactory;
import com.gdinwiddie.equinehoroscope.cache.derby.DerbyHoroscopeCache;
import com.idiacomputing.jdbc.JdbcWriter;

public class DerbyHoroscopeCacheTest extends HoroscopeCacheTestTemplate {

    @Before
    public void setUp() throws Exception {
        setCache(DerbyHoroscopeCache.instance());
    }

    @BeforeClass
    @AfterClass
    public static void cleanUp() {
        JdbcWriter cleaner = new JdbcWriter() {

            @Override
            protected String fetchInsertStatement() {
                return "DELETE from Horoscopes where effective_date like 'date%'";
            }

            @Override
            protected Connection fetchConnection() throws SQLException {
                return new ConnectionFactory().getConnection();
            }
        };
        try {
            cleaner.writeDb();
        } catch (Exception ignored) {
        }
    }
}
