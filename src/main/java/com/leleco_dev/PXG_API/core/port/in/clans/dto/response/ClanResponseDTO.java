package com.leleco_dev.PXG_API.core.port.in.clans.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
@AllArgsConstructor
public class ClanResponseDTO {
    @Setter(AccessLevel.NONE)
    private String id;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Elements is mandatory")
    private String elements;

}
