package br.com.ada.itau950.calculosalario.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CalculoSalarioResponseDTO {

    private BigDecimal salarioTotal;
}
