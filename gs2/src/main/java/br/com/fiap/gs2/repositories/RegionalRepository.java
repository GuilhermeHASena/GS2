package br.com.fiap.gs2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.gs2.models.RegionalModel;

@Repository
public interface RegionalRepository extends JpaRepository<RegionalModel, Integer> {

}
