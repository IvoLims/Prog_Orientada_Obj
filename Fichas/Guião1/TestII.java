import java.util.Scanner;

public class TestII{
  public static void main(String [] args){
    Scanner ler = new Scanner(System.in);
    ExII exs = new ExII();
    System.out.println("Introduza qual alinea quer: ");
    int alinea = ler.nextInt();
    ler.nextInt();
    switch(alinea) {
                 case 1: System.out.println("Indique o valor que quer converter: ");
                 double valC = ler.nextInt();
                 double valF = exs.celsiousTofahrenheit(valC);
                 System.out.println("O valor de "+valC+"ºC é de "+valF+"ºF.\n");
                 break;
                 case 2: System.out.println("Indique entre quais dois valores quer saber o maior: ");
                 int valM1 = ler.nextInt();
                 int valM2 = ler.nextInt();
                 int max = exs.maximo(valM1,valM2);
                 System.out.println("O maior entre os dois valores é "+max+".\n");
                 break;
                 case 3: System.out.println("Introduza um nome e um valor: "); 
                 String nome = ler.nextLine();
                 double val = ler.nextInt();
                 System.out.println(exs.criaConta(nome,val));
                 break;
                 case 4: System.out.println("Indique qual o valor em € que quer converter: ");
                 double valorE = ler.nextInt();
                 double valConv=exs.eurosTolibras(valorE);
                 System.out.println("O valor de "+valorE+"€ em libras é "+valConv+".\n");
                 break;
                 case 5: System.out.println("Indique para quais dois valores quer receber decrescentemente e também quer saber a sua média: ");
                 int valD1 = ler.nextInt();
                 int valD2 = ler.nextInt();
                 System.out.print("Os valores em ordem decrescente ficam: " + exs.descrescente(valD1, valD2) + ".\n");
                 System.out.print("Média = "+ ((valD1+valD2)/2) + ".\n");
                 break;
                 case 6: System.out.println("Indique para que nº quer saber o fatorial: ");
                 int fat = ler.nextInt();
                 long valFat = exs.factorial(fat);
                 System.out.println("O valor do fatorial de "+fat+" é " +valFat+".\n");
                 break;
                 case 7: System.out.println("Para se calcular o fatorial de 5000 demorou"+exs.tempoGasto(5000)+"milisegundos.\n");
                 break;
                 default: 
                 break;
                }
  }
}

//Comandos usados 'javac TestII.java' e depois 'java TestII'