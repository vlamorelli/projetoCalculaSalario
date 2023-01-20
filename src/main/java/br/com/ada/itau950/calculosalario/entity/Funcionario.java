package br.com.ada.itau950.calculosalario.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFunc;

    private String nome;
    private String cpf;
    private BigDecimal bonusSalarial;

    @OneToMany(mappedBy = "idCargo")
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Cargo cargo;
}
