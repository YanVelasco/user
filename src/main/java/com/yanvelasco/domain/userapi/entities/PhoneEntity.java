package com.yanvelasco.domain.userapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phone")
@Builder
public class PhoneEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "numbers", length = 10)
    private String numbers;
    @Column(name = "ddd", length = 3)
    private String ddd;
    @Column(name = "user_id")
    private UUID user_id;
}
