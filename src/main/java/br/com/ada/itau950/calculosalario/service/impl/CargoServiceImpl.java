package br.com.ada.itau950.calculosalario.service.impl;

import br.com.ada.itau950.calculosalario.entity.Cargo;
import br.com.ada.itau950.calculosalario.repository.CargoRepository;
import br.com.ada.itau950.calculosalario.service.CargoService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CargoServiceImpl implements CargoService {

    private CargoRepository cargoRepository;

    public CargoServiceImpl (CargoRepository cargoRepository){
        this.cargoRepository = cargoRepository;
    }

    @Override
    public Cargo save(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    @Override
    public Optional<Cargo> findById(Long idCargo) {
        return cargoRepository.findById(idCargo);
    }

    @Override
    public void delete(Long idCargo) {
        cargoRepository.deleteById(idCargo);
    }
}
