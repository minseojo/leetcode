class Solution {
    public int minimumDeviation(int[] nums) {
        Queue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            if(nums[i]%2==1) num *= 2; 
            pq.add(num);
            min = Math.min(min, num);
        }
        
        int result = Integer.MAX_VALUE;
        while(true) {
            int max = pq.poll();
            result = Math.min(result, max-min);
            if(max-min >= Math.abs((max/2)-min) && max%2==0) {
                pq.add(max/2);
                min = Math.min(min, max/2);
                result = Math.min(result, max-min);
            } else break;
        }
        return result;
    }
}


/**


*/

