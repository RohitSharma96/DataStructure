package com.practice;
import java.util.*;
import java.util.Map.Entry;
import java.lang.*; 
  
public class HashMapSorting { 
  
    // function to sort hashmap by values 
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Integer> > list = 
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> o1,  
                               Map.Entry<String, Integer> o2) 
            { 
            	/*if(o1.getValue().equals(o2.getValue())){
            		 int sortIfEqual(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2){
            			if(o1.getKey())
            		}
            	}*/
                if( (o1.getValue()) >(o2.getValue())){
                		return -1;
                }
                return 1;
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 
    public static String[] GetStringArray(ArrayList<String> arr) 
    { 
  
        // Convert ArrayList to object array 
        Object[] objArr = arr.toArray(); 
  
        // convert Object array to String array 
        String[] str = Arrays 
                           .copyOf(objArr, objArr 
                                               .length, 
                                   String[].class); 
  
        return str; 
    } 
  
    // Driver Code 
    public static void main(String[] args) 
    { 
    	Scanner sc= new Scanner(System.in);
    	int input = sc.nextInt();
    	
        HashMap<String, Integer> hm = new HashMap<String, Integer>(); 
  
        // enter data into hashmap 
        hm.put("Apple", 1);
		hm.put("Bango", 2);
		hm.put("Brapse", 2);
		hm.put("Banana", 3);
		hm.put("H", 2);
       //Got the sorted map based on the values in hm1
		Map<String, Integer> hm1 = sortByValue(hm); 
		//Took all the values and pushed into the Set
        List<Integer> list = new ArrayList<>();
        list.addAll(hm1.values());
        List<String> outputString = new ArrayList<String>();
        Set<Integer> hashSet = new HashSet<>();
        for(int i = 0 ; i < list.size(); i++){
        	//Checking if it is unique
        	if(!hashSet.contains(list.get(i))){
        		hashSet.add(list.get(i));
        		int listNumber = list.get(i);
        		ArrayList<String> alist = new ArrayList<>();
        		for(Map.Entry<String,Integer> entry : hm.entrySet()){
        			//Getting all the keys with same values for e.g value is 2 and keys are apple and mango
        			if(entry.getValue().equals(listNumber)){
        				alist.add(entry.getKey());
        			}
        		}
        		
        		String[] inputArr = GetStringArray(alist);
        		//Soting the list
        		for(int k = 0; k<inputArr.length-1; k++) {
        	         for (int j = k+1; j<inputArr.length; j++) {
        	            if(inputArr[k].compareTo(inputArr[j])>0) {
        	               String temp = inputArr[k];
        	               inputArr[k] = inputArr[j];
        	               inputArr[j] = temp;
        	            }
        	         }
        	      }
        		//Adding to the finalString
        		outputString.add(inputArr[0]);

        	}
        }
        
        //Print according to the input
        if(input >=1 && input < outputString.size()){
        for(int i = 0 ; i <input;i++){
        	System.out.println(outputString.get(i));
        }
        }
 
    } 
} 