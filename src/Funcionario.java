import java.math.BigDecimal;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    BigDecimal salario;
    String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void aplicarAumento() {
        this.salario = salario.multiply(BigDecimal.valueOf(1.10));
    }

    public String getFuncao() {
        return funcao;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Nascimento: " + getFormattedDataNascimento() + ", Salário: " + salario + ", Função: " + funcao;
    }
}

