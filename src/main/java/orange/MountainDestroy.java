package orange;
// https://www.codingame.com/ide/puzzle/the-descent


import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
    /**
     * The while loop represents the game.
     * Each iteration represents a turn of the game
     * where you are given inputs (the heights of the mountains)
     * and where you have to print an output (the index of the mountain to fire on)
     * The inputs you are given are automatically updated according to your last actions.
     **/
    public class MountainDestroy {

        static  class Mountain{
            public  int index;
            public     int height;

        }

        public static void main(String args[]) {
            Scanner in = new Scanner(System.in);

            int[] heights=new int[8];
            LinkedList<Mountain> list=new LinkedList<>();


            // game loop
            while (true) {
                for (int i = 0; i < 8; i++) {
                    int mountainH = in.nextInt(); // represents the height of one mountain.
                    //heights[i] = mountainH;
                    Mountain mountain=new Mountain();
                    mountain.index=i;
                    mountain.height=mountainH;
                    list.add(mountain);

                    //System.out.println(i);
                }

                Collections.sort(list,new Comparator<Mountain>(){
                    @Override
                    public  int compare(Mountain o1,Mountain o2){
                        return o2.height - o1.height;
                    }

                });

                while(!list.isEmpty())
                {
                    Mountain mountain = list.getFirst();
                    if(mountain.height>0)
                    {
                        System.out.println(mountain.index);
                    }

                    list.clear();

                    for (int i = 0; i < 8; i++) {
                        int mountainH = in.nextInt(); // represents the height of one mountain.
                        //heights[i] = mountainH;
                        if(mountainH>0){
                            Mountain mountain1=new Mountain();
                            mountain1.index=i;
                            mountain1.height=mountainH;
                            list.add(mountain1);
                        }


                        Collections.sort(list,new Comparator<Mountain>(){
                            @Override
                            public  int compare(Mountain o1,Mountain o2){
                                return o2.height - o1.height;
                            }

                        });

                        //System.out.println(i);
                    }



                }
            }
        }
    }

