package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table
public class APAffiliation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "Agency_id")
    private AssessmentAgency agencyId;




}
