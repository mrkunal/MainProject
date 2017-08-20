package multithreading.producerConsumer;


public class DataStore {

    static Long[] data = new Long[10];

    private int insertionPointer = 0;
    private int fetchPointer = -1;


    void add(Long d) {
        if(insertionPointer!=fetchPointer) {
            data[insertionPointer] = d;
            insertionPointer = (insertionPointer + 1) % 10;
        }
    }

    Long fetch() {

        if(insertionPointer!=fetchPointer) {
            Long d = data[ fetchPointer];
            fetchPointer = (fetchPointer + 1) % 10;
            return d;
        }
        return null;
    }


}
