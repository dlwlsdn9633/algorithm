package b_1325;

import java.util.*;

public class b_1325 {
    private static HashMap<Integer, ArrayList<Integer>> tree = new HashMap<>();
    private static ArrayList<Computer> computerList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] conds = scanner.nextLine().split(" ");

        int N = Integer.valueOf(conds[0]);
        int M = Integer.valueOf(conds[1]);

        // Computer Setting
        for (int com = 1; com <= N; ++com) {
            tree.put(com, new ArrayList<>());
            computerList.add(new Computer(com, 0));
        }

        for (int relationIdx = 0; relationIdx < M; ++relationIdx) {
            String[] coms = scanner.nextLine().split(" ");
            ArrayList<Integer> childComs = tree.get(Integer.valueOf(coms[1]));
            childComs.add(Integer.valueOf(coms[0]));
            tree.put(Integer.valueOf(coms[1]), childComs);
        }

        for (int com = 1; com <= 5; ++com) {
            hacking(com, 0, com);
        }

        Collections.sort(computerList, new Comparator<Computer>() {
            @Override
            public int compare(Computer o1, Computer o2) {
                return (o1.depth < o2.depth) ? 1 : -1;
            }
        });

        Computer maxComputer = computerList.get(0);
        for (Integer com : maxComputer.startHackingComputer) {
            System.out.print(com + " ");
        }
    }

    private static void hacking(int com, int depth, int startCom) {
        if (tree.get(com).size() == 0) {
            // 더 이상 해킹할 컴퓨터가 없다면
            computerList.get(com - 1).compareDepth(depth, startCom);
            return;
        }
        for (Integer childCom : tree.get(com)) {
            hacking(childCom, depth + 1, startCom);
        }
    }

    static class Computer {
        ArrayList<Integer> startHackingComputer;
        int num;
        int depth;
        public Computer(int num, int depth) {
            this.num = num;
            this.depth = depth;
            this.startHackingComputer = new ArrayList<>();
        }
        public void compareDepth(int depth, int startCom) {
            if (this.depth < depth) {
                startHackingComputer.clear();
                startHackingComputer.add(startCom);
            } else if (this.depth == depth) {
                startHackingComputer.add(startCom);
            }
            this.depth = (this.depth < depth) ? depth : this.depth;
        }
        public String toString() {
            return "[computer num: " + this.num + ", depth: " + this.depth + "]";
        }
    }
}
