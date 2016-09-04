import edu.duke.*;
import java.util.*;

/**
 * Write a description of codoncount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CodonCount {
  private HashMap<String,Integer> DNA;
  public CodonCount(){
      DNA=new HashMap<String,Integer>();
    }
  public void buildCodonMap(int start,String dna){
    DNA.clear();
    int length=dna.length();
    dna=dna.substring(start,length);
    int length2=dna.length();
    for(int i=0;i<length2-3;i=i+3){
      String s=dna.substring(i,i+3);
      if(DNA.keySet().contains(s)){
        DNA.put(s,DNA.get(s)+1);
        }
      else{
         DNA.put(s,1);
        }
    }
    }
  public String getMostCommonCodon(){
    int max=0;
    String mostCommon= new String();
     for(String w:DNA.keySet()){
     int occurances=DNA.get(w);
     if(max<=occurances){
        mostCommon=w;
        }
    }
    return mostCommon;
    }
  public void printCodonCounts(int start,int end){
      for(String w:DNA.keySet()){
        int occurances=DNA.get(w);
        if(occurances>=start && occurances<=end){
        System.out.println(w+"\t"+occurances);
        }
    }
   }
  public void tester(){
     FileResource fr=new FileResource();
     String f=fr.asString();
     String dna=f.toUpperCase();
     int num1=5;
     int num2=7;
     //frame 0
     System.out.println("for frame starts from 0 :");
     buildCodonMap(0,dna);
     String f1=getMostCommonCodon();
     System.out.println("for frame stars from 0 the most common codon:"+f1);
     //printCodonCounts(num1,num2);
     //System.out.println("size for 0"+"/t"+DNA.size());
     //frame 1
     System.out.println("for frame starts from 1 :");
     buildCodonMap(1,dna);
     String f2=getMostCommonCodon();
     System.out.println("for frame stars from 1 the most common codon:"+f2);
     printCodonCounts(num1,num2);
     System.out.println("size for 1"+"/t"+DNA.size());
     //frame 2
     System.out.println("for frame starts from 2 :");
     buildCodonMap(2,dna);
     String f3=getMostCommonCodon();
     System.out.println("for frame stars from 2 the most common codon:"+f3);
     //printCodonCounts(num1,num2);
     //System.out.println("size for 2"+"/t"+DNA.size());
   }
}
