import java.math.BigInteger;

class Solution {
    public BigInteger strToNum(String str) {
        BigInteger ans = BigInteger.ZERO;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int dig = 0;
            if (ch == '1') {
                dig = 1;
            } else if (ch == '2') {
                dig = 2;
            } else if (ch == '3') {
                dig = 3;
            } else if (ch == '4') {
                dig = 4;
            } else if (ch == '5') {
                dig = 5;
            } else if (ch == '6') {
                dig = 6;
            } else if (ch == '7') {
                dig = 7;
            } else if (ch == '8') {
                dig = 8;
            } else if (ch == '9') {
                dig = 9;
            } else {
                dig = 0;
            }
            ans = ans.multiply(BigInteger.TEN).add(BigInteger.valueOf(dig));
        }
        return ans;
    }

    public String numToString(BigInteger n) {
        String str = "";
        if (n.equals(BigInteger.ZERO)) {
            return "0";
        }
        while (!n.equals(BigInteger.ZERO)) {
            BigInteger dig = n.mod(BigInteger.TEN);
            if (dig.equals(BigInteger.ONE)) {
                str += "1";
            } else if (dig.equals(BigInteger.valueOf(2))) {
                str += "2";
            } else if (dig.equals(BigInteger.valueOf(3))) {
                str += "3";
            } else if (dig.equals(BigInteger.valueOf(4))) {
                str += "4";
            } else if (dig.equals(BigInteger.valueOf(5))) {
                str += "5";
            } else if (dig.equals(BigInteger.valueOf(6))) {
                str += "6";
            } else if (dig.equals(BigInteger.valueOf(7))) {
                str += "7";
            } else if (dig.equals(BigInteger.valueOf(8))) {
                str += "8";
            } else if (dig.equals(BigInteger.valueOf(9))) {
                str += "9";
            } else if (dig.equals(BigInteger.ZERO)) {
                str += "0";
            }
            n = n.divide(BigInteger.TEN);
        }
        String ans = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            ans += str.charAt(i);
        }
        return ans;
    }

    public String multiply(String num1, String num2) {
        BigInteger n = strToNum(num1).multiply(strToNum(num2));
        return numToString(n);
    }
}
