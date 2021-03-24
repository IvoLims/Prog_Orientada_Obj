import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

public class Test42 {
       public static void main(String [] args){
              Scanner ler = new Scanner(System.in);
              Ex42 exs = new Ex42("Ótima Átila Dantas", 12345678, "Rua Escadinhas da Porta do Carro", 665, LocalDate.now(), new ArrayList<LinhaEncomenda>());
              System.out.println("A sua encomenda foi criada com sucesso aqui estão os dados que forneceu: " + exs.toString());
              LinhaEncomenda linha1 = new LinhaEncomenda("11111", "Revista Maria", 1, 5, 6, 10);
              exs.adicionaLinha(linha1);
              System.out.println("Inserido na linha de encomenda: " + linha1.toString()+"\n");
              LinhaEncomenda linha2 = new LinhaEncomenda("22222", "Perninhas de Morcego Recheadas", 20, 3, 15, 17.5);
              exs.adicionaLinha(linha2);
              System.out.println("O seu pedido foi: " + linha2.toString()+"\n");
              System.out.println("Introduza qual método quer ver: ");
              int alinea = ler.nextInt();
              switch(alinea) {
                              case 2:{ 
                                      ler.close();
                                      System.out.println("O valor total da encomenda foi "+exs.calculaValorTotal()+"€.\n");
                              break;
                              }
                              case 3:{ 
                                      ler.close();
                                      System.out.println("O valor de desconto foi "+exs.calculaValorDesconto()+"€.\n");
                              break;
                              }
                              case 4:{
                                      ler.close();
                                      System.out.println("Você deverá receber "+exs.numeroTotalProdutos()+" produtos.\n");

                              break;
                              }
                              case 5:{
                                      System.out.println("Qual produto produto procura?\n");
                                      String refProduto = ler.nextLine();
                                      ler.close();
                                      System.out.println("Podemos confirmar que o produto que procura, "+exs.existeProdutoEncomenda(refProduto)+" existe.\n");

                              break;
                              }
                              default:{
                                       ler.close();
                                       System.out.println("Essa alínea não existe, tente outra.");
                              break;
                              }
                }
       }
}
