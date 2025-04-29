package br.futurodev.joinville.m1s10.exercicio.mappers;

import br.futurodev.joinville.m1s10.exercicio.dtos.organizatios.OrganizationRequestDto;
import br.futurodev.joinville.m1s10.exercicio.dtos.organizatios.OrganizationResponseDto;
import br.futurodev.joinville.m1s10.exercicio.entities.Organization;

import java.util.List;

public class OrganizationMapper {

    private OrganizationMapper() {
        // Private constructor to prevent instantiation
    }

    public static OrganizationResponseDto toDto(Organization organization) {
        return OrganizationResponseDto.builder()
                .id(organization.getId())
                .name(organization.getName())
                .contact(organization.getContact())
                .build();
    }

    public static List<OrganizationResponseDto> toDtos(List<Organization> organizations) {
        return organizations.stream()
                .map(OrganizationMapper::toDto)
                .toList();
    }

    public static Organization toEntity(Organization organization, OrganizationRequestDto dto) {
        organization.setName(dto.getName());
        organization.setContact(dto.getContact());
        return organization;
    }
}
