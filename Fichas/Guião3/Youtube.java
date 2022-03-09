import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;

public class Youtube {
    private String vName;
    private char[] video;
    private LocalTime date;
    private int[] duration;
    private final int minutes = 0;
    private final int seconds = 1;
    private int resolution;
    private String[] comments;
    private int[] reaction;
    private final int likes = 1;
    private final int dislikes = 0;

    public Youtube(){
    this.vName = "Clickbait";
    this.video = new char[0];
    this.date = LocalTime.now();
    this.resolution = 720;
    this.duration[minutes] = 0;
    this.duration[seconds] = 0;
    this.comments = new String[0];
    this.reaction[likes] = 0;
    this.reaction[dislikes] = 0;
}
public Youtube(String vName, char[] video, int[] duration, int resolution, int min, int sec) {
    this.vName = new String(vName);
    this.video = new char[video.length];
    System.arraycopy(video,0,this.video,0,video.length);
    this.resolution = resolution;
    this.duration[minutes] = min;
    this.duration[seconds] = sec;
    this.reaction[likes] = 0;
    this.reaction[dislikes] = 0;
    this.comments = new String[0];
}
public void insereComentario(String comment){
        String[] comments = this.getComments();
        String[] newComment = new String[comments.length+1];
        System.arraycopy(comments,0,newComment,0,comments.length);
        newComment[comments.length] = new String(comment);
        this.setComments(newComment);
}
public long qtsDiasDepois(){
        LocalTime estreia = this.getDate();
        LocalTime atual = LocalTime.now();
        return Duration.between(estreia,atual).toDays();
}
public void thumbsUp(){
        int i = getNlikes();
        this.setNlikes(i+1);
}
public String processa(){
        StringBuilder s = new StringBuilder();
        String[] vid = this.getVideo();
        for(String i :vid) s.append(i);
        return s.toString();
}
public String toString(){
    StringBuffer sb = new StringBuffer();
    sb.append("Titulo: ").append(this.getVname());
    sb.append("\nDuration: ").append(this.getMinutes()).append(":").append(this.getSeconds());
    sb.append("\n <3 Likes: ").append(this.getNlikes());
    sb.append(" Dislikes: ").append(this.getNdislikes());
    return sb.toString();
}
public boolean equals(Object y){
    if(y==this) return true;
    if(y==null || y.getClass()!=this.getClass()) return false;
    Youtube y = (Youtube) y;
    return this.vName.equals(y.vName) && Arrays.equals(this.video,y.video) &&
           this.resolution == y.resolution && Arrays.equals(this.duration,y.duration) &&
           Arrays.equals(this.reaction,y.reaction);
}
public String getVname(){
        return this.vName;
}
public void setVname(String name){
        this.vName = name;
}
public String[] getVideo(){
        String[] newV = new String[this.video.length];
        System.arraycopy(this.video,0,newV,0,this.video.length);
        return newV;
}
public void setVideo(char[] v){
    this.video = new char[v.length];
    System.arraycopy(v,0,this.video,0,video.length);
}
public LocalTime getDate(){
        return this.date;
}
public void setDate(LocalTime d){
        this.date = d;
}
public int getResolution(){
        return this.resolution;
}
public void setResolution(int res){
        this.resolution = res;
}
public String[] getComments(){
        String[] newCom = new String[this.comments.length];
        System.arraycopy(this.comments,0,newCom,0,this.comments.length);
        return newCom;
}
public void setComments(String[] com){
        this.comments = new String[com.length];
        System.arraycopy(com,0,comments,0,com.length);
}
public int getMinutes(){
        return this.duration[minutes];
}
public void setMinutes(int min){
        this.duration[minutes] = min;
}
public int getSeconds(){
        return this.duration[seconds];
}
public void setSeconds(int sec){
        this.duration[seconds] = sec;
}
public int getNlikes(){
    return this.reaction[likes];
}
public void setNlikes(int l){
    this.reaction[likes] = l;
}
public int getNdislikes(){
    return this.reaction[dislikes];
}
public void setNdislikes(int d){
    this.reaction[dislikes] = d;
}
}
