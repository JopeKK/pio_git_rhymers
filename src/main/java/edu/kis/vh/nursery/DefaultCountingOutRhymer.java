package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {
    private static final int TOTAL_NUMBERS = 12;
    private static final int ZERO_ELEMENTS = -1;
    private final int[] numbers = new int[TOTAL_NUMBERS];

    public int getTotal() {
        return total;
    }

    private int total = ZERO_ELEMENTS;

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    public void countIn(int in) {
        if (!isFull())
            numbers[++total] = in;
    }

    public boolean callCheck() {
        return total == -1;
    }

    public boolean isFull() {
        return total == 11;
    }

    protected int peekaboo() {
        if (callCheck())
            return -1;
        return numbers[total];
    }

    public int countOut() {
        if (callCheck())
            return -1;
        return numbers[total--];
    }

}
