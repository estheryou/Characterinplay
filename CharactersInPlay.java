
import edu.duke.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Write a description of CharactersInPlay here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CharactersInPlay {
	private ArrayList<String> names;
	private ArrayList<Integer> counts;
	private int i;
	public CharactersInPlay() {
    	names = new ArrayList<String>();
    	counts = new ArrayList<Integer>();
	}
	public void update(String person){
   	int index = names.indexOf(person);
        	if (index == -1){
            	names.add(person);
            	counts.add(1);
        	}
        	else {
            	int freq = counts.get(index);
            	counts.set(index,freq+1);
        	}
	}
	public void findAllCharacters(){
 	names.clear();
 	counts.clear();
 	FileResource resource = new FileResource();
 	for(String s : resource.lines()){
        	int index = s.indexOf(".",0);
        	if (index != -1){
            	String pn=s.substring(0,index);
            	update(pn);
        	}
    	}
	}
 	public void charactersWithNumParts(int num1,int num2){  	
 	for(int index=0;index<names.size();index++){
     	int number=counts.get(index);
    	if((number>=num1) && (number <= num2)){
        	System.out.println("possible names "+names.get(index)+" "+counts.get(index));
     	}
  	}
	}	
	public int findMax(){
    	int max = counts.get(0);
    	int maxIndex = 0;
    	for(int k=0; k < counts.size(); k++){
        	if (counts.get(k) > max){
           	max = counts.get(k);
            	maxIndex = k;
        	}
    	}
    	return maxIndex;
	}
	public void tester(){
 	System.out.println("this is a new test");
 	findAllCharacters();
 	System.out.println("# unique names: "+names.size()+counts.size()+i);
 	int num1=10;
 	int num2=15;
 	charactersWithNumParts(10,15);
 	int index = findMax();
 	System.out.println("max word/freq: "+names.get(index)+" "+counts.get(index));
	}
	
	}



