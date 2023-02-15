class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> temp = new ArrayList<Integer>();
        while(k > 0) {
            temp.add(k%10);
            k/=10;
        }
        Collections.reverse(temp);
        int[] num2 = temp.stream()
        .mapToInt(Integer::intValue)
        .toArray();

        List<Integer> result = new ArrayList<Integer>();
        int i=num.length-1, j=num2.length-1;
        int sum=0, carry=0;
        while(i >= 0 || j >= 0) {
            if(i>=0 && j>=0) sum = num[i] + num2[j];
            if(i<0) sum = num2[j];
            if(j<0) sum = num[i];
            carry = sum/10;
            sum = sum%10;
            result.add(0, sum);
            
            if(i>j) {
                if(i<=0) result.add(0, carry);
                else num[i-1] += carry;
            } else {
                if(j<=0) result.add(0, carry);
                else num2[j-1] += carry;
            }
            if(i >= 0) i--;
            if(j >= 0) j--;
        }
        if(result.get(0) == 0) result.remove(0);
        return result;
    }
}