/*

Program in String to longest string "a , e ,i,o,u"
 */
public class Application {

    public static void main(String[] args) {

        System.out.println("Hello World");

        String s="aeiouaaaeeiioaeeeueueeiiuiiuoouou";
        char[] val=s.toCharArray();

        int tempSPos=0;
        int tempEPos=0;
        int sPos=0;
        int ePos=0;

        for(int i=1;i<val.length;i++){

            if(isValid(val[i-1],val[i]))
            {
                tempEPos++;

            }else{
                if(tempEPos-tempSPos > ePos-sPos)
                {
                    System.out.println(s.substring(sPos,ePos+1));
                    ePos=tempEPos;
                    sPos=tempSPos;
                    tempSPos=tempEPos=i;
                }
            }
        }

        if(tempEPos-tempSPos > ePos-sPos)
        {
            ePos=tempEPos;
            sPos=tempSPos;
        }

        System.out.println(s.substring(sPos,ePos));



    }

  static   Boolean isVowel(char c){

        if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
            return true;
        }
        return false;
    }

   static Boolean isValid(char prevChar,char newChar){

        if(isVowel(newChar))
        {
          if(prevChar<=newChar)
          {
              return true;
          }
        }
        return false;
    }
}
