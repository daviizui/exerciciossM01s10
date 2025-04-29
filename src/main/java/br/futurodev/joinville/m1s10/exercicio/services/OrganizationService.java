package br.futurodev.joinville.m1s10.exercicio.services;

import br.futurodev.joinville.m1s10.exercicio.dtos.organizatios.OrganizationRequestDto;
import br.futurodev.joinville.m1s10.exercicio.dtos.organizatios.OrganizationResponseDto;

import java.util.List;

public interface OrganizationService {

    List<OrganizationResponseDto> getAll();
    OrganizationResponseDto getById(Long id);
    OrganizationResponseDto create(OrganizationRequestDto dto);
    OrganizationResponseDto update(Long id, OrganizationRequestDto dto);
    void delete(Long id);
}
