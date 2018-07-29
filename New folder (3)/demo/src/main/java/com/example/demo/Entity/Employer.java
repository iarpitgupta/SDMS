package com.example.demo.Entity;

import javax.persistence.*;
import java.math.BigInteger;
@Entity
@Table(name="Employer")
public class Employer {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name="Employer_id")
    private Integer employerId;

    @Column(name="Employer_name")
    private String employerName;

    @Column(name="Location_of_employer")
    private String locationOfEmployer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Location_id")
    private Location locationId;

}
