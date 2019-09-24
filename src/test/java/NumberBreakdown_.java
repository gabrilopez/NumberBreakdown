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
                //{10, new int[][]{{1,1}}},
        };
    }
    @Test
    public void execute() {
        assertThat(getBreakdown(number)).isEqualTo(this.breakdown);
    }

    private int[][] getBreakdown(int number){
        int numberOfDigits = ("" + number).length();
        if (number==0) return new int[][]{};
        return new int[][]{{number, units(number)}};
    }

    private int tens(int number) {
        return (number%100)/10;
    }

    private int units(int number) {
        return (number%10);
    }

}
