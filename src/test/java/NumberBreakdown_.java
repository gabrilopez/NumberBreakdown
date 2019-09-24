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
                {10, new int[][]{{1,2}}}
        };
    }
    @Test
    public void execute() {

    }

    private int[][] getBreakdown(int number){
        return null;
    }


}
