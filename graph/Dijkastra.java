

/*
class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
*/

// User function Template for Java
class Solution{
    // Function to find the shortest distance of all the vertices
    // from the source vertex src.
    ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
        // Write your code here
        int V = adj.size();
        PriorityQueue<iPair> pq = new PriorityQueue<>((a,b) -> (a.first>b.first)?-1:(a.first<b.first)?1:0);
        int[] ans=new int[V];
        for(int i=0;i<V;i++){
            ans[i]=Integer.MAX_VALUE;
        }
        ans[src]=0;
        pq.add(new iPair(src,0));
        while(pq.size()>0){
            iPair temp=pq.remove();
            int vertex=temp.first;
            int distance=temp.second;
            for(iPair it:adj.get(vertex)){
                int ver=it.first;
                int dis=it.second;
                if(distance+dis<ans[ver]){
                    ans[ver]=distance+dis;
                    pq.add(new iPair(ver,distance+dis));
                }
            }
        }
        ArrayList<Integer> res=new ArrayList<>();
        for(int i=0;i<V;i++){
            res.add(ans[i]);
        }
        return res;
    }
}