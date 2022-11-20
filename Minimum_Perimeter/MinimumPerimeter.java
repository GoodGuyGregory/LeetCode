/*
An integer area is given, representing the area of some rectangle.

The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).

The goal is to find the minimal perimeter of any rectangle whose area equals area. The sides of this rectangle should be only integers.

For example, given integer area = 30, rectangles of area 30 are:

(1, 30), with a perimeter of 62,
(2, 15), with a perimeter of 34,
(3, 10), with a perimeter of 26,
(5, 6), with a perimeter of 22.
Write a function:

public static int minimunPerimeterRectangle(int area);

that, given an integer area, returns the minimal perimeter of any rectangle whose area is exactly equal to area.

For example, given an integer area = 30, the function should return 22, as explained above.

Write an efficient algorithm for the following assumptions:

area is an integer within the range [1..1,000,000,000].
*/

public class MinimumPerimeter {

    public static int minimunPerimeterRectangle(int area) {

        int i = area;
        // default worst perimeter
        int maxPerimeter = 2 * (area + 1);
        // default best perimeter
        int minPerimeter = 0;
        do {
            // prevents rational numbers from being counted as potenital lengths and widths
            if ((area % i) == 0) {
                int length = area / i;
                int width = i;
                int resultPerimeter = 2 * (length + width);
                // default initial value for minPerimeter
                if (resultPerimeter < minPerimeter || minPerimeter == 0) {
                    // found new best
                    minPerimeter = resultPerimeter;
                }
            }
            i -= 1;
        } while (i > 0);
        // return the best
        return minPerimeter;
    }

    public static String validateResult(int result, int expectedResult) {
        StringBuffer buffer = new StringBuffer();
        boolean validResult = (result == expectedResult);
        buffer.append("The result of the function was: ").append(result);
        buffer.append(" and the expected result is: ").append(expectedResult);
        buffer.append(" The test passes: ").append(validResult);
        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(validateResult(minimunPerimeterRectangle(10), 14));
        System.out.println(validateResult(minimunPerimeterRectangle(25), 20));
        System.out.println(validateResult(minimunPerimeterRectangle(30), 22));
        System.out.println(validateResult(minimunPerimeterRectangle(31), 64));
        System.out.println(validateResult(minimunPerimeterRectangle(40), 26));
        System.out.println(validateResult(minimunPerimeterRectangle(62), 66));
        System.out.println(validateResult(minimunPerimeterRectangle(100), 40));
        System.out.println(validateResult(minimunPerimeterRectangle(500), 90));
        System.out.println(validateResult(minimunPerimeterRectangle(1000), 130));
        System.out.println(validateResult(minimunPerimeterRectangle(2000), 180));
    }

}
