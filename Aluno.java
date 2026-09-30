import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluno {

    private long id;
    private LocalDate nascimento;
    private String ra;
    private String nome;

    public long getId() {
        return id;

    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String admissaoNascimento = this.nascimento.format( dtf );
        return "-------- Aluno : [ID = " + id + "; Nascimento = " + nascimento + "; RA = " + ra + "; Nome = " + nome
                + " ]";
    }

}
