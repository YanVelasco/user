package com.yanvelasco.domain.userapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
@Builder
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private Long number;

    @Column(name = "complement", length = 10)
    private String complement;

    @Column(name = "city", length = 150)
    private String city;

    @Column(name = "state", length = 2)
    private String state;

    @Column(name = "zip_code", length = 9)
    private String zip_code;

}