class Maximum_Number_of_Pairs_in_Array {
    public static int[] numberOfPairs(int[] nums) {
        int pair = 0;
        int leng = nums.length;
        for (int i = 0; i < leng - 1; i++) {
            int a = nums[i];
            for (int j = i + 1; j < leng; j++) {
                int b = nums[j];
                if (a == b && a != -1) {
                    nums[i] = -1;
                    nums[j] = -1;
                    pair++;
                    break;
                }
            }
        }
        return new int[] { pair, leng - (pair * 2) };
    }

    public static void main(String[] args) {
        int s[] = { 1, 3, 2, 1, 3, 2, 2 };
        int r[] = numberOfPairs(s);
        System.out.println(r[0] + "," + r[1]);
    }
}
