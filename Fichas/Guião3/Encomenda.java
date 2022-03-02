import java.time.LocalDate;
    
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
    public double calculaValorTotal(){
        LinhaDeEncomenda[] ar = this.getEncomenda();
        double soma = 0;
        for(LinhaDeEncomenda lde : ar) soma+= lde.calculaValorLinhaEnc();
        return soma;
    }
    public double calculaValorDesconto(){
        LinhaDeEncomenda[] ar = this.getEncomenda();
        double desc = 0;
        for(LinhaDeEncomenda lde : ar) desc+=lde.calculaValorDesconto();
        return desc;
    }
    public int numeroTotalProdutos(){
        LinhaDeEncomenda[] ar = this.getEncomenda();
        int totalProd = 0;
        for(LinhaDeEncomenda lde: ar) totalProd+=lde.getQ();
        return totalProd;
    }
    public boolean existeProdutoEncomenda(String refProduto){
        LinhaDeEncomenda[] ar = this.getEncomenda();
        boolean enc = false;
        for(LinhaDeEncomenda lde: ar){
            if(lde.getCod().equals(refProduto) && lde.getQ() > 0){
                enc = true;
            }
        }
        return enc;
    }
    public void adicionaLinha(LinhaDeEncomenda linha){
        LinhaDeEncomenda[] ar = this.getEncomenda();
        LinhaDeEncomenda[] novo = new LinhaDeEncomenda[ar.length+1];
        System.arraycopy(ar,0,novo,0,ar.length);
        novo[ar.length] = new LinhaDeEncomenda(linha);
        this.setEncomenda(novo);
    }
    public void removeProduto(String codProd){
        LinhaDeEncomenda[] ar = this.getEncomenda();
        LinhaDeEncomenda[] novo = new LinhaDeEncomenda[ar.length-1];
        int j=0;
        for(int i = 0; i < ar.length; i++){
            if(!ar[i].getCod().equals(codProd)){
                novo[j] = ar[i];
                j++;
            }
        }
        System.arraycopy(novo, 0, ar, 0, novo.length);
    }
}
