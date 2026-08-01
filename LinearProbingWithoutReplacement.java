import java.util.*;
public class LinearProbingWithoutReplacement{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Hash table Size:");
        int n= sc.nextInt();
        
        int key[]= new int[n];
        int HashTable[]= new int[n];
        boolean check[]= new boolean[n];
        System.out.println("Enter keys:");

        for(int i=0;i<n; i++){
            key[i]=sc.nextInt();
        }
        for(int i=0; i<n; i++){
            int b= key[i]%n;
            if(!check[b]){
                HashTable[b]= key[i];
                check[b]=true;
            }
            else{
                int j=0;
                while(j<n){
                    int b1= (b+j)%n;
                    if(!check[b1]){
                        HashTable[b1]=key[i];
                        check[b1]=true;
                        break;
                    }
                    j++;
                }
            }
        }
        System.out.println("Hash Table:");
        for(int i=0; i<n; i++){
            System.out.println(i+"-->"+HashTable[i]);
        }
        
        sc.close();
    }
    
}
