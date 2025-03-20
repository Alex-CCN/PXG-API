package com.leleco_dev.PXG_API.core.port.out.clans;

import com.leleco_dev.PXG_API.core.domain.entity.Clan;

public interface ClanRepositoryPortOut {

    Clan findById(String id);
    Clan save(Clan domain);
    void deleteById(String id);
    boolean existsByName(String name);
    Clan update(Clan domain);

}
