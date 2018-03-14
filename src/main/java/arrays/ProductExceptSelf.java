package arrays;

/**
 * @author : Alexander Serebriyan
 *         https://leetcode.com/problems/product-of-array-except-self/description/
 */
public class ProductExceptSelf {

    public static void main(String[] args) {
        final int[] ints = productExceptSelf(new int[]{1,2,3,4});
        System.out.println(ints);
    }


    public static int[] productExceptSelf(int[] nums) {
        if (nums.length == 0) {
            return new int[]{};
        }
        final int[] products = new int[nums.length];

        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            products[i] = product;
            product *= num;
        }

        product = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            int num = nums[i];
            products[i] *= product;
            product *= num;
        }

        return products;
    }

}
