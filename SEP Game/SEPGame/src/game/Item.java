package game;

public class Item {
    public String name;
    protected String description;

    public String getName() {
        return name;
    }
    public void setName(String pString) {
        name = pString;
    } 

    public void printDescription() {
        System.out.println(description);
    }
    public void setDescription(String pDescription) {
        description = pDescription;
    }
    public String getDescription() {
        return description;
    }
}