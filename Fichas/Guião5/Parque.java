import java.util.*;
import java.util.stream.Collectors;

public class Parque {
    private String namePark;
    private Map<String, Lugar> lugar;

    public Parque(){
        this.namePark = "";
        this.lugar = Collections.emptyMap();
    }
    public Parque(String name, Map<String, Lugar> map){
        this.namePark = name;
        this.lugar = map.values().stream().collect(Collectors.toMap(Lugar::getMatricula, Lugar::clone));
    }
    public Parque(Parque p){
        this(p.namePark, p.lugar);
    }
    public Parque clone(){
        return new Parque(this);
    }
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || this.getClass() != o.getClass()) return false;
        Parque pa = (Parque) o;
        return this.namePark.equals(pa.namePark) && this.lugar.equals(pa.lugar);
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Park Name: ").append(this.namePark);
        if(this.lugar.isEmpty()) sb.append("\nEmpty Park");
        else {
            sb.append("\nLugares");
            this.lugar.values().forEach(a -> {sb.append(a.toString()).append("\n");});
        }
        return sb.toString();
    }
    public String getNamePark(){
        return this.namePark;
    }
    public Set<String> matriculas(){
        return this.lugar.keySet();
    }
    public void novoLugar(String mat, String name, int min, boolean perm){
        this.lugar.put(mat,new Lugar(mat,name,min,perm));
    }
    public void removeL(String mat){
        this.lugar.remove(mat);
    }
    public void alteraTime(String mat, int min){
        Lugar l = this.lugar.getOrDefault(mat,null);
        if(l != null){
            l.setMin(min);
            this.lugar.replace(mat,l);
        }
    }
    public int tempoRestanteInt(){
        return this.lugar.values().stream().filter(a->!a.getPerm()).mapToInt(Lugar :: getMin).sum();
    }
    public int tempoRestanteExt(){
        int soma = 0;
        for(Lugar lug : this.lugar.values()){
            soma+=lug.getMin();
        }
        return soma;
    }
    public boolean existeLugar(String mat){
        boolean res = false;
        if(this.lugar.containsKey(mat)){
            res = true;
        }
        return res;
    }
    public List<String> matriculaPermInt(int x){
        return this.lugar.values().stream().filter(a->a.getPerm() && a.getMin()>x).map(Lugar::getMatricula).collect(Collectors.toList());
    }
    public List<String> matriculasPermExt(int x){
        List<String> l = new ArrayList<String>();
        for(Lugar lug : this.lugar.values()){
            if(lug.getPerm() && lug.getMin() > x){
                l.add(lug.getMatricula());
            }
        }
        return l;
    }
    public Lugar InfoLugar(String mat){
        return this.lugar.getOrDefault(mat,null).clone();
    }
    public String getParkName(){
        return this.namePark;
    }
    public void setNamePark(String nP){
        this.namePark = nP;
    }
    public Map<String,Lugar> getLugar(){
        return this.lugar.values().stream().collect(Collectors.toMap(Lugar::getMatricula,Lugar::clone));
    }
    public void SetLugar(Map<String,Lugar> map){
        this.lugar = map.values().stream().collect(Collectors.toMap(Lugar::getMatricula,Lugar::clone));
    }
}
