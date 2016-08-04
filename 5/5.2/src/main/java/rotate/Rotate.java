/**
 * Created by ${Ruslan} on 23.07.2016.
 */
package rotate;


public class Rotate {
    int [][]arrayVal = new int[3][3];

    public Rotate(int[][] arrayVal) {
        this.arrayVal = arrayVal;
    }
    //{{2, 3, 7},{1, 8, 9},{8, 4, 50}};
    //int [][]rotArray = new int[3][3];

    public int [][]sortByClockArrow() {
        for (int i = 0; i < arrayVal.length/2; i++){
            for(int j = i; j < arrayVal.length - 1 - i; j++){
                int tmp = arrayVal[i][j];
                arrayVal[i][j] = arrayVal[arrayVal.length - 1 - j][i];
                arrayVal[arrayVal.length -1 - j][i] = arrayVal[arrayVal.length - 1 -i][arrayVal.length - 1 - j];
                arrayVal[arrayVal.length - 1 -i][arrayVal.length - 1 - j] = arrayVal[j][arrayVal.length - 1 - i];
                arrayVal[j][arrayVal.length - 1 - i] = tmp;
            }
        }
        return arrayVal;
    }
    public int [][] sortAgainstClockArrow(){
        for(int i = 0; i < arrayVal.length/2; i++){
            for(int j = i; j < arrayVal.length - 1 - i; j++){
                int tmp = arrayVal[i][j];
                arrayVal[i][j] = arrayVal[j][arrayVal.length - 1 - i];
                arrayVal[j][arrayVal.length - 1 - i] = arrayVal[arrayVal.length - 1 -i][arrayVal.length - 1 -j];
                arrayVal[arrayVal.length - 1 -i][arrayVal.length - 1 -j] = arrayVal[arrayVal.length - 1 -j][i];
                arrayVal[arrayVal.length - 1 -j][i] = tmp;
            }
        }
        return arrayVal;
    }
}
