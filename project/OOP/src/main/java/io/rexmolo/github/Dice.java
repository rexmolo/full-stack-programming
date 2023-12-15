package io.rexmolo.github;

import java.util.Random;

public enum Dice {

    D6(6), D10(10), D20(20), D100(100);

    private int maxValue;
    private Dice(int i){
        maxValue = i;
    }

    public int roll(){
        return new Random().nextInt(this.maxValue);
    }
}
