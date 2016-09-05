import edu.duke.*;
import java.util.*;
import java.io.*;
/**
 * Write a description of WordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordsInFiles {
  private HashMap<String,ArrayList<String>> map;
  public WordsInFiles(){
    map=new  HashMap<String,ArrayList<String>>();
    }
  private void addWordsFromFiles(File f){
    FileResource fr = new FileResource(f.toString());
    String name = f.getName();
    for(String word:fr.words()){
     if(!map.containsKey(word)){
         map.put(word,new ArrayList<String>());
         map.get(word).add(name);
     }
     else {
         if(!map.get(word).contains(name)){
             map.get(word).add(name);
            }
        }
    }
   }
  public void buildWordFileMap(){
   map.clear();
   DirectoryResource files=new DirectoryResource();
   for(File f:files.selectedFiles()){
     addWordsFromFiles(f);
    }
   }
  public int maxNumber(){
     int max=0;
     String maxwords= new String();
     for(String key:map.keySet()){
          int size = map.get(key).size();
          if(max<=size){
             maxwords=key;
             max=size;
            }
        
        }
      return max;
    }
  public ArrayList<String> wordsInNumFiles(int number){
    ArrayList<String> num=new ArrayList<String>();
    for(String key: map.keySet()){
       if( map.get(key).size()==number){
         num.add(key);
        }
    }
    return num;
    }
  public void printFilesIn(String word){
      System.out.println("The files contain "+word+" are(is): \t");
      int length=map.get(word).size();
      for(int i=0;i<length;i++){
        System.out.println(map.get(word).get(i)+"\t");
    }
    }
  public void tester(){
    buildWordFileMap();
    int maxnumber=maxNumber();
    ArrayList<String> list=wordsInNumFiles(maxnumber);
    for(int k=0;k<list.size();k++){
        System.out.print(list.get(k)+"");
      }
      System.out.println("end for this word.");
    
    }  
  public void test2(){
    buildWordFileMap();
    int i=0;
    for(String word:map.keySet()){
      if(map.get(word).size()==5){i++;}
    }  
    System.out.println("the # of words that appear in alll is :"+i);
    }
  public void test3(){
    buildWordFileMap();
    printFilesIn("red");
    }
    }
