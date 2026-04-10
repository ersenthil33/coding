class Solution {
    public int[][] merge(int[][] inter) {
        List<List<Integer>> li=new ArrayList<>();
        Arrays.sort(inter,(a,b)->a[0]-b[0]);
        int start=inter[0][0];
        int end=inter[0][1];
        for(int i=1;i<inter.length;i++){
            if(inter[i][0]<=end){
                end=Math.max(end,inter[i][1]);  
            }
            else{
                li.add(Arrays.asList(start,end));
                start=inter[i][0];
                end=inter[i][1];
            }
        }
        li.add(Arrays.asList(start,end));
        int [][] ans=new int[li.size()][li.get(0).size()];
        for(int i=0;i<li.size();i++){
            for(int j=0;j<li.get(0).size();j++){
                ans[i][j]=li.get(i).get(j);
            }
        }
        return ans;
    }
}