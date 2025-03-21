package com.leleco_dev.PXG_API.core.port.in.clans;


import com.leleco_dev.PXG_API.core.port.in.clans.dto.request.CreateClan;
import com.leleco_dev.PXG_API.core.port.in.clans.dto.request.UpdateClan;
import com.leleco_dev.PXG_API.core.port.in.clans.dto.response.ClanResponseDTO;

public interface ClansPortIn {
    ClanResponseDTO createClanById(CreateClan createClan);
    ClanResponseDTO updateClan(String id, UpdateClan updateClan);
    ClanResponseDTO findById(String id);
    void deleteClan(String id);
}
