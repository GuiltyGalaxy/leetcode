package daily.L899;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    public void case1() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.orderlyQueue("cba",1), "acb");
    }

    @Test
    public void case2() {
        Solution solution = new Solution();
        Assertions.assertEquals(solution.orderlyQueue("baaca",3), "aaabc");
    }

}