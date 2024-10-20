package com.ms.accounts.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity {
    @Id
    private String accountNumber;

    private Long customerId;

    @Column(name = "account_type")
    private String type;

    private String branchAddress;

    @PrePersist
    private void generateAccountNumber() {
        var accountPrefix = "0000";
        var year = String.valueOf(LocalDate.now().getYear());
        switch (this.type) {
            case "SAVINGS":
                accountPrefix = "100";
                break;
            case "REGULAR":
                accountPrefix = "200";
                break;
            default:
                break;
        }
        this.accountNumber = accountPrefix + year + String.format("%06d", customerId);
    }
}
