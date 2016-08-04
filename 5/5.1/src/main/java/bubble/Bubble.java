/**
 * Created by ${Ruslan} on 23.07.2016.
 */
package bubble;


public class Bubble {
    int arrayVal[] = new int [10];

    public Bubble(int[] arrayVal) {
        this.arrayVal = arrayVal;
    }
    //{8, 4, 5, 1, 2, 3, 9, 6, 7, 0}

    public int[] sortArray() {
        int mov = 0;
        int temp;
        boolean flagRemoved = true;
        while (flagRemoved) {
            flagRemoved = false;
            for (int i = 0; i < arrayVal.length - 1 - mov; i++) {
                if (arrayVal[i] > arrayVal[i + 1]) {
                    temp = arrayVal[i + 1];
                    arrayVal[i + 1] = arrayVal[i];
                    arrayVal[i] = temp;
                    flagRemoved = true;
                }
            }
            mov++;
        }
        return arrayVal;
    }
}
