import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

public class Test42 {
       public static void main(String [] args){
              Scanner ler = new Scanner(System.in);
              Ex42 exs = new Ex42("Ótima Átila Dantas", 12345678, "Rua Escadinhas da Porta do Carro", 665, LocalDate.now(), new ArrayList<LinhaEncomenda>());
              System.out.println("\nA sua encomenda foi criada com os seguintes dados: " + exs.toString());
              LinhaEncomenda linha1 = new LinhaEncomenda("11111", "Revista Maria", 5, 1, 6, 10);
              exs.adicionaLinha(linha1);
              System.out.println("Inserido na linha de encomenda: " + linha1.toString()+"\n");
              LinhaEncomenda linha2 = new LinhaEncomenda("22222", "Perninhas de Morcego Recheadas", 20, 3, 15, 17.5);
              exs.adicionaLinha(linha2);
              System.out.println("" + linha2.toString()+"\n");
              System.out.println("Introduza qual método quer ver: ");
              int alinea = ler.nextInt();
              switch(alinea) {
                              case 2:{ 
                                      ler.close();
                                      System.out.println("\nO valor total da encomenda foi "+exs.calculaValorTotal()+"€.\n");
                              break;
                              }
                              case 3:{ 
                                      ler.close();
                                      System.out.println("\nO valor de desconto foi "+exs.calculaValorDesconto()+"€.\n");
                              break;
                              }
                              case 4:{
                                      ler.close();
                                      System.out.println("\nVocê deverá receber "+exs.numeroTotalProdutos()+" produtos.\n");

                              break;
                              }
                              case 5:{
                                      System.out.println("\nQual é a referência do produto procura?");
                                      String refProduto = ler.next();
                                      ler.close();
                                      System.out.println("Podemos confirmar que o produto que procura, "+exs.existeProdutoEncomenda(refProduto)+" existe.\n");

                              break;
                              }
                              case 7:{
                                      System.out.println("\nQual é o código do produto que quer remover?");
                                      String codProd = ler.next();
                                      ler.close();
                                      exs.removeProduto(codProd);
                                      System.out.printf("O produto com o código "+codProd+", "+exs.existeProdutoEncomenda(codProd)+" foi removido.\n");
                              break;
                              }
                              default:{
                                       ler.close();
                                       System.out.println("\nEssa alínea não existe, tente outra.");
                              break;
                              }
                }
       }
}
