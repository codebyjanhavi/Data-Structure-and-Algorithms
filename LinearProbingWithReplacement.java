import java.util.*;
public class LinearProbingWithReplacement
{
    int ts;
    int ht[];
     LinearProbingWithReplacement(int ts){
        this.ts=ts;
        ht= new int[ts];
     }

     public void insert(int key){

        //case1:for empty slot
        int index= key%ts;//find array index by doing hashing
        if(ht[index]==0)//it means if there is any empty space in hashtable at finded index
        {
            ht[index]=key; //if empty_space=true, then place the key directly into the empty slot
            return;
        }

        //case2: for the slot occupied
        int existing= ht[index]; //if that index is already occupied by any other element then marks that element as exisiting
        int i= existing%ts; //find the reminder of existing element (here i means Existing index)
        if(i!=index){ //check that the exising index and current index should not be same
            ht[index]=key; //placed the key at ht[index]
            key=existing; //consider existing element as key
            }

        //case3: for displaed key
        int j=(index+1)%ts; //find next empty location
        while(j!=index){ //loop until back to starting index
            if(ht[j]==0){//empty slot found
                ht[j]=key; //place exisitng elemnt here that we have displaced because of actual owner
                return;
            }
            j=(j+1)%ts;//move to next slot
        }  
        System.out.println("Hash table is full cannot insert"+key);
    }
        void display(){
            System.out.println("Linear proning with replacement:");
            for(int i=0;i<ts;i++){
                System.out.println("index "+i+"->"+ht[i]);
            }
        }

     

    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Table size:");
        int ts= sc.nextInt();
        LinearProbingWithReplacement l= new LinearProbingWithReplacement(ts);
        System.out.println("Enter number of key");
        int n= sc.nextInt();
        System.out.println("Enter Key values:");
        for(int i=0;i<n;i++){
            int key=sc.nextInt();
            l.insert(key);
        }
          l.display();
       
          sc.close();

    }
}