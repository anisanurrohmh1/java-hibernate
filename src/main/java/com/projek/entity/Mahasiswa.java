package com.projek.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mahasiswa")
public class Mahasiswa {



    @Id
    private Long kode;

    @Column(name = "nim_mahasiswa", nullable = false, unique = true, length = 8)
    private String nim;

    @Column(name = "nama_mahasiswa", nullable = false, length = 25)
    private String nama;

    @Column(name = "tahun_masuk", length = 4)
    private Integer thnMasuk;

    @Column(name = "tanggal_lahir", nullable = false)
    private LocalDate tglLahir;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "is_active")
    private Boolean active;

    @Type(type = "text")
    @Column(name = "bio")
    private String biodata;





    public Long getKode() {
        return kode;
    }

    public void setKode(Long kode) {
        this.kode = kode;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getThnMasuk() {
        return thnMasuk;
    }

    public void setThnMasuk(Integer thnMasuk) {
        this.thnMasuk = thnMasuk;
    }

    public LocalDate getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(LocalDate tglLahir) {
        this.tglLahir = tglLahir;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getBiodata() {
        return biodata;
    }

    public void setBiodata(String biodata) {
        this.biodata = biodata;
    }
}