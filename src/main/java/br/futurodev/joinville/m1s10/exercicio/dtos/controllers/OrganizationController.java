package br.futurodev.joinville.m1s10.exercicio.dtos.controllers;

import br.futurodev.joinville.m1s10.exercicio.dtos.organizatios.OrganizationRequestDto;
import br.futurodev.joinville.m1s10.exercicio.dtos.organizatios.OrganizationResponseDto;
import br.futurodev.joinville.m1s10.exercicio.services.OrganizationService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/organizations")
public class OrganizationController {

    private final OrganizationService service;

    @GetMapping
    public List<OrganizationResponseDto> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public OrganizationResponseDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrganizationResponseDto create(@RequestBody OrganizationRequestDto dto) {
        return service.create(dto);
    }

    @PutMapping("{id}")
    public OrganizationResponseDto update(@PathVariable Long id, @RequestBody OrganizationRequestDto dto) {
        return service.update(id, dto);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
