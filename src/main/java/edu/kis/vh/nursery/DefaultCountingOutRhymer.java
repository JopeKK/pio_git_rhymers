package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {
    private static final int TOTAL_NUMBERS = 12;
    private static final int DEFAULT = -1;
    private static final int EMPTY = -1;
    private final int[] numbers = new int[TOTAL_NUMBERS];

    public int getTotal() {
        return total;
    }

    private int total = -1;

    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == EMPTY;
    }

    public boolean isFull() {
        return total == TOTAL_NUMBERS-1;
    }

    protected int peekaboo() {
        if (callCheck())
            return DEFAULT;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return DEFAULT;
        return numbers[total--];
    }

}
