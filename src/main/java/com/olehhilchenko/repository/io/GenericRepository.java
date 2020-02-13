package main.java.com.olehhilchenko.repository.io;

import java.util.List;

public interface GenericRepository<T, ID> {

    void insert(T t);

    T read (ID id);

    void update (T t);

    void remove (ID id);

    List<T> list();
}
