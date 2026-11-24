import java.util.Scanner;

public class A1 {
    /**
     * 主程式（猜數字反推）：使用者輸入幾 A 幾 B，把候選清單 number[] 逐一和目標 goal(1023) 比較，
     * 印出比對結果和輸入相同的候選數字。
     */
    public static void main(String[] args) {
        int[] a=new int[4];
        int[] b=new int[4];
        int goal=1023;
        int p,q,pq,cp,cq ;
        int[] number={1034,1305,5103,2193};
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
        }
        
    }
    /**
     * 把四位數 x 拆成各位數字存入陣列：
     * a[0] 個位、a[1] 十位、a[2] 百位、a[3] 千位（順序跟 11/03 版相反）。
     */
    public static void cut(int x,int[] a) {
          a[3] = x / 1000;        
          a[2] = (x / 100) % 10;  
          a[1]= (x / 10) % 10;   
          a[0]= x % 10; 
    }
    /**
     * 猜數字遊戲的 ?A?B 判定：比較兩組四位數字，
     * 數字相同且位置相同算 A，數字相同但位置不同算 B。
     * 回傳 A×10+B（十位數是 A、個位數是 B）。
     */
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
    /**
     * 分別讀入 A 與 B 的數量，合併成 A×10+B 一個整數回傳。
     */
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