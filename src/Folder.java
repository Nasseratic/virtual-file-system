import java.util.ArrayList;
import java.util.Date;

/**
 * Created by LENOVO on 17/05/02.
 */
public class Folder {

    private String name;
    private String path;
    private Date creation;
    private Date LastModification;
    private ArrayList<Folder> folders;
    private ArrayList<File> files;

    public Folder(String name, String path) {
        this.name = name;
        this.path = path;
        this.folders = new ArrayList<>();
        this.files = new ArrayList<>();
    }

    public Date getCreation() {
        return creation;
    }

    public Date getLastModification() {
        return LastModification;
    }

    public void setLastModification(Date lastModification) {
        LastModification = lastModification;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Folder> getFolders() {
        return folders;
    }

    public void setFolders(ArrayList<Folder> folders) {
        this.folders = folders;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }

    public void addFile(File file) {
        this.files.add(file);
    }

    public void addFolder(Folder folder) {
        this.folders.add(folder);
    }



}
