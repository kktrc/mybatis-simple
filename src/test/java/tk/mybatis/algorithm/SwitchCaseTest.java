package tk.mybatis.algorithm;

import org.junit.Test;

public class SwitchCaseTest {




    @Test
    public void switchCashTest() {

        int number = 0;
        int n = 2;
        switch (n) {
            case 1:
                number += n;
            case 2:
                number += n;
            case 3:
                number += n;
            case 4:
                number += n;
        }

        System.out.println(number);
    }
}
