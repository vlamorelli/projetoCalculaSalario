package br.com.ada.itau950.calculosalario.service;

import br.com.ada.itau950.calculosalario.entity.Funcionario;

import java.util.Optional;

public interface FuncionarioService {

    Funcionario save (Funcionario funcionario);

    Optional<Funcionario> findById (Long idFunc);

    void delete (Long idFunc);

}
