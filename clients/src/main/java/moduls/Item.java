package moduls;

/**
 Created by ${Ruslan} on 19.09.16.

 */
public class Item {
    String name;
    long dateAdd;
    String description;
    String clientId;

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

    public long getDateAdd() {
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
}
