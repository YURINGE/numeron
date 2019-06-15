import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Numeron {
    public static void main(String args[]){

        System.out.println("Numeron Start!");

        //ランダムな三桁を変数にいれる
        Random random = new Random();
        boolean[] bool = new boolean[10];
        int[] nums = new int[3];

        for (int i = 0; i < 10; i++){
            bool[i] = false;
        }

        for (int i = 0; i < 3;){
            int num = random.nextInt(10);
            if (bool[num] == false){
                nums[i] = num;
                bool[num] = true;
                i++;
            }
        }
        //System.out.println("nums[0]:" + nums[0] + ", nms[1]:" + nums[1] + ", nums[2]:" + nums[2]);

        Scanner scan = new Scanner(System.in);
        while(true){
            //標準入力
            System.out.print("input > ");

            int inputNum = scan.nextInt();

            int[] inputNums = new int[3];
            for(int i = 2; 0 <= i; i--){
                inputNums[i] = inputNum % 10;
                inputNum /= 10;
            }
            
            //数字があってるかの処理
            int eatCount = 0;
            int biteCount = 0;
            for (int i = 0; i < 3; i++){
                for (int k = 0; k < 3; k++){
                    if(i == k){
                        if (inputNums[i] == nums[k]){
                            eatCount++;
                        }
                    } else {
                        if (inputNums[i] == nums[k]){
                            biteCount++;
                        }
                    }
                }
            }
            System.out.println(Arrays.toString(inputNums) + "  " + eatCount +" eat, " + biteCount + " bite");
            if(eatCount == 3){
                break;
            }
        }
        scan.close();
        System.out.println("Finish");
    }
}