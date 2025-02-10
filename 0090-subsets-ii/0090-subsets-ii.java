class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        generateSubsets(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
    private void generateSubsets(int[] arr, int index, List<Integer>curr, List<List<Integer>> result){
        result.add(new ArrayList<>(curr));
        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1]){
                continue;
            }
            curr.add(arr[i]);
            generateSubsets(arr, i+1, curr,result);
            curr.remove(curr.size()-1);
        }
    }
}