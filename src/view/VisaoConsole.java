package view;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import model.Funcionario;

public class VisaoConsole {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void exibirFuncionarios(List<Funcionario> funcionarios) {
        System.out.println("\nLista de Funcionários:");
        funcionarios.forEach(f -> System.out.println(f.formatado(formatter)));
    }

    public void exibirFuncionariosAgrupados(Map<String, List<Funcionario>> funcionariosPorFuncao) {
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("\nFunção: " + funcao);
            lista.forEach(f -> System.out.println(f.formatado(formatter)));
        });
    }

    public void exibirAniversariantes(List<Funcionario> aniversariantes) {
        System.out.println("\nAniversariantes em Outubro e Dezembro:");
        aniversariantes.forEach(f -> System.out.println(f.formatado(formatter)));
    }

    public void exibirFuncionarioMaisVelho(Funcionario funcionario) {
        if (funcionario != null) {
            System.out.println("\nFuncionário com maior idade: " + funcionario.getNome() + ", " + funcionario.getIdade() + " anos");
        } else {
            System.out.println("\nNão há funcionários na lista.");
        }
    }

    public void exibirTotalSalarios(BigDecimal totalSalarios) {
        System.out.println("\nTotal dos salários: R$" + totalSalarios.toPlainString());
    }

    public void exibirSalariosMinimos(Map<Funcionario, BigDecimal> salariosMinimos) {
        System.out.println("\nSalários mínimos por funcionário:");
        salariosMinimos.forEach((funcionario, salarios) -> {
            System.out.println(funcionario.getNome() + " - " + salarios.toPlainString() + " salários mínimos");
        });
    }
}