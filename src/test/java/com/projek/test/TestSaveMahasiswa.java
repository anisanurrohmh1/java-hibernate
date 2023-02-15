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
public class TestSaveMahasiswa extends TestCase {

    private Session session;
    private MahasiswaDao dao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.dao = new MahasiswaDao(session);
    }

    @Test
    public void testSaveMahasiswa() {
//        init value
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setKode(1L);
        mahasiswa.setNim("10511148");
        mahasiswa.setNama("Fulan");
        mahasiswa.setActive(true);
        mahasiswa.setCreatedBy("admin");
        mahasiswa.setCreatedDate(LocalDateTime.now());
        mahasiswa.setTglLahir(LocalDate.of(1999, 9, 9));
        mahasiswa.setThnMasuk(2015);

        this.session.beginTransaction();
//        save data and then return auto generated id
        mahasiswa = this.dao.save(mahasiswa);

//        commit
        this.session.getTransaction().commit();

        log.info("mahasiswa saved: {}", mahasiswa);
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
