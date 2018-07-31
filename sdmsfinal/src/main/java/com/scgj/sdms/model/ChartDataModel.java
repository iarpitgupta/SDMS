package com.scgj.sdms.model;

import jdk.nashorn.internal.ir.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;

@Entity
@Table(name="chart_data_model1")

public class ChartDataModel {
    public ChartDataModel() {
    }

    @Column(name="count(candidate_id)")
    int count;
    public ChartDataModel(int count, String batchType) {
        this.count = count;
        this.batchType = batchType;
    }

    @Id

    @Column(name="batch_type")
    String batchType;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getBatchMode() {
        return batchType;
    }

    public void setBatchMode(String batchType) {
        this.batchType= batchType;
    }

    public String[] getResult()
    {
        String resArr[]=new String[2];
        resArr[0]=batchType;
        resArr[1]=String.valueOf(count);
        return resArr;
    }

}
