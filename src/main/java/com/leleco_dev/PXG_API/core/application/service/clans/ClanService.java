package com.leleco_dev.PXG_API.core.application.service.clans;

import com.leleco_dev.PXG_API.core.domain.entity.Clan;
import com.leleco_dev.PXG_API.core.port.in.clans.ClansPortIn;
import com.leleco_dev.PXG_API.core.port.in.clans.dto.request.UpdateClan;
import com.leleco_dev.PXG_API.core.port.in.clans.dto.response.ClanResponseDTO;
import com.leleco_dev.PXG_API.core.port.out.clans.ClanRepositoryPortOut;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClanService implements ClansPortIn {
    private ClanRepositoryPortOut clanRepositoryPortOut;
    private ModelMapper mapper;

    public ClanService(ClanRepositoryPortOut clanRepositoryPortOut, ModelMapper mapper) {
        this.clanRepositoryPortOut = clanRepositoryPortOut;
        this.mapper = mapper;
    }

    @Override
    public ClanResponseDTO createClanById(ClanResponseDTO createClan) {
        Clan clan = mapper.map(createClan, Clan.class);

        clan = clanRepositoryPortOut.save(clan);
        return mapper.map(clan, ClanResponseDTO.class);
    }

    @Override
    public ClanResponseDTO updateClan(String id, UpdateClan updateClan) {
        return null;
    }

    @Override
    public ClanResponseDTO findById(String id) {
        Clan clan = findClanById(id);
        return mapper.map(clan, ClanResponseDTO.class);
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
