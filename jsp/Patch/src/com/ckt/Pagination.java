package com.ckt;

import java.sql.*;

/*
 * 
 * @author MM
 */
public class Pagination {
    private int     current_Pages;  // ��ǰҳ�� 
    private int     total_Pages;    // ��ҳ��
    private int     page_record;    // ����ÿҳ��ʾ��¼��  
   
  
    
    public int current_Pages(String strPage)
    {
        try
        {
            if (strPage == null)
            {
            	// Ĭ��û�о������ǵ�һҳ
                current_Pages = 1;
            }
            else
            {
                current_Pages = Integer.parseInt(strPage);// ȡ��strPage������ֵ
                if ( current_Pages < 1 ) // ���С��1,ͬ�������ǵ�һҳ
                {
                    current_Pages = 1;
                }
            }
        }
        catch (Exception e)
        {
            System.out.print ("current_Pages");
        }
        return current_Pages;// ����ҳ����  
    }
    
    public int getTotal_Pages (int total_record)  
    {  
        int test;// ����  
        test = total_record % page_record;// ȡ������  
        if (test == 0)
        {
            total_Pages = total_record / page_record;// ÿҳ��ʾ������
        }
        else
        {
            total_Pages = total_record / page_record + 1;// ���������ͼ�һ 
        }
        return total_Pages;
    }
    
    public ResultSet getPageSet (ResultSet rs, int current_Pages)  
    {  
        if (current_Pages == 1)  
        {
            return rs;// �����һҳ���ͷ������rs
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
                        break;// �˳�
                    }
                }
                return rs;// ���˳���ʼ�����������
            }
            catch (Exception e)
            {
                System.out.print (e.getMessage ());
            }
        }
        return rs;
    }
}
