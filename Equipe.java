import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private int id;
    private String nome;
    private String descricao;
    private List<Usuario> membros; // Lista de usuários nesta equipe

    public Equipe(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.membros = new ArrayList<>();
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public List<Usuario> getMembros() { return membros; }
}