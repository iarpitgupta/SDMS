package com.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Import_history")
public class ImportHistory {
    @Id
    @Column(name="Import_history_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long importHistoryId;

    @Column(name="File_name")
    private String fileName;

    @Column(name="Data_type")
    private String dataType;

    @Column(name = "Uploaded_date")
    private Date uploadedDate;

    @Column(name="Uploaded_by")
    private String uploadedBy;

    public long getImportHistoryId() {
        return importHistoryId;
    }

    public void setImportHistoryId(long importHistoryId) {
        this.importHistoryId = importHistoryId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Date getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(Date uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    public String getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(String uploadedBy) {
        this.uploadedBy = uploadedBy;
    }
}
