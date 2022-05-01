import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GestaoEncomendas implements Comparable<GestaoEncomendas>{
    private Map<Integer, Encomenda> enc;
    public GestaoEncomendas(){
        this.enc = Collections.emptyMap();
    }
    public GestaoEncomendas(Map<String,Encomenda> nEnc){
        this.enc = nEnc.values().stream().collect(Collectors.toMap(Encomenda::getNumEnc, Encomenda::clone));
    }
    public GestaoEncomendas(GestaoEncomendas gE){
        this.enc = gE.getEnc();
    }
    public boolean equals(Object gestEnc){
        if(this == gestEnc) return true;
        if(gestEnc == null || this.getClass() != gestEnc.getClass()) return false;
        GestaoEncomendas gE = (GestaoEncomendas) gestEnc;
        return this.enc.equals(gE.getEnc());
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(this.enc.isEmpty()){
            sb.append("Sem Encomendas");
        } else{
            sb.append("Encomendas: "); this.enc.values().forEach(a -> sb.append(a.toString()+"\n"));
        }
        return sb.toString();
    }
    public int compareTo(GestaoEncomendas gE) {
        return this.enc.size() - gE.enc.size();
    }
    public GestaoEncomendas clone(){
        return new GestaoEncomendas(this);
    }
    public Map<Integer,Encomenda> getEnc(){
        return this.enc.values().stream().collect(Collectors.toMap(Encomenda::getNumEnc, Encomenda::clone));
    }
    public void setEnc(Map<Integer,Encomenda> nEnc){
        this.enc = nEnc.values().stream().collect(Collectors.toMap(Encomenda::getNumEnc, Encomenda::clone));
    }
    public Set<Integer> todosOsCodigos(){
        return this.enc.keySet();
    }
    public void addEncomenda(Encomenda e){
        this.enc.put(e.getNumEnc(), e.clone());
    }
}