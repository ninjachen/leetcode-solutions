package rocks.ninjachen.leet_code_contest._153;

public class DayOfTheWeek {
    public static void main(String[] args) {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        System.out.println(dayOfTheWeek.dayOfTheWeek(31, 8,  2019));
    }

    String[] dayOfTheWeekNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    int[] daysInAMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public String dayOfTheWeek(int day, int month, int year) {
        int dayOfWeekIndex = 5;
        int dayCur = 1;
        int monthCur = 1;
        int yearCur = 1971;
        for (; ; ) {
            //Got
            if (dayCur == day && monthCur == month && yearCur == year) {
                return dayOfTheWeekNames[dayOfWeekIndex];
            }
            // Forward
            dayOfWeekIndex = (dayOfWeekIndex + 1) % 7;
            dayCur++;
            // Deal Feb
            if(monthCur == 2){
                int dayNumInFeb;
                if((yearCur % 4) == 0){
                    dayNumInFeb = 29;
                }else {
                    dayNumInFeb = 28;
                }
                if(dayCur == dayNumInFeb + 1){
                    dayCur = 1;
                    monthCur++;
                    if(monthCur == 13){
                        monthCur = 1;
                        yearCur++;
                    }
                }
            }else if(dayCur == daysInAMonth[monthCur-1] + 1){
                dayCur = 1;
                monthCur++;
                if(monthCur == 13){
                    monthCur = 1;
                    yearCur++;
                }
            }
        }
    }
}
