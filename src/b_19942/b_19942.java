package b_19942;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// ArrayList 정렬 방법이 약한듯
// 다시 한 번 풀어보자!
public class b_19942 {
    private static int N;
    private static Ingredient threshold;
    private static ArrayList<Ingredient> ingredientList = new ArrayList<>();
    private static int minValue = Integer.MAX_VALUE;
    private static HashMap<Integer, ArrayList<ArrayList<Integer>>> ret_v = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        setThreshold(br);
        setIngredientList(br);

        ArrayList<Ingredient> chooseList = new ArrayList<>();
        for (int i = 0; i < (1 << N); ++i) {
            int totalProtein = 0;
            int totalFat = 0;
            int totalHydro = 0;
            int totalVitamin = 0;
            int totalCost = 0;

            ArrayList<Integer> v = new ArrayList<>();
            for (int j = 0; j < N; ++j) {
                if ((i & (1 << j)) != 0) {
                    v.add(j + 1); // 여기서 선택한 num값들을 저장한다.
                    chooseList.add(ingredientList.get(j));
                    totalProtein += ingredientList.get(j).protein;
                    totalFat += ingredientList.get(j).fat;
                    totalHydro += ingredientList.get(j).hydro;
                    totalVitamin += ingredientList.get(j).vitamin;
                    totalCost += ingredientList.get(j).cost;
                }
            }

            boolean isValid = (totalProtein >= threshold.protein) && (totalFat >= threshold.fat) && (totalHydro >= threshold.hydro) && (totalVitamin >= threshold.vitamin);
            if (isValid) {
                if (minValue >= totalCost) {
                    minValue = totalCost;
                    if (ret_v.get(minValue) == null) {
                        ret_v.put(minValue, new ArrayList<>());
                        ret_v.get(minValue).add(v);
                    } else {
                        ret_v.get(minValue).add(v);
                    }
                }
            }
        }

        if (minValue == Integer.MAX_VALUE) {
            bw.write(String.valueOf(-1));
        } else {
            ArrayList<ArrayList<Integer>> optimalCombinations = ret_v.get(minValue);
            Collections.sort(optimalCombinations, (list1, list2) -> {
                for (int k = 0; k < Math.min(list1.size(), list2.size()); ++k) {
                    if (!list1.get(k).equals(list2.get(k))) {
                        return list1.get(k) - list2.get(k);
                    }
                }
                return list1.size() - list2.size(); // 마지막으로, size순 정렬
            });
            bw.write(String.valueOf(minValue));
            bw.write("\n");
            for (Integer index : optimalCombinations.get(0)) {
                bw.write(index + " ");
            }
        }

        bw.flush();
        bw.close();
    }

    private static void setThreshold(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        String[] conds = br.readLine().split(" ");
        threshold = new Ingredient(
                Integer.parseInt(conds[0]),
                Integer.parseInt(conds[1]),
                Integer.parseInt(conds[2]),
                Integer.parseInt(conds[3])
        );
    }
    private static void setIngredientList(BufferedReader br) throws IOException {
        for (int i = 0; i < N; ++i) {
            String[] ingredientConds = br.readLine().split(" ");
            ingredientList.add(new Ingredient(
                    Integer.parseInt(ingredientConds[0]),
                    Integer.parseInt(ingredientConds[1]),
                    Integer.parseInt(ingredientConds[2]),
                    Integer.parseInt(ingredientConds[3]),
                    Integer.parseInt(ingredientConds[4])
            ));
        }
    }



    static class Ingredient {
        int protein;
        int fat;
        int hydro;
        int vitamin;
        int cost;
        public Ingredient(
                int protein,
                int fat,
                int hydro,
                int vitamin
        ) {
            this.protein = protein;
            this.fat = fat;
            this.hydro = hydro;
            this.vitamin = vitamin;
        }
        public Ingredient (
            int protein,
            int fat,
            int hydro,
            int vitamin,
            int cost
        ) {
            this.protein = protein;
            this.fat = fat;
            this.hydro = hydro;
            this.vitamin = vitamin;
            this.cost = cost;
        }
    }
}
