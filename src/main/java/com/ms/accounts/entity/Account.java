package com.ms.accounts.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity {
    @Id
    private Long accountNumber;

    private Long customerId;

    @Column(name = "account_type")
    private String type;

    private String branchAddress;
}
