package projectBFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.*;
/**
 * Created by slava on 10.11.2016.
 */

public class Main {
    public static void main(String[] args) {
        AhoCorasick ahoCorasick = new AhoCorasick(1000);
        ahoCorasick.addString("bac");
        ahoCorasick.addString("a");
        String s = "abacbaca";
        int node = 0;
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            node = ahoCorasick.transition(node, s.charAt(i));
            if (ahoCorasick.nodes[node].leaf)
                positions.add(i);
        }
        System.out.println(positions);
    }
}
