
import java.util.Scanner;

public class Floyd {
	static int MAX = 10;
	int DUM = 99;
	int P[][] = new int[MAX][MAX];
	static int[][] D = new int[MAX][MAX]; // 각 정점들 사이의 최단 거리 
    static int[][] W = new int[MAX][MAX]; // 엣지의 가중치
    int start, end; // 사용자 입력을 받을 변수

    
    public Floyd(int start, int end){
    	this.start =start;
    	this.end = end;
    	
    	//P 0: 서울, 1: 원주, 2: 강릉, 3: 천안, 4: 대전, 5: 대구, 6: 포항
    	//P 7: 논산, 8: 광주, 9: 부산
        // W 배열 값 초기화 
    	
    	//서울
        W[0][0] = 0; W[0][1] = 15; W[0][2] = DUM; W[0][3] = 12; W[0][4] = DUM;
        W[0][5] = DUM; W[0][6] = DUM; W[0][7] = DUM; W[0][8] = DUM; W[0][9] = DUM; 
        
        // 원주
        W[1][0] = 15; W[1][1] = 0; W[1][2] = 21; W[1][3] = DUM; W[1][4] = DUM;
        W[1][5] = 7; W[1][6] = DUM; W[1][7] = DUM; W[1][8] = DUM; W[1][9] = DUM;
        
        // 강릉
        W[2][0] = DUM; W[2][1] = 21; W[2][2] = 0; W[2][3] = DUM; W[2][4] = DUM;
        W[2][5] = DUM; W[2][6] = 25; W[2][7] = DUM; W[2][8] = DUM; W[2][9] = DUM;
        
        // 천안
        W[3][0] = 12; W[3][1] = DUM; W[3][2] = DUM; W[3][3] = 0; W[3][4] = 10;
        W[3][5] = DUM; W[3][6] = DUM; W[3][7] = 4; W[3][8] = DUM; W[3][9] = DUM;
        
        // 대전
        W[4][0] = DUM; W[4][1] = DUM; W[4][2] = DUM; W[4][3] = 10; W[4][4] = 0;
        W[4][5] = 10; W[4][6] = DUM; W[4][7] = 3; W[4][8] = DUM; W[4][9] = DUM;

        // 대구
        W[5][0] = DUM; W[5][1] = 7; W[5][2] = DUM; W[5][3] = DUM; W[5][4] = 10;
        W[5][5] = 0; W[5][6] = 19; W[5][7] = DUM; W[5][8] = DUM; W[5][9] = 9;
        
        // 포항
        W[6][0] = DUM; W[6][1] = DUM; W[6][2] = 25; W[6][3] = DUM; W[6][4] = DUM;
        W[6][5] = 19; W[6][6] = 0; W[6][7] = DUM; W[6][8] = DUM; W[6][9] = 5;
        
        // 논산
        W[7][0] = DUM; W[7][1] = DUM; W[7][2] = DUM; W[7][3] = 4; W[7][4] = 3;
        W[7][5] = DUM; W[7][6] = DUM; W[7][7] = 0; W[7][8] = 13; W[7][9] = DUM;
        
        // 광주
        W[8][0] = DUM; W[8][1] = DUM; W[8][2] = DUM; W[8][3] = DUM; W[8][4] = DUM;
        W[8][5] = DUM; W[8][6] = DUM; W[8][7] = 13; W[8][8] = 0; W[8][9] = 15;
        
        // 부산
        W[9][0] = DUM; W[9][1] = DUM; W[9][2] = DUM; W[9][3] = DUM; W[9][4] = DUM;
        W[9][5] = 9; W[9][6] = 5; W[9][7] = DUM; W[9][8] = 15; W[9][9] = 0;
    }
    
    int[][] getP(){
    	return this.P;
    }
    
    int[][] getD(){
    	return this.D;
    }
    
    int[][] getW()
    {
    	return this.W;
    }
    
