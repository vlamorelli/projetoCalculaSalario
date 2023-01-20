package br.com.ada.itau950.calculosalario.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculoSalarioController {

    @GetMapping("/calculo-salario")
    public String calculoSalario(){
        return "Salário Calculado";
    }

}
