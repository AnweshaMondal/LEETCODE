class Solution {
    public int[] plusOne(int[] digits) {

        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int plusOne = digits[i] + carry;
            digits[i] = (plusOne) % 10;
            carry = plusOne / 10;
        }

        //after the loop ends,if the carry = 1, increase the size of the array by 1
        if (carry == 1) {
            int[] newNums = new int[digits.length + 1];
            newNums[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                newNums[i + 1] = digits[i];
            }
            return newNums;
        }

        return digits;
    }
}