package com.leleco_dev.PXG_API.infrastructure.persistente.h2;

import com.leleco_dev.PXG_API.infrastructure.persistente.h2.model.ClanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClanRepository extends JpaRepository<ClanEntity, String> {

    boolean existsByName(String name);

    ClanEntity findByName(String name);
}
