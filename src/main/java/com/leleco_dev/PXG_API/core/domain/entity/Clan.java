package com.leleco_dev.PXG_API.core.domain.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Arrays;
import java.util.UUID;

@Data
public class Clan {

    private String id;
    private String name;
    private String elements;

    public boolean hasNameClans() {
        if (name == null) {
            return false;
        }
        String nameLowerCase = this.name.toLowerCase();
        return Arrays.asList("malefic", "wingeon", "ironhard", "volcanic", "seavell", "gardestrike", "orebound", "naturia", "psycraft", "railbolt").contains(nameLowerCase);
    }
}
