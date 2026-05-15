public class Usuario {
    // Atributos privados - (Encasulamento)
    private int id;
    private String nomeCompleto;
    private String cpf;
    private String email;
    private String cargo;
    private String login;
    private String senha;
    private String perfil;


    public Usuario(String nomeCompleto, String cpf, String email, String cargo, String login, String senha, String perfil) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
    }


    public String getNomeCompleto() { return nomeCompleto; }
    public String getCpf() { return cpf; }
    public String getEmail() { return email; }
    public String getCargo() { return cargo; }
    public String getLogin() { return login; }
    public String getSenha() { return senha; }
    public String getPerfil() { return perfil; }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}