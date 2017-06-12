package moduls;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 Created by ${Ruslan} on 19.09.16.

 */
public class Item {
    private String name;
    private long dateAdd;
    private String description;
    private String clientId;
    private SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yy hh:mm");
    private List<Comment> comments = new ArrayList<Comment> ();

    public Item(String name, long dateAdd, String description) {
        this.name = name;
        this.dateAdd = dateAdd;
        this.description = description;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateAdd(long dateAdd) {
        this.dateAdd = dateAdd;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    long getDateAdd() {
        return dateAdd;
    }

    public String getDescription() {
        return description;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientId() {
        return clientId;
    }

    public void addComment(Comment comment){
                comments.add(comment);
    }

    public List<Comment> getComments(){
        return comments;
    }

    @Override
    public String toString(){

        return "Client Id: " + getClientId()
                + "   Client name: " + getName()
                + "   Date add: " + myFormat.format(getDateAdd())
                + "   Description: " + getDescription();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (dateAdd != item.dateAdd) return false;
        if (!name.equals(item.name)) return false;
        if (description.equals(item.description)) if (clientId.equals(item.clientId)) return true;
        return false;

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (int) (dateAdd ^ (dateAdd >>> 32));
        result = 31 * result + description.hashCode();
        result = 31 * result + clientId.hashCode();
        return result;
    }
}
