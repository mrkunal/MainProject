package problems.substringVowelsConstants;

import java.util.ArrayList;

public class substringStartWithVowel {


    // Java program to print all substrings of a string


        // Function to print all substring
        public static void SubString(String str, int n)
        {
            ArrayList stringsList= new ArrayList();


            char[] chars= str.toCharArray();

            int vowelPos =-1;
            int constPos =-1;

            int counter=0;

            while (counter<str.length())
            {
                char c=chars[counter];

                if(isVowel(c)&& vowelPos==-1)
                {
                        vowelPos=counter;

                }else if(vowelPos>-1)
                {
                    if(chars[counter-1]>c && isConsonant(c))
                    {
                        constPos=counter;
                        break;
                    }else if(chars[counter-1]<c){
                        vowelPos=-1;
                        counter--;
                    }


                }
                 counter++;
            }

            System.out.println(str.substring(vowelPos,constPos));


//            for (int i = 0; i < n; i++) {
//                for (int j = i + 1; j <= n; j++) {
//
//
//                    String checkSubString = str.substring(i, j);
//                      if (isVowel(checkSubString.charAt(0)))
//                      {
//                          if (isConsonant(checkSubString.charAt(checkSubString.length()-1)))
//                              stringsList.add(checkSubString);
//                      }
//
//                }
//
//
//            }

//
//            System.out.println(stringsList.get(0));
//            System.out.println(stringsList.get(stringsList.size()-1));
        }

    static boolean isVowel(char c)
    {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o'
                || c == 'u');
    }

    // Utility method to check consonant
    static boolean isConsonant(char c)
    {
        return !(c == 'a' || c == 'e' || c == 'i' || c == 'o'
                || c == 'u');
    }


    public static void main(String[] args)
        {
            String str = "aab";
            SubString(str, str.length());
        }




}
