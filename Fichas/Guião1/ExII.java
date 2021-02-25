import java.text.DecimalFormat;

public class ExII{
       public double celsiousTofahrenheit(double valC){
              return valC * 1.8 + 32;
       }
       public int maximo(int a, int b){
              if(a>b) return a;
              else return b;
       }
       public String criaConta(String nome, double val){
              return "A conta pertence a "+ nome + "e o otente tem um valor de "+ val +"€ na sua conta.\n";
       }
       public double eurosTolibras(double valorE){
              return valorE*0.86424503681067;
              // https://www.xe.com/pt/currencyconverter/convert/?Amount=1&From=EUR&To=GBP acessado a 22/02/2021
       }
       public String descrescente(int valD1,int valD2){
              if(valD1 > valD2) return String.format("%d %d",valD2,valD1);
              else return String.format("%d %d",valD1,valD2);
       }
       public long factorial(int fat){
              if (fat<=1) return 1;
              else return fat*factorial(fat-1);
       }
       public long tempoGasto(int val){
              long startTime = System.nanoTime();
              factorial(val);
              long endTime = System.nanoTime();
              long duration = (endTime - startTime);
              return duration/1000000;
       }
}