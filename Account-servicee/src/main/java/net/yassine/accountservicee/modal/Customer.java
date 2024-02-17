package net.yassine.accountservicee.modal;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Customer {
   private Long id;
    private String firstName;
    private String lastName;
    private String email;



}
