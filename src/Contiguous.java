import jdk.nashorn.internal.ir.Block;

import java.util.ArrayList;

/**
 * Created by LENOVO on 17/05/05.
 */
public class Contiguous implements Allocation{

    class Block {
        int from;
        int to;
        String file;

        public Block(int from, int to, String file) {
            this.from = from;
            this.to = to;
            this.file = file;
        }
    }
    ArrayList<Block> blocks;
    static int size;
    static int MAXSIZE;

    public Contiguous(int size) {
        this.size = size;
        this.MAXSIZE = size;
        blocks =new ArrayList<>();
        blocks.add(new Block(0,size,"_Free"));
    }

    @Override
    public boolean allocate(int size, String path) {
        if(this.size-size>0) {
            for (int i = 0; i < blocks.size(); i++) {
                Block temp = blocks.remove(i);
                if (temp.file.equals("_Free")) {
                    if (size < temp.to - temp.from) {
                        blocks.add(new Block(temp.from, temp.from + size, path));
                        blocks.add(new Block(temp.from + size + 1, temp.to, "_Free"));
                        this.size -= size;
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public void deallocate(String path) {
        // TODO Yaso
    }

    @Override
    public void printEmptySlots() {

        System.out.println("Empty Slots : ");
        for (int i = 0; i < this.blocks.size() ; i++) {
            System.out.println( this.blocks.get(i).from + "to" + this.blocks.get(i).to );
        }

    }

    @Override
    public void printEmptySpace() {
        System.out.println( "Empty space :" + size );
    }

    @Override
    public void printOccupiedSpace() {
        System.out.println( "Occupied space :" + ( MAXSIZE - size) );
    }


}
