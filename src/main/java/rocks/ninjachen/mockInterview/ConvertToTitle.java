package rocks.ninjachen.mockInterview;

public class ConvertToTitle {
    public String convertToTitle(int n) {
        n--;
        int origin = n;
        int len = 0;
        if(n == 0) {
            len = 1;
        } else {
            while (n > 0) {
                n = n / 26;
                len++;
            }
        }

        len--;
        n = origin;
        StringBuffer sb = new StringBuffer();
        for (int i = len; i >= 0; i--) {
            int base = (int) Math.pow(26, i);
            int curNum = n / base;
            n = n - curNum * base;
            if (i == len && i != 0) {
                sb.append((char) ('A' + curNum - 1));
            } else {
                sb.append((char) ('A' + curNum));
            }
        }
        return sb.toString();
    }
}
