package br.com.ada.itau950.calculosalario.service;

import br.com.ada.itau950.calculosalario.entity.Cargo;

import java.util.Optional;

public interface CargoService {

    Cargo save (Cargo cargo);

    Optional<Cargo> findById (Long idCargo);

    void delete (Long idCargo);
}
