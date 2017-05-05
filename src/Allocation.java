/**
 * Created by LENOVO on 17/05/02.
 */
public interface Allocation {

    public boolean allocate(int size , String path);
    public void deallocate(String path);
    public void printEmptySlots();
    public void printEmptySpace();
    public void printOccupiedSpace();

}
