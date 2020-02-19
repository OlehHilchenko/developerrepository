package main.java.com.olehhilchenko.repository;

import java.util.Map;

public interface GenericRepository<T, ID> {

    void insert(T t);

    T read(ID id);

    void update(T t);

    void remove(ID id);

    Map<Long, T> map();
}
