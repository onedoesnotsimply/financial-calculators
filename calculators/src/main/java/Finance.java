import java.util.Scanner;

public class Finance {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Which calculator would you like to use?");
        System.out.println("Option 1: Mortgage calculator ");
        System.out.println("Option 2: CD calculator ");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                mortgageCalculator();
                break;

            case 2:
                cdCalculator();
                break;

            default:
                System.out.println("Invalid input.");
                break;
        }
    }

    public static void mortgageCalculator() {
        // prompt for principal

        System.out.print("Please enter principal cost as a whole number : ");
        int principal = scanner.nextInt();

        // interest
        System.out.print("Please enter the yearly interest rate as a decimal number (i.e. 7.6) : ");
        double interestRate = scanner.nextDouble();

        // and length of loan
        System.out.print("Please enter the length of your loan in years : ");
        int loanLength = scanner.nextInt();
        // consume newline
        scanner.nextLine();

        // calculate monthly interest
        double monthlyInterest = interestRate / 1200;

        int loanLengthInMonths = loanLength * 12;

        // monthly mortgage calculation
        double monthlyPayment = principal * monthlyInterest / (1 - Math.pow(1 + monthlyInterest, - loanLengthInMonths));

        // total interest
        double totalInterest = monthlyPayment * loanLengthInMonths - principal;

        // output information
        System.out.printf("You will have a monthly payment of $%.2f/mo with a total interest of $%.2f", monthlyPayment, totalInterest);
    }

    public static void cdCalculator() {
        // prompt for deposit amount
        System.out.print("Please enter the deposit amount: ");
        double deposit = scanner.nextDouble();
        // prompt for interest rate
        System.out.print("Please enter the interest rate as a decimal number : ");
        double interestRate = scanner.nextDouble();
        // prompt for length of loan
        System.out.print("Please enter the number of years: ");
        int loanLength = scanner.nextInt();

        // calculate monthly interest
        double monthlyInterest = interestRate / 1200;
        // convert years to months
        int loanInMonths = loanLength*12;

        double futureValue = deposit * Math.pow(1 + monthlyInterest, loanInMonths);

        double totalInterest = futureValue - deposit;

        System.out.printf("Your deposit will mature to $%.2f and you will have earned $%.2f in interest.",futureValue, totalInterest);

    }
}
