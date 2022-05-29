public class StepTracker {
    MonthData[] month;
    int goal = 10000;
    public StepTracker() {
        month = new MonthData[12];
        for (int i = 0; i < month.length; i++) {
            month[i] = new MonthData();
        }
    }
    class MonthData {
        int[] dayAndSteps = new int[30];
    }
    void save(int monat, int days, int steps) {
        month[monat].dayAndSteps[days - 1] = steps;
    }
    public void printStatistics(int x) {
        for (int i = 0; i < month[x].dayAndSteps.length; i++) {
            if (i < month[x].dayAndSteps.length - 1) {
                System.out.print((i + 1) + " день : " + month[x].dayAndSteps[i] + ", ");
            } else {
                System.out.println((i + 1) + " день : " + month[x].dayAndSteps[i] + ". ");
            }
        }
    }
    public void totalSteps(int x) {
        int all = 0;
        for (int i = 0; i < month[x].dayAndSteps.length; i++) {
            all = all + month[x].dayAndSteps[i];
        }
        System.out.println("Общее количество шагов за месяц : " + all);
    }
    public void maxSteps(int x) {
        int max = 0;
        for (int i = 0; i < month[x].dayAndSteps.length; i++) {
            if (month[x].dayAndSteps[i] > max) {
                max = month[x].dayAndSteps[i];
            }
        }
        System.out.println("Максимальное пройденное количество шагов в месяце : " + max);
    }
    public void avgSteps(int x) {
        int all = 0;
        for (int i = 0; i < month[x].dayAndSteps.length; i++) {
            all = all + month[x].dayAndSteps[i];
        }
        double avg = all / month[x].dayAndSteps.length;
        System.out.println("Среднее количество шагов : " + avg);
    }
    public void stepsToCalories(int x) {
        int max = 0;
        for (int i = 0; i < month[x].dayAndSteps.length; i++) {
            if (month[x].dayAndSteps[i] > max) {
                max = month[x].dayAndSteps[i];
            }
        }
        double kkal = max * 0.05;
        double km = max * 0.00075;
        System.out.println("Пройденная дистанция " + km + " км.");
        System.out.println("Количество сожжённых килокалорий : " + kkal);
    }
    public int bestSeries (int x){
        int max = 0;
        int current = 0;
        for (int i = 0; i < month[x].dayAndSteps.length; i++) {
            if (month[x].dayAndSteps[i] >= goal) {
                current++;
            } else {
                max = Math.max(current, max);
                current = 0;
            }
        }
        return max;
    }
    public void changeGoal (int x){
        goal = x;
        System.out.println("Ваша цель: " + goal);
    }
}




