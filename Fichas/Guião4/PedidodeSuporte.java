import java.time.LocalDate;

public class PedidodeSuporte {
    private String name;
    private LocalDate date;
    private String assunto;
    private String descricao;
    private String nTratou;
    private LocalDate concluido;
    private String informacao;

    public PedidodeSuporte(String nome,LocalDate data, String assunto,String desc, String tratou, LocalDate conc, String inf){
        this.name = nome;
        this.date = data;
        this.assunto = assunto;
        this.descricao = desc;
        this.nTratou = tratou;
        this.concluido = conc;
        this.informacao = inf;
    }
    public PedidodeSuporte(){
        this("",LocalDate.now(),"","","",LocalDate.now(),"");
    }
    public PedidodeSuporte(PedidodeSuporte p){
        this(p.name, p.date, p.assunto, p.descricao, p.nTratou, p.concluido, p.informacao);
    }
    public boolean equals(Object p){
        if(this == p) return true;
        if(p == null || this.getClass() != p.getClass()) return false;
        PedidodeSuporte ps = (PedidodeSuporte) p;
        return this.name.equals(ps.name) && this.date.equals(ps.date) &&
               this.assunto.equals(ps.assunto) && this.descricao.equals(ps.descricao) &&
               this.concluido.equals(ps.concluido) && this.informacao.equals(ps.informacao);
    }
    public PedidodeSuporte clone(){
        return new PedidodeSuporte(this);
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.name);
        sb.append("\n Date: ").append(this.date);
        sb.append("\n Assunto: ").append(this.assunto);
        sb.append("\n Descricao: ").append(this.descricao);
        sb.append("\n Tratou: ").append(this.nTratou);
        sb.append("\nTerminou: ").append(this.concluido);
        sb.append("\n informacao: ").append(this.informacao);
        return sb.toString();
    }
    public String getName(){
        return this.name;
    }
    public void setNome(String n){
        this.name = n;
    }
    public LocalDate getDate(){
        return this.date;
    }
    public void setDate(LocalDate d){
        this.date = d;
    }
    public String getAssunto(){
        return this.assunto;
    }
    public void setAssunto(String as){
        this.assunto = as;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String desc){
        this.descricao = desc;
    }
    public String getNtratou(){
        return this.nTratou;
    }
    public void setNtratou(String nT){
        this.nTratou = nT;
    }
    public LocalDate getConcluido(){
        return this.concluido;
    }
    public void setConcluido(LocalDate conc){
        this.concluido = conc;
    }
    public String getInformacao(){
        return this.informacao;
    }
    public void setInformacao(String inf){
        this.informacao = inf;
    }
}
