
public class Utils {
    public static String getStringOnIndex(String str, int index, String separator) {
        if (index == 0) 
            return "";

        int current_index = 0;
        int index_last = 0;

        str = separator + str;

        while (true) {
            int index_next = str.indexOf(separator, index_last + 1);
            index_next = index_next < 0 ? str.length() : index_next;

            current_index++;

            if (index_next == index_last) 
                return "";

            String value = str.substring(index_last + 1, index_next);

            if (value.equals(separator)) 
                return "";
            if(current_index >= index) 
                return value;

            index_last = index_next;
        }
    }

    public static String insertStringOnIndex(String str, int index, String separator, String insert) {
        int index_current = 1;
        int indexSep_last = str.indexOf(separator);

        String string_modified = str;

        if (index == 0) 
            return insert + separator + str;

        while (indexSep_last != str.length() && indexSep_last > 0) {
            int indexSep_next = str.indexOf(separator, indexSep_last + 1);

            if (index_current == index) {
                string_modified = string_modified.substring(0, indexSep_last) 
                        + separator + insert  
                        + string_modified.substring(indexSep_last, str.length());

                break;
            }

            indexSep_last = indexSep_next;
            index_current++;
        }

        if ((indexSep_last < 0) && (index_current == index))
            return str + separator + insert;

        return string_modified;
    }

    public static String sortByAlphabet(String str, boolean ascending, String separator) {
        // insertion sort

        int index = 2;
        String item_last = str.substring(0, str.indexOf(separator) < 0 ? 0 : str.indexOf(separator));
        String arranged = item_last;

        while (true) {
            String item = getStringOnIndex(str, index, separator);

            if (item.isEmpty()) 
                break;

            if (item.compareTo(item_last) <= 0) {
                // greater or equal

                // linear search

                int linear_index = 0;

                for (int i = 1; i < index; i++) {
                    String arranged_item = getStringOnIndex(arranged, i, separator);

                    if (arranged_item.equals(item_last)) 
                        break;
                    
                    if (arranged_item.compareTo(item) > 0) 
                        break;

                    linear_index = i;
                }

                arranged = insertStringOnIndex(arranged, linear_index, separator, item);

            } else {
                // lesser

                item_last = item;
                arranged += separator + item_last;
            }

            index++;
        }

        return arranged.substring(0, arranged.length());
    }

    public static String sortByLength(String str, boolean ascending, String separator) {
        String arranged = "";

        while (str.length() != 0) {
            int i0 = 0;

            int shortestLength = str.length();    
            int shortI0 = 0; 
            int shortI1 = 0;

            String shortest = "";

            while (i0 != str.length()) {
                int i1 = str.indexOf(separator, i0 + 1);
                if (i1 < 0) 
                    i1 = str.length();

                String item = str.substring(i0+1, i1);

                if (item.length() <= shortestLength) {
                    shortestLength = item.length();
                    shortest = item;
                    shortI0 = i0;
                    shortI1 = i1;
                }

                i0 = i1;
            }

            str = str.substring(0, shortI0) + str.substring(shortI1, str.length());                  
            arranged += " " + shortest;
        }

        arranged = arranged.substring(1, arranged.length());
        return arranged;
        }

    public static String properCase(String str) {
        if (str.isEmpty()) 
            return str;

        int spaceIndex = str.indexOf(' ');

        if (spaceIndex == -1) 
            return capitalizeFirstChar(str);

        return capitalizeFirstChar(str.substring(0, spaceIndex)) + " " + properCase(str.substring(spaceIndex + 1));
    }

    public static int random(int min, int max) {
        return min + (int)(Math.random() * (max - min + 1));
    }
        
    private static String capitalizeFirstChar(String str) {
        if (str.isEmpty()) 
            return str;
        
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }
}
