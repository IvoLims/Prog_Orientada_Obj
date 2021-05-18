import java.time.LocalDate;
import java.util.ArrayList;

public class FBPost {
    private int id;
    private String name;
    private LocalDate date;
    private String content;
    private int likes;
    private ArrayList<String> comments;

public FBPost(int ident, String userName, LocalDate time, String cont, int li, ArrayList<String> com){
    this.id = ident;
    this.name = userName;
    this.date = time;
    this.content = cont;
    this.likes = li;
    this.comments = new ArrayList<String>(com);
}
public FBPost(){
    this(129867, "Mark Zuckerberg",LocalDate.now(),"None",0,new ArrayList<String>());
}
public FBPost(FBPost post){
    this.id = post.getId();
    this.name = post.getUserName();
    this.date = post.getInstanceCreated();
    this.content = post.getContent();
    this.likes = post.getLikes();
    this.comments = post.getComments();
}
public int getId(){
    return this.id;
}
public void setId(int ident){
    this.id = ident;
}
public String getUserName(){
    return this.name;
}
public void setUserName(String username){
    this.name = username;
}
public LocalDate getInstanceCreated(){
    return this.date;
}
public void setInstanceCreated(LocalDate time){
    this.date = time;
}
public String getContent(){
    return this.content;
}
public void setContent(String cont){
    this.content = cont;
}
public int getLikes(){
    return this.likes;
}
public void setLikes(int li){
    this.likes = li;
}
public ArrayList<String> getComments(){
    return new ArrayList<String>(this.comments);
}
public void setComments(ArrayList<String> com){
    this.comments = new ArrayList<String>(com);
}
public FBPost clone(){
    return new FBPost(this);
}
public boolean equals(Object f){
    if(this == f) return true;
    if(f == null || this.getClass() != f.getClass()) return false;
    FBPost fpost = (FBPost) f;
    return this.id == fpost.id && this.name.equals(fpost.name) &&
           this.date.equals(fpost.date) && this.content.equals(fpost.content) &&
           this.likes == fpost.likes && this.comments.equals(fpost.comments);
}
public String toString(){
    StringBuffer sb = new StringBuffer();
    sb.append("Id: ").append(this.id);
    sb.append("\nName: ").append(this.name);
    sb.append("\nDate: ").append(this.date);
    sb.append("\nContent: ").append(this.content);
    sb.append("\nLikes: ").append(this.likes);
    sb.append("\nComments: ").append(this.comments);
    return sb.toString();
}
}
