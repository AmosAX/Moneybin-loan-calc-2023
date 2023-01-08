package MoneyBin;

import static org.junit.jupiter.api.Assertions.*;

class MathLogicTest {
    @org.junit.jupiter.api.Test
    void pow() {
        double power1 = MathLogic.pow(3,9);
        //3×3×3×3×3×3×3×3×3
        double power2 = MathLogic.pow(7,4);
        //7×7×7×7
        assertTrue(power1 == 19683);
        assertTrue(power2 == 2401 );
    }

    @org.junit.jupiter.api.Test
    void calcMonthlyPayment() {
        double loan = 4500;
        double interest = 3.5;
        int years = 3;
        double monthlySum = MathLogic.CalcMonthlyPayment(years,interest,loan);
        System.out.println(monthlySum);
        assertTrue(monthlySum == 131.86);

    }

}