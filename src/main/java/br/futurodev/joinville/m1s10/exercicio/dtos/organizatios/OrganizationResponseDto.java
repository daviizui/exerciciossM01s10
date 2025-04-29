package br.futurodev.joinville.m1s10.exercicio.dtos.organizatios;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrganizationResponseDto {
    private Long id;
    private String name;
    private String contact;}
