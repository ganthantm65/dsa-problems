import java.util.*;

public class FindGrandFather {

    public int countGrandChildren(Map<String, List<String>> tree, String person) {

        List<String> children = tree.get(person);

        if (children == null)
            return 0;

        int count = 0;

        for (String child : children) {

            List<String> grandChildren = tree.get(child);

            if (grandChildren != null) {
                count += grandChildren.size();
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String[][] input = {
                {"luke", "shaw"},
                {"wayne", "rooney"},
                {"rooney", "ronaldo"},
                {"shaw", "rooney"}
        };

        Map<String, List<String>> tree = new HashMap<>();

        for (String[] relation : input) {
            tree.computeIfAbsent(relation[1], k -> new ArrayList<>())
                    .add(relation[0]);
        }

        FindGrandFather obj = new FindGrandFather();

        System.out.println(obj.countGrandChildren(tree, "ronaldo"));
    }
}