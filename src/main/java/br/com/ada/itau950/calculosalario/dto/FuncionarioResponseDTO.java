package br.com.ada.itau950.calculosalario.dto;

import br.com.ada.itau950.calculosalario.entity.Cargo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class FuncionarioResponseDTO {

    private Long idFunc;
    private String nome;
    private String cpf;
    private BigDecimal bonusSalarial;
    private Cargo cargo;

    }

