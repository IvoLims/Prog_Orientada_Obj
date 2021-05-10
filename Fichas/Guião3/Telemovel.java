import java.util.ArrayList;

public class Telemovel {
    private String marca;
    private String modelo;
    private int dimX;
    private int dimY;
    private int nMens;
    private ArrayList<String> mens;
    private int arm;
    private double armF;
    private double armA;
    private double espO;
    private int fotos;
    private int apps;
    private ArrayList<String> appN;

    public Telemovel(String marca, String modelo, int dimX, int dimY, int nMens, ArrayList<String> mens, int arm, double armF, double armA, double espO, int fotos, int apps) {
        this.marca = new String(marca);
        this.modelo = new String(modelo);
        this.dimX = dimX;
        this.dimY = dimY;
        this.nMens = nMens;
        this.mens = new ArrayList<String>(mens.size());
        this.mens.addAll(mens);
        this.arm = arm;
        this.armF = armF;
        this.armA = armA;
        this.espO = 0.0;
        this.fotos = 0;
        this.apps = 0;
        this.appN = new ArrayList<String>(apps);
    }

    public Telemovel() {
        this.marca = "None";
        this.modelo = "None";
        this.dimX = 120;
        this.dimY = 120;
        this.nMens = 10;
        this.arm = 64;
        this.armF = 13.2;
        this.armA = 12.4;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Marca: ").append(this.getMarca());
        sb.append("\nModelo: ").append(this.getModelo());
        sb.append("\nDimX: ").append(this.getDisplayX());
        sb.append("\nDimY: ").append(this.getDisplayY());
        sb.append("\nNumero de mensagens: ").append(this.getNumMensagens());
        sb.append("\nArmazenamento: ").append(this.getArmazenamento());
        sb.append("\nArmazenamento de Fotos: ").append(this.getArmazenamentoFotos());
        sb.append("\nNumero de Fotos: ").append(this.getFotos());
        sb.append("\nArmazenamento de Apps: ").append(this.getArmazenamentoApps());
        sb.append("\nNumero de Apps: ").append(this.getApps());
        sb.append("\nEspaco ocupado: ").append(this.getEspacoOcupado());
        return sb.toString();
    }

    public boolean equals(Telemovel t) {
        if (t == this) return true;
        if (t == null || t.getClass() != this.getClass()) return false;
        return this.getMarca().equals(t.getMarca()) && this.getModelo().equals(t.getModelo()) &&
                this.getDisplayX() == t.getDisplayX() && this.getDisplayY() == t.getDisplayY() &&
                this.nMens == t.nMens && this.arm == t.arm && this.armA == t.armA && this.apps == t.apps &&
                this.armF == t.armF && this.fotos == t.fotos && this.espO == t.espO;
    }

    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public int getDisplayX() {
        return this.dimX;
    }

    public int getDisplayY() {
        return this.dimY;
    }

    public int getNumMensagens() {
        return this.nMens;
    }

    public ArrayList<String> getMessages() {
        return this.mens;
    }

    public double getArmazenamento() {
        return this.arm;
    }

    public double getArmazenamentoFotos() {
        return this.armF;
    }

    public int getArmazenamentoApps() {
        return this.apps;
    }

    public double getEspacoOcupado() {
        return this.espO;
    }

    public int getFotos() {
        return this.fotos;
    }

    public ArrayList<String> getApps() {
        return this.appN;
    }

    public String[] getAppNomes() {
        String[] n = new String[this.apps];
        if (this.apps >= 0) System.arraycopy(this.appN, 0, n, 0, this.apps);
        return n;
    }

    public void setMarca(String marca) {
        this.marca = new String(marca);
    }

    public void setModelo(String modelo) {
        this.modelo = new String(modelo);
    }

    public void setDisplayX(int x) {
        this.dimX = x;
    }

    public void setDisplayY(int y) {
        this.dimY = y;
    }

    public void setNumeroMensagens(int x) {
        this.nMens = x;
    }

    public void setMessages(ArrayList<String> mens) {
        this.mens = new ArrayList<String>(this.mens.size());
        for (String message : mens) this.mens.add(message);
    }

    public void setArmazenamento(int ar) {
        this.arm = ar;
    }

    public void setArmazenamentoFotos(double af) {
        this.armF = af;
    }

    public void setArmazenamentoApps(double aa) {
        this.armA = aa;
    }

    public void setEspacoOcupado(double eO) {
        this.espO = eO;
    }

    public void setFotos(int f) {
        this.fotos = f;
    }

    public void setApps(int apps, ArrayList<String> appN) {
        this.apps = apps;
        this.appN = new ArrayList<String>(apps);
        for (String app : appN) this.appN.add(app);
    }

    public boolean existeEspaco(int numeroBytes) {
        return this.getEspacoOcupado() + numeroBytes <= this.getArmazenamento();
    }

    public void instalaApp(String nome, int tamanho) {
        if (existeEspaco(tamanho) && this.getArmazenamentoApps() >= tamanho) {
            this.apps++;
            this.appN.add(nome);
            this.setEspacoOcupado(this.getEspacoOcupado() + tamanho);
            this.setArmazenamentoApps(this.getArmazenamentoApps() + tamanho);
        }
    }

    public void recebeMsg(String msg) {
        this.espO += msg.length();
    }

    public double tamMedioApps() {
        double media = 0;
        if (getArmazenamentoApps() > 0) {
            media = (double) this.getArmazenamentoApps() / this.getApps().size();
        }
        return media;
    }

    public String maiorMsg() {
        if (this.getNumMensagens() < 1) return "";
        int maiorLen = Integer.MIN_VALUE;
        String mensagem = "";
        for (String message : this.mens) {
            if (message.length() > maiorLen) {
                maiorLen = message.length();
                mensagem = message;
            }
        }
        return mensagem;
    }

    public void removeApp(String nome, int tamanho) {
        if (this.getArmazenamentoApps() >= tamanho) {
            if (appN.contains(nome)) {
                this.setEspacoOcupado(this.getEspacoOcupado() - tamanho);
                this.apps--;
                this.appN.remove(nome);
                this.setArmazenamentoApps(this.getArmazenamentoApps() - tamanho);
            }
        }
    }
}