    int getMax()
    {
    	return this.MAX;
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  // 입력 받기위한 Scanner 생성
	      Scanner input = new Scanner(System.in);
	      int start = 0, end = 0;
	      String start_city, end_city;
	      
	      System.out.print("시작 도시 입력: "); // 경로 시작점 입력 받기
	      
	    	//P 0: 서울, 1: 원주, 2: 강릉, 3: 천안, 4: 대전, 5: 대구, 6: 포항
	    	//P 7: 논산, 8: 광주, 9: 부산
	      
	      start_city = input.nextLine();
	      switch(start_city) {
	      case "서울": start = 0; break;
	      case "원주": start = 1; break;
	      case "강릉": start = 2; break;
	      case "천안": start = 3; break;
	      case "대전": start = 4; break;
	      case "대구": start = 5; break;
	      case "포항": start = 6; break;
	      case "논산": start = 7; break;
	      case "광주": start = 8; break;
	      case "부산": start = 9; break;
	      default: break;
	      }
	      //start = input.nextInt()-1;
	      
	      input = new Scanner(System.in);
	      System.out.print("끝 도시 입력: "); // 경로 끝점 입력 받기
	      end_city = input.nextLine();
	      switch(end_city) {
	      case "서울": end = 0; break;
	      case "원주": end = 1; break;
	      case "강릉": end = 2; break;
	      case "천안": end = 3; break;
	      case "대전": end = 4; break;
	      case "대구": end = 5; break;
	      case "포항": end = 6; break;
	      case "논산": end = 7; break;
	      case "광주": end = 8; break;
	      case "부산": end = 9; break;
	      default: break;
	      }
	      //end = input.nextInt()-1;
	     
	      Floyd fw = new Floyd(start, end);
		fw.floyd2(start, end, fw.getW(), fw.getP());
		System.out.print("최단 경로 상의 정점들: "); 
		System.out.print(" " + start_city);
		fw.path(start, end);
		System.out.println(" - " + end_city);
		
		System.out.println("* 최단 경로의 길이: " + D[start][end]);

	}
	
	void floyd2(int m, int n, int W[][], int P[][]){
		for(int i = 0; i < MAX; i++)
			for(int j = 0; j < MAX; j++)
				P[i][j] = 0;
		
		D = W;
		 // 초기 상태 출력
	      System.out.println("---Start---------");
	      System.out.print("  ");
	      for(int s = 0; s < MAX; s++) 
	         System.out.print("  "+ (s+1));
	      System.out.println("\n-----------------");
	      for(int i = 0; i < MAX; i++) {
	         System.out.print((i+1) + "| ");
	         for(int j = 0; j < MAX; j++) {
	            System.out.printf("%2d ", D[i][j]); // 배열값 출력
	         }
	         System.out.println(); // 줄바꿈
	      }
	      System.out.println("----------------- \n");

		
		for(int k = 0; k < MAX; k++){
			System.out.println("---D(" + (k+1) + ")----------");
			System.out.print("  ");
			for(int s = 0; s < MAX; s++) 
		         System.out.print("  "+ (s+1));
			System.out.println("\n-----------------");
			for(int i = 0; i < MAX; i++){
				System.out.print((i+1) + "| ");
				for(int j = 0; j < MAX; j++){
					if (D[i][k] + D[k][j] < D[i][j]){
						P[i][j] = k;
						D[i][j] = D[i][k] + D[k][j];
					}
					System.out.printf("%2d ", D[i][j]);
				}
				System.out.println(); // 줄바꿈
			}
			System.out.println("----------------- \n");
		}
	}
	
	void path(int q, int r){
		if(this.P[q][r] != 0){
			
			path(q, this.P[q][r]);
			
			String city = "";
		      switch(this.P[q][r]) {
		      case 0: city = "서울"; break;
		      case 1: city = "원주"; break;
		      case 2: city = "강릉"; break;
		      case 3: city = "천안"; break;
		      case 4: city = "대전"; break;
		      case 5: city = "대구"; break;
		      case 6: city = "포항"; break;
		      case 7: city = "논산"; break;
		      case 8: city = "광주"; break;
		      case 9: city = "부산"; break;
		      default: break;
		      }
			
			System.out.print(" - " + (city));
			path(this.P[q][r], r);

		}

	}
}