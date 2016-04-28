// 216. Combination Sum III
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n == 0 || k == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        DFS(k, n, 1, result, cur);
        return result;
    }
    
    private void DFS(int k, int n, int curNum, List<List<Integer>> result, List<Integer> curList) {
        if (n == 0 && curList.size() == k) {
            result.add(new ArrayList<Integer>(curList));
            return;
        } else if (curList.size() >= k) {
            return;
        }
        
        for (int i = curNum; i <= 9; i++) {
            if (i <= n) {
                curList.add(i);
                DFS(k, n - i, i + 1, result, curList);
                curList.remove(curList.size() - 1);
            } else {
                break;
            }
        }
    }
}