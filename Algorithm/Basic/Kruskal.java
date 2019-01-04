import java.util.Arrays;

// 크루스칼 알고리즘
public class Kruskal {
	static int total = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int V = 8;	// 점의 수
		int E = 11;	// 선의 수
		Kruskal graph = new Kruskal(V, E);
		
		// 1-2
		graph.edge[0].src = 0;
		graph.edge[0].dest = 1;
		graph.edge[0].weight = 6;
		
		// 1-3
		graph.edge[1].src = 0;
		graph.edge[1].dest = 2;
		graph.edge[1].weight = 4;
		
		// 3-4
		graph.edge[2].src = 2;
		graph.edge[2].dest = 3;
		graph.edge[2].weight = 5;
		
		// 2-6
		graph.edge[3].src = 1;
		graph.edge[3].dest = 5;
		graph.edge[3].weight = 3;
		
		// 3-6
		graph.edge[4].src = 2;
		graph.edge[4].dest = 5;
		graph.edge[4].weight = 2;
		
		// 4-6
		graph.edge[5].src = 3;
		graph.edge[5].dest = 5;
		graph.edge[5].weight = 9;
		
		// 4-7
		graph.edge[6].src = 3;
		graph.edge[6].dest = 6;
		graph.edge[6].weight = 11;
		
		// 2-5
		graph.edge[7].src = 1;
		graph.edge[7].dest = 4;
		graph.edge[7].weight = 7;
		
		// 2-8
		graph.edge[8].src = 1;
		graph.edge[8].dest = 7;
		graph.edge[8].weight = 10;
		
		// 5-8
		graph.edge[9].src = 4;
		graph.edge[9].dest = 7;
		graph.edge[9].weight = 1;
		
		// 6-8
		graph.edge[10].src = 5;
		graph.edge[10].dest = 7;
		graph.edge[10].weight = 8;
				
		graph.KruskalMST();
		System.out.println("* 경로의 총 비용: " + total);
	}

	// Edge를 나타내는 클래스
	class Edge implements Comparable<Edge>{
		int src, dest, weight;
		// 가중치를 기준으로 edge를 정렬
		@Override
		public int compareTo(Edge compareEdge) {
			// TODO Auto-generated method stub
			return this.weight - compareEdge.weight;
		}
		
	};
	
	// 하위 집합을 나타내는 클래스
	class subset{
		int parent, rank;
	}
	
	int V, E;	
	Edge edge[];	// edge 배열 선언
	
	// V, E를 사용해 그래프 생성
	Kruskal(int v, int e) {
		// TODO Auto-generated constructor stub
		V = v;
		E = e;
		edge = new Edge[E];
		for(int i=0; i<e; ++i) {
			edge[i] = new Edge();
		}
	}
	
	// i -> 원소 집합을 찾기위한 함수
	int find(subset subsets[], int i) {
		// 부모를 찾아서 i로 루트로 만듬
		if(subsets[i].parent != i) {
			subsets[i].parent = find(subsets, subsets[i].parent);
		}
		
		return subsets[i].parent;
	}
	
	void Union(subset subsets[], int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);
		
		// 작은 등급의 트리 부착
		if(subsets[xroot].rank < subsets[yroot].rank) {
			subsets[xroot].parent = yroot;
		} else if(subsets[xroot].rank > subsets[yroot].rank) {
			subsets[yroot].parent = xroot;
		} else {	// 등급이 동일한 경우 루트 및 증분
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}
	// MST를 만드는 메인 함수
	void KruskalMST() {
		Edge result[] = new Edge[V];	// MST 저장 배열
		int e=0;	// 결과에 사용되는 변수
		int i=0;	// edge에 저장되는 index 변수
		for(i=0; i<V; ++i) {
			result[i] = new Edge();
		}
		// 모든 가장자리를 비결합적인 순서로 정렬
		// 주어진 그래프를 변경할 수 없는 경우, edge 복사본 생성
		Arrays.sort(edge);
		// V 하위 집합을 생성하기 위한 메모리 할당
		subset subsets[] = new subset[V];
		// 단일 요소로 V 하위집합 생성
		for(i=0; i<V; ++i) {
			subsets[i] = new subset();
		}
		for(int v=0; v<V; ++v) {
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}
		i = 0; // 다음 edge를 선택하는데 사용되는 index 변수
		
		while(e < V-1) {
			// 가장 작은 edge를 선택
			// 다음 반복에 대한 i변수 증가
			Edge next_edge = new Edge();
			next_edge = edge[i++];
			int x = find(subsets, next_edge.src);
			int y = find(subsets, next_edge.dest);
			// edge가 사이클이 안되는 경우, 결과에 포함된 결과를 포함하고 다음 edge에 대한 결과를 증가
			if(x != y) {
				result[e++] = next_edge;
				Union(subsets, x, y);
			}
		}
		System.out.println("<Kruskal's Algorithm>");
		
		for(i=0; i<e; ++i) {
			System.out.println((i+1) + "번째로 포함한 edge: v" + (result[i].src + 1) + " - v" + (result[i].dest + 1) + " (가중치: "+result[i].weight + ")");
			total += result[i].weight;
		}
	}

}