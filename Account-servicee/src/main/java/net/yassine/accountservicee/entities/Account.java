package net.yassine.accountservicee.entities;

import jakarta.persistence.*;
import lombok.*;
import net.yassine.accountservicee.modal.Customer;


import java.time.LocalDate;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    @Id
    String acountId;
    private Double Sold;
     private LocalDate createAt;
     private String currency;
     @Enumerated(EnumType.STRING)
     private AccountType type;
     @Transient
       private Customer customer;

       private Long owener;
}
