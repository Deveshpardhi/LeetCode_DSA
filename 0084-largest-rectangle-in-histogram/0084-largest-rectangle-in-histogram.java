class Solution {
    public int largestRectangleArea(int[] arr) {
        int max=0;
        int nsr[]=new int[arr.length];
        int nsl[]=new int[arr.length];

        Stack<Integer> s=new Stack<>();

        //nsr
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i]=arr.length;
            }else{
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        //nsl
        s=new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!s.isEmpty() && arr[s.peek()]>=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i]=-1;
            }else{
                nsl[i]=s.peek();
            }
            s.push(i);
        }

        for(int i=0;i<arr.length;i++){
            max=Math.max(max,arr[i]*(nsr[i]-nsl[i]-1));
        }

        return max;
    }
}