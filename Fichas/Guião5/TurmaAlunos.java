import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TurmaAlunos{
    private String nT;
    private String uc;
    private Map<String, Aluno> alunos;
    public TurmaAlunos(){
        this("","",Collections.emptyMap());
    }
    public TurmaAlunos(String t, String nUC, Map<String, Aluno> al){
        this.nT = t;
        this.uc = nUC;
        this.alunos = al.values().stream().collect(Collectors.toMap(Aluno::getNumero, Aluno::clone));
    }
    public TurmaAlunos(TurmaAlunos tA){
        this.nT = tA.getNturma();
        this.uc = tA.getUC();
        this.alunos = tA.getAlunos();
    }
    public boolean equals(Object ta){
        if(this == ta) return true;
        if(ta == null || this.getClass() != ta.getClass()) return false;
        TurmaAlunos nA = (TurmaAlunos) ta;
        return this.nT.equals(nA.getNturma()) &&
               this.uc.equals(nA.getUC()) &&
               this.alunos.equals(nA.getAlunos());
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome da Turma: ").append(this.nT)
          .append("\nNome da Uc: ").append(this.uc);
        if(this.alunos.isEmpty()){
            sb.append("\nSem Alunos.");
        } else {
            sb.append("\nAlunos: "); this.alunos.values().forEach(a -> sb.append(a.toString()+"\n"));
        }
        return sb.toString();
    }
    public int compareTo(Object ta){
        if(ta.getClass() != this.getClass()) return 1;
        TurmaAlunos nA = (TurmaAlunos) ta;
        if(!this.nT.equals(nA.nT)) return this.nT.compareTo(nA.nT);
        if(!this.uc.equals(nA.uc)) return this.uc.compareTo(nA.uc);
        if(!this.alunos.equals(nA.alunos)) return this.alunos.size() - nA.alunos.size();
        return 0;
    }
    public TurmaAlunos clone(){
        return new TurmaAlunos(this);
    }
    public String getNturma(){
        return this.nT;
    }
    public String getUC(){
        return this.uc;
    }
    public Map<String, Aluno> getAlunos(){
        return this.alunos.values().stream().collect(Collectors.toMap(Aluno::getNumero, Aluno::clone));
    }
    public void setNturma(String newNT){
        this.nT = newNT;
    }
    public void setUC(String nUC){
        this.uc = nUC;
    }
    public void setAlunos(Map<String, Aluno> al){
        this.alunos = al.values().stream().collect(Collectors.toMap(Aluno::getNumero, Aluno::clone));
    }
    public void insereAluno(Aluno a){
        this.alunos.put(a.getNumero(), a.clone());
    }
    public Aluno getAluno(String codAluno){
        return this.alunos.getOrDefault(codAluno, null).clone();
    }
    public void removeAluno(String codAluno){
        this.alunos.remove(codAluno);
    }
    public Set<String> todosOsCodigos(){
        return this.alunos.keySet();
    }
    public int qtsAlunos(){
        return this.alunos.size();
    }
    public Collection<Aluno> alunosOrdemAlfabetica(){
        //compareTo in Aluno already inserts with order
        return this.alunos.values().stream().sorted().collect(Collectors.toList());
    }
    public Set<Aluno> alunosOrdemDecrescenteNumero(){
        SortedSet<Aluno> s = new TreeSet<>((a,b) -> b.getNumero().compareTo(a.getNumero()));
        this.alunos.values().forEach(a->s.add(a.clone()));
        return s;
    }
}
