package com.wu.usermanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user_beneficiary")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beneficiary_id")
    private Long beneficiaryId;
    @Column(name = "user_id")
    private int userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "country")
    private String country;
    @Column(name = "bank_account_number")
    private int bankAccountNumber;
    @Column(name = "iban")
    private String iban;
    @Column(name = "status")
    private String status;
    @Column(name = "modified_by")
    private String modifiedBy;
    @Column(name = "modified_on")
    private String modifiedOn;
}
