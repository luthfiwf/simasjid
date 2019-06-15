package com.skripsi.simasjid.model;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="master_notulensi")
public class ModelNotulensi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_notulensi")
    private Integer id;

    @Column(name = "id_amir")
    private Integer idAmir;

    @Column(name = "id_notulen")
    private Integer idNotulen;

    @Column(name = "id_status")
    private Integer idStatus;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_notulensi", referencedColumnName = "id_notulensi")
    private List<ModelDetailProgres> detailProgres;

    @Transient
    private String namaAmirMusyawarah;

    @Transient
    private String namaNotulen;

    @Transient
    private String convertedDate;

    private Date created;

    @PrePersist
    protected void onCreate() {
        created = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdAmir() {
        return idAmir;
    }

    public void setIdAmir(Integer idAmir) {
        this.idAmir = idAmir;
    }

    public Integer getIdNotulen() {
        return idNotulen;
    }

    public void setIdNotulen(Integer idNotulen) {
        this.idNotulen = idNotulen;
    }

    public Integer getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(Integer idStatus) {
        this.idStatus = idStatus;
    }

    public List<ModelDetailProgres> getDetailProgres() {
        return detailProgres;
    }

    public void setDetailProgres(List<ModelDetailProgres> detailProgres) {
        this.detailProgres = detailProgres;
    }

    public String getNamaAmirMusyawarah() {
        return namaAmirMusyawarah;
    }

    public void setNamaAmirMusyawarah(String namaAmirMusyawarah) {
        this.namaAmirMusyawarah = namaAmirMusyawarah;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getConvertedDate() {
        return convertedDate;
    }

    public void setConvertedDate(Date date) {
        System.out.println("date : "+ date);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try{
            this.convertedDate = format.format(date);
        } catch (Exception e){
            this.convertedDate = "-";
        }
    }



    public String getNamaNotulen() {
        return namaNotulen;
    }

    public void setNamaNotulen(String namaNotulen) {
        this.namaNotulen = namaNotulen;
    }
}
