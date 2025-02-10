class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subset(nums,0,new ArrayList<>(),ans);
        return ans;
    }
private void subset(int[] arr, int index, List<Integer>curr, List<List<Integer>>ans){
        ans.add(new ArrayList<>(curr));
        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1])
            {
                continue;
            }
             curr.add(arr[i]);
                   subset(arr, i+1,curr,ans);
        curr.remove(curr.size()-1);
        }
    }
}
