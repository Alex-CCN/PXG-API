package com.leleco_dev.PXG_API.api.rest.clans;

import com.leleco_dev.PXG_API.core.port.in.clans.ClansPortIn;
import com.leleco_dev.PXG_API.core.port.in.clans.dto.request.CreateClan;
import com.leleco_dev.PXG_API.core.port.in.clans.dto.response.ClanResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/clans")
@Validated

public class ClanControllerImpl implements ClanController{

    private  ClansPortIn clansPortIn;

    public ClanControllerImpl(ClansPortIn clansPortIn) {
        this.clansPortIn = clansPortIn;
    }


    //@GetMapping(consumes = "application/json", produces = "application/json")
    @GetMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<ClanResponseDTO> getClanById(
            @PathVariable(name = "id") String id,
            @RequestHeader HttpHeaders headers) {
        ClanResponseDTO clanResponseDTO = clansPortIn.findById(id);


        return ResponseEntity.status(HttpStatus.OK).body(clanResponseDTO);

    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ClanResponseDTO> createClan(
            @RequestBody @Valid CreateClan clanCreateResponseDTO
           ) {
        ClanResponseDTO clanResponseDTO = clansPortIn.createClanId(clanCreateResponseDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).body(clanResponseDTO);
    }
}
