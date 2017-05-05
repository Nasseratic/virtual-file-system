import java.util.Date;

/**
 * Created by LENOVO on 17/05/02.
 */
public class File {
    private String name;
    private int size;
    private String type;
    private String location;
    private Date creation;
    private Date LastModification;

    public File(String name, int size, String location) {
        this.name = name;
        this.size = size;
        String s[] = name.split(".");
        if(s.length > 2)
        this.type = s[s.length];
        else
        this.type = "file";
        this.location = location;
        this.creation = new Date();
        this.LastModification = new Date();
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.LastModification = new Date();
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.LastModification = new Date();
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.LastModification = new Date();
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.LastModification = new Date();
        this.location = location;
    }

    public Date getCreation() {
        return creation;
    }

    public Date getLastModification() {
        return LastModification;
    }

}
