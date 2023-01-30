package br.com.ada.itau950.calculosalario.controller;

import br.com.ada.itau950.calculosalario.dto.CalculoSalarioResponseDTO;
import br.com.ada.itau950.calculosalario.service.CalculoSalarioService;
import br.com.ada.itau950.calculosalario.service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CalculoSalarioController {

 /*   private FuncionarioService funcionarioService;

   public CalculoSalarioController (FuncionarioService funcionarioService){
        this.funcionarioService = funcionarioService;
    }*/

    private CalculoSalarioService calculoSalarioService;

    public CalculoSalarioController (CalculoSalarioService calculoSalarioService){
        this.calculoSalarioService = calculoSalarioService;
    }

    @GetMapping("/calculo-salario/{idFunc}")
    public ResponseEntity<CalculoSalarioResponseDTO> calculoSalario(@PathVariable Long idFunc){

        BigDecimal salarioTotal = calculoSalarioService.salarioTotal(idFunc);

        CalculoSalarioResponseDTO calculoSalarioResponseDTO = new CalculoSalarioResponseDTO();
        calculoSalarioResponseDTO.setSalarioTotal(salarioTotal);

        return ResponseEntity.ok(calculoSalarioResponseDTO);
    }

}
