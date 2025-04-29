package br.futurodev.joinville.m1s10.exercicio.repositories;

import br.futurodev.joinville.m1s10.exercicio.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository <Organization, Long> {

}
