import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        new DepositCalculator().initializeMenu();
    }

    void initializeMenu() {
        int period;
        int action;
        int amount;
        double depositFinalValue = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt( );
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if(action == 1)
            depositFinalValue = calculateSimplePercentFunction(amount, 0.06, period);
        else if (action == 2)
            depositFinalValue = calculateComplexPercentFunction(amount, 0.06, period);

        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + depositFinalValue);
    }

    double calculateSimplePercentFunction(double doubleAmount, double doubleYearRate, int depositPeriod) {
        double pay = doubleAmount + doubleAmount * doubleYearRate * depositPeriod;
        return calculateDeposit(pay, 2);
    }

    double calculateComplexPercentFunction(double doubleAmount, double doubleYearRate, int depositPeriod) {
        double pay = doubleAmount * Math.pow(1 + doubleYearRate / 12, 12 * depositPeriod);
        return calculateDeposit(pay, 2);
    }

    double calculateDeposit(double pay, int places) {
        double scale = Math.pow(10, places);
        return Math.round(pay * scale) / scale;
    }
}
