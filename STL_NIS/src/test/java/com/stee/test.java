package com.stee;

 

 
 
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;

import com.mysql.fabric.xmlrpc.base.Array;
import com.stee.controller.NisController;
import com.stee.dto.Commands;
import com.stee.dto.Set;
import com.stee.gui.Gui;

public class test {
 
	public static void main(String[] args) throws InterruptedException {
		int r=(int)(Math.round(11.3));
		System.out.println(r);
		
		System.out.println(System.currentTimeMillis());
		long u=System.currentTimeMillis();
		
		 Thread.sleep(2000);
		 long  now=System.currentTimeMillis();
		 System.out.println(Math.round((now-u)/1000.0));
		
   int a[]={2,4,3,56,34,6373,22,222,111,1};
//   System.out.println(a.length);
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length-i-1;j++){
				if(a[j]>a[j+1]){
					int b=a[j];
					a[j]=a[j+1];
					a[j+1]=b;					
				}
			}
		}
		
	Arrays.sort(a);
	for(int b:a){
		System.out.print (b+"  ");
	}
	System.out.println();
	int b[]={2,4,3,56,34,6373,22,222,222,111,1};
	int m= a[0];
	int n=1;
	for(int i=0;i<b.length ;i++){
		if(b[i]>m){
			m=b[i];
			 n++;
		}
	}
	System.out.println(m+"  "+n);
	
	Map<Integer, String> map=new HashMap<Integer, String>();
	map.put(1, "ok");
	map.put(2, "error");
	System.out.println(map.get(2));		
	}
	Date date=new Date(); 
	SimpleDateFormat format=new SimpleDateFormat("");
}
