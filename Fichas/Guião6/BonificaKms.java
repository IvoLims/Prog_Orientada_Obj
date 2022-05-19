public interface BonificaKms {
    
    //Definir o valor de pontos a atribuir por cada km.
    public void setPontos(int pontos);
    //Obter o valor de pontos que se está a a atribuir por cada km.
    public int getPontos();
    //Obter o valor de pontos que um determinado veículo já acumulou.
    public int getPontosAcumulados();
}
