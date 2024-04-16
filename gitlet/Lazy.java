package gitlet;
import java.util.function.Supplier;
public class Lazy<T> implements Supplier<T> {
    private volatile Supplier<T> delegate;
    private volatile boolean innitialized;
    private T value;
    public Lazy(Supplier<T> delegate){
        this.delegate=delegate;
    }


    public T get(){
        if(!innitialized){
            synchronized (this){
                if(!innitialized){
                    T t= delegate.get();
                    value =t;
                    innitialized=true;
                    delegate=null;
                    return t;
                }
            }
        }
    return value;}
}
