/**
 * ArrayDictionary
 * Program to store values in a dictionary with attached accessor tags
 * Author: August Penny
 * Collaborator(s): The names of anyone you collaborated with here
 * Collaboration: Describe the collaboration that took place
 * Date: 2/24/22
 **/

import java.util.ArrayList;
import java.util.Collection;


public class ArrayDictionary <T,E> {
    private ArrayList<E> tags;
    private ArrayList<T> Vals;
    private int length=0;

    public ArrayDictionary() { //default constructor
        tags = new ArrayList<>();
        Vals = new ArrayList<>();
    }

    public void put(E tag, T value){ //adds a value to the value array list and a corresponding tag to the tag arraylist
        tags.add(tag);
        Vals.add(value);
        length++;
    }

    public T get(E tag){//returns a value given the corresponding tag
        if(tags.contains(tag)) {
            return Vals.get(tags.indexOf(tag));
        }
        return null;
    }

    public T remove(E tag){//removes a given value given its tag and returns the value deleted
        if(tags.contains(tag)){
            int temp=tags.indexOf(tag);
            tags.remove(tag);
            T temp2=Vals.get(temp);
            Vals.remove(temp);
            length--;
            return temp2;
        }
        return null;

    }

    public boolean contains(E tag){ //returns true if a value is stored somewhere in the array bssed on tag
        if(tags.contains(tag)){
            return true;
        } else {
            return false;
        }
    }


    public boolean isEmpty(){ //returns true if the object is empty, false if it is full
        if(tags.size()>0&&Vals.size()>0){
            return false;
        }
        return true;
    }


    public int size(){//returns the number of stored values
        return Vals.size();
    }

    public Collection<E> keys(){//returns tag array as a collection
        Collection temp = tags;
        return temp;
    }

    public Collection<E> values(){//returns vslues array as a collection
        Collection temp = Vals;
        return temp;
    }




}
