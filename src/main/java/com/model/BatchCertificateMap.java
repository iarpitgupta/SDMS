package com.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name="Batch_Certificate")
public class BatchCertificateMap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Batch_certificate_id")
    private BigInteger batchCertificateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Batch_id")
    private Batch batchI;

    @Column(name="Zipfile")
    private String zipFile;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public BigInteger getBatchCertificateId() {
        return batchCertificateId;
    }

    public void setBatchCertificateId(BigInteger batchCertificateId) {
        this.batchCertificateId = batchCertificateId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Batch_id",insertable=false,updatable = false)
    private Batch batch;


    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public String getZipFile() {
        return zipFile;
    }

    public void setZipFile(String zipFile) {
        this.zipFile = zipFile;
    }

    public User getUserId() {
        return user;
    }

    public void setUserId(User user) {
        this.user = user;
    }
}
