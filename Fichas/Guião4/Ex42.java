import java.time.LocalDate;
import java.util.ArrayList;

public class Ex42{
       private String name;
       private int nif;
       private String adress;
       private int orderN;
       private LocalDate date;
       private ArrayList<LinhaEncomenda> encomendas;
       
       public Ex42() {
              this.name = "None";
              this.nif = -1;
              this.adress = "None";
              this.orderN = -1;
              this.date = LocalDate.now();
              this.encomendas = new ArrayList<LinhaEncomenda>();
       }
       public Ex42(String name, int nif, String adress, int orderN,  LocalDate date, ArrayList<LinhaEncomenda> encomendas) {
              this.name = name;
              this.nif = nif;
              this.adress = adress;
              this.orderN = orderN;
              this.date = date;
              this.setEncomendas(encomendas);
       }
       public Ex42(Ex42 exs) {
              this.name = exs.getName();
              this.nif = exs.getNif();
              this.adress = exs.getAdress();
              this.orderN = exs.getOrderN();
              this.date = exs.getDate();
              this.setEncomendas(exs.getEncomendas());
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
       public ArrayList<LinhaEncomenda> getEncomendas() {
               return this.encomendas;       
       }
       public void setEncomendas(ArrayList<LinhaEncomenda> encomendas){
              this.encomendas = new ArrayList<>();
              for(LinhaEncomenda l : encomendas) {
              this.encomendas.add(l.clone());
              }
        }          
       public double calculaValorTotal(){
              double valorTotal = 0;
              for(LinhaEncomenda enc : this.encomendas) {
              valorTotal += enc.calculaValorLinhaEnc();
              }
        return valorTotal;
       }
       public double calculaValorDesconto(){
              double valorDesconto = 0;
              for(LinhaEncomenda enc : this.encomendas) {
              valorDesconto += enc.calculaValorDesconto();
              }
        return valorDesconto;
       }
       public int numeroTotalProdutos(){
              int totalProdutos = 0;
              for(LinhaEncomenda enc : this.encomendas) {
                  totalProdutos += enc.getQuantidade();
              }
        return totalProdutos;
       }
       public boolean existeProdutoEncomenda(String refProduto){
              for(LinhaEncomenda enc : this.encomendas)
              if(refProduto.equals(enc.getReferencia()))
                 return true;
       return false;
       }
       public void adicionaLinha(LinhaEncomenda line) {
              this.encomendas.add(line);
       }
       public void removeProduto(String codProd){
              this.encomendas.removeIf(line -> (codProd.equals(line.getReferencia())));
       }
       public String toString() {
              final StringBuffer sb = new StringBuffer("\n");
              sb.append("\nNome fornecido: ").append(name).append("\n");
              sb.append("Número de encomenda fornecido: ").append(orderN).append("\n");
              sb.append("Data fornecido: ").append(date.toString()).append("\n");
              sb.append("Encomendas: ").append(encomendas.toString()).append("\n\n");
              return sb.toString();
       }
       public Ex42 clone() {
              return new Ex42(this);
       }
       public boolean equals(Object o) {
              if (this == o) return true;
              if (o == null || this.getClass() != o.getClass()) return false;
              Ex42 that = (Ex42) o;
              return this.nif == that.nif && this.orderN == that.orderN && this.name.equals(that.name) &&  this.adress.equals(that.adress) && this.date.equals(that.date) && this.encomendas.equals(that.encomendas);
    }

}
