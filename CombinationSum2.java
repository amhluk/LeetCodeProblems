// 40. Combination Sum II
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || target == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        DFS(candidates, target, cur, result, 0);
        return result;
    }
    
    private void DFS(int[] candidates, int target, List<Integer> curList, List<List<Integer>> resultList, int index) {
        if (target == 0) {
            resultList.add(new ArrayList<Integer>(curList));
            return;
        }
        
        for (int i = index; i < candidates.length; i ++) {
            if (i > index && candidates[i] == candidates[i - 1]) { // remove dupicates
                continue;
            }
            if (candidates[i] <= target) {
                curList.add(candidates[i]);
                DFS(candidates, target - candidates[i], curList, resultList, i + 1);
                curList.remove(curList.size() - 1);
            } else {
                break;
            }
        }
    }
}