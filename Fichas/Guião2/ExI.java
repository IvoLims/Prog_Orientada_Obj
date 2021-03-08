import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;
import java.lang.Object;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.util.Date;
import java.time.LocalDate;
import java.util.Calendar;

public class ExI{

       public int minInt(int[] array){
              int min = array[0];
              for(int i = 0; i< array.length;i++)
                  if(array[i]<min) min = array[i];
              return min;
       }
       public int[] limites(int[] array, int numsinf,int numsup){
              int[] res = new int [array.length];
              for(int i = numsinf,k=0; i<=numsup ;i++,k++){
                  res[k] = array[i];
              }
              return res;
       }
       public int[] compInt(int[] array1,int[] array2){
              int[] iguais = new int [array1.length];
              boolean[] seen = new boolean[array1.length];
              for (int i = 0, k = 0; i < array1.length; i++,k++){
                   if(seen[i]) continue;
                   boolean duplicate = false;
                   for (int j = 0; j < array2.length; j++){
                        if (array1[i] == array2[j]){
                            duplicate = seen[j] = true;
                        }
                    }
                    if(duplicate) 
                        iguais[k] = array1[i];
                    }
              return iguais;
       }
       
       public String ordena(int[] array){
              for (int i = 1; i < array.length; i++) {
                   for (int j = 0; j < i; j++) {
                        if (array[i] < array[j]) {
                            int temp = array[i];
                            array[i] = array[j];
                            array[j] = temp;
                        }
                    }
              }
              return Arrays.toString(array); 
       }
       public String busca(int[] array,int num){
              int inf = 0;
              int sup = (array.length) - 1;
              int meio;
              while (inf <= sup){
                     meio = (inf + sup)/2;
                     if (num == array[meio])
                     return "existe e está na posição: "+meio+"";
                     if (num < array[meio])
                         sup = meio-1;
                     else
                         inf = meio+1;
              }
              return " não existe";
       }
       public String comparar(String[] array2,int len){
              int cont=len-1;
              int i = 1, j=2;
              if(len == 1){
                return ""+ cont +"";
              }
              while(i<len){
                for(;j < len; j++)
                       if(array2[i].equals(array2[j]) && (i != j))     cont-=1;
              i++;
              }
              return ""+ cont +"";
       }/*String[] rep = Arrays.stream(array2).distinct().toArray(s -> new String[s]); elimina repetidos*/
       public String maior(String[] array2,int len){
              if(len == 1){
                return ""+ array2[1] +"";
              }
              int index = 1;
              int maior = array2[1].length();
              for(int i = 1 ; i<len;i++){
                  if(array2[i].length() > maior) {
                    index=i; maior = array2[i].length();
                  }
              }

              return ""+array2[index]+"";
       }
       // Não 100% certa
       public String[] repetidos(String[] array2,int len){
              for (int i = 1, k=0; i < len; i++) {
                   for (int j = i + 1 ; j < len; j++) {
                        if (array2[i].equals(array2[j])) {
                            System.arraycopy(array2, j, rep, k, 1);
                            k+=1;
                        }
                   }
              }
              return rep;
       }
       public int vOcorre(String[] array2,int len, String verificar){
              int res = 0;
              for (int i = 1; i < len; i++) {
                        if (array2[i].equals(verificar)) res+=1;
              }
              return res;

       }
}
