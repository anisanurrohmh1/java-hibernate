package com.projek.test;

import com.projek.config.HibernateConfiguration;
import com.projek.entity.Mahasiswa;
import com.projek.dao.MahasiswaDao;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
public class TestFindByIdMahasiswa extends TestCase {

    private Session session;
    private MahasiswaDao dao;

    @Override
    protected void setUp() throws Exception {
        log.info("init hibernate session");
        this.session = HibernateConfiguration.getSession();
        this.dao = new MahasiswaDao(session);
    }

    @Test
    public void testFindById() {
        this.session.beginTransaction();
        Optional<Mahasiswa> mahasiswaOptional = this.dao.findById(1L);
        assertTrue("object mahasiswa not null", mahasiswaOptional.isPresent());
        log.info("mahasiswa by id: {}", mahasiswaOptional.orElse(null));
    }

    @Override
    protected void tearDown() throws Exception {
        log.info("destroy hibernate session!");
        this.session.close();
    }
}
