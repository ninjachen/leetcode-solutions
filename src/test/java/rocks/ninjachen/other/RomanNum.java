package rocks.ninjachen.other;

public class RomanNum {
    public static void main(String[] args) {
//        String input = "MCMXCIV";
//        System.out.println(new RomanNum().parse(input));

        System.out.println(new RomanNum().parse(new StringBuffer(), 1000).toString());
    }

    // Symbol       Value
    //I             1
    //V             5
    //X             10
    //L             50
    //C             100
    //D             500
    //M             1000
    public Integer parse(String input) {
        int index = 0;
        int sum = 0;
        while (true) {
            if (index == input.length())
                break;
            Character thisChar = input.charAt(index);
            Character nextChar = index + 1 < input.length() ? input.charAt(index + 1) : null;
            // nextChar is bigger than this char
            if (nextChar != null && isBigger(nextChar, thisChar)) {
                index = index + 2;
                sum += intval(thisChar, nextChar);
            } else {
                sum += intval(thisChar);
                index++;
            }
        }
        return sum;
    }

    public StringBuffer parse(StringBuffer sb, int val) {
        System.out.println("Cur val is " + val);
        String[] strArr = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] intArr = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; i < intArr.length; i++) {
            if(val > intArr[i]) {
                sb.append(strArr[i]);
                return parse(sb, val - intArr[i]);
            }
        }
        return sb;
    }

    private boolean isBigger(Character nextChar, Character thisChar) {
        Character[] charArr = new Character[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        int i2 = 0;
        for (; i2 < charArr.length; i2++) {
            Character c = charArr[i2];
            if (c.equals(thisChar)) {
                break;
            }
        }
        int i1 = 0;
        for (; i1 < charArr.length; i1++) {
            Character c = charArr[i1];
            if (c.equals(nextChar)) {
                break;
            }
        }
        return i1 < i2;
    }

    private int intval(Character thisChar) {
        Character[] charArr = new Character[]{'M', 'D', 'C', 'L', 'X', 'V', 'I'};
        Integer[] intArr = new Integer[]{1000, 500, 100, 50, 10, 5, 1};

        int i = 0;
        for (; i < charArr.length; i++) {
            Character c = charArr[i];
            if (c.equals(thisChar)) {
                break;
            }
        }
        return i == -1 ? -1 : intArr[i];
    }

    private int intval(Character thisChar, Character nextChar) {
        return intval(nextChar) - intval(thisChar);
    }


}
