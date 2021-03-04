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
}
