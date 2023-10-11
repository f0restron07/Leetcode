import java.util.TreeMap;

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] flower : flowers) {
            map.put(flower[0], map.getOrDefault(flower[0], 0) + 1);
            map.put(flower[1] + 1, map.getOrDefault(flower[1] + 1, 0) - 1);
        }

        int currBloom = 0;
        TreeMap<Integer, Integer> bloomOnDay = new TreeMap<>();

        for (Integer day : map.keySet()) {
            currBloom += map.get(day);
            bloomOnDay.put(day, currBloom);
        }

        int[] answer = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            Integer key = bloomOnDay.floorKey(people[i]);
            answer[i] = key == null ? 0 : bloomOnDay.get(key);
        }

        return answer;
    }
}
