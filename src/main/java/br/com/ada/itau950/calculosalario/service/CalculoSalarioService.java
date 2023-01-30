package br.com.ada.itau950.calculosalario.service;

import java.math.BigDecimal;

public interface CalculoSalarioService {

    BigDecimal salarioTotal(Long idFunc);
}
