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
        };
    }
    @Test
    public void execute() {
        assertThat(getBreakdown(number)).isEqualTo(this.breakdown);
    }

    private int[][] getBreakdown(int number){
            int numberOfDigits = ("" + number).length();
            int numberOfZeros = findZeros(number);
            int [][] numberBreakdown = new int[numberOfDigits-numberOfZeros][];
            int index = 0;

            while(number != 0) {
                int quantity = powerOf(10, numberOfDigits-1);
                int digit = number/quantity;
                if (digit != 0) {
                    numberBreakdown[index] = new int[]{digit, numberOfDigits-1};
                    index++;
                    number-=digit*quantity;
                }
                numberOfDigits--;

            }
            return numberBreakdown;
    }


    private int powerOf(int base, int exponent) {
        int res = 1;
        for (int i = exponent; i > 0; i--){
            res*=base;
        }
        return res;
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
