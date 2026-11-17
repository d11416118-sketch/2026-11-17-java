import java.util.Scanner;

public class A2 {
    public static void main(String[] args) {
        int[] a=new int[4];
        int[] b=new int[4];
        int p,q,pq,cp=0,cq=0 ;
        int[] number={1023,1034,1305,5103,2193};
        int goal=number[0];
        int count=0;
        for(int j=0;j<number.length;j++){
            if(number[j]!=1){
                goal=number[j];
                number[j]=1;
                System.out.printf("answer-%d\n",goal);
                pq=input_answer();
                cp=pq/10;
                cq=pq%10;

                for(int i=0 ; i<number.length ; i++){
                cut(number[i],a);
                cut(goal,b);
                pq=compare(a,b);
                p=pq/10;
                q=pq%10;
                if ((p == cp)&&(cq == q)) {
                    System.out.printf("%-6d ==> %dA %dB \n",number[i],p,q);
                }
                else{
                    number[i]=1;
                }
            }
            }
            
            
        }
        
        
    }
    public static void cut(int x,int[] a) {
          a[3] = x / 1000;        
          a[2] = (x / 100) % 10;  
          a[1]= (x / 10) % 10;   
          a[0]= x % 10; 
    }
    public static int compare(int[] a,int[] b){
        int p=0,q=0;
        for(int i=0;i<a.length;i++){ //a[]
            for(int j=0;j<b.length;j++){ //b[]
                if(a[i]==b[j]){
                    if(i==j){
                        p++;
                    }
                    else{
                        q++;
                    }
                }
            }
           
        }
         return p*10+q;
    }
    public static int input_answer() {
        int p,q;
        Scanner sc=new Scanner(System.in);
        System.out.print("A= ");
        p=sc.nextInt();
        System.out.print("B= ");
        q=sc.nextInt();
        return p*10+q;
    }
}
