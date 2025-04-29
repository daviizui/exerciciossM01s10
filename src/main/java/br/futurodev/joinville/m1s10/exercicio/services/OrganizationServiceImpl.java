package br.futurodev.joinville.m1s10.exercicio.services;

import br.futurodev.joinville.m1s10.exercicio.dtos.organizatios.OrganizationRequestDto;
import br.futurodev.joinville.m1s10.exercicio.dtos.organizatios.OrganizationResponseDto;
import br.futurodev.joinville.m1s10.exercicio.entities.Organization;
import br.futurodev.joinville.m1s10.exercicio.mappers.OrganizationMapper;
import br.futurodev.joinville.m1s10.exercicio.repositories.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository repository;


    @Override
    public List<OrganizationResponseDto> getAll() {
        List<Organization> organizations = repository.findAll();
        return OrganizationMapper.toDtos(organizations);
    }

    @Override
    public OrganizationResponseDto getById(Long id) {
        Organization organization = findEntityById(id);
        return OrganizationMapper.toDto(organization);
    }

    @Override
    public OrganizationResponseDto create(OrganizationRequestDto dto) {
        Organization organization = new Organization();
        OrganizationMapper.toEntity(organization, dto);
        organization = repository.save(organization);
        return OrganizationMapper.toDto(organization);
    }

    @Override
    public OrganizationResponseDto update(Long id, OrganizationRequestDto dto) {
        Organization organization = findEntityById(id);
        OrganizationMapper.toEntity(organization, dto);
        organization = repository.save(organization);
        return OrganizationMapper.toDto(organization);
    }

    @Override
    public void delete(Long id) {
        Organization organization = findEntityById(id);
        repository.delete(organization);

    }

    private Organization findEntityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Organization not found"));
    }
}
