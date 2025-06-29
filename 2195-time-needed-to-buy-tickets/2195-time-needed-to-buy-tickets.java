class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < tickets.length; i++) {
            q.add(i); // store indices
        }

        int time = 0;

        while (!q.isEmpty()) {
            int idx = q.poll(); // person at front

            // person buys one ticket
            tickets[idx]--;
            time++;

            // if person still has tickets, put them at the end
            if (tickets[idx] > 0) {
                q.add(idx);
            }

            // if person `k` has finished
            if (idx == k && tickets[idx] == 0) {
                break;
            }
        }

        return time;
    }
}
