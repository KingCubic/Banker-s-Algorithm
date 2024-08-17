//Boston Woods
//4/6/2022
//Banker's algorithm for Operating Systems
public class BankersLab
{ 
    int[][] maxR; 
    int[][] allocated; 
    int[] available; 
    int numProcess = 5; 
    int numResources = 3;
    int need[][] = new int[numProcess][numResources]; 
    int safe[] = new int[numProcess]; 
  
    
    
    void printMatrix(int[][] a) {
    	for(int i = 0; i < a.length; i++) {
    		for (int j = 0; j < a[0].length; j++) {
    			System.out.print(a[i][j] + " ");
    		}    		
    		System.out.println();
    	}
    	System.out.println();
    }
    
    void SafetyAlgorithm() 
    { 
    int k=0; 
    boolean isDone[] = new boolean[numProcess];  
          
    //Temp array to hold a copy of the available array
    int temp[] = new int[numResources];     
    for (int i = 0;i < numResources; i++) 
    { 
        temp[i] = available[i]; 
    } 
  
    while (k<numProcess) 
    { 
        boolean flag = false; 
        for (int i = 0;i < numProcess; i++) 
        { 
            if (isDone[i] == false) 
            { 
            	int j; 
            	for (j = 0;j < numResources; j++) 
            	{        
            		if (need[i][j] > temp[j]) 
            			break; 
            	}
            	
            	if (j == numResources) { 
            		safe[k++]=i; 
            		isDone[i]=true; 
            		flag=true; 
            		for (j = 0;j < numResources; j++) { 
            			temp[j] = temp[j] + allocated[i][j]; 
            		} 
            	} 
             } 
        }
        
        if (flag == false) 
        { 
            break; 
        }
        
    } 
    if (k < numProcess) 
    { 
        System.out.println("System is unsafe, exiting..."); 
    } 
    else
    { 
        System.out.println("Safe sequence:"); 
        for (int i = 0;i < numProcess; i++) 
        { 
            System.out.print("p" + safe[i]); 
            if (i != numProcess-1) 
            System.out.print(" "); 
        }
        System.out.println();
    } 
    } 
  
    public static void main(String[] args) 
    {   
      BankersLab Test = new BankersLab(); 
      
      //Initialize arrays
      Test.allocated = new int[][] { { 1, 0, 2 },     
                    				 { 3, 1, 0 }, 
                    				 { 0, 1, 1 }, 
                    				 { 1, 0, 1 }, 
                    				 { 1, 0, 2 } }; 
                    
      Test.maxR = new int[][] { { 6, 5, 3 },  
               					{ 4, 2, 1 },  
               					{ 5, 1, 2 }, 
               					{ 1, 0, 2 },  
               					{ 5, 2, 3 } }; 
               					
      Test.available = new int[] { 7, 5, 7 };    
      
      for (int i = 0;i < Test.numProcess; i++) 
      { 
          for (int j = 0;j < Test.numResources; j++) 
           { 
        	  Test.need[i][j] = Test.maxR[i][j]-Test.allocated[i][j]; 
           } 
      }       
      
      System.out.println("Given the following allocation matrix: ");
      Test.printMatrix(Test.allocated);
      System.out.println("Given the following Max matrix: ");
      Test.printMatrix(Test.maxR);
      System.out.println("Given the following Need matrix: ");
      Test.printMatrix(Test.need);
      System.out.println("\nAvailable array: ");
      for(int i: Test.available) {
      		System.out.print(i + " ");
      }
      System.out.println("\n");
      Test.SafetyAlgorithm();  
      

  	
    } 
} 
