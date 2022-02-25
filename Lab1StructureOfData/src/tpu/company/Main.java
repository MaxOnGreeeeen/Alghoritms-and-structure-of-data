package tpu.company;

import java.io.File;
import java.io.IOException;

public class Main {
    //for the first two bunch of data
    public static int[] test_data = new int[]{500,1000,1500,
    2000,2500,3000,3500,4000, 4500};
    //for the last point
    public static int[] test_data1 = new int[]{5000,10000,
            15000,20000, 25000,30000,35000,40000,45000);
    }
    public static void main(String[] args) throws IOException {
        Helper helper = new Helper("Ctqxfc ns pfljk," +
                "ftimcz jcjpyfdfnm, xnj ;t pltcm yfgbcfyj b ,eltim gbcfnm yjhvfkmyj/ Rfr ujdjhbncz, elfxb b dctuj [jhjituj");
        String fileName = "C:\\Users\\User\\OneDrive\\Рабочий стол\\Алгоритмы и структуры данных\\Lab4File1.txt";
        File file = new File(fileName);
        for (int i = 0; i <  test_data.length; i++){
            Solution solution2 = new Solution(file,test_data[i]);
            solution2.solve();
        }
    }
}