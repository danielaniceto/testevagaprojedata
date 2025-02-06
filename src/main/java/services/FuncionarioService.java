package main.java.services;

import main.java.model.Funcionario;
import main.java.util.Util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FuncionarioService {

    private static final BigDecimal SALARIO_MINIMO = BigDecimal.valueOf(1212.00);
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00");

    // Remover funcionário pelo nome
    public static void removerFuncionario(List<Funcionario> funcionarios, String nome) {
        funcionarios.removeIf(f -> f.getNome().equalsIgnoreCase(nome));
    }

    // Aplicar aumento de salário
    public static void aplicarAumento(List<Funcionario> funcionarios, double percentual) {
        funcionarios.forEach(f -> {
            BigDecimal aumento = f.getSalario().multiply(BigDecimal.valueOf(percentual / 100));
            f.setSalario(f.getSalario().add(aumento));
        });
    }

    // Encontrar funcionário mais velho
    public static Optional<Funcionario> encontrarMaisVelho(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .min((f1, f2) -> f1.getDataNascimento().compareTo(f2.getDataNascimento()));
    }

    // Listar funcionários em ordem alfabética
    public static List<Funcionario> listarPorOrdemAlfabetica(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .sorted((f1, f2) -> f1.getNome().compareToIgnoreCase(f2.getNome()))
                .collect(Collectors.toList());
    }

    // Agrupar funcionários por função
    public static Map<String, List<Funcionario>> agruparPorFuncao(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    // Calcular quantos salários mínimos ganha cada funcionário
    public static void imprimirSalariosMinimos(List<Funcionario> funcionarios) {
        funcionarios.forEach(f -> {
            BigDecimal qtdSalarios = f.getSalario()
                    .divide(SALARIO_MINIMO, 2, RoundingMode.HALF_UP);
            System.out.printf("\nFuncionário: %s, Salário: %s, Quantidade de Salários Mínimos: %s",
                    f.getNome(), Util.formatarValor(f.getSalario()), DECIMAL_FORMAT.format(qtdSalarios));
        });
    }

    // Imprimir os funcionarios que fazem aniversario no mês 10 e 12
    public static void  imprimirAniversariantesMes(List<Funcionario> funcionarios) {
        List<Integer> mesesFiltro = List.of(10, 12);

        funcionarios.stream()
                .filter(f -> mesesFiltro.contains(f.getDataNascimento().getMonthValue()))
                .forEach(f -> {
                    String dataFormatada = Util.formatarData(f.getDataNascimento());
                    System.out.println("Funcionários: " + f.getNome() + ", Data de Nascimento:" + dataFormatada);
                });
    }

    // Imprimir a lista de funcionários por ordem alfabética.
    public static void imprimiOrdemAlfabetica(List<Funcionario> funcionarios) {
        funcionarios.stream()
                .sorted((f1, f2) -> f1.getNome().compareToIgnoreCase(f2.getNome()))
                .forEach(f -> System.out.println("\nFuncionários: " + f.getNome() + ", função: " +f.getFuncao() + ", Salário: " + f.getSalario()));
    }

    // Calcular e imprimir o total dos salários dos funcionários
    public static void imprimirTotalSalarios(List<Funcionario> funcionarios) {
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.printf("\nTotal dos salários dos funcionários: R$ %.2f%n", totalSalarios);
    }
}