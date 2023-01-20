package br.com.ada.itau950.calculosalario.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class CargoResponseDTO {

    private Long idCargo;
    private String nome;
    private BigDecimal salario;

    }

