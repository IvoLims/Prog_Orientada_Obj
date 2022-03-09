public class Jogo {
    private final int porIni = 0;
    private final int decorrer = 1;
    private final int terminou = 2;

    private int gameState;
    private int golosV;
    private String nEquipaV;
    private int golosC;
    private String nEquipaC;

    public Jogo(String eq1, String eq2){
        this.setGameState(porIni);
        this.setnEquipaV(eq1);
        this.setnEquipaC(eq2);
    }
    public void startGame(){
        if(this.getGameState() == porIni){
            this.setGameState(decorrer);
            this.setGolosEqV(0);
            this.setGolosEqC(0);
        }
    }
    public void endGame(){
        if(this.getGameState() == decorrer){
            this.setGameState(terminou);
        }
    }
    public void goloVisitado(){
        if(this.getGameState() == decorrer){
            this.setGolosEqC(this.getGolosC()+1);
        }
    }
    public void goloVisitante(){
        if(this.getGameState() == decorrer){
            this.setGolosEqV(this.getGolosV()+1);
        }
    }
    public String resultadoActual(){
        StringBuffer sb = new StringBuffer();
        sb.append("The game has result: ").append(this.getGolosC());
        sb.append(" ").append(this.getnEquipaC()).append(" ");
        sb.append(this.getGolosV()).append(" ").append(this.getnEquipaV()).append(" ");
        return sb.toString();
    }
    public String toString() {
        return "Estado de jogo: " + this.getGameState() +"\n"+ this.resultadoActual();
    }
    public boolean equals(Object j){
         if(j == this) return true;
         if(j == null || j.getClass() != this.getClass()) return false;
         Jogo j = (Jogo) j;
         return j.golosC == this.golosC && j.golosV == this.golosV &&
                this.nEquipaC.equals(j.nEquipaC) && this.nEquipaV.equals(j.nEquipaV);
    }
    public int getGameState(){
        return this.gameState;
    }
    public void setGameState(int est){
        this.gameState = est;
    }
    public int getGolosC(){
        return this.golosC;
    }
    public void setGolosEqC(int gc){
        this.golosC = gc;
    }
    public int getGolosV(){
        return this.golosV;
    }
    public void setGolosEqV(int gv){
        this.golosV = gv;
    }
    public String getnEquipaC() {
        return this.nEquipaC;
    }
    public void setnEquipaC(String eq1){
        this.nEquipaC = eq1;
    }
    public String getnEquipaV(){
        return this.nEquipaV;
    }
    public void setnEquipaV(String eq2){
        this.nEquipaV = eq2;
    }
}
