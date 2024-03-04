package com.posunipe.backend.apisports.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ErrorDTO {
    private String error;
    private String detalhes;
}
