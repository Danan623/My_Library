package advent_of_code2022.day4;

import java.util.ArrayList;
import java.util.List;

/**
 * The MyListModifier class is a simple search and split implementation. 
 * I have not decided if the class should be fully generic (if it's even possible) or if I should make the class semi generic. in : generic , out : depends on the method used       
 * 
 * To use the MyListModifier class, create an instance of the class and specify the type of elements that the list will hold, for example:
 * 
 * MyListModifier<String> listmodifier = new MyListModifier<>();
 * 
 * You can then use the following methods to interact with the listmodifier instance:
 * 
 * - List<T> remove(T element1, T element2, T element3) : remove up to three different elements from a string (List<String>). Splits the string when element is found. add to a unique index.
 * - List<T> removeAndRetract(T element1, T element2, T element3) : remove up to three different elements from a string (List<String>). Retract the string sequence. add to a unique index.
 * - List<T> splitEach() : splits each string from a sequence (List<String>). add to a unique index.
 * {@link} https://github.com/Danan623/My_Library
 * @author Daniel Andersson
 * @param <T> the type of elements in the List
 */

public class MyListModifier<T>  {

    private List<T> list_in;
    
    public MyListModifier(List<T> list) {
        this.list_in = list;
    }
    /** time complexity O(n^2)
    * split each element in list of Strings.
    * Add each element to a unique index. 
    * select up to three different elements that you want to skip.
    * ex. in: ["10-*hjk9#2"] arg: ("-","*","#") -> out: ["10","hjk9","2"] 
    * @param element1 : element to skip
    * @param element2 : element to skip
    * @param element3 : element to skip
    * @return new List<T>
    */
    public List<T> remove(T element1, T element2, T element3){
        List<T> list_out = new ArrayList<>();
        String tmpS;
        String retract = "";

        for(T sequence : list_in){
            tmpS = (String) sequence;
            for(char c : tmpS.toCharArray()){
                String character = String.valueOf(c);
    
                if(character.equals((String) element1)){
                    if(!retract.equals("")){
                    list_out.add((T) retract);
                    retract = "";
                }
                    continue;
                }
                if(character.equals((String) element2)){
                    if(!retract.equals("")){
                    list_out.add((T) retract);
                    retract = "";
                }
                    continue;
                }
                if(character.equals((String) element3)){
                    if(!retract.equals("")){
                    list_out.add((T) retract);
                    retract = "";
                }
                    continue;
                }
                retract += character;   
            }
            list_out.add((T) retract);
            retract = "";
        }
        return list_out;
    }
    /** time complexity O(n^2)
     * split each element into a new index.
     * One index for each element.
     * @return List<T>
     */
    public List<T> splitEach(){
        List<T> list_out = new ArrayList<>();
        String tmpS;

        for(T sequence : list_in){
            tmpS = (String) sequence;
            for(char c : tmpS.toCharArray()){
                String character = String.valueOf(c);
                list_out.add((T) character);   
            }
            
        }
        return list_out;
    }
    /** time complexity O(n^2)
     * skip up to three elements
     * retract to a new generic sequence
     * adds the new sequence to an ArrayList<T> 
     * ex. in: ["10-*hjk9#2"] arg: ("-","*","#") -> out: ["10hjk92"]
     * @param element1 : element to skip
     * @param element2 : element to skip
     * @param element3 : element to skip
     * @return new List<T>
     */
    public List<T> removeAndRetract(T element1, T element2, T element3){
        List<T> list_out = new ArrayList<>();
        String tmpS; 
        String retract = "";

        for(T sequence : list_in){
            tmpS = (String) sequence;
            for(char c : tmpS.toCharArray()){
                String character = String.valueOf(c);
    
                if(character.equals((String) element1)){
                    continue;
                }
                if(character.equals((String) element2)){
                    continue;
                }
                if(character.equals((String) element3)){
                    continue;
                }
                retract += character;   
            }
            list_out.add((T) retract);
            retract = "";
        }
        return list_out;
    }




}
