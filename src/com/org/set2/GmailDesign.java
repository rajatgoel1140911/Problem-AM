package com.org.set2;

import java.util.HashMap;
import java.util.Scanner;

class Node{
int data;
Node left;
Node right;	

Node(int x)
{
	this.data=x;
}

}



class DLL{
	
	HashMap<Integer,Node> hunread=new HashMap<Integer,Node>();
	HashMap<Integer,Node> hread=new HashMap<Integer,Node>();
	HashMap<Integer,Node> htrash=new HashMap<Integer,Node>();
	Node uhead;
	Node rhead;
	Node thead;
	Node uend;
	Node rend;
	Node tend;
	
	
	//build hunread and unread DLL
	void build(int n)
	{

		if(uhead==null)
		{
		uhead=new Node(1);
		hunread.put(1,uhead);
		uend=uhead;
		}
		
		for(int i=2;i<=n;i++)
		{
			Node p=new Node(i);
			p.left=uend;
			uend.right=p;
			hunread.put(i,p);
			uend=p;
		}
		
		//for trial only 
		//print(uhead);
	}


	public Node uDelete(int x)
	{
		Node p=hunread.remove(x);
		Node back=p.left;
		Node front=p.right;
		if(back==null)
		{
			uhead=front;
		}
		else{
			back.right=front;
			
			if(front!=null)
			front.left=back;
		}
		
		p.left=null;
		p.right=null;
		
		return p;
	}

	public Node tDelete(int x)
	{
		//remove from trash
		
		Node p=htrash.remove(x);
		Node back=p.left;
		Node front=p.right;
		if(back==null)
		{
			thead=front;
		}
		else{
			back.right=front;
			
			if(front!=null)
			front.left=back;
		}
		
		p.left=null;
		p.right=null;
		
		return p;
		
	}
	
	public Node rDelete(int x)
	{
		Node p=hread.remove(x);
		Node back=p.left;
		Node front=p.right;
		if(back==null)
		{
			rhead=front;
		}
		else{
			back.right=front;
			
			if(front!=null)
			front.left=back;
		}
		
		p.left=null;
		p.right=null;
		
		return p;
		
	}
	
	public void utot(int x) {
		//unread to trash
		if(thead==null)
		{
			thead=uDelete(x);
			tend=thead;
		}
		else{
			
			Node p=uDelete(x);
			tend.right=p;
		    p.left=tend;
		    tend=p;
		}
		
		htrash.put(x,tend);
		
	}



	public void ttor(int x) {
		//trash to read

		if(rhead==null)
		{
			rhead=tDelete(x);
			rend=rhead;
		}
		else{
			
			Node p=tDelete(x);
			rend.right=p;
		    p.left=rend;
		    rend=p;
		}
		
		hread.put(x,rend);
		
	}



	public void utor(int x) {
	//unread to read
		
		if(rhead==null)
		{
			rhead=uDelete(x);
			rend=rhead;
		}
		else{
			
			Node p=uDelete(x);
			rend.right=p;
		    p.left=rend;
		    rend=p;
		}
		
		hread.put(x,rend);
		
	}



	public void rtot(int x) {
		
		//read to trash
		if(thead==null)
		{
			thead=rDelete(x);
			tend=thead;
		}
		else{
			
			Node p=rDelete(x);
			tend.right=p;
		    p.left=tend;
		    tend=p;
		}
		
		htrash.put(x,tend);
		
		
	}
	
	//printing the answer
	
	void print(Node head)
	{
	if(head==null)
		System.out.println("EMPTY");
	
	else
	{
		Node p=head;
		while(p!=null)
		{
			System.out.print(p.data+" ");
			p=p.right;
		}
		System.out.println();
	}
		
	}
				
}

public class GmailDesign {
public static void main(String[] args) {
	
	Scanner obj=new Scanner(System.in);
	int n=obj.nextInt();
	int q=obj.nextInt();
   DLL mail=new DLL();
	mail.build(n);
	
	for(int i=1;i<=q;i++)
	{
		int a=obj.nextInt();
		int x=obj.nextInt();
		
		switch(a){
			
		case 1:
			
			mail.utor(x);
			break;
			
		case 2:
			
			mail.rtot(x);
			break;
			
        case 3:
			
			mail.utot(x);
			break;
			
		case 4:
			
			mail.ttor(x);
			break;	
		}
		
		
	}
	
	mail.print(mail.uhead);
	mail.print(mail.rhead);
	mail.print(mail.thead);
	
}
}
