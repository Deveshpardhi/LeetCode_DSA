class Solution {
    public int dayOfYear(String date) {
        int sum = 0, flag = 0;
        String str = "";

        for (int i = 0; i < 4; i++) {
            str += date.charAt(i);
        }
        int year = Integer.parseInt(str);
        str = "";

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            flag = 1;
        }

        for (int i = 5; i < 7; i++) {
            str += date.charAt(i);
        }
        int mon = Integer.parseInt(str);
        str = "";

        for (int i = 8; i < 10; i++) {
            str += date.charAt(i);
        }
        int n = Integer.parseInt(str);

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (flag == 1) {
            daysInMonth[1] = 29;
        }

        for (int i = 0; i < mon - 1; i++) {
            sum += daysInMonth[i];
        }

        sum += n;
        return sum;
    }
}
