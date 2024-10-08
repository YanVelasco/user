package com.yanvelasco.domain.userapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_phones")
@Builder
public class PhoneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "numbers", length = 10)
    private String numbers;

    @Column(name = "ddd", length = 3)
    private String ddd;

}