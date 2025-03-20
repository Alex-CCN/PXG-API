package com.leleco_dev.PXG_API.infrastructure.persistente.h2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

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
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ELEMENTS")
    private String elements;
}
