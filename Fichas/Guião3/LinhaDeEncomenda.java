public class LinhaDeEncomenda {
    private String codProd;
    private String descricao;
    private double preImposto;
    private int quantidade;
    private double imposto;
    private double desComercial;
    
    public LinhaDeEncomenda(){
        this.codProd = "";
        this.descricao = "";
        this.preImposto = 0;
        this.quantidade = 0;
        this.imposto = 0;
        this.desComercial = 0;
    }
    public LinhaDeEncomenda(String ref, String desc, double pi, int q, double imp, double dCom){
        this.codProd = ref;
        this.descricao = desc;
        this.preImposto = pi;
        this.quantidade = q;
        this.imposto = imp;
        this.desComercial =  dCom;
    }
    public LinhaDeEncomenda(LinhaDeEncomenda lde){
        this(lde.getCod(), lde.getDesc(), lde.getPreImp(), lde.getQ(), lde.getImp(), lde.getDComp());
    }
    public String getCod(){
        return this.codProd;
    }
    public String getDesc(){
        return this.descricao;
    }
    public double getPreImp(){
        return this.preImposto;
    }
    public int getQ(){
        return this.quantidade;
    }
    public double getImp(){
        return this.imposto;
    }
    public double getDComp(){
       return this.desComercial;
    }
    public void setCod(String newRef){
        this.codProd = newRef;
    }
    public void setDesc(String newDesc){
        this.descricao = newDesc;
    }
    public void setPreImp(double newPreImp){
        this.preImposto = newPreImp;
    }
    public void setQ(int newQ){
        this.quantidade = newQ;
    }
    public void setImp(double newImp){
        this.imposto = newImp;
    }
    public void setDComp(double newdesComp){
       this.desComercial = newdesComp;
    }
    public boolean equals(LinhaDeEncomenda lde){
        if(this == lde) return true;
        if(lde == null || this.getClass() != lde.getClass()) return false;
        LinhaDeEncomenda le = (LinhaDeEncomenda) lde;
        return this.getCod().equals(le.getCod()) &&
               this.getDesc().equals(le.getDesc()) &&
               this.getPreImp() == le.getPreImp() &&
               this.getQ() == le.getQ() &&
               this.getImp() == le.getImp() &&
               this.getDComp() == le.getDComp();
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Referencia: ").append(this.codProd)
          .append("\nDescricao: ").append(this.descricao)
          .append("\nPreco antes do Imposto: ").append(this.preImposto)
          .append("\nQuantidade: ").append(this.quantidade)
          .append("\nImposto: ").append(this.imposto)
          .append("\nDesconto de Comercial: ").append(this.desComercial)
          .append("\n");
        return sb.toString();
    }
    public LinhaDeEncomenda clone(){
        return new LinhaDeEncomenda(this);
    }
    public double calculaValorDesconto(){
        double descFinal = (this.getDComp()/ 100) * this.getPreImp();
        return descFinal;
    }
    public double calculaValorLinhaEnc(){
        double precoF = this.getPreImp() * ((1 + (this.getImp() - this.getDComp()))/ 100);
        return precoF;
    }
}
