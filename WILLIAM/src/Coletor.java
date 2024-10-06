public class Coletor {

    //ATRIBUTOS DOS COLETORES QUE OS COMPOEM

    private String nome;
    private int matricula;
    private String funcionario;
    private String turno;


    public Coletor(String nome, int matricula, String funcionario, String Turno) {

    }

    //CONSTRUINDOS OS MEUS GETS E SETERS DE ACESSO AS CLASSES PRIVADAS

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



}

