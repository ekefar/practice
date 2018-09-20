package arrays;

import java.util.Stack;

/**
 * @author : Alexander Serebriyan
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        System.out.println(trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trap(int[] height) {


        int totalWaterUnits = 0;
        int currentIndex = 0;

        Stack<Integer> stack = new Stack<>();

        while (currentIndex < height.length) {

            int currentValue = height[currentIndex];

            while (!stack.isEmpty() && currentValue > height[stack.peek()]) {
                int top = stack.pop();

                if (stack.isEmpty())
                    break;

                int distance = currentIndex - stack.peek() - 1;
                int boundedHeight = Math.min(height[currentIndex], height[stack.peek()]) - height[top];
                totalWaterUnits += distance * boundedHeight;
            }

            stack.push(currentIndex);
            currentIndex++;
        }


        return totalWaterUnits;
    }

    public static int trap2(int[] height) {
        int leftBound = 0;
        int rightBound = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int totalWaterUnits = 0;

        while (leftBound <= rightBound) {
            leftMax = Math.max(leftMax, height[leftBound]);
            rightMax = Math.max(rightMax, height[rightBound]);
            if (leftMax < rightMax) {
                totalWaterUnits += (leftMax - height[leftBound]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
                leftBound++;
            } else {
                totalWaterUnits += (rightMax - height[rightBound]);
                rightBound--;
            }
        }
        return totalWaterUnits;
    }
}
