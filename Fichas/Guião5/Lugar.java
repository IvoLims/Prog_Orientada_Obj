import java.util.Objects;

public class Lugar implements Comparable<Lugar>{
    private String matricula;
    private String name;
    private int min;
    private boolean perm;
    
    public Lugar(){
        this.matricula = "";
        this.name = "";
        this.min = 0;
        this.perm = true;
    }
    public Lugar(String matricula, String name, int min, boolean perm) { 
        this.matricula = matricula;
        this.name = name;
        this.min = min;
        this.perm = perm;
    }
    public Lugar(Lugar l) {
        this(l.matricula,l.name,l.min, l.perm);
    }
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null && this.getClass() != o.getClass()) return false;
        Lugar l = (Lugar) o;
        return this.matricula.equals(l.matricula) && this.name.equals(name) &&
               this.min == l.min && this.perm == l.perm;
    }
    /*or
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lugar)) return false;
        Lugar lugar = (Lugar) o;
        return min == lugar.min && perm == lugar.perm && Objects.equals(matricula, lugar.matricula) && Objects.equals(name, lugar.name);
    }
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Matricula: ").append(this.matricula);
        sb.append("\nName: ").append(this.name);
        sb.append("\nTempo: ").append(this.min).append(" min\n");
        sb.append("Lugar permanente: ").append(this.perm);
        return sb.toString();
    }
    public Lugar clone(){
        return new Lugar(this);
    }
    public int compareTo(Lugar l){
        return this.min - l.min;
    }
    public String getMatricula(){
        return this.matricula;
    }
    public void setMatricula(String m){
        this.matricula = m;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String n){
        this.name = n;
    }
    public int getMin() {
        return this.min;
    }
    public void setMin( int min){
        this.min = min;
    }
    public boolean getPerm(){
        return this.perm;
    }
    public void setPerm(boolean pe){
        this.perm = pe;
    }
}
