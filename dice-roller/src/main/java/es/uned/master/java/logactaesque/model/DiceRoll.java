package es.uned.master.java.logactaesque.model;

import java.util.Date;

public class DiceRoll {

    private Date diceRolledAt = new Date();
    private int rolledNumber;

    public Date getDiceRolledAt() {
        return diceRolledAt;
    }

    public int getRolledNumber() {
        return rolledNumber;
    }

    public static DiceRoll invoke(int rolledNumber) {
        return new DiceRoll(rolledNumber);
    }

    private DiceRoll(int rolledNumber) {
        this.rolledNumber = rolledNumber;
    }

}
