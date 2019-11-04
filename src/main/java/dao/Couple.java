package dao;

public class Couple<T, K> {

    private T prim1;
    private K prim2;

    public Couple(T prim1, K prim2) {
        this.prim1 = prim1;
        this.prim2 = prim2;
    }

    public T getPrim1() {
        return prim1;
    }

    public void setPrim1(T prim1) {
        this.prim1 = prim1;
    }

    public K getPrim2() {
        return prim2;
    }

    public void setPrim2(K prim2) {
        this.prim2 = prim2;
    }
}
