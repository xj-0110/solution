package com.xj.recall;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class permute {

    public void backtrack(int first , List<Integer> output ,int n , List<List<Integer>> res){
        if(first==n){
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first ;i<n;i++){
            if(output.get(first)==output.get(i)&&first!=i){
                return;
            }
            Collections.swap(output,first,i);//交换
            backtrack(first+1,output,n,res);
            Collections.swap(output,first,i);//撤销

        }
    }


    public static void main(String[] args) {
        List<List<Integer>> res =new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        output.add(1);
        output.add(2);
        output.add(3);
        output.add(3);
        permute p = new permute();
        p.backtrack(0,output,output.size(),res);
        System.out.println(res.toString());
    }
}
