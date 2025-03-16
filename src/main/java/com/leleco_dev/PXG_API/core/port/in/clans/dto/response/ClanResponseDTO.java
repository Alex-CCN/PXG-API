package com.leleco_dev.PXG_API.core.port.in.clans.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ClanResponseDTO {

    private String id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Elements is mandatory")
    private String elements;

}
