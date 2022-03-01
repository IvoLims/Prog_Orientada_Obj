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
        this.encomenda = new LinhaDeEncomenda[];
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
}
