package MoneyBin;

public class MathLogic {

    //since we are not allowed to use "java.math or similar math dependencies" we have to create our own method.
    static double pow(double base, int exponent) {
        double result = 1;
        for (int i = 0; i < exponent; i++) {
            result = result * base;
        }
        return result;
    }

    //put method static so we can easily call it
    static double CalcMonthlyPayment(int years,double interest, double loan) {
        int p = years * 12;//Number of payments
        double monthlyInterest= (interest/100)/12;
        double monthly_pay;// Fixed monthly payment
        monthly_pay = loan * ((monthlyInterest * pow((1 + monthlyInterest), p)) / (pow((1 + monthlyInterest), p) - 1));
        return round(monthly_pay);
    }

    //we need to round the numbers
    static double round(double number){
        double mult = number * 100;
        double add = mult + 0.5;
        double result = (int) add;
        return result/100.0;
    }

    static double calculateInterestToPay(double monthly, int years, double loan){
        return round((monthly*years*12)-loan);
    }

}

