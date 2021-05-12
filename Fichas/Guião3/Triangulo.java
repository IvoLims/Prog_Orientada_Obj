package com.company;

import java.util.Objects;

public class Triangulo {
    private Ponto x;
    private Ponto y;
    private Ponto z;
    
    public Triangulo(){
        this.x = new Ponto();
        this.y = new Ponto();
        this.z = new Ponto();
    }
    public Triangulo(Triangulo t){
        this.x = t.getX();
        this.y = t.getY();
        this.z = t.getZ();
    }
    public double calculaAreaTriangulo(){
        double dx1 = Math.abs(this.x.getX() - this.y.getX());
        double dy1 = Math.abs(this.x.getX() - this.y.getY());
        double resXY = Math.sqrt(Math.pow(dx1,2) + Math.pow(dy1,2));
        double dy2 = Math.abs(this.y.getX() - this.z.getX());
        double dz1 = Math.abs(this.y.getX() - this.z.getY());
        double resYZ = Math.sqrt(Math.pow(dy2,2) + Math.pow(dz1,2));
        double dx2 = Math.abs(this.x.getX() - this.z.getX());
        double dz2 = Math.abs(this.x.getX() - this.z.getY());
        double resXZ = Math.sqrt(Math.pow(dx2,2) + Math.pow(dz2,2));
        double[] lados = {resXY,resYZ,resXZ};
        double s = (lados[0] + lados[1] + lados[2])/2;
        return Math.sqrt(s*(s-lados[0]) *(s-lados[1]) *(s-lados[2]));

    }
    public double calculaPerimetroTriangulo(){
        double dx1 = Math.abs(this.x.getX() - this.y.getX());
        double dy1 = Math.abs(this.x.getX() - this.y.getY());
        double resXY = Math.sqrt(Math.pow(dx1,2) + Math.pow(dy1,2));
        double dy2 = Math.abs(this.y.getX() - this.z.getX());
        double dz1 = Math.abs(this.y.getX() - this.z.getY());
        double resYZ = Math.sqrt(Math.pow(dy2,2) + Math.pow(dz1,2));
        double dx2 = Math.abs(this.x.getX() - this.z.getX());
        double dz2 = Math.abs(this.x.getX() - this.z.getY());
        double resXZ = Math.sqrt(Math.pow(dx2,2) + Math.pow(dz2,2));
        double[] lados = {resXY,resYZ,resXZ};
        return lados[0] +lados[1] +lados[2];
    }
    public double calculaAltura(){
        double min = 0;
        double max = 0;
        double[] ys = {this.x.getY(),this.y.getY(),this.z.getY()};
        for(double y : ys){
            if(y<min) min = y;
            if(y>max) max = y;
        }
        return max-min;
    }
    public Ponto getX(){
        return this.x;
    }
    public void setX(Ponto x){
        this.x = x;
    }
    public Ponto getY(){
        return this.y;
    }
    public void setY(Ponto y){
        this.y = y;
    }
    public Ponto getZ(){
        return this.z;
    }
    public void setZ(Ponto z){
        this.z = z;
    }
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("X: ").append(x.toString());
        sb.append("Y: ").append(y.toString());
        sb.append("Z: ").append(z.toString());
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangulo)) return false;
        Triangulo triangulo = (Triangulo) o;
        return this.x.equals(triangulo.x) &&
                this.y.equals(triangulo.y) &&
                this.z.equals(triangulo.z);
    }

    public Triangulo clone(){
        return new Triangulo(this);
    }
}
