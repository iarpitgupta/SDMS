package com.scgj.sdms.model;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SubmittedForms
{
    int application_id;
    String organisation_Name;
    String type;
    Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    //    String location;


    public int getApplication_id() {
        return application_id;
    }

    public void setApplication_id(int application_id) {
        this.application_id = application_id;
    }

    public String getOrganisation_Name() {
        return organisation_Name;
    }

    public void setOrganisation_Name(String organisation_Name) {
        this.organisation_Name = organisation_Name;
    }

    public String getType() {
        return type;
    }

    public SubmittedForms(int application_id, String organisation_Name, String type,Date date) {
        this.application_id = application_id;
        this.organisation_Name = organisation_Name;
        this.type = type;
        this.date=date;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }

//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }


}
