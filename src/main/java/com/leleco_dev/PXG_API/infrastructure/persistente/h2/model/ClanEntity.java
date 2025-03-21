package com.leleco_dev.PXG_API.infrastructure.persistente.h2.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "CLAN")
@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClanEntity {

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "ID")
    //@GeneratedValue(strategy = GenerationType.IDENTITY)

    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ELEMENTS")
    private String elements;
}
