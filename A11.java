public class A11 {
    /**
     * 主程式：找出 1023~9876 中「四個數字都不重複」的四位數，
     * 0~1022 先排除，其餘用 check_4() 檢查，有重複就排除，最後印出剩下的數字。
     */
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
    /**
     * 印出陣列中值為 0（沒被排除）的索引，也就是剩下的候選數字，每 10 個左右換一行。
     */
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
    /**
     * 檢查四位數 x 有沒有重複的數字，有重複回傳 1，沒有回傳 0。
     * （被註解掉的寫法是把四個位數兩兩比較。）
     * ※ 注意：目前把同一個 x 拆進 a、b 再交給 repate() 比對相同位置，結果永遠是 1；
     *   註解掉的兩兩比較寫法才能真正檢查重複。
     */
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
    /**
     * 猜數字遊戲的 ?A?B 判定：比較兩組四位數字，
     * 數字相同且位置相同算 A，數字相同但位置不同算 B。
     * 回傳 A×10+B（十位數是 A、個位數是 B）。
     * ※ 注意：return 寫在外層 for 迴圈裡面，會出現 missing return statement 無法編譯，
     *   要把 return p*10+q; 移到外層迴圈結束之後。
     */
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
     * 比較兩個陣列「相同位置」的數字，只要有任一位相同就回傳 1，否則回傳 0。
     */
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