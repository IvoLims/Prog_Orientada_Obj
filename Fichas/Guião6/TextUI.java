import java.util.Scanner;

public class TextUI {
  // o modelo
  private DriveItPL8 model;
  
  //scanner 
  private Scanner sc;

  /**
   * Construtor que cria os menus e o model
   */

  public TextUI() {
    this.model = new DriveItPL8();
    sc = new Scanner(System.in);
  }
  
  
  /**
   * Método que executa o menu principal.
   * Coloca a interface em execução.
   */
  
  public void run() {
    NewMenu menu = new NewMenu(new String[] {
            " Gestão de Veículos",
            " Dar Nome à Empresa"
    });
    
    //pré-condição: só se altera o nome da empresa se este for vazio!!
    menu.setPreCondition(2, () -> this.model.getNome().equals(""));
    //registar os métodos de tratamento, passados como 
    //expressões lambda (interface funcional)
    menu.setHandler(1, () -> gestaoVeiculos());
    menu.setHandler(2, () -> alterarNomeEmpresa());
    
    //colocar o menú em visualização e esperar leitura de opção
    menu.run();
  }
  
  /**
   * Métodos associados ao handler
   */
  private void gestaoVeiculos() {
    NewMenu menuVeiculos = new NewMenu(new String[] {"Adicionar Veiculo", 
                            "Listar Veiculo", 
                            "Remover Veiculo"});
                            
    //registar os handlers
    menuVeiculos.setHandler(1, () -> addVeiculo());
    menuVeiculos.setHandler(2, () -> listVeiculo());
    menuVeiculos.setHandler(3, () -> remVeiculo());
    
    menuVeiculos.run();
  }
  
  
  private void alterarNomeEmpresa() {
    System.out.println("Novo nome da Empresa: ");
    String nome = sc.nextLine();
    this.model.setNome(nome);
  }
  
  private void addVeiculo() {
      
  }
  
  private void listVeiculo() {
      
  }
  
  private void remVeiculo() {
      
  }
  
}
