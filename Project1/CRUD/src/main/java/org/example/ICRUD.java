package org.example;

public interface ICRUD {
    public Object add();
    public int udpate(Object obj);
    public int delete(Object obj);
    public void selectOne(int id);
}
