class Solution {
    public int trap(int[] height) {
        int left_h[]=new int[height.length];
        int right_h[]=new int[height.length];
        int water=0;
        left_h[0]=height[0];
        right_h[height.length-1]=height[height.length-1];

        //left height array
        for(int i=1;i<height.length;i++){
            if(height[i]<=left_h[i-1]){
                left_h[i]=left_h[i-1];
            }else{
                left_h[i]=height[i];
            }
        }
        // right height array
        for(int i=height.length-2;i>=0;i--){
            if(height[i]<=right_h[i+1]){
                right_h[i]=right_h[i+1];
            }else{
                right_h[i]=height[i];
            }
        }

        for(int i=0;i<height.length;i++){
            if(left_h[i]<=right_h[i]){
                if((left_h[i]-height[i])<=0){
                    water=water+0;
                }else{
                    water=water+(left_h[i]-height[i]);
                }
            }else{
                if((right_h[i]-height[i])<=0){
                    water=water+0;
                }else{
                    water=water+(right_h[i]-height[i]);
                }
            }
            
        }
        return water;
    }
}