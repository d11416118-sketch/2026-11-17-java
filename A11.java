public class A11 {
    public static void main(String[] args) {
        int[] number = new int[9877];
        int flag ;
        for(int i=0;i<1023;i++){
            number[i]=1;
        }
        for(int i=1023 ; i<number.length ; i++){
            flag = check_4(i);
            if(flag==1){
                number[i]=1;
            }
        }    
        print_addr(number);
    }
    public static void print_addr(int[] number) {
        int count =0;
        for(int i=0 ; i<number.length ; i++){
            if(number[i]==0){
                System.out.printf("%6d ",i);
                if(count++%10==0){
                    System.out.println();
                }
            }
        }
    }
    public static int check_4(int x) {
        /*
        int a = x / 1000;        
        int b = (x / 100) % 10;  
        int c = (x / 10) % 10;   
        int d = x % 10;          

    
        if (a == b || a == c || a == d || b == c || b == d || c == d) {
            return 1;
        } else {
            return 0;
        }
        */
        int[] a=new int[4];
        int[] b=new int[4];
        
        int flag ;
        cut(x,a);
        cut(x,b);
        return  repate(a,b) ;

    }
    public static int compare(int[] a,int[] b) {
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
            return p*10+q;
        }
    }
    public static void cut(int x,int[] a) {
          a[3] = x / 1000;        
          a[2] = (x / 100) % 10;  
          a[1]= (x / 10) % 10;   
          a[0]= x % 10; 
    }
    public static int repate(int[] a,int[] b) {
         int flag=0;
            for(int i=0;i<a.length;i++){ 
                for(int j=0;j<b.length;j++){
                    if(i==j){
                        if(a[i]==b[j]){
                            flag = 1 ;
                        }
                    
                    }
                }
            }
            return flag;
    }
}