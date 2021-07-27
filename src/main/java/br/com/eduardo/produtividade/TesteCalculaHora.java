package br.com.eduardo.produtividade;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.eduardo.produtividade.modelo.Funcionario;
import br.com.eduardo.produtividade.modelo.Lancamento;

public class TesteCalculaHora {
	
	public static void main(String[] args) {
		
		LocalDate horaLancamento = LocalDate.of(2021, 07, 26);
		Funcionario funcionario = new Funcionario("Teste");
		LocalTime horaInicio = LocalTime.of(8, 0);
		LocalTime horaFim = LocalTime.of(9, 38);
		Integer quantidade = 1500;
		Lancamento lancamento1 = new Lancamento(horaLancamento, funcionario, quantidade, horaInicio, horaFim);

		System.out.println(lancamento1);
		
	}
	
}
