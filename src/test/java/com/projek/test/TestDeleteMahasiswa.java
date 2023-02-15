package com.projek.test;

import com.projek.config.HibernateConfiguration;
import com.projek.entity.Mahasiswa;
import com.projek.dao.MahasiswaDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
public class TestDeleteMahasiswa extends TestCase {

    private Session session;
    private MahasiswaDao dao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.dao = new MahasiswaDao(session);
    }

    @Test
    public void testDeleteMahasiswa() {
        this.session.beginTransaction();
        Mahasiswa mahasiswa = this.session.get(Mahasiswa.class, 1L);
        this.dao.remove(mahasiswa);

//        commit
        this.session.getTransaction().commit();

        log.info("mahasiswa was delete: {}", mahasiswa);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
