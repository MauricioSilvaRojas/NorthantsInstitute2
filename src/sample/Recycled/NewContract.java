package sample.Recycled;

import static org.junit.Assert.assertTrue;

/**
 * Created by regga on 30/04/2017.
 */
public class NewContract {

    private String myName;
    private int numberA;
    private int numberB;

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public int getNumberA() {
        return numberA;
    }

    public void setNumberA(int numberA) {
        this.numberA = numberA;
    }

    public int getNumberB() {
        return numberB;
    }

    public void setNumberB(int numberB) {
        this.numberB = numberB;
    }

    public NewContract(String myName, int numberA, int numberB) {

        this.myName = myName;
        this.numberA = numberA;
        this.numberB = numberB;
    }

    //@precondition result   > 0
    public int addingAB(int numberA, int numberB){
        assertTrue("startBalance > 0", numberA >= 0.0);
        int result=numberA+numberB;

        return result;
    }
}
