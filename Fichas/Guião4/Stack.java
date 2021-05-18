import java.util.ArrayList;

public class Stack {
    private ArrayList<String> val;
    public Stack(){
        this.val = new ArrayList<>();
    }
    public Stack(ArrayList<String> a){
        this.val = new ArrayList<String>(a);
    }
    public Stack(Stack a){
        this(a.val);
    }
    public boolean equals(Object s){
        if(this == s) return true;
        if(s == null || this.getClass() != s.getClass()) return false;
        Stack sa = (Stack) s;
        return this.val.equals(sa.val);
    }
    public String toString(){
        return this.val.toString();
    }
    public Stack clone(){
        return new Stack(this);
    }
    public String top(){
        if(!this.val.isEmpty())
           return this.val.get(this.val.size()-1);
        else return null;
    }
    public void push(String s){
        this.val.add(s);
    }
    public void pop(){
        this.val.remove(this.val.size()-1);
    }
    public boolean empty(){
        return this.val.isEmpty();
    }
    public int length(){
        return this.val.size();
    }
}
