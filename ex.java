class ex {
    public int[] twoSum(int[] nums, int target) {
        int[] ans= new int[2];
        for(int i=0,j=nums.length;i<j;i++,j--){
            if((nums[i]+nums[j])==target){
                ans[0]=i;ans[1]=j;
                return ans;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println();
    }
}