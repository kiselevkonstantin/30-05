import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker tracker = new StepTracker();
        Converter convert = new Converter();
        printMenu();
        int userInput = scanner.nextInt();

        while (userInput != 0) {
            if (0 > userInput) {
                System.out.println("Вы ввели неверное значение. Попробуйте снова.");
            }
            else if (userInput > 3) {
                System.out.println("Вы ввели неверное значение. Попробуйте снова.");
            }
            else if (userInput == 1) {
                System.out.println("Введите название месяца. 0-Январь, 1-Февраль, 2-Март, 3-Апрель, 4-Май, 5-Июнь, 6-Июль, 7-Август, 8-Сентябрь, 9-Октябрь, 10-Ноябрь, 11-Декабрь? ");
                int monthsNumber = scanner.nextInt();
                System.out.println("Введите номер дня (от 1 до 30): ");
                int daysNumber = scanner.nextInt();
                System.out.println("Введите количество шагов, пройденных в этот день");
                int stepsNumber = scanner.nextInt();
                if (stepsNumber < 0) {
                    System.out.println("Вы ввели неверное значение");
                    break;
                }
                tracker.save(monthsNumber,daysNumber,stepsNumber);
            } else if (userInput == 2) {
                System.out.println("Введите номер месяца. 0-Январь, 1-Февраль, 2-Март, 3-Апрель, 4-Май, 5-Июнь, 6-Июль, 7-Август, 8-Сентябрь, 9-Октябрь, 10-Ноябрь, 11-Декабрь ");
                int monthNumber = scanner.nextInt();
                System.out.println("Ваша статистика за выбранный месяц:");
                tracker.printStatistics (monthNumber);
                tracker.totalSteps (monthNumber);
                tracker.maxSteps (monthNumber);
                tracker.avgSteps (monthNumber);
                tracker.stepsToCalories (monthNumber);
                System.out.println("Максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого: " + tracker.bestSeries(monthNumber));
            } else if (userInput == 3) {
                System.out.println("Ваша цель сейчас: " + tracker.goal);
                System.out.println("Введите число:");
                int target = scanner.nextInt();
                if (target < 0) {
                    System.out.println("Вы ввели неверное число");
                    break;
                } else {
                    tracker.changeGoal(target);
                }
            }
            printMenu(); // печатем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }
    private static void printMenu() {
        System.out.println("Введите команду: ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}



