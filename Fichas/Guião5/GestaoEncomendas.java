import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GestaoEncomendas implements Comparable<GestaoEncomendas>{
    private Map<Integer, Encomenda> enc;
    public GestaoEncomendas(){
        this.enc = Collections.emptyMap();
    }
    public GestaoEncomendas(Map<String,Encomenda> nEnc){
        this.enc = nEnc.values().stream().collect(Collectors.toMap(Encomenda::getOrderN, Encomenda::clone));
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
        return this.enc.values().stream().collect(Collectors.toMap(Encomenda::getOrderN, Encomenda::clone));
    }
    public void setEnc(Map<Integer,Encomenda> nEnc){
        this.enc = nEnc.values().stream().collect(Collectors.toMap(Encomenda::getOrderN, Encomenda::clone));
    }
    public Set<Integer> todosOsCodigos(){
        return this.enc.keySet();
    }
    public void addEncomenda(Encomenda e){
        this.enc.put(e.getOrderN(), e.clone());
    }
    public void removeEncomenda(Integer codEnc){
        this.enc.remove(codEnc);
    }
    public int encomendaComMaisProdutos(){
        return this.enc.values().stream().min((a,b)->b.numProdutos() - a.numProdutos()).get().getOrderN();
    }
    public Set<Integer> encomendasComProduto(String codProd){
        return this.enc.values().stream().filter(a -> a.existeNaEncomenda(codProd)).map(Encomenda::getOrderN).collect(Collectors.toSet());
    }
    public Set<Integer> encomendasAposData(LocalDate d){
        return this.enc.values().stream().filter(a->a.getDate().isAfter(ChronoLocalDate.from(d))).map(Encomenda::getOrderN).collect(Collectors.toSet());
    }
    public Set<Encomenda> encomendasValorDecrescente(){
        return this.enc.values().stream().map(Encomenda::clone).sorted((a,b) -> (int) (b.calculaValorTotal()-a.calculaValorTotal())).collect(Collectors.toSet());
        /*
        public Set<Encomenda> encomendasValorDecrescente(){
            Comparator<Encomenda> comp=(e1,e2)->(int)(e2.calculaValorTotal()-e1.calculaValorTotal());
            TreeSet <Encomenda> aux=new TreeSet<Encomenda>(comp);
            for(Encomenda e:this.encomendas.values())
                aux.add(e.clone());
            return aux;
        }
       
        public Collection<Encomenda> encomendasValorDecrescenteext(){ //Usa iteradores externos
            List<Encomenda> aux=new ArrayList();
            for(Encomenda e: this.encomendas.values())
                aux.add(e.clone());
            aux.sort((e1,e2)->(int)(e2.calculaValorTotal()-e1.calculaValorTotal()));
            return aux;
        }
       */
    }
    public Map<String,List<Integer>> encomendasDeProduto(){
        Map<String,List<Integer>> aux=new HashMap<>();
        for(Encomenda e:this.enc.values()){
            List<String> lprods=e.getListaProdutos();
            for(String codProd: lprods){
               if(!aux.containsKey(codProd))
                    aux.put(codProd,new ArrayList<Integer>());
               aux.get(codProd).add(e.getOrderN());
            }
         }
        return aux;
    }
}