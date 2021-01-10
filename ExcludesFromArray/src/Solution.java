import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Item [] itemsArr = new Item[]{
                new Item("iPhone 11", "gold", "phone"),
                new Item("Samsung 123", "black", "tv"),
                new Item("Amazon Kindle", "red", "tablet")
        };
        Exclude [] excludesArr = new Exclude[]{
                new Exclude("color", "gold"),
                new Exclude("color", "sliver"),
                new Exclude("id", "12233"),
                new Exclude("type", "tv")
        };

        Item [] res = new Solution().getFinalItems(itemsArr, excludesArr);
        for(Item i : res) {
            System.out.println(i.name + ", " + i.type + ", " + i.color);
        }
    }

    // Store the keys and vals to a HashMap<Key to exclude, its value>.
    // Ex. <"color", ["gold", "silver"]>, <"type", ["tv"]>
    // Iterate the items array, check each property of the item and see if map contains it? If so, skip it
    // Else, add that item to the result ArrayList
    // After iteration, turn ArrayList into array of Item and return it
    // Time: O(n) if the properties of Item is fixed.

    public Item [] getFinalItems(Item [] itemsArr, Exclude [] excludesArr) {
        HashMap<String, List<String>> map = new HashMap();
        for(Exclude ex : excludesArr) {
            map.putIfAbsent(ex.key, new ArrayList<>());
            map.get(ex.key).add(ex.val);
        }

        List<Item> res = new ArrayList();
        String [] types = new String[]{"name", "color", "type"};
        for(Item item : itemsArr) {
            boolean match = false;
            for(String s : types) {
                if(map.containsKey(s) && map.get(s).contains(item.get(s))) {
                    match = true;
                    break;
                }
            }
            if(!match) {
                res.add(item);
            }
        }

        Item [] ans = new Item[res.size()];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
