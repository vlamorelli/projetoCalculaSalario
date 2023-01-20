package br.com.ada.itau950.calculosalario.repository;

import br.com.ada.itau950.calculosalario.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository <Cargo, Long> {
}
