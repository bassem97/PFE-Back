package com.ats.remotetimemanager.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESSES")
public class Address {

    private long addressId;
    private String streetName;
    private String streetNumber;
    private String state;
    private String governorate;
    private long zipCode;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties(value ="addresses" , allowSetters = true)
    private User user;

}
