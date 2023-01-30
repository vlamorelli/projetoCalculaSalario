package br.com.ada.itau950.calculosalario.dto;

import br.com.ada.itau950.calculosalario.entity.Cargo;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class FuncionarioSaveRequestDTO {

    //private Long idFunc;

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}$", message = "CPF invalido")
    private String cpf;

    @NotNull @DecimalMin(value = "0.1")
    private BigDecimal bonusSalarial;

    @NotNull
    private long idCargo;


}
