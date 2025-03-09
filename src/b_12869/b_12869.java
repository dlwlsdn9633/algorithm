package b_12869;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class b_12869 {
    private static String[] scvs;
    private static ArrayList<ArrayList<Integer>> candidates;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        candidates = new ArrayList<>();
        scvs = br.readLine().split(" ");
        setCandidates(0);

        int attackNumber = 0;
        while (true) {
            boolean flag = false;
            for (int i = 0; i < candidates.size(); ++i) {
                int attack[] = { 9, 3, 1 };
                for (int j = 0; j < candidates.get(i).size(); ++j) {
                    candidates.get(i).set(j, candidates.get(i).get(j) - attack[j]);
                }
                boolean isAllNegative = true;
                for (int j = 0; j < candidates.get(i).size(); ++j) {
                    if (candidates.get(i).get(j) > 0) {
                        isAllNegative = false;
                    }
                }
                if (isAllNegative) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
            ++attackNumber;
        }
        System.out.println(attackNumber);
    }

    private static void setCandidates(int depth) {
        if (depth == scvs.length) {
            ArrayList<Integer> candidate = new ArrayList<>();
            for (int i = 0; i < scvs.length; ++i) {
                candidate.add(Integer.valueOf(scvs[i]));
            }
            candidates.add(candidate);
            return;
        }
        for (int i = 0; i < scvs.length; ++i) {
            swap(i, depth);
            setCandidates(depth + 1);
            swap(i, depth);
        }
    }

    private static void swap(int idx1, int idx2) {
        String temp = scvs[idx1];
        scvs[idx1] = scvs[idx2];
        scvs[idx2] = temp;
    }
}
