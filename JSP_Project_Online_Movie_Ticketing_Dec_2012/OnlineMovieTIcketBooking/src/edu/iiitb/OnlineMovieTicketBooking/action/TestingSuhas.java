package edu.iiitb.OnlineMovieTicketBooking.action;

import java.util.Arrays;

public class TestingSuhas {

	/**
	 * @param args
	 */
	/*
	public static String getSorted(String s){
		String ret="";
		
		String ss[] = s.split(";");
		
		System.out.println(ss.length);
		
		int a[]=new int[ss.length];
		
		
		for(int i=0;i<=ss.length-1;i++){
			System.out.println(i);
			
			a[i]=Integer.parseInt(ss[i]);
			
			
		}
		
		
	/*for(int i=0;i<a.length;i++){
		for(int j=0;j<a.length-i;j++){
			
			if(a[i]>a[j]){
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
			
		}
	}
		System.out.println("B4");
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		
		Arrays.sort(a,0,a.length);
		
		System.out.println("After");
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]);
		}
		
		
	
	for(int i=0;i<a.length;i++){
		ret=ret+a[i];
		if(i<a.length-1)
		ret=ret+";";
	}
		
	
	
		return ret;
	}
*/
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		String textBoxSplitted[] = "15;19;14".split(";");

		String sortedTextBox;
		String temp;
		int countForSorting;
		
		countForSorting = 0;
		sortedTextBox = null;
		
		int index;
		
		//add for one seat only
		
		for(index = 0 ; index < textBoxSplitted.length ; index++){
			
			if ( Integer.parseInt(textBoxSplitted[index]) > Integer.parseInt(textBoxSplitted[index + 1]) ){
				
				//SWAP
				temp = textBoxSplitted[index] ; 
				textBoxSplitted[index ] = textBoxSplitted[index + 1];
				textBoxSplitted[index + 1] = temp;
			}
			
			if ( index == ( textBoxSplitted.length - 2 ) ){
				index = -1;
			}
			
			countForSorting++ ;
			
			if(countForSorting == ( textBoxSplitted.length ) * ( textBoxSplitted.length ) ){
				break;
			}
		}

		countForSorting = 0;
		for(index = 0; index < textBoxSplitted.length ; index++){
			
			if(countForSorting == 0)
				sortedTextBox = textBoxSplitted[index];
			else
				sortedTextBox = sortedTextBox + ";" + textBoxSplitted[index];
			
			countForSorting++ ;
		}
		
		System.out.println("sorting the text box input:   "+sortedTextBox);
		
		
		//System.out.println("Suhas -----> "+getSorted("15;19;14"));
		
		
		
	}

}
