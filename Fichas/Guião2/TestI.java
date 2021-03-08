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
                 case 4: int len4;
                         do{ System.out.println("Diga quantos elementos tem o array que vai ordenar: ");
                             len4 = ler.nextInt();
                           } while (len4 <= 0);
                         int[] array4= new int[len4];
                         System.out.println("Digite os elementos do array:");
                         for(int i=0;i<len4;i++){
                           array4[i] = ler.nextInt();
                         }
                         System.out.println("1: Ordenar por ordem crescente, ou 2: Procura binária de um elemento:");
                         int prob4 = ler.nextInt();
                         switch(prob4){
                                    case 1: ler.close();
                                    String res1 = exs.ordena(array4);
                                    System.out.println("O array ordenado fica assim "+res1);
                                    break;
                                    case 2: System.out.println("Que elemento está à procura? ");
                                    int num = ler.nextInt();
                                    ler.close();
                                    String res2 = exs.busca(array4,num);
                                    System.out.println("A busca teve resultado "+res2);
                                    break;
                                    default: System.out.println("Essa alínea não existe, tente outra.");
                                    break;
                         }
                 break;
                 case 5: int len5;
                         do{ System.out.println("Diga quantas strings quer comparar: ");
                             len5 = ler.nextInt();
                           } while (len5 <= 0);
                         String[] array5 = new String[len5+1];
                         System.out.println("Digite as suas strings:");
                         for (int i=0; i<=len5;i++){
                                array5[i] = ler.nextLine();
                         }
                         System.out.println("1: Strings existentes (sem repetições), ou 2: Maior String inserida, ou 3: Strings que aparecem mais de uma vez, ou 4: Saber quantas vezes uma determinada String ocorre no array.");
                         int prob5 = ler.nextInt();
                         switch(prob5){
                                    case 1: ler.close();
                                    String val = exs.comparar(array5,len5);
                                    System.out.println("O array tem "+val+" strings diferentes.");
                                    break;
                                    case 2: ler.close();
                                    String val2 = exs.maior(array5,len5);
                                    System.out.println("A maior string foi "+val2);
                                    break;
                                    case 3: ler.close();
                                    if(len5 == 1){
                                       System.out.println("Não tem repetidos.");
                                       break;
                                    }
                                    String[] val3 = exs.repetidos(array5,len5);
                                    System.out.println("As Strings que se repetem são "+Arrays.toString(val3));
                                    break;
                                    case 4: System.out.println("A String que quer verificar:");
                                    String comp = ler.nextLine();
                                    ler.close();
                                    int val4 = exs.vOcorre(array5,len5,comp);
                                    System.out.println("A String "+ comp +" ocorre "+ val4+ " vezes.");
                                    break;
                                    default: ler.close();
                                    System.out.println("Essa alínea não existe, tente outra.");
                                    break;
                         }
                 break;
                 default: ler.close();
                 System.out.println("Essa alínea não existe, tente outra.");
                 break;
                }
  }
}
