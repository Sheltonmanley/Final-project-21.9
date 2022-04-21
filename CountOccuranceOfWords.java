
import java.util.HashMap;
import java.util.*;

public class CountOccuranceOfWords {
	 // set text in a string

    String text = "Good Morning. Have a good class. Have a good visit. Have fun!";

    // create a Hashmap to hold words as a key and count as value- name it map to work with rest of the code here

    HashMap< String, Integer > map = new HashMap< String, Integer >();

    String[] words = text.split("[\n\t\r.,;:!?(){} ]+");

    for ( int i = 0; i < words.length; i++ )
    {

        String key = words[ i ].toLowerCase();
        // Check for word in map and if present, increment count, else add with a count of one

        if ( !map.containsKey(key) ) {

            map.put(key, 1);
        }
        else {

            int value = map.get(key);
            map.put(key, value + 1);
        }

//        System.out.println(words[ i ]);
    }

   /* // Print each key and the value associated with it

    for ( Map.Entry< String, Integer > entry : map.entrySet() ) {

        if ( entry.getKey().length() < 4 ) {

            System.out.println(entry.getKey() + "\t\t\t" + entry.getValue());
        }
        else {

            System.out.println(entry.getKey() + "\t\t" + entry.getValue());
        }
    }*/
  
    Map<String, Integer> hm1 = sortByValue(map);

    // print the sorted hashmap
    for (Map.Entry<String, Integer> en : hm1.entrySet()) {
        System.out.println("Key = " + en.getKey() +
                      ", Value = " + en.getValue());

    }
  
  
  
}
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
           return (o1.getValue()).compareTo(o2.getValue());
       }
   });
  
   // put data from sorted list to hashmap
   HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
   for (Map.Entry<String, Integer> aa : list) {
       temp.put(aa.getKey(), aa.getValue());
   }
   return temp;
}
