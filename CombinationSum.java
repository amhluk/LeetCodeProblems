// 39. Combination Sum
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || target == 0) {
            return null;
        }
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        Arrays.sort(candidates);
        DFS(candidates, target, ret, curList, 0);
        return ret;
    }
    
    private void DFS(int[] candidates, int target, List<List<Integer>> resultList, List<Integer> curList, int index) {
        if (target == 0) {
            resultList.add(new ArrayList<Integer>(curList));
            return;
        }
        
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) { // skip duplicates
                continue;
            }
            if (candidates[i] <= target) {
                curList.add(candidates[i]);
                DFS(candidates, target - candidates[i], resultList, curList, i);
                curList.remove(curList.size() - 1);
            } else {
                break;
            }
        }
    }
}