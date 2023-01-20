package br.com.ada.itau950.calculosalario.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@Entity
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCargo;

    private String nome;
    private BigDecimal salario;

    @OneToMany(mappedBy = "cargo")
    private Set<Funcionario> funcionario;

}
