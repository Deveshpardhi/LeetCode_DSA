class Solution {
    //int len;
    public void backtrack(String title,boolean arr[],HashSet<String> set,String curr){
        int len=title.length();
        if(set.contains(curr)){
            return;
        }
        set.add(curr);
        for(int i=0;i<len;i++){
            if(arr[i]){
                continue;
            }
            arr[i]=true;
            backtrack(title,arr,set,curr+ title.charAt(i));
            arr[i]=false;
        }
    }
    public int numTilePossibilities(String tiles) {
        int len=tiles.length();
        boolean []arr =new boolean[len];
        HashSet<String> set =new HashSet<>();
        backtrack(tiles,arr,set,"");
        return set.size()-1;
    }
}