class Solution {
    public boolean isAnagram(String str1,String str2){
        char arr1[]=str1.toCharArray();
        char arr2[]=str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        if(arr1.length!=arr2.length){
            return false;
        }

        for(int i=0;i<arr1.length;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }
    public List<String> removeAnagrams(String[] words) {
        List<String> al=new ArrayList<>();
        for(String word:words){
            al.add(word);
        }
        for(int i=0;i<words.length-1;i++){
            int idx=i;
            if(isAnagram(words[i],words[i+1])){
                al.remove(words[i+1]);
            }
        }
        return al;
    }
}