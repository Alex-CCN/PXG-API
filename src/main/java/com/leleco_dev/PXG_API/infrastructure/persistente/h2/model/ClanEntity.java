package com.leleco_dev.PXG_API.infrastructure.persistente.h2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clan")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClanEntity {

    @Id
    @Column(name = "id", nullable = false)
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "elements")
    private String elements;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getElements() {
        return this.elements;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setElements(String elements) {
        this.elements = elements;
    }

    public String toString() {
        return "ClanEntity(id=" + this.getId() + ", name=" + this.getName() + ", elements=" + this.getElements() + ")";
    }
}
