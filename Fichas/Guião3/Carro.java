public class Carro{
    private static final double ON = 100;
    private static final double OFF = 0;
    private String marca;
    private String modelo;
    private int ano;
    private double consumo;
    private int kmsTotais;
    private double medConsumo;
    private int kmsUlt;
    private double medUltP;
    private double regen;

    public Carro(){
        this.marca = "";
        this.modelo = "";
        this.ano = 0;
        this.consumo = 2.41;
        this.kmsTotais = 0;
        this.medConsumo = 0;
        this.kmsUlt = 0;
        this.medUltP = 0;
        this.regen = 0;
    }
    public Carro(String nMarca, String nModelo, int nAno, double nConsumo, int nKMSTotais, double nMedConsumo, int nKMSUlt, double nMedUltP, double nRegeneracao){
        this.marca = nMarca;
        this.modelo = nModelo;
        this.ano = nAno;
        this.consumo = nConsumo;
        this.kmsTotais = nKMSTotais;
        this.medConsumo = nMedConsumo;
        this.kmsUlt = nKMSUlt;
        this.medUltP = nMedUltP;
        this.regen = nRegeneracao;
    }
    public Carro(Carro car){
        this.marca = car.getMarca();
        this.modelo = car.getModelo();
        this.ano = car.getAno();
        this.consumo = car.getConsumo();
        this.kmsTotais = car.getKMSTotais();
        this.medConsumo = car.getMedConsumo();
        this.kmsUlt = car.getKMSUlt();
        this.medUltP = car.getMedUltPerc();
        this.regen = car.getRegen();
    }
    public String getMarca(){
        return this.marca;
    }
    public String getModelo(){
        return this.modelo;
    }
    public int getAno(){
        return this.ano;
    }
    public double getConsumo(){
        return this.consumo;
    }
    public int getKMSTotais(){
        return this.kmsTotais;
    }
    public double getMedConsumo(){
        return this.medConsumo;
    }
    public int getKMSUlt(){
        return this.kmsUlt;
    }
    public double getMedUltPerc(){
        return this.medUltP;
    }
    public double getRegen(){
        return this.regen;
    }
    public void setMarca(String nMarca){
        this.marca =  nMarca;
    }
    public void setModelo(String nModelo){
        this.modelo = nModelo;
    }
    public void setAno(int nAno){
        this.ano = nAno;
    }
    public void setConsumo(double nConsumo){
        this.consumo = nConsumo;
    }
    public void setKMSTotais(int nKMSTotais){
        this.kmsTotais = nKMSTotais;
    }
    public void setMedConsumo(double nMedConsumo){
        this.medConsumo = nMedConsumo;
    }
    public void setKMSUlt(int nKMSUlt){
        this.kmsUlt = nKMSUlt;
    }
    public void setMedUltPerc(double nMedUltP){
        this.medUltP = nMedUltP;
    }
    public void setRegen(double nRegen){
        this.regen= nRegen;
    }
    public boolean equals(Object car){
        if(this == car) return true;
        if(car == null || this.getClass() != car.getClass()) return false;
        Carro nCar = (Carro) car; 
        return this.getMarca().equals(nCar.getMarca()) &&
               this.getModelo().equals(nCar.getModelo()) &&
               this.getAno() == nCar.getAno() &&
               this.getConsumo() == nCar.getConsumo() &&
               this.getKMSTotais() == nCar.getKMSTotais() &&
               this.getMedConsumo() == nCar.getMedConsumo() &&
               this.getKMSUlt() == nCar.getKMSUlt() &&
               this.getMedUltPerc() == nCar.getMedUltPerc() &&
               this.getRegen() == nCar.getRegen();
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Marca: ").append(this.marca)
          .append("\nModelo: ").append(this.modelo)
          .append("\nAno: ").append(this.ano)
          .append("\nConsumo: ").append(this.consumo)
          .append("\nKms Totais: ").append(this.kmsTotais)
          .append("\nMedia Consumo: ").append(this.medConsumo)
          .append("\nKMS Ultima Viagem:").append(this.kmsUlt)
          .append("\nMedia Ultimo Percurso:").append(this.medUltP)
          .append("\nRegeneracao: ").append(this.regen);
        return sb.toString();
    }
    public Carro clone(){
        return new Carro(this);
    }
    public void ligaCarro(){
        this.setConsumo(ON);
    }
    public void desligaCarro(){
        this.setConsumo(OFF);
    }
    public void resetUltimaViagem(){
        if(this.getConsumo() != OFF){
            this.setKMSUlt(0);
            this.setMedUltPerc(0);
        }
        System.out.println("Couldn't reset the values of the last trip.\n");
    }
    public void avancaCarro(double metros, double velocidade){
        if(this.getConsumo() != OFF){
            int kms = (int) metros/1000;
            double vTotal = velocidade/100;
            this.setKMSTotais(this.getKMSTotais() + kms);
            this.setKMSUlt(kms);
            if(velocidade >= 100){
                this.setMedConsumo(this.getMedConsumo() + (kms/(this.getConsumo()*vTotal)));
                this.setMedUltPerc(kms/(this.getConsumo()*vTotal));
            } else {
                this.setMedConsumo(this.getMedConsumo() + ((kms/this.getConsumo()*vTotal)/2));
                this.setMedUltPerc((kms/(this.getConsumo()*vTotal))/2);
            }
        }
        System.out.println("Couldn't change the values because the car is OFF.\n");
    }
    public void travaCarro(double metros){
        if(this.getConsumo() != OFF){
            int kms = (int) metros/1000;
            if(kms >= 1){
                this.setRegen(1.2*kms);
                this.setConsumo(this.getConsumo() - this.getRegen());
            } else {
                this.setRegen(0);
            }
        }
        System.out.println("Couldn't change the values because the car is OFF.\n");
    }
}
