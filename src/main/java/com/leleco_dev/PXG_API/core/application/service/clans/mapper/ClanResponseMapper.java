package com.leleco_dev.PXG_API.core.application.service.clans.mapper;

import com.leleco_dev.PXG_API.core.domain.entity.Clan;
import com.leleco_dev.PXG_API.core.port.in.clans.dto.request.CreateClan;
import com.leleco_dev.PXG_API.core.port.in.clans.dto.response.ClanResponseDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class ClanResponseMapper {
    public static ClanResponseDTO mapClanResponse(Clan response){
        log.info("Mapping Database response to MS response: {}", response);
        return ClanResponseDTO.builder()
                .id(Optional.ofNullable(response).map(Clan::getId).orElse(null))
                .name(Optional.ofNullable(response).map(Clan::getName).orElse(null))
                .elements(Optional.ofNullable(response).map(Clan::getElements).orElse(null))

                .build();
    }
}
