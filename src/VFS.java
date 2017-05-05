import java.util.*;

/**
 * Created by LENOVO on 17/05/02.
 */

public class VFS {
    private static final int DISKSIZE = 1000000;
    Folder root;
    Allocation allocation;

    public VFS() {
        this.root = new Folder( "VFSD:/" , "" );
    }

    public void displayStatus(){

    }

    public void displayTree( String level , Folder folder){
        if(folder.getFolders().isEmpty()) {
            System.out.println(level + folder.getName());
            return;
        }
        ArrayList<Folder> temp = folder.getFolders();
        for (int i = 0; i < temp.size() ; i++) {
            displayTree(level+"  " , temp.get(i) );
        }
        ArrayList<File> files = folder.getFiles();
        for (int i = 0; i < files.size() ; i++) {
            System.out.println(level + files.get(i).getName() );
        }
    }

    public void contiguousVFS(){
        this.allocation = new Contiguous(DISKSIZE);
    }

    public void indexesVFS(){
        this.allocation = new Indexed(DISKSIZE);
    }

    public static void main( String [] args){



    }

}
