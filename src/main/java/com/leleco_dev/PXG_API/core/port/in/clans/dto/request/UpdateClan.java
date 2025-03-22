package com.leleco_dev.PXG_API.core.port.in.clans.dto.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)

//DTO for update a existing clan
public class UpdateClan {
    @NotBlank(message = "Elements is mandatory")
    private String elements;
}
