package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GerenciadorFuncionarios {
    private List<Funcionario> funcionarios;

    public GerenciadorFuncionarios() {
        this.funcionarios = new ArrayList<>();
    }

    public void inserir(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionarioPorNome(String nome) {
        funcionarios.removeIf(f -> f.getNome().equals(nome));
    }

    public void aplicarAumentoSalario(BigDecimal percentualAumento) {
        funcionarios.forEach(f -> f.setSalario(f.getSalario().multiply(BigDecimal.ONE.add(percentualAumento))));
    }

    public Map<String, List<Funcionario>> agruparPorFuncao() {
        return funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public List<Funcionario> filtrarPorMesAniversario(int... meses) {
        Set<Month> mesesAniversario = Arrays.stream(meses).mapToObj(Month::of).collect(Collectors.toSet());
        return funcionarios.stream()
                .filter(f -> mesesAniversario.contains(f.getDataNascimento().getMonth()))
                .collect(Collectors.toList());
    }

    public Funcionario funcionarioMaisVelho() {
        return funcionarios.stream().max(Comparator.comparingInt(Funcionario::getIdade)).orElse(null);
    }

    public void ordenarPorNome() {
        funcionarios.sort(Comparator.comparing(Funcionario::getNome));
    }

    public BigDecimal calcularTotalSalarios() {
        return funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Map<Funcionario, BigDecimal> calcularSalariosMinimos(BigDecimal salarioMinimo) {
        return funcionarios.stream()
                .collect(Collectors.toMap(
                        f -> f,
                        f -> f.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP)
                ));
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
