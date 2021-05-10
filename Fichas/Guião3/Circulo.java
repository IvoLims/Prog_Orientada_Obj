public class Circulo {
    private double x;
    private double y;
    private double r;
    public Circulo(double xx, double yy, double rr){
        this.x = xx;
        this.y = yy;
        this.r = rr;
    }
    public Circulo(){
        this.x = 0;
        this.y = 0;
        this.r = 1;
    }
    public Circulo(Circulo c){
        this(c.getX(),c.getY(),c.getR());
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getR() {
        return this.r;
    }
    public void setX(double xx){
        this.x = xx;
    }
    public void setY(double yy){
        this.y = yy;
    }
    public void setR(double rr){
        this.r = rr;
    }
    public void alteraCentro(double xx, double yy){
        this.x = xx;
        this.y = yy;
    }
    public double calculaArea(){
        return Math.PI * Math.pow(this.r, 2);
    }
    public double calculaPerimetro(){
        return 2 * Math.PI * this.r;
    }
    public Circulo clone(){
        return new Circulo(this);
    }
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("X: ").append(this.x);
        sb.append("\nY: ").append(this.y);
        sb.append("\nRaio: ").append(this.r);
        return sb.toString();
    }
    public boolean equals(Object p) {
        if (p == this) return true;
        if (p == null || this.getClass() != p.getClass()) return false;
        Circulo circ = (Circulo) p;
        return this.x == circ.x && this.y == circ.y && this.r == circ.r;
    }
}
