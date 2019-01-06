import java.util.Random;

public class Sort {
	// 비교 횟수를 저장할 변수
	static int counts = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("<Data sets>");
		
		int[] set1 = new int[50]; // 1 ... 50
		int[] set2 = new int[50]; // 50 ... 1
		int[] set3 = new int[50]; // random numbers between 1 ... 300
		
		int[] set11 = new int[50]; // 1 ... 50
		int[] set22 = new int[50]; // 50 ... 1
		int[] set33 = new int[50]; // random numbers between 1 ... 300 

		Random rand = new Random();
		
		for(int i = 0; i < 50; i++) {
			set1[i] = i+1;
			set11[i] = set1[i];
			set2[i] = 50 - i;
			set22[i] = set2[i];
			set3[i] = rand.nextInt(300) + 1;
			set33[i] = set3[i];
		}
		
		// show data sets
		System.out.print("데이터 set1: ");
		for(int i = 0; i < 50; i++)
			System.out.print(set1[i] + " ");
		
		System.out.print("\n데이터 set2: ");
		for(int i = 0; i < 50; i++)
			System.out.print(set2[i] + " ");
		
		System.out.print("\n데이터 set3: ");
		for(int i = 0; i < 50; i++)
			System.out.print(set3[i] + " ");
		
		
		
		// Merge sort
		int[] sample = new int[50]; // temp array to save the result of Merge sort
		
		System.out.print("\n\n<Merge Sort>----------------------------------------------");
		
		
		
		// Set1
		System.out.print("\n1. set1 결과");
		double beforeTime = System.currentTimeMillis(); //코드 실행 전 시간
		
		MergeSort(set11, sample, 0, 49); // 합병 정렬 실행
		
		double afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간
		double secDiffTime = (afterTime - beforeTime)/1000.0; //두 시간 차
		
		//System.out.print("\n정렬된 데이터: " );
		//for(int i = 0; i < 50; i++) System.out.print(set11[i] + " ");
		System.out.print("\n소요 시간(s) : " + secDiffTime);
		System.out.print("\n비교 횟수: " + counts);
		counts = 0; // 비교횟수 초기화
		
		
		// Set2
		System.out.print("\n2. set2 결과");
		beforeTime = System.currentTimeMillis(); //코드 실행 전 시간
		
		MergeSort(set22, sample, 0, 49); // 합병 정렬 실행
		
		afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간
		secDiffTime = (afterTime - beforeTime)/1000.0; //두 시간 차
		
		//System.out.print("\n정렬된 데이터: " );
		//for(int i = 0; i < 50; i++) System.out.print(set22[i] + " ");
		System.out.print("\n소요 시간(s) : " + secDiffTime);
		System.out.print("\n비교 횟수: " + counts);
		counts = 0; // 비교횟수 초기화
		
		
		// Set3
		System.out.print("\n3. set3 결과");
		beforeTime = System.currentTimeMillis(); //코드 실행 전 시간
		
		MergeSort(set33, sample, 0, 49); // 합병 정렬 실행
		
		afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간
		secDiffTime = (afterTime - beforeTime)/1000.0; //두 시간 차
		
		//System.out.print("\n정렬된 데이터: " );
		//for(int i = 0; i < 50; i++) System.out.print(set33[i] + " ");
		System.out.print("\n소요 시간(s) : " + secDiffTime);
		System.out.print("\n비교 횟수: " + counts);
		counts = 0; // 비교횟수 초기화
		
	
		
		
		System.out.print("\n\n<Quick Sort>----------------------------------------------");
		

		
		// Set1
		System.out.print("\n1. set1 결과");
		beforeTime = System.currentTimeMillis(); //코드 실행 전 시간
		
		QuickSort(set1, 0, 49); // 빠른 정렬 실행
		
		afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간
		secDiffTime = (afterTime - beforeTime)/1000.0; //두 시간 차
		
		//System.out.print("\n정렬된 데이터: " );
		//for(int i = 0; i < 50; i++) System.out.print(set1[i] + " ");
		System.out.print("\n소요 시간(s) : " + secDiffTime);
		System.out.print("\n비교 횟수: " + counts);
		counts = 0; // 비교횟수 초기화
		
		
		// Set2
		System.out.print("\n2. set2 결과");
		beforeTime = System.currentTimeMillis(); //코드 실행 전 시간
		
		QuickSort(set2, 0, 49); // 빠른 정렬 실행
		
		afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간
		secDiffTime = (afterTime - beforeTime)/1000.0; //두 시간 차
		
		//System.out.print("\n정렬된 데이터: " );
		//for(int i = 0; i < 50; i++) System.out.print(set2[i] + " ");
		System.out.print("\n소요 시간(s) : " + secDiffTime);
		System.out.print("\n비교 횟수: " + counts);
		counts = 0; // 비교횟수 초기화
		

		// Set3
		System.out.print("\n3. set3 결과");
		beforeTime = System.currentTimeMillis(); //코드 실행 전 시간

		QuickSort(set3, 0, 49); // 빠른 정렬 실행

		afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간
		secDiffTime = (afterTime - beforeTime)/1000.0; //두 시간 차
		
		//System.out.print("\n정렬된 데이터: " );
		//for(int i = 0; i < 50; i++) System.out.print(set3[i] + " ");
		System.out.print("\n소요 시간(s) : " + secDiffTime);
		System.out.print("\n비교 횟수: " + counts);
		counts = 0; // 비교횟수 초기화
		
	}
	
	// Merge method
	private static void Merge(int[] items, int[] tmpArray, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int tmpIndex = left;
 
        while (left <= leftEnd && right <= rightEnd){
            if (items[left] < items[right] ){
                tmpArray[tmpIndex++] = items[left++];
                
            } else {
                tmpArray[tmpIndex++] = items[right++];
            }

        }
 
        while (left <= leftEnd) { // Copy rest of LEFT half
            tmpArray[tmpIndex++] = items[left++];
            counts++;
        }
        while (right <= rightEnd) { // Copy rest of RIGHT half
            tmpArray[tmpIndex++] = items[right++];
            counts++;
        }
        while(rightEnd >= 0){ // Copy TEMP back
            items[rightEnd] = tmpArray[rightEnd--];
            counts++;
        }
	}
	
	// Merge sort method
	private static void MergeSort(int[] items, int[] tmpArray, int left, int right) {
		if(items.length == 0 || left >= right){
            return;  //길이가 0 또는 왼쪽이 오른쪽보다 크거나 같을 때 종료
        }
 
        int middle = (left + right) / 2;  //if조건이 거짓일 때까지  반복
        
        //재귀함수
        MergeSort(items, tmpArray, left, middle);
        MergeSort(items, tmpArray, middle + 1, right); 
        Merge(items, tmpArray, left, middle + 1, right); // 병합
	}
	
	// Partition method for Quick sort
	private static int Partition(int items[], int left, int right) {
	    int pivot = items[right];
	    int i = left - 1;

	    for(int j = left; j <= right - 1; j++){
	    	counts++;
	        if (items[j] <= pivot){
	        	counts++;
	            i = i + 1;
	            int temp = items[i];
	            items[i] = items[j];
	            items[j] = temp;
	        }


	    }

	    int temp = items[i+1];
	    items[i+1] = items[right];
	    items[right] = temp;
	    
	    return i+1;
	}
	
	// Quick sort method
	private static void QuickSort(int items[], int left, int right) {
		
		 if (left < right){
			 	counts++;
		        int pivot;  
		        pivot = Partition(items, left, right);
		        QuickSort(items, left, pivot - 1);
		        QuickSort(items, pivot + 1, right);
		    }

	}

}
