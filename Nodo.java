
public class Nodo <T>{
    private T data;
    private Nodo<T> next;

    public Nodo(T data){
        this.data = data;
        this.next = null;
    }

    public T getData(){
        return this.data;
    }

    public void setData(T data){
        this.data = data;
    }

    public Nodo<T> getNext(){
        return this.next;
    }

    public void setNext(Nodo<T> next){
        this.next = next;
    }

    public String toString(){
        return this.data.toString();
    }
}

