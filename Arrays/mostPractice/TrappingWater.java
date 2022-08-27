package Arrays.mostPractice;

public class TrappingWater {


    public static int trapWater(int[] height){

        //left max boundary
        int leftMax []= new int[height.length];
        leftMax[0]=height[0];
        for (int i = 1; i <height.length ; i++) {
            leftMax[i]=Math.max(height[i] ,leftMax[i-1]);
        }

        //right max boundary
        int rightMax []= new int[height.length];
        rightMax[height.length-1]=height[height.length-1];
        for (int i = height.length-2; i >=0 ; i--) {
            rightMax[i]=Math.max(height[i] ,rightMax[i+1]);
        }

        //loop

        int trappedWater=0;
        for (int i = 0; i <height.length ; i++) {
            //waterlevel=min(leftmax, rightmax)
            int waterLevel=Math.min(leftMax[i],rightMax[i] );

            //trap watrer =waterleve-height
            trappedWater += waterLevel-height[i];
        }

       return trappedWater;

    }

    public static void main(String[] args) {
        int[] height={5,2,3};
        System.out.println(trapWater(height));
    }
}
