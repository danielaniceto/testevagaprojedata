package main.java.services;

import main.java.model.Funcionario;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FuncionarioService {

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
}