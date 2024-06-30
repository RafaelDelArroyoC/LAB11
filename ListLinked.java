public class ListLinked <T>{
    protected Nodo<T> head;

    public ListLinked(){
        this.head = null;
    }

    public void setHead(Nodo<T> head){
        this.head = head;
    }
    public Nodo<T> getHead(){
        return this.head;
    }
    public boolean isEmpty(){
        return this.head == null;
    }

    public int length(){
        int count = 0;
        Nodo<T> current = this.head;
        while(current != null){
            count++;
            current = current.getNext();
        }
        return count;
    }

    protected void destroyList(){
        this.head = null;
    }

    public int search(T searchItem){
        int count = 0;
        Nodo<T> current = this.head;
        while(current != null){
            if(current.getData().equals(searchItem)){
                return count;
            }
            count++;
            current = current.getNext();
        }
        return -1;
    }

    public void insertFirst(T newItem){
        Nodo<T> newNode = new Nodo<T>(newItem);
        newNode.setNext(this.head);
        this.head = newNode;
    }

    public void insertLast(T newItem){
        Nodo<T> newNode = new Nodo<T>(newItem);
        if(this.isEmpty()){
            this.head = newNode;
        }else{
            Nodo<T> current = this.head;
            while(current.getNext() != null){
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void removeNode(T deleItem){
        if(this.isEmpty()){
            System.out.println("La lista esta vacia");
        }else{
            if(this.head.getData().equals(deleItem)){
                this.head = this.head.getNext();
            }else{
                Nodo<T> current = this.head;
                Nodo<T> trail = null;
                boolean found = false;
                while(current != null && !found){
                    if(current.getData().equals(deleItem)){
                        found = true;
                    }else{
                        trail = current;
                        current = current.getNext();
                    }
                }
                if(found){
                    trail.setNext(current.getNext());
                }else{
                    System.out.println("NO se encontro el elemento a eliminar");  
                }
            }
        }
    }

    public String toString(){
        String result = "";
        Nodo<T> current = this.head;
        while(current != null){
            result += current.getData() + " ";
            current = current.getNext();
        }
        return result;
    }

    
}
