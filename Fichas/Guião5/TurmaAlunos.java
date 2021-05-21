import java.util.*;
import java.util.stream.Collectors;

public class TurmaAlunos {
    private Map<String,Aluno> aluno;
    private String turmaName;
    private String uc;

    public TurmaAlunos(Map<String,Aluno> al, String name, String codUc){
        this.aluno = al.values().stream().collect(Collectors.toMap(Aluno :: getNumero,Aluno :: clone));
        this.turmaName = name;
        this.uc = codUc;
    }
    public TurmaAlunos(TurmaAlunos t){
        this(t.aluno,t.turmaName,t.uc);
    }
    public TurmaAlunos clone(){
        return new TurmaAlunos(this);
    }
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        TurmaAlunos tA = (TurmaAlunos) o;
        return this.aluno.equals(tA.aluno) && this.turmaName.equals(tA.turmaName) &&
               this.uc.equals(tA.uc);
    }
    public int compareTo(Object o){
        if(o.getClass() != this.getClass()) return 1;
        TurmaAlunos tA = (TurmaAlunos) o;
        if(!this.aluno.equals(tA.aluno)){
            return this.aluno.size() - tA.aluno.size();
        }
        if(!this.turmaName.equals(tA.turmaName)){
            return this.turmaName.compareTo(tA.turmaName);
        }
        if(!this.uc.equals(tA.uc)){
            return this.uc.compareTo(tA.uc);
        }
        return 0;
    }
    public Map<String, Aluno> getAluno() {
        return this.aluno.values().stream().collect(Collectors.toMap(Aluno::getNumero, Aluno::clone));
    }
    public void setAluno(Map<String,Aluno> al){
        this.aluno = al.values().stream().collect(Collectors.toMap(Aluno::getNumero,Aluno::clone));
    }
    public String getTurmaName(){
        return this.turmaName;
    }
    public void setTurmaName(String tN){
        this.turmaName = tN;
    }
    public String getUc(){
        return this.uc;
    }
    public void setUc(String codUc){
        this.uc = codUc;
    }
    public void insereAluno(Aluno a){
        this.aluno.put(a.getNumero(),a.clone());
    }
    public Aluno getAluno(String codAluno){
        return this.aluno.getOrDefault(codAluno,null).clone();
    }
    public void removeAluno(String codAluno){
        this.aluno.remove(codAluno);
    }
    public Set<String> todosOsCodigos(){
        return this.aluno.keySet();
    }
    public int qtsAlunos(){
        return this.aluno.size();
    }
    public Collection<Aluno> alunosOrdemAlfabetica(){
        return this.aluno.values().stream().sorted().collect(Collectors.toList());
    }
    public Set<Aluno> alunosOrdemDescrescenteNumero(){
        SortedSet<Aluno> s = new TreeSet<Aluno>( (a, b)-> b.getNumero().compareTo(a.getNumero()));
        this.aluno.values().forEach(a -> s.add(a.clone()));
        return s;
    }
}
