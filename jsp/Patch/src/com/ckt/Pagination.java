package com.ckt;

import java.sql.*;

/*
 * 
 * @author MM
 */
public class Pagination {
    private int     current_Pages;  // 当前页数 
    private int     total_Pages;    // 总页数
    private int     page_record;    // 设置每页显示记录数  
   
  
    
    public int current_Pages(String strPage)
    {
        try
        {
            if (strPage == null)
            {
            	// 默认没有就设置是第一页
                current_Pages = 1;
            }
            else
            {
                current_Pages = Integer.parseInt(strPage);// 取得strPage的整数值
                if ( current_Pages < 1 ) // 如果小于1,同样返回是第一页
                {
                    current_Pages = 1;
                }
            }
        }
        catch (Exception e)
        {
            System.out.print ("current_Pages");
        }
        return current_Pages;// 返回页面数  
    }
    
    public int getTotal_Pages (int total_record)  
    {  
        int test;// 变量  
        test = total_record % page_record;// 取得余数  
        if (test == 0)
        {
            total_Pages = total_record / page_record;// 每页显示的整数
        }
        else
        {
            total_Pages = total_record / page_record + 1;// 不是整数就加一 
        }
        return total_Pages;
    }
    
    public ResultSet getPageSet (ResultSet rs, int current_Pages)  
    {  
        if (current_Pages == 1)  
        {
            return rs;// 如果就一页，就返回这个rs
        }
        else  
        {
            int i = 1;
            try
            {
                while (rs.next ())  
                {
                    i = i + 1;
                    if ( i > ((current_Pages - 1)*page_record))
                    {
                        break;// 退出
                    }
                }
                return rs;// 从退出开始将结果集返回
            }
            catch (Exception e)
            {
                System.out.print (e.getMessage ());
            }
        }
        return rs;
    }
}
