import jdk.nashorn.internal.ir.Block;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.function.BooleanSupplier;

/**
 * Created by LENOVO on 17/05/05.
 */
public class Indexed implements Allocation {

    private class Block{
        ArrayList<Block> blocks;
        int index;
        Block(int i){
            index = i;
            blocks = new ArrayList<>();
        }
    }

    static int  SIZE ;
    ArrayList<Block> free;
    ArrayList<Block> allocated;
    HashMap<String, Integer> hashMap ;

    Indexed(int size){
        SIZE = size;
        free = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            free.add(new Block(i));
        }
        hashMap = new HashMap<String,Integer>();
    }
    @Override
    public boolean allocate(int size, String path) {
        if(free.size() > size+1 ){
            Block afree = free.remove(0);
            for (int i = 0; i < size ; i++) {
                afree.blocks.add(free.remove(0));
            }
            this.allocated.add(afree);
            hashMap.put(path,allocated.size()-1);
            return true;
        }
        else
        return false;
    }

    @Override
    public void deallocate(String path) {

        int index=hashMap.remove(path);
        Block temp = allocated.remove(index);
        for (int i = 0; i < temp.blocks.size(); i++) {
            this.free.add(temp.blocks.get(i));
        }
    }

    @Override
    public void printEmptySlots() {
        System.out.println("Empty Slots : ");
        for (int i = 0; i < this.free.size() ; i++) {
            System.out.println( this.free.get(i).index);
        }
    }

    @Override
    public void printEmptySpace() {
        System.out.println( "Empty space :" +this.free.size());
    }

    @Override
    public void printOccupiedSpace() {
        System.out.println( "Occupied space :" + ( SIZE - this.free.size() ) );
    }

}