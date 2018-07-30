package com.example.demo.Entity;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name="Batch_Certificate")
public class BatchCertificateMap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="Batch_certificate_id")
    private int batchCertificateId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Batch_id")
    private Batch batchId;

    @Column(name="Zipfile")
    private String zipFile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="User_id")
    private User user;

    public int getBatchCertificateId() {
        return batchCertificateId;
    }

    public void setBatchCertificateId(int batchCertificateId) {
        this.batchCertificateId = batchCertificateId;
    }

    public Batch getBatchId() {
        return batchId;
    }

    public void setBatchId(Batch batchId) {
        this.batchId = batchId;
    }

    public String getZipFile() {
        return zipFile;
    }

    public void setZipFile(String zipFile) {
        this.zipFile = zipFile;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
