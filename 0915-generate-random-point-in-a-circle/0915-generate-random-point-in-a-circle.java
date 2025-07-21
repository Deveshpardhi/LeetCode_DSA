class Solution {
    double radius;
    double x_center;
    double y_center;
    Random rand;
    public Solution(double radius, double x_center, double y_center) {
        this.radius=radius;
        this.x_center=x_center;
        this.y_center=y_center;
        rand=new Random();
    }
    
    public double[] randPoint() {
        double angle=rand.nextDouble()*2*3.14;
        double dist=Math.sqrt(rand.nextDouble())*radius;
        double x = x_center + dist * Math.cos(angle);
        double y = y_center + dist * Math.sin(angle);

        return new double[]{x, y};

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */