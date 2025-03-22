package com.leleco_dev.PXG_API.core.application.service.clans;

import com.leleco_dev.PXG_API.core.domain.entity.Clan;
import com.leleco_dev.PXG_API.core.port.in.clans.ClansPortIn;
import com.leleco_dev.PXG_API.core.port.in.clans.dto.request.CreateClan;
import com.leleco_dev.PXG_API.core.port.in.clans.dto.request.UpdateClan;
import com.leleco_dev.PXG_API.core.port.in.clans.dto.response.ClanResponseDTO;
import com.leleco_dev.PXG_API.core.port.out.clans.ClanRepositoryPortOut;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.leleco_dev.PXG_API.core.application.service.clans.mapper.ClanResponseMapper.mapClanResponse;

@Slf4j
@Service

public class ClanService implements ClansPortIn {
    private final ClanRepositoryPortOut clanRepositoryPortOut;
    private final ModelMapper mapper;

    //@Autowired
    public ClanService(ClanRepositoryPortOut clanRepositoryPortOut, ModelMapper mapper) {
        this.clanRepositoryPortOut = clanRepositoryPortOut;
        this.mapper = mapper;
    }

    @Override
    public ClanResponseDTO createClanId(CreateClan createClan) {
        Clan clan = mapper.map(createClan, Clan.class);

        if(!clan.hasNameClans()) {
            throw new RuntimeException("Clan name must be one of the  following: malefic\", \"wingeon\", \"ironhard\", \"volcanic\", \"seavell\", \"gardestrike\", \"orebound\", \"naturia\", \"psycraft\", \"railbolt");
        }
        clan = clanRepositoryPortOut.save(clan);
        return mapper.map(clan, ClanResponseDTO.class);
    }

    @Override
    public ClanResponseDTO updateClan(String id, UpdateClan updateClan) {
        return null;
    }

    @Override
    public ClanResponseDTO findById(String id) {

        var clan = findClanById(id);
        log.info("Clan value before mapper: {}", clan);

        return mapClanResponse(clan);
    }

    @Override
    public void deleteClan(String id) {

    }
    private Clan findClanById(String id) {
        Clan clan = clanRepositoryPortOut.findById(id);
        if (clan == null) {
            throw new RuntimeException("Clan not found");
        }
        return clan;
    }
}
