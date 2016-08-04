/**
 * Created by ${Ruslan} on 23.07.2016.
 */
package dublicate;


public class Dublicate {
    public static void main(String[] args) {
    }

    public String[] stringArray = new String[7];

    public Dublicate(String[] stringArray) {
        this.stringArray = stringArray;
    }
    //{"one", "two", "three", "four", "one", "four", "five"}

    public String[] checkDoublicates() {
        int tmp = 0;
        for (int i = 0; i < stringArray.length - tmp; i++) {
            for (int j = 0; j < stringArray.length - tmp; j++) {
                if (stringArray[i].equals(stringArray[j]) & (i != j)) {
                    stringArray[j] = null;
                    for (int t = j; t < stringArray.length - 1 - tmp; t++) {
                        //if (stringArray[t].equals(null)){
                        stringArray[t] = stringArray[t + 1];
                     //   remove(stringArray, stringArray.length - 1 - tmp);
                       //}
                    }
                    tmp++;
                }
            }
        }
        String [] newArr = new String[stringArray.length - tmp];
        for (int m = 0; m < newArr.length; m++){
            newArr[m] = stringArray[m];
        }
        return newArr;
    }
}

