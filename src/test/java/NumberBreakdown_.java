import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class NumberBreakdown_ {
    private final int number;
    private final int[][] breakdown;

    public NumberBreakdown_(int number, int[][] breakdown) {
        this.number = number;
        this.breakdown = breakdown;
    }

    @Parameterized.Parameters
    public static Object [][] cases(){
        return new Object[][]{
                {0, new int[][]{}},
                {1, new int[][]{{1,0}}},
                {10, new int[][]{{1,1}}},
                {11, new int[][]{{1,1},{1,0}}},
                {3804, new int[][]{{3,3},{8,2},{4,0}}},
                {1000, new int[][]{{1,3}}},
                {1234, new int[][]{{1,3},{2,2},{3,1},{4,0}}},
                {4004, new int[][]{{4,3},{4,0}}},
                {51004, new int[][]{{5,4},{1,3},{4,0}}},
        };
    }
    @Test
    public void execute() {
        assertThat(getBreakdown(number)).isEqualTo(this.breakdown);
    }

    private int[][] getBreakdown(int number){
            int digitsLeft = ("" + number).length();
            int numberOfZeros = findZeros(number);
            int [][] numberBreakdown = new int[digitsLeft-numberOfZeros][];

            for (; digitsLeft>0 ; digitsLeft--){
                int positionValue = (int) Math.pow(10, digitsLeft-1);
                int digit = number/positionValue;
                if (digit != 0) {
                    numberBreakdown[numberBreakdown.length-digitsLeft] = new int[]{digit, digitsLeft-1};
                    number -= digit*positionValue;
                }
            }
            return numberBreakdown;
    }

    private int findZeros(int number){
        int numberOfZeros = 0;
        String numberString = number + "";
        for (int i = 0; i < numberString.length(); i++){
            if (numberString.charAt(i) == '0') numberOfZeros++;
        }
        return numberOfZeros;
    }

}
