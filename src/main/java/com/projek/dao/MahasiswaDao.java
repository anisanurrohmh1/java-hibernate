package com.projek.dao;
import com.projek.entity.Mahasiswa;
import com.projek.repository.CrudRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class MahasiswaDao implements CrudRepository<Mahasiswa, Long> {

    private Session session;

    public MahasiswaDao(Session session) {
        this.session = session;
    }

    @Override
    public Mahasiswa save(Mahasiswa value) throws HibernateException {
        Long pk = (Long) this.session.save(value);
        value.setKode(pk);
        return value;
    }

    @Override
    public Mahasiswa update(Mahasiswa value) throws HibernateException {
        this.session.update(value);
        return value;
    }

    @Override
    public boolean removeById(Long value) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Mahasiswa value) throws HibernateException {
        this.session.remove(value);
        return true;
    }

    @Override
    public Optional<Mahasiswa> findById(Long value) throws HibernateException {
        Mahasiswa mhs = this.session.find(Mahasiswa.class, value);
        return mhs != null ? Optional.of(mhs) : Optional.empty();
    }


    @Override
    public List<Mahasiswa> findAll() throws HibernateException {
        throw new UnsupportedOperationException();
    }
}
