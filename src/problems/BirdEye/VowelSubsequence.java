package problems.BirdEye;

public class VowelSubsequence {

    public static void main(String[] args) {

        System.out.println(getLongestSubsequence("aeiou"));
    }

   static String getLongestSubsequence(String vowelString){

        char[] chars = vowelString.toCharArray();

        int startIndex=-1;
        int endIndex=-1;

        char c = 'a';
        int continous=0;

        for(int i=0;i<vowelString.length();i++)
        {
            if(chars[i]>=c)
            {

                continous++;

                if(endIndex-startIndex<continous)
                {
                    startIndex=continous-i;
                    endIndex=continous;
                }
            }

        }

        return null;
    }
}
