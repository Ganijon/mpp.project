package dao;


import java.util.List;

public interface Dao <T> {

    List<T> read();
    boolean write(List<T> list);
    boolean add(T object);
    boolean update(T data);
    //T find(String key);
}
