import java.util.*;

public class VeiculoOcasiaoNovo extends Veiculo{

  private boolean emPromocao;
  
  /**
   * ....
   * 
   */
    
  public VeiculoOcasiaoNovo() {
    super();
    this.emPromocao = false;
  }
  
  public VeiculoOcasiaoNovo(String marca, String modelo, String matricula,
                   int ano, double velociademedia, double precokm,
                   List<Integer> classificacao,
                   int kms, int kmsUltimo, boolean emPromocao) {
                       
         super(marca, modelo, matricula, ano, velociademedia, precokm, classificacao, kms, kmsUltimo);
         this.emPromocao = emPromocao;
  }
  
   public VeiculoOcasiaoNovo(VeiculoOcasiaoNovo vo){
        super(vo);
        this.emPromocao = vo.getPromocao();
    }

    public boolean getPromocao() {
        return this.emPromocao;
    }

    public void setPromocao(boolean promocao) {
        this.emPromocao = promocao;
    }

    @Override
    public double custoRealKM(){
        
        double valor = getPrecokm()*(2-1/Math.exp(getKms()));
        return this.emPromocao ? 0.75 * valor : valor;
    }
    
    
    /**
     * equals, toString, clone
     */
    
    public VeiculoOcasiaoNovo clone() {
       return new VeiculoOcasiaoNovo(this);   
    }
    
    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || ! o.getClass().equals(this.getClass())) return false;
        VeiculoOcasiaoNovo v = (VeiculoOcasiaoNovo) o;
        return super.equals(v) && this.emPromocao == v.getPromocao();
  }
  
  public String toString() {
        return super.toString() + " Em Promoção: "+ this.emPromocao;
  }  
    
}


