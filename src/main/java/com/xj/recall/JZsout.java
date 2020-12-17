package com.xj.recall;

/*

输出矩阵

 */
public class JZsout {

    public boolean isOK(int[][] y){
        // 判断是否遍历完
        boolean flag = true ;
        for (int i =0;i<y.length;i++)
        {
            for(int j=0;j<y[0].length;j++){
                if(y[i][j]==0){
                    flag = false;
                }
            }
        }
        return flag;
    }


    public int way(int[][] x ,int[][] y , int a,int b ,int n){
        if(a<0||b<0||a>=y.length||b>=y[0].length||y[a][b]!=0) return -1; //越界返回
        y[a][b]=n;
        if(isOK(y)){
            return 1;
        }

        //递归
        if(way(x,y,a+1,b,n+1)==0){y[a+1][b]=0;}
        if(way(x,y,a-1,b,n+1)==0){y[a-1][b]=0;}
        if(way(x,y,a,b+1,n+1)==0){y[a][b+1]=0;}
        if(way(x,y,a,b-1,n+1)==0){y[a][b-1]=0;}

        if(isOK(y)){
            return 1;
        }
        return 0;
    }


    public static void main(String[] args) {
        int[][] x = new int[4][5];
        int[][] y = new int[4][5];
        int n=0;
        for(int i=0;i<4;i++,n++){
            for(int j=0;j<5;j++,n++){
                x[i][j]=n;
            }
        }
        JZsout jZsout = new JZsout();
        jZsout.way(x,y,2,1,1);
        for(int i=0;i<4;i++,n++){
            for(int j=0;j<5;j++,n++){
                System.out.print(y[i][j]+" ");
            }
            System.out.println();
        }
    }
}
