import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FBFeed {
    private ArrayList<FBPost> posts;
    
public FBFeed(ArrayList<FBPost> list){
    this.posts = new ArrayList<FBPost>(list);
    /* Also right
    this.posts = new ArrayList<FBPost>();
    for(FBPost elem : list){
        this.posts.add(elem.clone());
    }*/
}
public FBFeed(){
    this(new ArrayList<FBPost>());
    // Also right this.posts = new ArrayList<>();
}
public FBFeed(FBFeed fb){
    this.setPosts(fb.getPosts());
}
public int nrPosts(String user){
   return (int) this.posts.stream().filter(a->a.getUserName().equals(user)).count();
}
public List<FBPost> postsOf(String user){
    return this.posts.stream().filter(a->a.getUserName().equals(user)).collect(Collectors.toList());
}
public List<FBPost> postsOf(String user, LocalDateTime inicio, LocalDateTime fim){
       List<FBPost> l1 = this.posts.stream().filter(a->a.getUserName().equals(user)).collect(Collectors.toList());
       l1.removeIf(a->a.getInstanceCreated().isAfter(ChronoLocalDate.from(fim)) || a.getInstanceCreated().isBefore(ChronoLocalDate.from(inicio)));
       return l1;
}
public FBPost getPost(int id){
       FBPost l1 = this.posts.stream().filter(a->a.getId() == id).findFirst().orElse(null);
       if(l1 != null) return l1.clone();
       else return l1;
 }
 public void comment(FBPost post, String comentario){
        boolean encontrou = false;
        int i;
        for(i = 0; !encontrou && i<this.posts.size(); i++){
            FBPost p = this.posts.get(i);
            if(p.equals(post)) encontrou = true;
        }
        if (!encontrou) {
            i = this.posts.size();
        }else i--;
        ArrayList<String> com = post.getComments();
        com.add(comentario);
        post.setComments(com);
        this.posts.set(i,post);
 }
 public void comment(int postid, String comentario) {
        boolean encontrou = false;
        int i;
        for (i = 0; !encontrou && i < this.posts.size(); i++) {
            if (postid == this.posts.get(i).getId()) encontrou = true;
        }
        if (encontrou) {
            i--;
            FBPost post = this.posts.get(i);
            ArrayList<String> com = post.getComments();
            com.add(comentario);
            post.setComments(com);
            this.posts.set(i, post);
        }
 }
 public void like(FBPost post){
        boolean encontrou = false;
        int i;
        for(i = 0; !encontrou && i<this.posts.size(); i++){
            FBPost p = this.posts.get(i);
            if(p.equals(post)) encontrou = true;
        }
        if (!encontrou) {
            i = this.posts.size();
        }else i--;
        int likes = post.getLikes()+1;
        post.setLikes(likes);
        this.posts.set(i,post);
}
public void like(int postid){
       boolean encontrou = false;
       int i;
       for (i = 0; !encontrou && i < this.posts.size(); i++) {
           if (postid == this.posts.get(i).getId()) encontrou = true;
       }
       if (encontrou) {
           i--;
           FBPost post = this.posts.get(i);
           int likes = post.getLikes()+1;
           post.setLikes(likes);
           this.posts.set(i, post);
       }
}
//Exterior
public List<Integer> top5CommentsExt() {
       ArrayList<FBPost> copy = new ArrayList<>(this.posts);
       List<Integer> top5 = new ArrayList<>();
       for(int i = 0; i < 5; i++) {
           FBPost mostCommented = null;
           for(FBPost post : copy)
               if(mostCommented == null || mostCommented.getComments().size() < post.getComments().size())
                  mostCommented = post;
           top5.add(mostCommented.getId());
           copy.remove(mostCommented);
       }
       return top5;
}
//Interno
public List<Integer> top5CommentsInt(){
       return this.posts.stream().sorted((Comparator<? super FBPost>) (p1,p2) -> p2.getComments().size()- p1.getComments().size()).limit(5).map(FBPost::getId).collect(Collectors.toList());
}
public ArrayList<FBPost> getPosts(){
    return new ArrayList<FBPost>(this.posts);
}
public void setPosts(ArrayList<FBPost> nPosts){
    this.posts = new ArrayList<FBPost>(nPosts);
    /* Também certo
    this.posts = new ArrayList<FBPost>();
    for(FBPost fbp: nPost) this.posts.add(fbp.clone());
    */
}
public boolean equals(Object f){
    if(this == f) return true;
    if(f == null || this.getClass() == f.getClass()) return false;
    FBFeed fbf = (FBFeed) f;
    return this.posts.equals(fbf.getPosts()); 
}
public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("Posts: ").append(this.posts);    
    return sb.toString();
}
public FBFeed clone(){
    return new FBFeed(this);
}
}
