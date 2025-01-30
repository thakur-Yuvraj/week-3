public class Pair {
    public Object first;
    public Object second;
    public Object[] pair = new Object[2];
    public Pair(Object first, Object second) {
        this.first = first;
        this.second = second;
        pair[0] = first;
        pair[1] = second;
    }
}