import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class TestI{
  public static void main(String [] args){
    Scanner ler = new Scanner(System.in);
    ExI exs = new ExI();
    System.out.println("Introduza qual alinea quer: ");
    int alinea = ler.nextInt();
    switch(alinea) {
                 case 1:
                 break;
                 case 4: int len;
                         do{ System.out.println("Diga quantos elementos tem o array que vai ordenar: ");
                             len = ler.nextInt();
                           } while (len <= 0);
                         int[] array= new int[len];
                         System.out.println("Digite os elementos do array:");
                         for(int i=0;i<len;i++){
                           array[i] = ler.nextInt();
                         }
                         System.out.println("1: Ordenar por ordem crescente, ou 2: Procura binária de um elemento:");
                         int prob = ler.nextInt();
                         switch(prob){
                                    case 1: ler.close();
                                    String res1 = exs.ordena(array);
                                    System.out.println("O array ordenado fica assim "+res1);
                                    break;
                                    case 2: System.out.println("Que elemento está à procura? ");
                                    int num = ler.nextInt();
                                    ler.close();
                                    String res2 = exs.busca(array,num);
                                    System.out.println("A busca teve resultado "+res2);
                                    break;
                                    default: System.out.println("Essa alínea não existe, tente outra.");
                                    break;
                         }
                 break;
                 default: System.out.println("Essa alínea não existe, tente outra.");
                 break;
                }
  }
}
