import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class SistemadeSuporte {
    private ArrayList<PedidodeSuporte> pedidos;
    private List<PedidodeSuporte> DoubleStream;

    public SistemadeSuporte(ArrayList<PedidodeSuporte> ps){
        this.pedidos = new ArrayList<PedidodeSuporte>();
        for(PedidodeSuporte elem : ps)
            this.pedidos.add(elem.clone());
    }
    public SistemadeSuporte(){
        this(new ArrayList<PedidodeSuporte>());
    }
    public SistemadeSuporte(SistemadeSuporte s){
        this(s.pedidos);
    }
    public boolean equals(Object s){
        if(this == s) return true;
        if(s == null || this.getClass() != s.getClass()) return false;
        SistemadeSuporte si = (SistemadeSuporte) s;
        boolean iSame = true;
        if(this.pedidos.size() != si.pedidos.size()) return false;
        for(int i = 0; iSame && i< this.pedidos.size();i++){
            iSame = this.pedidos.get(i).equals(si.pedidos.get(i));
        }
        return iSame;
    }
    public SistemadeSuporte clone(){
        return new SistemadeSuporte(this);
    }
    public String toString(){
        StringBuilder sb = new StringBuilder("Pedidos: ");
        for(PedidodeSuporte elem : this.pedidos){
            sb.append(elem.toString()).append("\n");
        }
        return sb.toString();
    }
    public ArrayList<PedidodeSuporte> getSs(){
        return (ArrayList<PedidodeSuporte>) this.pedidos.stream().map(PedidodeSuporte::clone).collect(Collectors.toList());
    }
    public void setSs(ArrayList<PedidodeSuporte> pedidos){
        this.pedidos = new ArrayList<PedidodeSuporte>();
        this.pedidos.stream().map(PedidodeSuporte::clone).collect(Collectors.toList());
    }
    public void inserePedido(PedidodeSuporte pedido){
        this.pedidos.add(pedido.clone());
    }
    public PedidodeSuporte procuraPedido(String user, LocalDateTime data){
        PedidodeSuporte p = this.pedidos.stream().filter(a->a.getName().equals(user) && a.getDate().equals(data)).findFirst().orElse(null);
        return p;
    }
    public void resolvePedido(PedidodeSuporte pedido,String tecnico, String info){
        boolean enc = false;
        int i;
        for(i=0; !enc && i<this.pedidos.size(); i++){
            enc = this.pedidos.get(i).equals(pedido);
        }if(enc){
            i--;
        } else{
            this.pedidos.add(pedido);
            i = this.pedidos.size() - 1;
        }
        pedido.setNtratou(tecnico);
        pedido.setInformacao(info);
        pedido.setConcluido(LocalDate.now());
        this.pedidos.set(i,pedido);
    }
    public List<PedidodeSuporte> resolvidos(){
        /*
        List<PedidodeSuporte> p = new ArrayList<PedidodeSuporte>();
        for(PedidodeSuporte pds: this.pedidos){
            if(!(pds.getAssunto().equals("")) && (pds.getNTratou().equals(""))){
                p.add(pds.clone());
            }
        }
        return p;
        */
        return this.pedidos.stream().map(PedidodeSuporte::clone).filter(a->!(a.getNtratou().equals("")) && !(a.getAssunto().equals(""))).collect(Collectors.toList());
    }
    public String colaboradorTop(){
        ArrayList<PedidodeSuporte> tops = new ArrayList<>(this.pedidos);
        int max = 0;
        int spot;
        String nameOftop = "None";
        for(PedidodeSuporte l : tops) {
            spot = (int) tops.stream().filter(a -> a.getNtratou().equals(l.getNtratou())).count();
            if (spot > max) {
                max = spot;
                nameOftop = l.getNtratou();
            }
        }
        return nameOftop;
    }
    public List<PedidodeSuporte>resolvidos(LocalDateTime inicio, LocalDateTime fim){
        /*
        List<PedidodeSuporte> res = new ArrayList<>();
        for(PedidodeSuporte pds: this.pedidos){
            if(pds.getDate().isAfter(ini) && pds.getConcluido().isBefore(fim) && !(pds.getNTratou().equals(""))){
                res.add(pds.clone());
            }
        }
        return res;
        */
        return this.pedidos.stream().map(PedidodeSuporte::clone).filter(a->a.getDate().isAfter(ChronoLocalDate.from(inicio)) && a.getDate().isBefore(ChronoLocalDate.from(fim)) && !a.getNtratou().equals("")).collect(Collectors.toList());
    }
    public double tempoMedioResolucao(){
        /*
        long tmpH = 0, tmpM = 0;
        int numP = 0;
        for(PedidodeSuporte pds: this.pedidos){
            if(!(pds.getNTratou().equals(""))){
                numP +=1;
                tmpH += ChronoUnit.MINUTES.between(pds.getDate(), pds.getConcluido());
                tmpM += ChronoUnit.MINUTES.between(pds.getDate(), pds.getConcluido());
            }
        }
        long tmp = tmpH * 60 + tmpM;
        return (double) tmp/numP;
        */
        DoubleStream dates = this.pedidos.stream().map(PedidodeSuporte::clone).filter(a->!a.getNtratou().equals("")).mapToDouble(a-> ChronoUnit.MINUTES.between(a.getDate(),a.getConcluido()));
        return dates.sum()/dates.count();
    }
    public double tempoMedioResolucao(LocalDateTime inicio, LocalDateTime fim){
        /*
        long tmpH = 0, tmpM = 0;
        int numP = 0;
        for(PedidodeSuporte pds: this.ped){
            if(pds.getDate().isAfter(ini) && pds.getConcluido().isBefore(fim) && !pds.getNtratou().equals("")){
                numP+=1;
                tmpH += ChronoUnit.HOURS.between(pds.getDate(), pds.getConcluido());
                tmpM += ChronoUnit.MINUTES.between(pds.getDate(), pds.getConcluido());
            }
        }
        long tmp = tmpH * 60 + tmpM;
        return (double) tmp/numP;
        */
        DoubleStream dates = this.pedidos.stream().map(PedidodeSuporte::clone).filter(a->!a.getNtratou().equals("") && a.getDate().isAfter(ChronoLocalDate.from(inicio)) && a.getDate().isBefore(ChronoLocalDate.from(fim))).mapToDouble(a-> ChronoUnit.MINUTES.between(a.getDate(),a.getConcluido()));
        return dates.sum()/dates.count();
    }
    public PedidodeSuporte pedidoMaisLongo(){
        /*
        long tmpH = 0, tmpM = 0;
        long max = 0, val;
        PedidodeSuporte p = new PedidodeSuporte();
        for(PedidodeSuporte pds : this.pedidos){
            if(!pds.getNTratou().equals("")){
                tmpH = ChronoUnit.HOURS.between(pds.getDate(), pds.getConcluido());
                tmpM = ChronoUnit.MINUTES.between(pds.getDate(), pds.getConcluido());
                val = tmpH * 60 + tmpM;
                if(max < val){
                    max = val;
                    p = pds;
                }
            }
        }
        return p;
        */
        ArrayList<PedidodeSuporte> l = new ArrayList<>(this.pedidos).stream().map(PedidodeSuporte::clone).filter(a->!a.getNtratou().equals("")).sorted(Comparator.comparing(a->ChronoUnit.MINUTES.between(a.getDate(),a.getConcluido()))).collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(l);
        if(l.isEmpty()) return null;
        else return l.stream().findFirst().orElse(null);
    }
    public PedidodeSuporte pedidoMaisLongo(LocalDateTime inicio, LocalDateTime fim){
        /*
        long tmpH = 0, tmpM = 0;
        long max = 0, val;
        PedidodeSuporte p = new PedidodeSuporte();
        for(PedidodeSuporte pds : this.pedidos){
            if(!pds.getNTratou().equals("") && pds.getDate().isAfter(inicio) && pds.getConcluido().isBefore(fim)){
                tmpH = ChronoUnit.HOURS.between(pds.getDate(), pds.getConcluido());
                tmpM = ChronoUnit.MINUTES.between(pds.getDate(), pds.getConcluido());
                val = tmpH * 60 + tmpM;
                if(max < val){
                    max = val;
                    p = pds;
                }
            }
        }
        return p;
        */
        ArrayList<PedidodeSuporte> l = new ArrayList<>(this.pedidos).stream().map(PedidodeSuporte::clone).filter(a->!a.getNtratou().equals("") && a.getDate().isAfter(ChronoLocalDate.from(inicio)) && a.getDate().isBefore(ChronoLocalDate.from(fim))).sorted(Comparator.comparing(a->ChronoUnit.MINUTES.between(a.getDate(),a.getConcluido()))).collect(Collectors.toCollection(ArrayList::new));
        Collections.reverse(l);
        if(l.isEmpty()) return null;
        else return l.stream().findFirst().orElse(null);
    }
    public PedidodeSuporte pedidoMaisCurto(){
        /*
        long tmpH = 0, tmpM = 0;
        long min = Long.MAX_VALUE, val;
        PedidodeSuporte p = new PedidodeSuporte();
        for(PedidodeSuporte pds : this.pedidos){
            if(!pds.getNTratou().equals("")){
                tmpH = ChronoUnit.HOURS.between(pds.getDate(), pds.getConcluido());
                tmpM = ChronoUnit.MINUTES.between(pds.getDate(), pds.getConcluido());
                val = tmpH * 60 + tmpM;
                if(min > val){
                    min = val;
                    p = pds;
                }
            }
        }
        return p;
        */
        ArrayList<PedidodeSuporte> l = new ArrayList<>(this.pedidos).stream().map(PedidodeSuporte::clone).filter(a->!a.getNtratou().equals("")).sorted(Comparator.comparing(a->ChronoUnit.MINUTES.between(a.getDate(),a.getConcluido()))).collect(Collectors.toCollection(ArrayList::new));
        if(l.isEmpty()) return null;
        else return l.stream().findFirst().orElse(null);
    }
    public PedidodeSuporte pedidoMaisCurto(LocalDateTime inicio, LocalDateTime fim){
        /*
        long tmpH = 0, tmpM = 0;
        long min = Long.MAX_VALUE, val;
        PedidodeSuporte p = new PedidodeSuporte();
        for(PedidodeSuporte pds : this.pedidos){
            if(pds.getNTratou().equals("") && pds.getDate().isAfter(inicio) && pds.getConcluido().isBefore(fim)){
                tmpH = ChronoUnit.HOURS.between(pds.getDate(), pds.getConcluido());
                tmpM = ChronoUnit.MINUTES.between(pds.getDate(), pds.getConcluido());
                val = tmpH * 60 + tmpM;
                if(min > val){
                    min = val;
                    p = pds;
                }
            }
        }
        return p;
        */
        ArrayList<PedidodeSuporte> l = new ArrayList<>(this.pedidos).stream().map(PedidodeSuporte::clone).filter(a->!a.getNtratou().equals("") && a.getDate().isAfter(ChronoLocalDate.from(inicio)) && a.getDate().isBefore(ChronoLocalDate.from(fim))).sorted(Comparator.comparing(a->ChronoUnit.MINUTES.between(a.getDate(),a.getConcluido()))).collect(Collectors.toCollection(ArrayList::new));
        if(l.isEmpty()) return null;
        else return l.stream().findFirst().orElse(null);
    }
}
