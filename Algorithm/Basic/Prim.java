public class Prim {
  final static int infi = 99;  // 연결이 되지 않음
  
  public static void main(String[] args) {
     
	// 그래프 노드간의 가중치 입력
    int[][] graph = {
        {0,	6, 4, infi,	infi, infi, infi, infi},
        {6, 0, infi, infi, 7, 3, infi, 10},
        {4, infi, 0, 5, infi, 2, infi, infi},
        {infi, infi, 5, 0, infi, 9, 11, infi},
        {infi, 7, infi, infi, 0, infi, infi, 1},
        {infi, 3, 2, 9, infi, 0, infi, 8},
        {infi, infi, infi, 11, infi, infi, 0, infi},
        {infi, 10, infi, infi, 1, 8, infi, 0}
        };   
    int[][] t = new int[2][graph.length-1];
 
    prim(graph, graph.length, t, 0);
    
    int min = 0;
    System.out.println("<Prim's Algorithm>");
    for(int i = 0; i < t[0].length; i++) {
      System.out.println((i+1) + "번째로 포함한 edge: v" + t[0][i] + " - v" + (t[1][i]) + " (가중치: " + graph[t[0][i]-1][t[1][i]-1] + ")");
      min += graph[t[0][i]-1][t[1][i]-1];
    }
    System.out.println("* 경로의 총 비용: " + min);
    
  }
  
  
  public static void prim(int[][] c, int n, int[][] t, int vertex) {

    int[] from = new int[n]; // 현재 부분 배열이 어디로부터 연결된지 표시
    int[] dist = new int[n]; //현재 부분 배열의 각 정점마다의 가중치를 표시
     
    for(int i = 0; i < n; i++) { // 최초 시작정점은 첫번째 정점
      from[i] = vertex;
      dist[i] = c[vertex][i];
    }
     
    for(int i = 0; i < n-1; i++) { 
       
      int best = isBest(dist); 
      t[0][i] = from[best]+1; 
      t[1][i] = best+1;
      dist[best] = 0; 
       
      for(int j = 1; j < n; j++) { // dist배열과 from배열 갱신
        if(c[best][j] < dist[j]) { 
          from[j] = best;
          dist[j] = c[best][j];
        }
      }
    }
  }
 
  // 최적인지 확인
  public static int isBest(int[] dist) { 
    int best = 0;
     
    for(int i = 0; i < dist.length; i++)
    	if(dist[i] > 0) {
        best = i;
        break;
      }
    
     
    for(int j = 0; j < dist.length; j++) { 
      if(dist[j] !=0 && dist[j] < dist[best]) {
        best = j;
      }
    }
         
    return best;
  }
   
   
}
