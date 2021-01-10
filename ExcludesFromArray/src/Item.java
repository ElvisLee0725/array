public class Item {
    String name;
    String color;
    String type;

    public Item(String name, String color, String type) {
        this.name = name;
        this.color = color;
        this.type = type;
    }

    public String get(String type) {
        if(type == "name") {
            return this.name;
        }
        else if(type == "color") {
            return this.color;
        }
        else if(type == "type") {
            return this.type;
        }
        return "";
    }
}


