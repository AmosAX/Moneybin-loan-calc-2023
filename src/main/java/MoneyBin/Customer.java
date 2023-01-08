package MoneyBin;

// The file we are reading from is called prospects
public class Customer {

    private  String name;
    private  double loan;
    private  double interest;
    private  int years;
    private  double monthlyPayment;

    //constructor class


    public Customer(String name, double loan, double interest, int years) {
        this.name = name;
        this.loan = loan;
        this.interest = interest;
        this.years = years;
        this.monthlyPayment = MathLogic.CalcMonthlyPayment(years,interest,loan);
    }

    public Customer() {
        this.name = "default";
        this.loan = 5;
        this.interest = 5;
        this.years = 2;
        this.monthlyPayment = MathLogic.CalcMonthlyPayment(years,interest,loan);
    }

    public String getName() {
        return this.name;
    }

    public double getLoan() {
        return this.loan;
    }

    public double getInterest() {
        return this.interest;
    }

    public int getYears() {
        return this.years;
    }

    public double getMonthlyPayment() {
        return this.monthlyPayment;
    }

    //Setters
    public void setName(String newName) {
        this.name = newName;
    }
    public void setLoan(double loan) {
        this.loan = loan;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }


}