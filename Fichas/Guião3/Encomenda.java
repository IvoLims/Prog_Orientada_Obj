import java.time.LocalDate;
import java.util.ArrayList;
    
public class Encomenda{
    private String clienteName;
    private int nif;
    private String morada;
    private int numEnc;
    private LocalDate date;
    private LinhaDeEncomenda[] encomenda;

    public Encomenda(){
        this.clienteName = "";
        this.nif = 0;
        this.morada = "";
        this.numEnc = 0;
        this.date = LocalDate.now();
        this.encomenda = new LinhaDeEncomenda[0];
    }
    public Encomenda(String clienteName, int nif, String morada, int numEnc, LocalDate data, LinhaDeEncomenda[] encomenda) {
        this.clienteName = clienteName;
        this.nif = nif;
        this.morada = morada;
        this.numEnc = numEnc;
        this.date = data;
        this.encomenda = encomenda;
    }
    public Encomenda(Encomenda enc){
        this.clienteName = enc.getClienteName();
        this.nif = enc.getNIF();
        this.morada = enc.getMorada();
        this.numEnc = enc.getNumEnc();
        this.date = enc.getDate();
        this.setEncomenda(enc.getEncomenda());
    }
    public String getClienteName(){
        return this.clienteName;
    }
    public int getNIF(){
        return this.nif;
    }
    public String getMorada(){
        return this.morada;
    }
    public int getNumEnc(){
        return this.numEnc;
    }
    public LocalDate getDate(){
        return this.date;
    }
    public LinhaDeEncomenda[] getEncomenda(){
        LinhaDeEncomenda[] array = new LinhaDeEncomenda[this.encomenda.length];
        for(int i = 0; i < this.encomenda.length; i++) array[i] = new LinhaDeEncomenda(this.encomenda[i]);
        return array;
    }
    public void setClienteName(String cliName){
        this.clienteName = cliName;
    }
    public void setNIF(int nNIF){
        this.nif = nNIF;
    }
    public void setMorada(String nMorada){
        this.morada = nMorada;
    }
    public void setNumEnc(int nNumEnc){
        this.numEnc = nNumEnc;
    }
    public void setData(LocalDate nDate){
        this.date = nDate;
    }
    public void setEncomenda(LinhaDeEncomenda[] enco){
        this.encomenda = new LinhaDeEncomenda[enco.length];
        for(int i = 0; i < enco.length; i++) this.encomenda[i] = new LinhaDeEncomenda(enco[i]);
    }
    public boolean equals(Encomenda enc){
        if(this == enc) return true;
        if(enc == null || this.getClass() != enc.getClass()) return false;
        Encomenda nEnc = (Encomenda) enc;
        return this.getClienteName().equals(nEnc.getClienteName()) &&
               this.getNIF() == nEnc.getNIF() &&
               this.getMorada().equals(nEnc.getMorada()) &&
               this.getNumEnc() == nEnc.getNumEnc() &&
               this.getDate().equals(nEnc.getDate()) &&
               this.getEncomenda().equals(nEnc.getEncomenda());
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome do Cliente: ").append(this.clienteName)
          .append("\n NIF: ").append(this.nif)
          .append("\n Morada: ").append(this.morada)
          .append("\n Num de Encomenda: ").append(this.numEnc)
          .append("\n Data: ").append(this.date.toString())
          .append("\n Encomendas:").append(this.encomenda.toString());
        return sb.toString();
    }
    public Encomenda clone(){
        return new Encomenda(this);
    }
}
