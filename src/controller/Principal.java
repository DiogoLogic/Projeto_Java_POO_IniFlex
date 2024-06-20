package controller; // Declaração do pacote

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import model.Funcionario;
import model.GerenciadorFuncionarios;
import view.VisaoConsole;

public class Principal {
    private GerenciadorFuncionarios gerenciador;
    private VisaoConsole visao;

    public Principal() {
        this.gerenciador = new GerenciadorFuncionarios();
        this.visao = new VisaoConsole();
    }

    public void executar() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        
        gerenciador.inserir(new Funcionario("Maria", LocalDate.parse("18/10/2000", formatter), new BigDecimal("2009.44"), "Operador"));
        gerenciador.inserir(new Funcionario("João", LocalDate.parse("12/05/1990", formatter), new BigDecimal("2284.38"), "Operador"));
        gerenciador.inserir(new Funcionario("Caio", LocalDate.parse("02/05/1961", formatter), new BigDecimal("9836.14"), "Coordenador"));
        gerenciador.inserir(new Funcionario("Miguel", LocalDate.parse("14/10/1988", formatter), new BigDecimal("19119.88"), "Diretor"));
        gerenciador.inserir(new Funcionario("Alice", LocalDate.parse("05/01/1995", formatter), new BigDecimal("2234.68"), "Recepcionista"));
        gerenciador.inserir(new Funcionario("Heitor", LocalDate.parse("19/11/1999", formatter), new BigDecimal("1582.72"), "Operador"));
        gerenciador.inserir(new Funcionario("Arthur", LocalDate.parse("31/03/1993", formatter), new BigDecimal("4071.84"), "Contador"));
        gerenciador.inserir(new Funcionario("Laura", LocalDate.parse("08/07/1994", formatter), new BigDecimal("3017.45"), "Gerente"));
        gerenciador.inserir(new Funcionario("Heloísa", LocalDate.parse("24/05/2003", formatter), new BigDecimal("1606.85"), "Eletricista"));
        gerenciador.inserir(new Funcionario("Helena", LocalDate.parse("02/09/1996", formatter), new BigDecimal("2799.93"), "Gerente"));

    
        visao.exibirFuncionarios(gerenciador.getFuncionarios());

   
        gerenciador.removerFuncionarioPorNome("João");

     
        visao.exibirFuncionarios(gerenciador.getFuncionarios());

     
        gerenciador.aplicarAumentoSalario(new BigDecimal("0.10"));

        
        Map<String, List<Funcionario>> funcionariosPorFuncao = gerenciador.agruparPorFuncao();

     
        visao.exibirFuncionariosAgrupados(funcionariosPorFuncao);

     
        List<Funcionario> aniversariantes = gerenciador.filtrarPorMesAniversario(10, 12);
        visao.exibirAniversariantes(aniversariantes);

     
        Funcionario maisVelho = gerenciador.funcionarioMaisVelho();
        visao.exibirFuncionarioMaisVelho(maisVelho);

        
        gerenciador.ordenarPorNome();
        visao.exibirFuncionarios(gerenciador.getFuncionarios());

     
        BigDecimal totalSalarios = gerenciador.calcularTotalSalarios();
        visao.exibirTotalSalarios(totalSalarios);

   
        Map<Funcionario, BigDecimal> salariosMinimos = gerenciador.calcularSalariosMinimos(new BigDecimal("1212.00"));
        visao.exibirSalariosMinimos(salariosMinimos);
    }

    public static void main(String[] args) {
        new Principal().executar();
    }
}
