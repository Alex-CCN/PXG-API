package com.leleco_dev.PXG_API.api.rest.clans;


import com.leleco_dev.PXG_API.core.port.in.clans.dto.response.ClanResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.junit.jupiter.api.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.*;


@Tag("Contract for Clan's methods")
public interface ClanController {

    @Operation(summary = "Get a clan by id", tags = {"Clans"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clan found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ClanResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Clan not found", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProblemDetail.class)) })
    })
    @GetMapping("/clans/{id}")
    public ResponseEntity<ClanResponseDTO> getClanById(
            @Parameter(description = "Clan's id")@PathVariable String id,
            @RequestHeader HttpHeaders headers);


}
