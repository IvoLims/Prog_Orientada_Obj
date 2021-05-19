import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SistemadeSuporte {
    ArrayList<PedidodeSuporte> pedidos;
    
    public SistemadeSuporte(ArrayList<PedidodeSuporte> ps){
        this.pedidos = new ArrayList<PedidodeSuporte>();
        for(PedidodeSuporte elem : ps)
            this.pedidos.add(elem.clone());
    }
    public SistemadeSuporte(){
        this(new ArrayList<PedidodeSuporte>());
    }
    public SistemadeSuporte(SistemadeSuporte s){
        this(s.pedidos);
    }
    public boolean equals(Object s){
        if(this == s) return true;
        if(s == null || this.getClass() != s.getClass()) return false;
        SistemadeSuporte si = (SistemadeSuporte) s;
        boolean iSame = true;
        if(this.pedidos.size() != si.pedidos.size()) return false;
        for(int i = 0; iSame && i< this.pedidos.size();i++){
            iSame = this.pedidos.get(i).equals(si.pedidos.get(i));
        }
        return iSame;
    }
    public SistemadeSuporte clone(){
        return new SistemadeSuporte(this);
    }
    public String toString(){
        StringBuilder sb = new StringBuilder("Pedidos: ");
        for(PedidodeSuporte elem : this.pedidos){
            sb.append(elem.toString()).append("\n");
        }
        return sb.toString();
    }
    public void inserePedido(PedidodeSuporte pedido){

    }
    public PedidodeSuporte procuraPedido(String user, LocalDateTime data){

    }
    public void resolvePedido(PedidodeSuporte pedido,String tecnico, String info){

    }
    public List<PedidodeSuporte> resolvidos(){

    }
    public String colaboradorTop(){

    }
    public List<PedidodeSuporte>resolvidos(LocalDateTime inicio, LocalDateTime fim){

    }
    public double tempoMedioResolucao(){

    }
    public double tempoMedioResolucao(LocalDateTime inicio, LocalDateTime fim){

    }
    public PedidodeSuporte pedidoMaisLongo(){

    }
    public PedidodeSuporte pedidoMaisLongo(LocalDateTime inicio, LocalDateTime fim){

    }
    public PedidodeSuporte pedidoMaisCurto(){

    }
    public PedidodeSuporte pedidoMaisCurto(LocalDateTime inicio, LocalDateTime fim){

    }
}
