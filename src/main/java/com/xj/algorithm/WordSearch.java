package com.xj.algorithm;

public class WordSearch {
    public int exist_1(char[][] board,char[] words,boolean[][] booleans,int x,int y,int num){
        booleans[x][y]=false;
        if(num>=words.length){
            return 0;
        }
        if(num<words.length){
            if(x+1<board.length&&booleans[x+1][y]&&board[x+1][y]==words[num]){
                return exist_1(board,words,booleans,x+1,y,num+1)+0;
            }
            if(x-1>0&&booleans[x-1][y]&&board[x-1][y]==words[num]){
                return exist_1(board,words,booleans,x-1,y,num+1)+0;
            }
            if(y+1<board[0].length&&booleans[x][y+1]&&board[x][y+1]==words[num]){
                return exist_1(board,words,booleans,x,y+1,num+1)+0;
            }
            if(y-1>0&&booleans[x][y-1]&&board[x][y-1]==words[num]){
                return exist_1(board,words,booleans,x,y-1,num+1)+0;
            }
            return 1;
        }
        return 0;
    }

    public boolean exist(char[][] board, String word) {
        boolean flag=false;
        int lenX = board.length;//行
        int lenY = board[0].length; //列
        char[] words=word.toCharArray();  //字符数组
        System.out.println(words);
        int[] x=new int[lenX*lenY];
        int[] y =new int[lenY*lenX];
        boolean[][] bools= new boolean[lenX][lenY];
        for (int i=0;i<lenX;i++){
            for (int j=0;j<lenY;j++){
                bools[i][j]=true;
            }
        }
        int num=0;
        for (int i=0;i<lenX;i++){
            for (int j=0;j<lenY;j++){
                if(words[0]==board[i][j]){
                    x[num]=i;
                    y[num]=j;
                    num++;
                }
            }
        }

        if(num==0){
            return false;
        }
        else {
            for (int j =0;j<num;j++){
                if(exist_1(board,words,bools,x[j],y[j],1)==0){
                    flag=true;
                    break;
                }
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        long start,end;
        start = System.currentTimeMillis();

        WordSearch ws = new WordSearch();
        char[][] boards = {{'A','B','C','E'},{'S', 'F', 'C', 'S'},{'A', 'D', 'E', 'E'}};
        boolean bool = ws.exist(boards,"ABCB");
        System.out.println(bool);

        end = System.currentTimeMillis();
        System.out.println("start time:" + start+ "; end time:" + end+ "; Run Time:" + (end - start) + "(ms)");
    }
}
