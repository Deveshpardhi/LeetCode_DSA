class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int count=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<trainers.length;i++){
            pq.add(trainers[i]);
        }
        Arrays.sort(players);
        for(int i=players.length-1;i>=0;i--){
            
            if(!pq.isEmpty()){
                int t=pq.remove();
                if(players[i]<=t){
                    count++;
                }else{
                    pq.add(t);
                }
            }
            
        }
        return count;
    }
}