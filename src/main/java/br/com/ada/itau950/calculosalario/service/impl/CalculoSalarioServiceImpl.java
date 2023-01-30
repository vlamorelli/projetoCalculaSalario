package br.com.ada.itau950.calculosalario.service.impl;

import br.com.ada.itau950.calculosalario.entity.Funcionario;
import br.com.ada.itau950.calculosalario.repository.FuncionarioRepository;
import br.com.ada.itau950.calculosalario.service.CalculoSalarioService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CalculoSalarioServiceImpl implements CalculoSalarioService {


    private FuncionarioRepository funcionarioRepository;

    public CalculoSalarioServiceImpl(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public BigDecimal salarioTotal(Long idFunc){

        Optional<Funcionario> funcionario = funcionarioRepository.findById(idFunc);

        BigDecimal salarioTotal = funcionario.get().getBonusSalarial().add(funcionario.get().getCargo().getSalario());

        return salarioTotal;
    }
}
