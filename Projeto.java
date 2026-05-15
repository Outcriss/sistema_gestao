import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Projeto {
    private int id;
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataTerminoPrevista;
    private String status;
    private Usuario gerenteResponsavel; // Associação direta com a classe Usuario
    private List<Equipe> equipesAlocadas;

    public Projeto(String nome, String descricao, LocalDate dataInicio, LocalDate dataTerminoPrevista, String status, Usuario gerenteResponsavel) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTerminoPrevista = dataTerminoPrevista;
        this.status = status;
        this.gerenteResponsavel = gerenteResponsavel;
        this.equipesAlocadas = new ArrayList<>();
    }

    // Getters e Setters principais
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public LocalDate getDataInicio() { return dataInicio; }
    public LocalDate getDataTerminoPrevista() { return dataTerminoPrevista; }
    public String getStatus() { return status; }
    public Usuario getGerenteResponsavel() { return gerenteResponsavel; }
}