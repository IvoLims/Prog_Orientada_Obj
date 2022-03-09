public class Lampada {
    private static int Max = 100;
    private static int Eco = 50;
    private static int Off = 0;
    private int consumo;
    private int consumoT;
    private long time;

    public Lampada(Lampada l){
        this(l.getConsumo(), l.getConsumoT());
    }
public Lampada(int consumo,int consumoT){
        this.setConsumo(consumo);
        this.consumoT = consumoT;
}
public boolean equals(Object l){
        if(this == l) return true;
        if(l == null || l.getClass() == this.getClass()) return false;
        Lampada l = (Lampada) l;
        return this.consumo == l.consumo;
}
public Lampada clone(){
        return new Lampada(this);
}
public void lampON(){
        if(this.getConsumo() != Off){
            this.setConsumo((int) (this.getConsumo() + this.getConsumoT() * (System.currentTimeMillis() - this.getTime())));
        }
        this.setConsumo(Max);
        this.setTime(System.currentTimeMillis());
}
public void lampOFF(){
    if(this.getConsumo() != Off){
        this.setConsumo((int) (this.getConsumo() + this.getConsumoT() * (System.currentTimeMillis() - this.getTime())));
    }
    this.setConsumo(Off);
    this.setTime(System.currentTimeMillis());
}
public void lampECO(){
    if(this.getConsumo() != Off){
        this.setConsumo((int) (this.getConsumo() + this.getConsumoT() * (System.currentTimeMillis() - this.getTime())));
    }
    this.setConsumo(Eco);
    this.setTime(System.currentTimeMillis());
}
public double totalConsumo(){
        return this.getConsumoT();
}
public double periodoConsumo(){
        return this.getConsumo() * (System.currentTimeMillis() - this.getTime());
}
public int getConsumo(){
        return this.consumo;
}
public void setConsumo(int c){
        this.consumo = c;
}
public int getConsumoT(){
        return this.consumoT;
}
public void setConsumoT(int ct){
        this.consumoT = ct;
}
public long getTime(){
        return this.time;
}
public void setTime(long d){
        this.time = d;
}
}
