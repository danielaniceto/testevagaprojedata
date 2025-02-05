import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args){
        List<Funcionario> funcionarios = new ArrayList<>();

        // inserir os funcionarios
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.44), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 05, 12), BigDecimal.valueOf(2284.38), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 05, 02), BigDecimal.valueOf(9836.14), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(19119.88), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 01, 05), BigDecimal.valueOf(2234.68), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 03, 31), BigDecimal.valueOf(4071.84), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 07, 08), BigDecimal.valueOf(3017.45), "Gerente"));
        funcionarios.add(new Funcionario("Heloisa", LocalDate.of(2003, 05, 18), BigDecimal.valueOf(1606.85), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 09, 02), BigDecimal.valueOf(2799.93), "Operador"));

        // Remove o funcionário João da lista
        funcionarios.removeIf(f -> f.getNome().equalNome.equalsIgnoreCase("João"));

        // Imprime todos os funcionários da lista, com suas infos ja formatadas
        System.out.prinln("Listar Funcoionários:");
        funcionarios.forEach(f-> {
            System.out.println(f.getNome() + ", Nascimento: " + f.getFormattedDataNascimento() + ", Salário: R$ " + formatarValor(f.getSalario()) + ", Função: " + f.getFuncao());
            });

        // Aplicando aumento de 10% no salario base
        funcionarios.forEach(f-> f.aplicarAumento());

        //Agrupando os funcionarios por função
        Map<String, List<Funcionario>> grupoPorFuncao = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
        System.out.prinln("\nFuncionários agrupados por função:");
        grupoPorFuncao.forEach((funcao, lista)->{System.out.println(funcao + ":" + lista);
    });
}
