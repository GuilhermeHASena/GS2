package br.com.fiap.gs2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.gs2.models.AmbienteModel;

@Repository
public interface AmbienteRepository extends JpaRepository<AmbienteModel, Integer> {

}
