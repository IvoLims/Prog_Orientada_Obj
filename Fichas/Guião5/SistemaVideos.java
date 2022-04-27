import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class SistemaVideos implements Comparable<SistemaVideos>{
    private Map<String, VideoYoutube> vid;
    private LocalDate dInicial;
    private LocalDate dFinal;
    public SistemaVideos(){
        this(Collections.emptyMap());
    }
    public SistemaVideos(Map<String, VideoYoutube> v){
        this.vid = v.values().stream().collect(Collectors.toMap(VideoYoutube::getNomeVideo,VideoYoutube::clone));
    }
    public SistemaVideos(SistemaVideos v){
        this.vid = v.getVid();
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(this.vid.isEmpty()){
            sb.append("Sem videos.");
        } else{
            sb.append("Videos: ");
            this.vid.values().stream().forEach(a->sb.append(a.toString()+"\n"));
        }
        return sb.toString();
    }
    public boolean equals(Object vid){
        if(this == vid) return true;
        if(vid == null || this.getClass() != vid.getClass()) return false;
        SistemaVideos sv = (SistemaVideos) vid;
        return this.vid.equals(sv.getVid());
    }
    public SistemaVideos clone(){
        return new SistemaVideos(this);
    }
    public Map<String, VideoYoutube> getVid() {
        return this.vid.values().stream().collect(Collectors.toMap(VideoYoutube::getNomeVideo, VideoYoutube::clone));
    }
    public void setVid(Map<String, VideoYoutube> vid) {
        this.vid = vid.values().stream().collect(Collectors.toMap(VideoYoutube::getNomeVideo,VideoYoutube::clone));
    }
    public int compareTo(SistemaVideos sv) {
        if(this.getClass() != sv.getClass()) return 1;
        SistemaVideos sisV = (SistemaVideos) sv;
        if(!this.vid.equals(sisV.vid)) return this.vid.size() - sisV.vid.size();
        return 0;
    }
    public void addVideo(VideoYoutube v){
        this.vid.put(v.getNomeVideo(), v.clone());
    }
    public VideoYoutube getVideo(String codVideo){
        return this.vid.getOrDefault(codVideo, null).clone();
    }
    public void removeVideo(String codVideo){
        this.vid.remove(codVideo);
    }
    public void addLike(String codVideo){
        this.vid.forEach((k,v)->{if(k.equals(codVideo)){v.setLikes(v.getLikes()+1);}});
    }
    public String topLikes(){
        if(this.vid.isEmpty()) return null;
        return this.vid.values().stream().min((a,b)->b.getLikes() - a.getLikes()).get().getNomeVideo();
    }
    public String topLikes(LocalDate dInicial, LocalDate dFinal){
        if(this.vid.isEmpty()) return null;
        VideoYoutube v = this.vid.values().stream().filter(a->a.getData().isAfter(ChronoLocalDateTime.from(dInicial)) && a.getData().isBefore(ChronoLocalDateTime.from(dFinal))).min((a,b)->b.getLikes() - a.getLikes()).orElse(null);
        return (v == null) ? null : v.getNomeVideo();
    }
    public VideoYoutube videoMaisLongo(){
        if(this.vid.isEmpty()) return null;
        Comparator<VideoYoutube> comp = Comparator.comparing(a->-a.getMinutos());
        Comparator<VideoYoutube> compFinal = comp.thenComparing(Comparator.comparing(a->-a.getSegundos()));
        VideoYoutube v = this.vid.values().stream().min(compFinal).orElse(null);
        return (v == null) ? null : v.clone();
    }
}
