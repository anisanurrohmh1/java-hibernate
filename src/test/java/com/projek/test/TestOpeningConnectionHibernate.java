package com.projek.test;


import com.projek.config.HibernateConfiguration;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

@Slf4j
public class TestOpeningConnectionHibernate extends TestCase {

    private Session session;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
    }

    @Test
    public void testOpenConnection() {
        this.session.beginTransaction();
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}