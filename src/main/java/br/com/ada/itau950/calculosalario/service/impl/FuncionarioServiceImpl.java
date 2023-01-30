package br.com.ada.itau950.calculosalario.service.impl;

import br.com.ada.itau950.calculosalario.entity.Funcionario;
import br.com.ada.itau950.calculosalario.repository.FuncionarioRepository;
import br.com.ada.itau950.calculosalario.service.FuncionarioService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private FuncionarioRepository funcionarioRepository;

    public FuncionarioServiceImpl (FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    @Override
    public Optional<Funcionario> findById(Long idFunc) {
        return funcionarioRepository.findById(idFunc);
    }

    @Override
    public void delete(Long idFunc) {
        funcionarioRepository.deleteById(idFunc);
    }

    @Override
    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }

 /*   public BigDecimal salarioTotal(Long idFunc){

        Optional<Funcionario> funcionario = findById(idFunc);

        BigDecimal salarioTotal = funcionario.get().getBonusSalarial().add(funcionario.get().getCargo().getSalario());

        return salarioTotal;
    }*/
}
