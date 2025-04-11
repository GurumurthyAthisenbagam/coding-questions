/**
Integer.MAX_VALUE = 2,147,483,647 → binary 0 111...1111
Integer.MIN_VALUE = -2,147,483,648 → binary 1 000...0000
In Java, adding two ints can cause overflow without exception.
Integer.MAX_VALUE + 1 → wraps to Integer.MIN_VALUE (-2,147,483,648)
Integer.MAX_VALUE + Integer.MAX_VALUE → wraps to -2 (binary overflow, 2’s complement flip)
Integer.MIN_VALUE + Integer.MIN_VALUE → wraps to 0 (carry-out wrapping effect)
Java int uses mod 2³² arithmetic (silent wraparound, no auto error).
To prevent overflow: use long, or Math.addExact() (throws ArithmeticException on overflow).
Key concept: Java int addition wraps silently by binary overflow rules (2's complement system).
 */

class Solution {
    public int sum(int num1, int num2) {
        return num1 + num2;
    }
}
