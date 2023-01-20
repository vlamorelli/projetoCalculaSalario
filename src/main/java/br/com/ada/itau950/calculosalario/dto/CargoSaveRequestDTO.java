package br.com.ada.itau950.calculosalario.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class CargoSaveRequestDTO {


   // private Long idCargo;
   @NotNull @NotBlank private String nome;

    @NotNull @DecimalMin(value = "0.1")
    private BigDecimal salario;

}
