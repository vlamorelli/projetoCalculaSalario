package br.com.ada.itau950.calculosalario.controller;

import br.com.ada.itau950.calculosalario.dto.CargoResponseDTO;
import br.com.ada.itau950.calculosalario.dto.CargoSaveRequestDTO;
import br.com.ada.itau950.calculosalario.dto.CargoSaveResponseDTO;
import br.com.ada.itau950.calculosalario.entity.Cargo;
import br.com.ada.itau950.calculosalario.service.CargoService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/cargos")
public class CargoController {


    private CargoService cargoService;

    public CargoController (CargoService cargoService){
        this.cargoService = cargoService;
    }


    @PostMapping
    public ResponseEntity<CargoSaveResponseDTO> save(@RequestBody @Valid CargoSaveRequestDTO cargoRequest) {

        log.info(cargoRequest.toString());

        Cargo cargo = new Cargo();
        cargo.setNome(cargoRequest.getNome());
        cargo.setSalario(cargoRequest.getSalario());

        //save
        cargo = cargoService.save(cargo);

        CargoSaveResponseDTO cargoResponseDto = new CargoSaveResponseDTO();
        cargoResponseDto.setIdCargo(cargo.getIdCargo());
        return ResponseEntity.ok(cargoResponseDto);
    }

    @GetMapping(value = "/{idCargo}")
    public ResponseEntity<CargoResponseDTO> getById(@PathVariable(value = "idCargo") Long id) {

        Optional<Cargo> cargo = cargoService.findById(id);

        if (cargo.isPresent()){
            CargoResponseDTO cargoResponseDto = new CargoResponseDTO();
            cargoResponseDto.setNome(cargo.get().getNome());
            cargoResponseDto.setSalario(cargo.get().getSalario());
            cargoResponseDto.setIdCargo(id);
            return ResponseEntity.ok(cargoResponseDto);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
   }

    @PatchMapping("/{idCargo}/{salario}")
    public ResponseEntity updateSalario(@PathVariable Long idCargo, @PathVariable BigDecimal salario) {
        //update
        log.info("idCargo: {} salario: {}", idCargo, salario);

        Optional<Cargo> cargo = cargoService.findById(idCargo);

        if (cargo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            cargo.get().setSalario(salario);
            cargoService.save(cargo.get());
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping("/{idCargo}")
    public ResponseEntity<String> delete(@PathVariable Long idCargo) {

        Optional<Cargo> cargo = cargoService.findById(idCargo);
        if (cargo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // delete
        cargoService.delete(idCargo);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<CargoResponseDTO>> findAll() {

        List<Cargo> cargos = cargoService.findAll();
        List<CargoResponseDTO> cargoResponseDTOS = new ArrayList<>();

        for (Cargo cargo: cargos) {
            CargoResponseDTO cargoResponseDto = new CargoResponseDTO();
            cargoResponseDto.setNome(cargo.getNome());
            cargoResponseDto.setSalario(cargo.getSalario());
            cargoResponseDto.setIdCargo(cargo.getIdCargo());

            cargoResponseDTOS.add(cargoResponseDto);
        }

        return ResponseEntity.ok(cargoResponseDTOS);
    }

}
