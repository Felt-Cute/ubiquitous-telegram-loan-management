package com.dcat23.loanmgmt.officers.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "loan_officers")
public class LoanOfficer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long officerId;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;


}
