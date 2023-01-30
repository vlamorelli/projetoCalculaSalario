package br.com.ada.itau950.calculosalario.controller;

import br.com.ada.itau950.calculosalario.dto.CargoResponseDTO;
import br.com.ada.itau950.calculosalario.dto.FuncionarioResponseDTO;
import br.com.ada.itau950.calculosalario.dto.FuncionarioSaveRequestDTO;
import br.com.ada.itau950.calculosalario.dto.FuncionarioSaveResponseDTO;
import br.com.ada.itau950.calculosalario.entity.Cargo;
import br.com.ada.itau950.calculosalario.entity.Funcionario;
import br.com.ada.itau950.calculosalario.service.FuncionarioService;
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
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    public FuncionarioController (FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<FuncionarioSaveResponseDTO> save(@RequestBody @Valid FuncionarioSaveRequestDTO funcionarioRequest) {

        log.info(funcionarioRequest.toString());

        Funcionario funcionario = new Funcionario();
        funcionario.setNome(funcionarioRequest.getNome());
        funcionario.setCpf(funcionarioRequest.getCpf());
        funcionario.setBonusSalarial(funcionarioRequest.getBonusSalarial());
        funcionario.setCargo(new Cargo());
        funcionario.getCargo().setIdCargo(funcionarioRequest.getIdCargo());

        funcionario = funcionarioService.save(funcionario);

        FuncionarioSaveResponseDTO funcionarioResponseDto = new FuncionarioSaveResponseDTO();
        funcionarioResponseDto.setIdFunc(funcionario.getIdFunc());
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioResponseDto);
    }

    @GetMapping(value = "/{idFunc}")
    public ResponseEntity<FuncionarioResponseDTO> getById(@PathVariable(value = "idFunc") Long id) {

        Optional<Funcionario> funcionario = funcionarioService.findById(id);

        if (funcionario.isPresent()){
            FuncionarioResponseDTO funcionarioDto = new FuncionarioResponseDTO();
            funcionarioDto.setNome(funcionario.get().getNome());
            funcionarioDto.setCpf(funcionario.get().getCpf());
            funcionarioDto.setBonusSalarial(funcionario.get().getBonusSalarial());
            funcionarioDto.setCargo(new CargoResponseDTO());
            funcionarioDto.getCargo().setIdCargo(funcionario.get().getCargo().getIdCargo());
            funcionarioDto.getCargo().setNome(funcionario.get().getCargo().getNome());
            funcionarioDto.getCargo().setSalario(funcionario.get().getCargo().getSalario());
            funcionarioDto.setIdFunc(id);
            return ResponseEntity.ok(funcionarioDto);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PatchMapping("/{idFunc}/{bonusSalario}")
    public ResponseEntity updateSalario(@PathVariable Long idFunc, @PathVariable BigDecimal bonusSalario) {
        //update
        log.info("idFunc: {} bonusSalario: {}", idFunc, bonusSalario);

        Optional<Funcionario> funcionario = funcionarioService.findById(idFunc);

        if (funcionario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            funcionario.get().setBonusSalarial(bonusSalario);
            funcionarioService.save(funcionario.get());
            return ResponseEntity.ok().build();
        }
    }

    @DeleteMapping("/{idFunc}")
    public ResponseEntity<String> delete(@PathVariable Long idFunc) {

        Optional<Funcionario> funcionario = funcionarioService.findById(idFunc);
        if (funcionario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // delete
        funcionarioService.delete(idFunc);
        return ResponseEntity.ok().build();

    }

    @GetMapping
    public ResponseEntity<List<FuncionarioResponseDTO>> findAll() {


        List<Funcionario> funcionarios = funcionarioService.findAll();
        List<FuncionarioResponseDTO> funcionarioResponseDTOS = new ArrayList<>();

        for (Funcionario funcionario: funcionarios) {
            FuncionarioResponseDTO funcionarioResponseDto = new FuncionarioResponseDTO();
            funcionarioResponseDto.setNome(funcionario.getNome());
            funcionarioResponseDto.setBonusSalarial(funcionario.getBonusSalarial());
            funcionarioResponseDto.setCpf(funcionario.getCpf());
            funcionarioResponseDto.setIdFunc(funcionario.getIdFunc());
            funcionarioResponseDto.setCargo(new CargoResponseDTO());
            funcionarioResponseDto.getCargo().setIdCargo(funcionario.getCargo().getIdCargo());
            funcionarioResponseDto.getCargo().setNome(funcionario.getCargo().getNome());
            funcionarioResponseDto.getCargo().setSalario(funcionario.getCargo().getSalario());

            funcionarioResponseDTOS.add(funcionarioResponseDto);
        }

        return ResponseEntity.ok(funcionarioResponseDTOS);

    }
}
