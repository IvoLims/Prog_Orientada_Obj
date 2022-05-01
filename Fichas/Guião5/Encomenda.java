import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Encomenda implements Comparable<Encomenda>{
       private String name;
       private int nif;
       private String adress;
       private int orderN;
       private LocalDate date;
       private List<LinhaDeEncomenda> encomendas;
       
       public Encomenda() {
              this.name = "None";
              this.nif = -1;
              this.adress = "None";
              this.orderN = -1;
              this.date = LocalDate.now();
              this.encomendas = new ArrayList<LinhaDeEncomenda>();
       }
       
       public Encomenda(String name, int nif, String adress, int orderN,  LocalDate date, ArrayList<LinhaDeEncomenda> encomendas) {
              this.name = name;
              this.nif = nif;
              this.adress = adress;
              this.orderN = orderN;
              this.date = date;
              this.setEncomendas(encomendas);
       }
       
       public Encomenda(Encomenda es) {
              this.name = es.getName();
              this.nif = es.getNif();
              this.adress = es.getAdress();
              this.orderN = es.getOrderN();
              this.date = es.getDate();
              this.setEncomendas(es.getEncomendas());
       }
       
       public String getName() {
              return this.name;
       }
       public void setName(String name) {
              this.name = name;
       }
       public int getNif() {
              return this.nif;
       }
       
       public void setNif(int nif) {
              this.nif = nif;
       }
       
       public String getAdress() {           
              return this.adress;
       }
       public void setAdress(String adress) {           
              this.adress = adress;       
       }
       
       public int getOrderN() {           
              return this.orderN;       
       }
       
       public void setOrderN(int orderN) {
              this.orderN = orderN;       
       }
       
       public LocalDate getDate() {           
              return this.date;       
       } 
       
       public void setDate(LocalDate date) {
              this.date = date;       
       }   
       
       public List<LinhaDeEncomenda> getEncomendas() {
               return this.encomendas;       
       }
       
       public void setEncomendas(List<LinhaDeEncomenda> encomendas){
              this.encomendas = new ArrayList<>();
              for(LinhaDeEncomenda l : encomendas) {
              this.encomendas.add(l.clone());
              }
       }
        
       public double calculaValorTotal(){
              double valorTotal = 0;
              for(LinhaDeEncomenda enc : this.encomendas) {
              valorTotal += enc.calculaValorLinhaEnc();
              }
        return valorTotal;
       }
       
       public Encomenda clone(){
           return new Encomenda(this);
       }

       public int numProdutos(){
           return this.encomendas.stream().mapToInt(LinhaDeEncomenda:: getQ).sum();
       }
       
       public boolean existeNaEncomenda(String n){
           return this.encomendas.stream().anyMatch(enc->enc.getCod().equals(n));
       }
       
       public List<String> getListaProdutos(){
           return this.encomendas.stream().map(LinhaDeEncomenda::getCod).distinct().collect(Collectors.toList());
       }
       
       public int compareTo(Encomenda e){
           return this.nif-e.getNif();
       }
}