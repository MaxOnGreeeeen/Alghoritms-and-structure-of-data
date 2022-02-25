package tpu.company;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<T> {
    private int size;
    private ArrayList<T> arrayList = new ArrayList<>(size);
    private int top;
    Stack (int size){
        this.top = -1;
        this.size = size();
    }
    public T pop(){
        if(!arrayList.isEmpty()){
            return arrayList.remove(0);
        }
        else{
            throw new EmptyStackException();
        }
    }
    public void push (T object){
        arrayList.add(0,object);
    }
    public int size(){
        return arrayList.size();
    }
    public T get(int index ){
        return arrayList.get(index);
    }
    public boolean isEmpty(){
        return arrayList.isEmpty();
    }
    public T top(){
        if(!arrayList.isEmpty()){
            return arrayList.get(0);
        }else{
            throw new EmptyStackException();
        }
    }

}
