import java.time.LocalDateTime;
import java.util.ArrayList;
public class Ex42 {
    
    // variaveis enunciadas na aula
    private String nomCiente;
    private int numFiscal;
    private String morada;
    private int numEncomenda;
    private LocalDateTime data;
    private ArrayList<LinhaEncomenda> encomendas;

    public Ex42() {
        this.nomCiente = "";
        this.numFiscal = 0;
        this.morada = "";
        this.numEncomenda = 0;
        this.data = LocalDateTime.now();
        this.encomendas = new ArrayList<LinhaEncomenda>();
    }

    public Ex42(String nomCiente, int numFiscal, String morada, int numEncomenda, LocalDateTime data, ArrayList<LinhaEncomenda> encomendas) {
        this.nomCiente = nomCiente;
        this.numFiscal = numFiscal;
        this.morada = morada;
        this.numEncomenda = numEncomenda;
        this.data = data;
        this.setEncomendas(encomendas);
    }

    public Ex42(Ex42 Ex42) {
        this.nomCiente = Ex42.getnomCiente();
        this.numFiscal = Ex42.getnumFiscal();
        this.morada = Ex42.getMorada();
        this.numEncomenda = Ex42.getnumEncomenda();
        this.data = Ex42.getData();
        this.setEncomendas(Ex42.getEncomendas());
    }

    public String getnomCiente() {
        return this.nomCiente;
    }
    public void setnomCiente(String nomCiente) {
        this.nomCiente = nomCiente;
    }

    public int getnumFiscal() {
        return this.numFiscal;
    }
    public void setnumFiscal(int numFiscal) {
        this.numFiscal = numFiscal;
    }

    public String getMorada() {
        return this.morada;
    }
    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getnumEncomenda() {
        return this.numEncomenda;
    }
    public void setnumEncomenda(int numEncomenda) {
        this.numEncomenda = numEncomenda;
    }

    public LocalDateTime getData() {
        return this.data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public ArrayList<LinhaEncomenda> getEncomendas() {
        return this.encomendas;
    }
    public void setEncomendas(ArrayList<LinhaEncomenda> encomendas) {
        this.encomendas = new ArrayList<>();
        for(LinhaEncomenda l : encomendas) this.encomendas.add(l.clone());
    }

    public double calculaValorTotal() {
        double valorTotal = 0;
        for(LinhaEncomenda enc : this.encomendas) valorTotal += enc.calculaValorLinhaEnc();
        return valorTotal;
    }
    
    public double calculaValorDesconto() {
        double valorDesconto = 0;
        for(LinhaEncomenda enc : this.encomendas) valorDesconto += enc.calculaValorDesconto();
        return valorDesconto;
    }

    public int numeroTotalProdutos() {
        int totalProdutos = 0;
        for(LinhaEncomenda enc : this.encomendas) totalProdutos += enc.getQuantidade();
        return totalProdutos;
    }

    public boolean existeProdutoEncomenda(String refProduto) {
        for(LinhaEncomenda enc : this.encomendas) if(refProduto.equals(enc.getReferencia())) return true;
        return false;
    }

    public void adicionaLinha(LinhaEncomenda linha) {
        this.encomendas.add(linha);
    }

    public void removeProduto(String codProd) {
        this.encomendas.removeIf(linha -> (codProd.equals(linha.getReferencia())));
    }

    public String toString() {
        // estrutura tipo json
        final StringBuffer sb = new StringBuffer("Encomenda [ ");
        sb.append("Nome Cliente = '").append(nomCiente+"'; ");
        sb.append("Num Fiscal = '").append(numFiscal+"'; ");
        sb.append("Morada = '").append(morada+"'; ");
        sb.append("Numero de encomenda = '").append(numEncomenda+"'; ");
        sb.append("Data = '").append(data.toString()+"'; ");
        sb.append("Encomendas = ").append(encomendas.toString()+"; ");
        sb.append(']');
        return sb.toString();
    }

    public Ex42 clone() {
        return new Ex42(this);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Ex42 ef = (Ex42) o;

        return this.numFiscal == ef.numFiscal && this.numEncomenda == ef.numEncomenda && this.nomCiente.equals(ef.nomCiente) && this.morada.equals(ef.morada) && this.data.equals(ef.data) && this.encomendas.equals(ef.encomendas);
    }
    
}
