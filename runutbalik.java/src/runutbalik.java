import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class runutbalik {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah angka: ");
        int n = scanner.nextInt();

        List<Integer> nums = new ArrayList<>();
        System.out.println("Masukkan angka-angka:");
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            nums.add(num);
        }

        System.out.print("Masukkan target: ");
        int target = scanner.nextInt();

        List<List<Integer>> result = subsetSum(nums, target);

        if (!result.isEmpty()) {
            System.out.println("Kombinasi yang memenuhi target:");
            for (List<Integer> subset : result) {
                System.out.println(subset);
            }
        } else {
            System.out.println("Tidak ada kombinasi yang memenuhi target.");
        }
    }

    public static List<List<Integer>> subsetSum(List<Integer> nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentSubset = new ArrayList<>();
        backtrack(nums, target, currentSubset, 0, result);
        return result;
    }

    private static void backtrack(List<Integer> nums, int target, List<Integer> currentSubset, int start, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currentSubset));
            return;
        }

        for (int i = start; i < nums.size(); i++) {
            int num = nums.get(i);
            if (target - num >= 0) {
                currentSubset.add(num);
                backtrack(nums, target - num, currentSubset, i + 1, result);
                currentSubset.remove(currentSubset.size() - 1);
            }
        }
    }
}
