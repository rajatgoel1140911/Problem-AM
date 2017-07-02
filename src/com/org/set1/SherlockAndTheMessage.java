package com.org.set1;

import java.util.HashMap;
import java.util.Scanner;

@SuppressWarnings(value = { "unchecked","rawtypes" })
class Trie{
	
	HashMap<Character,HashMap> hm;
	
	public Trie()
	{
		hm=new HashMap<Character,HashMap>();
	}
	
	public void addString(String s)
	{
		HashMap<Character,HashMap> tm=hm;
		
		for(int i=0;i<s.length();i++)
		{
			if(!tm.containsKey(s.charAt(i)))
			{
				tm.put(s.charAt(i),new HashMap());
			}
			
			tm=tm.get(s.charAt(i));
		}
		
		tm.put('\0',null);
		
	}
	

	public boolean contains(String s)
	{
		HashMap<Character,HashMap> tm=hm;
		for(int i=0;i<s.length();i++)
		{
			if(!tm.containsKey(s.charAt(i)))
			{
				return false;
			}
			tm=tm.get(s.charAt(i));
		}
		
		if(tm.containsKey('\0'))
			return true;
		
		return false;
	}
	
	
}

public class SherlockAndTheMessage {
public static void main(String[] args) {
	
	Scanner obj=new Scanner(System.in);
	
	int n=obj.nextInt();
	int m=obj.nextInt();
	
    Trie trie=new Trie();
    int count=0;
    
    for(int i=1;i<=n;i++)
    {
    	trie.addString(obj.next());
    }
    
    for(int i=1;i<=m;i++)
    {
    count=trie.contains(obj.next())?count+1:count;	
    }
	
    if(count==n)
    	System.out.println("YES");
    
    else
    	System.out.println("NO");
    
    obj.close();
	
}
}
