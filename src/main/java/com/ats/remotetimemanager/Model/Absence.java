package com.ats.remotetimemanager.Model;

import javax.persistence.*;

@Entity
public class Absence {

    @Id
    @Column(name= "absence_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAbsence;


}
