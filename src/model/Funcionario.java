package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public int getIdade() {
        return Period.between(getDataNascimento(), LocalDate.now()).getYears();
    }

    public String formatado(DateTimeFormatter formatter) {
        return String.format("%-10s %-12s R$%,.2f %-15s Idade: %d",
                getNome(), getDataNascimento().format(formatter), getSalario(), getFuncao(), getIdade());
    }
}