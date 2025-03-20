package com.leleco_dev.PXG_API.api.rest.clans;

import com.leleco_dev.PXG_API.core.port.in.clans.ClansPortIn;
import com.leleco_dev.PXG_API.core.port.in.clans.dto.response.ClanResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/clans")
@Validated

public class ClanControllerImpl implements ClanController{

    private  ClansPortIn clansPortIn;

    public ClanControllerImpl(ClansPortIn clansPortIn) {
        this.clansPortIn = clansPortIn;
    }

    @Override
    public ResponseEntity<ClanResponseDTO> getClanById(
            @PathVariable(name = "Clan's id") String id,
            @RequestHeader HttpHeaders headers) {
        ClanResponseDTO clanResponseDTO = clansPortIn.findById(id);
        return new ResponseEntity<>(clanResponseDTO, headers, HttpStatus.OK);
    }
}
