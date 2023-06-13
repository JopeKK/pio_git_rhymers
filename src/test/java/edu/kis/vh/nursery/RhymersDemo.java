package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.RhymersFactory;

class RhymersDemo {

    public static final int RHYMER_TYPES_END = 3;
    public static final int FIRST_UNCOUNTED_VALUE = 15;
    public static int FIRST_COUNTED_VALUE = 1;
    public static final int HANOI_RHYMER_INDEX = 3;
    public static final int MAX_RANDOM_NUMBER_VALUE = 20;
    public static final int RANDOM_NUMBER_COUNTER = 15;
    public static int RANDOM_NUMBER_LOOP_STARTING_VALUE = 1;
    public static final String REJECTED_HEADER = "total rejected is ";
    public static final String SPACING = "  ";

    public static void main(String[] args) {
        RhymersFactory factory = new DefaultRhymersFactory();
        testRhymers(factory);
    }

    private static void testRhymers(RhymersFactory factory){
        DefaultCountingOutRhymer[] rhymers = { factory.getStandardRhymer(), factory.getFalseRhymer(),
                factory.getFIFORhymer(), factory.getHanoiRhymer()};

        for (int i = FIRST_COUNTED_VALUE; i < FIRST_UNCOUNTED_VALUE; i++)
            for (int j = 0; j < RHYMER_TYPES_END; j++)
                rhymers[j].countIn(i);

        java.util.Random rn = new java.util.Random();
        for (int i = RANDOM_NUMBER_LOOP_STARTING_VALUE; i < RANDOM_NUMBER_COUNTER; i++)
            rhymers[HANOI_RHYMER_INDEX].countIn(rn.nextInt(MAX_RANDOM_NUMBER_VALUE));

        for (int i = 0; i < rhymers.length; i++) {
            while (!rhymers[i].callCheck())
                System.out.print(rhymers[i].countOut() + SPACING);
            System.out.println();
        }

        System.out.println(REJECTED_HEADER
                + ((HanoiRhymer) rhymers[HANOI_RHYMER_INDEX]).reportRejected());

    }
    
}