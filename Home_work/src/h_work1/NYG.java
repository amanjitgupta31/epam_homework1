package h_work1;
import java.io.*;
import java.util.*;


interface Gift
{
	int getweight(int y);
	int getprice(int y);
	
}

class Sweets implements Gift
{
	String sweet_name[]= {"rasgulla","ladoo","peda","halwa","jalebi"};
	int sweet_pro[][]= {{300,270,150,250,200},{100,150,80,250,120}};
	public int find(String x)
	{
		int j;
		for(j=0;j<5;j++)
			{
				if(sweet_name[j].equals(x))
					{return(j);}
			}
		return (-1);
	}
	public int getweight(int y)
	{
		return (sweet_pro[0][y]);
	}
	public int getprice(int y)
	{
		return (sweet_pro[1][y]);
	}
}

class Choco implements Gift
{
	String choco_name[]= {"dairy milk","milkybar","kitkat","fuse","silk"};
	int choco_pro[][]= {{50,40,50,60,100},{50,50,40,100,100}};
	int find(String x)
	{
		int j;
		for(j=0;j<5;j++)
			{
				if(choco_name[j].equals(x))
					{return (j);}
			}
				return (-1);
	}
	
	public int getweight(int y)
	{
		return (choco_pro[0][y]);
	}
	
	public int getprice(int y)
	{
		return (choco_pro[1][y]);
	}
}

class Candies implements Gift
{
	String cn_name[]= {"eclairs","pulse","candy man","coffee bite","alpenleibe"};
	int cn_pro[][]= {{20,25,15,30,20},{25,20,20,15,25}};
	int find(String x)
	{
		int j;
		for(j=0;j<5;j++)
			{
				if(cn_name[j].equals(x))
					return (j);
			}
				return (-1);
	}
	public int getweight(int y)
	{
		return (cn_pro[0][y]);
	}
	public int getprice(int y)
	{
		return (cn_pro[1][y]);
	}
}



public class NYG 
{
	public static void main(String args[])
	{
	int i,item,temp=0,j;
	String tmp;
	Sweets sw=new Sweets();
	Choco cho=new Choco();
	Candies cn=new Candies();
	Scanner sc = new Scanner(System.in);
	System.out.println("total number of items in the gift? : ");
	item=sc.nextInt();
	item++;
	String gft[]=new String[item];
	int p[][]=new int[3][item];
	System.out.println("what contains the gift?(sweets->rasgulla,ladoo,peda,halwa,jalebi//chocolate->dairy milk,milkybar,kitkat,fuse,silk//candies->eclairs,pulse,candy man,coffee bite,alpenleibe) : ");
	for(i=0;i<item;i++)
		p[2][i]=0;
	for(i=0;i<item;i++)
	{      
	gft[i]=sc.nextLine();
	}
	for(i=1;i<item;i++)
	{
		int flag=-1;
		if(flag==-1)
		{
		flag=sw.find(gft[i]);
		if(flag!=-1)
		{
			temp=sw.getweight(flag);
			p[0][i]=temp;
			temp=sw.getprice(flag);
			p[1][i]=temp;
			continue;
		}
		}
		 if(flag==-1)
		{
			flag=cho.find(gft[i]);
			if(flag!=-1)
			{
				temp=cho.getweight(flag);
				p[0][i]=temp;
				temp=cho.getprice(flag);
				p[1][i]=temp;
				continue;
			}
		}
		if(flag==-1)
		{
			flag=cn.find(gft[i]);
			if(flag!=-1)
			{
				temp=cn.getweight(flag);
				p[0][i]=temp;
				temp=cn.getprice(flag);
				p[1][i]=temp;
				p[2][i]=3;
				
				continue;
			}
		}
	}
	System.out.println();
System.out.println("the candies in the gift are : ");
	for(i=1;i<item;i++)
	{
		if(p[2][i]==3)
			System.out.println(gft[i]);
	}
	System.out.println();
	System.out.println("total weight of the gift is : ");
	int wt=0;
	for(i=1;i<item;i++)
	{
		wt=wt+p[0][i];
	}
	System.out.println(wt);
	System.out.println();
	System.out.println("total price of the gift is : ");
	int sum=0;
	for(i=1;i<item;i++)
	{
		sum=sum+p[1][i];
	}
	System.out.println(sum);
	for (i = 1; i < item-1; i++)
    {
        for (j = i+1; j < item; j++)
            if (p[1][j] > p[1][i])
            {
        temp = p[1][j];
        p[1][j] = p[1][i];
        p[1][i] = temp;
        temp = p[0][j];
        p[0][j] = p[0][i];
        p[0][i] = temp;
        tmp = gft[j];
        gft[j] = gft[i];
        gft[i] = tmp;
    }
    }
	System.out.println();
	System.out.println("gift contents in their decreasing order of price : ");
	for(i=1;i<item;i++)
	{
		if(i==item-1)
			System.out.print(gft[i]);
		else System.out.print(gft[i]+" -> ");
	}
	
	

	}

}
