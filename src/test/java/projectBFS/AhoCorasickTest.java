package projectBFS;
import java.util.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Trokzen on 25.05.2017.
 */
 public class AhoCorasickTest extends AhoCorasick.Node
{
    @Test//Тестируем несколько подстрок
    public void testEquals() {
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
        List<Integer> positionsTest = new ArrayList<>();
        positionsTest.add(0);
        positionsTest.add(3);
        positionsTest.add(6);
        positionsTest.add(7);
        assertEquals(positionsTest,positions);
    }
    @Test//Тестируем с инъекцией ошибки
    public void testNotEquals() {
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
        List<Integer> positionsTest = new ArrayList<>();
        positionsTest.add(0);
        positionsTest.add(5);
        positionsTest.add(6);
        positionsTest.add(7);
        assertNotEquals(positionsTest,positions);
    }
    @Test//Тестируем с инъекцией ошибки
    public void testOneStr() {
        AhoCorasick ahoCorasick = new AhoCorasick(1000);
        ahoCorasick.addString("bac");
        String s = "abacbaca";
        int node = 0;
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            node = ahoCorasick.transition(node, s.charAt(i));
            if (ahoCorasick.nodes[node].leaf)
                positions.add(i);
        }
        List<Integer> positionsTest = new ArrayList<>();
        positionsTest.add(3);
        positionsTest.add(6);
        assertEquals(positionsTest,positions);
    }
}