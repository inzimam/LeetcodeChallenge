public class NumberComplement {

    /*
    Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

    Example 1:

    Input: 5
    Output: 2
    Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

    Example 2:

    Input: 1
    Output: 0
    Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.

    Note:

    The given integer is guaranteed to fit within the range of a 32-bit signed integer.
    You could assume no leading zero bit in the integer’s binary representation.
     */

    public static void main(String[] args) {
        NumberComplement numberComplement = new NumberComplement();
        System.out.println("jewelsAndStones " + numberComplement.findComplement(5));
    }

    private int findComplement(int num) {
        String complBinary = "";
        while (num > 0) {
            int q = num % 2;
            q = q == 1 ? 0 : 1;
            num = num / 2;
            complBinary = q + complBinary;
        }
        int finalInt = 0;
        boolean leftZero = true;
        while (!complBinary.isEmpty()) {
            if (complBinary.charAt(0) == '0' && leftZero) {
                complBinary = complBinary.substring(1);
            } else {
                leftZero = false;
                finalInt = (2 * finalInt) + Integer.parseInt(complBinary.charAt(0) + "");
                complBinary = complBinary.substring(1);
            }
        }
        return leftZero ? 0 : finalInt;
    }
}
