import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;
import java.lang.Object;
import java.lang.*;
import java.util.*;
import java.io.*;

public class ExI{
       //aux's
       public String DiadaSemana(int diaS){
              switch(diaS) {
                            case 0: return "Domingo";
                            case 1: return "Segunda-feira";
                            case 2: return "Terça-feira";
                            case 3: return "Quarta-feira";
                            case 4: return "Quinta-feira";
                            case 5: return "Sexta-feira";
                            case 6: return "Sábado";
                }
                return "None.";
       }
       public int minimo(int a, int b){
              if(a>b) return b;
              else return a;
       }
       public static int[] addElement(int len, int arr[], int x){ 
                     int i;
                     int newarr[] = new int[len + 1]; 
                     for (i = 0; i < len; i++) 
                         newarr[i] = arr[i]; 
               
                     newarr[len] = x; 
               
                     return newarr; 
                 } 
       public int SaberData(int dia,int mes, int ano){
              int novo = (ano-1900)*365;  // para dar certo deveria ser 'int novo =(int) ((ano-1900)*365.25)'
              if(ano%4 == 0 && mes < 3) novo--;
              for(int i = mes; i > 0; i--){
                if(i==2) novo+=28;
                else if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12) novo+=31;
                else novo+=30;
              }
              return novo % 7;
       }
       public int converter(int dia,int mes,int minM, int maxA, int minA){
              int val=0;
              while(maxA>minA){
                if(maxA%4 == 0) val+=366;
                else val+=365;
                maxA--;
              }
              for(int i = minM;i<mes-1;i++){ // melhorar aqui
              if(maxA%4 == 0 && i == 2) {val+=29;}
              else {val+=28;
              }
              if(i==1 || i==3 || i==5 || i==7 || i==8 || i==10 || i==12) val+=31;
              else val+=30;
              System.out.println(val);
              System.out.println(maxA);
              maxA--;
              }
              return val+dia;
            }
      public int[] primos(int val){
             int[] list = new int[val];
             int i = 1, num = 0, size=0;
             for (; i <= val; i++){ 		 		  
                  int counter=0; 		  
                  for(num =i; num>=1; num--){
	                    if(i%num==0){
		                     counter = counter + 1;
	                    }
	                }
	                if (counter ==2){
                      size++;
	                    list = addElement(size,list, i);
                      System.out.println(list);
	                }	
              }
              return list;
      }
}