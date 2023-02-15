package com.projek;

import com.projek.config.HibernateConfiguration;
import com.projek.dao.MahasiswaDao;
import com.projek.entity.Mahasiswa;
import org.hibernate.Session;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

         Session session;
         session = HibernateConfiguration.getSession();

         MahasiswaDao layanan = new MahasiswaDao(session);


         //test insert
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setKode(2L);
        mahasiswa.setNim("10511149");
        mahasiswa.setNama("Anisa Nur Rohkmah");
        mahasiswa.setActive(true);
        mahasiswa.setCreatedBy("admin");
        mahasiswa.setCreatedDate(LocalDateTime.now());
        mahasiswa.setTglLahir(LocalDate.of(1999, 8, 20));
        mahasiswa.setThnMasuk(2017);
        layanan.save(mahasiswa);

        Optional<Mahasiswa> mhsOp = layanan.findById(2L);
        System.out.println(mhsOp);

    }
}
