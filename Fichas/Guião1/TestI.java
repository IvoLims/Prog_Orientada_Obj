import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestI{
  public static void main(String [] args){
    Scanner ler = new Scanner(System.in);
    ExI exs = new ExI();
    System.out.println("Introduza qual alinea quer: ");
    int alinea = ler.nextInt();
    switch(alinea) {
                 case 1: System.out.println("Introduza uma data: ");
                         int dia = ler.nextInt();
                         int mes = ler.nextInt();
                         int ano = ler.nextInt();
                         ler.close();
                         int diaS=exs.SaberData(dia,mes,ano);
                         System.out.println("A data que inseriu corresponde a um/uma "+ exs.DiadaSemana(diaS) + ".\n");
                 break;
                 case 2: System.out.println("Introduza a primeira data: ");
                         int maxA,minA;
                         int dia1 = ler.nextInt();
                         int mes1 = ler.nextInt();
                         int ano1 = ler.nextInt();
                         System.out.println("Introduza a segunda data: ");
                         int dia2 = ler.nextInt();
                         int mes2 = ler.nextInt();
                         int ano2 = ler.nextInt();
                         ler.close();
                         if(ano1 > ano2) { maxA = ano1%100; minA = ano2%100;
                         }else {
                           maxA = ano2%100; minA = ano1%100;
                         }
                         int minM = exs.minimo(mes1,mes2); 
                         int total = exs.converter(dia1+dia2,mes1+mes2,minM,maxA,minA);
                         System.out.println((total)+"D"+" "+((total)*24)+"H"+" "+((total)*1440)+"M"+" "+((total)*86400)+"S");
                 break;
                 case 3: System.out.println("Introduza as classificações: ");
                 break;
                 case 4: System.out.println("Digite pelo menos duas temperaturas: ");
                 System.out.println("A média das _n_ temperaturas foi de ____ graus.\n A maior variação registou-se entre os dias __ e __, tendo a temperatura subido/descido3 ___graus.");
                 break;
                 case 5: System.out.println("Indique para quais dois valores quer receber decrescentemente e também quer saber a sua média: ");
                 break;
                 case 6: System.out.println("Indique um nº inteiro: ");
                         int val = ler.nextInt();
                         ler.close();
                         int[] list = exs.primos(val); 
                         System.out.println("Os valores primos do valor" +" são: " + Arrays.toString(list) + ".\n");
                 break;
                 case 7: System.out.println("Indique a sua data de nascimento (dia mês ano): ");
                 System.out.println("A sua idade atual em horas corresponde a " +". Realizado às " + ".\n");
                 break;
                 default: 
                 break;
                }
  }
}