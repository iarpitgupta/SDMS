package com.scgj.sdms.model;

import com.sun.javafx.beans.IDProperty;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.management.Query;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


//@Immutable
@Entity
@Table(name="top5tptab")
//@Subselect("select name,cnt from(select tp.training_partner_name as name, count(c.candidate_id) as cnt from training_partner  tp join candidate c join batch b on tp.training_partner_id = b.training_partner_id and c.batch_id=b.batch_id where c.placement_status= 'placed' group by tp.training_partner_id )tab limit 5")
public class QueryControllerModel {
    @Id
    @Column(name = "training_partner_name")
    public  String trainingPartnerName;

    public String getTrainitrainingPartnerNamengPartnerId() {
        return trainingPartnerId;
    }

    public void setTrainitrainingPartnerNamengPartnerId(String trainitrainingPartnerNamengPartnerId) {
        this.trainingPartnerId = trainitrainingPartnerNamengPartnerId;
    }

    @Column(name="cnt")
    public  int cnt;
    @Column(name="training_partner_id")
    public String  trainingPartnerId;

    //public QueryControllerModel(){trainingPartner=new TrainingPartner ();}

    public String getName() {
        return trainingPartnerName;
    }

    public void setName(String name) {
        this.trainingPartnerName= name;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getCount() {
        return cnt;
    }

   public List<String> getParams()

   {
       List<String>list=new ArrayList<> ();
       list.add(trainingPartnerName);
       list.add(String.valueOf (cnt));
       return list;
   }
}
