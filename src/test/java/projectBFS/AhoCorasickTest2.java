package projectBFS;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Trokzen on 25.05.2017.
 */
 public class AhoCorasickTest2 extends AhoCorasick2.Node
{
    @Test//Тестируем несколько подстрок
    public void testEquals2() {
        AhoCorasick2 ahoCorasick2 = new AhoCorasick2(1000);
        ahoCorasick2.addString("bac");
        ahoCorasick2.addString("a");
        String s = "abacbaca";
        int node = 0;
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            node = ahoCorasick2.transition(node, s.charAt(i));
            if (ahoCorasick2.nodes[node].leaf)
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
    public void testNotEquals2() {
        AhoCorasick2 ahoCorasick2 = new AhoCorasick2(1000);
        ahoCorasick2.addString("bac");
        ahoCorasick2.addString("a");
        String s = "abacbaca";
        int node = 0;
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            node = ahoCorasick2.transition(node, s.charAt(i));
            if (ahoCorasick2.nodes[node].leaf)
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
    public void testOneStr2() {
        AhoCorasick2 ahoCorasick2 = new AhoCorasick2(1000);
        ahoCorasick2.addString("bac");
        String s = "abacbaca";
        int node = 0;
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            node = ahoCorasick2.transition(node, s.charAt(i));
            if (ahoCorasick2.nodes[node].leaf)
                positions.add(i);
        }
        List<Integer> positionsTest = new ArrayList<>();
        positionsTest.add(3);
        positionsTest.add(6);
        assertEquals(positionsTest,positions);
    }
    @Test//Другой случай поиска строк
    public void testOneStr() {
        AhoCorasick2 ahoCorasick2 = new AhoCorasick2(1000);
        ahoCorasick2.addString("a");
        ahoCorasick2.addString("b");
        String s = "abacbaca";
        int node = 0;
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            node = ahoCorasick2.transition(node, s.charAt(i));
            if (ahoCorasick2.nodes[node].leaf)
                positions.add(i);
        }
        List<Integer> positionsTest = new ArrayList<>();
        positionsTest.add(0);
        positionsTest.add(1);
        positionsTest.add(2);
        positionsTest.add(4);
        positionsTest.add(5);
        positionsTest.add(7);
        assertEquals(positionsTest,positions);
    }
    @Test(timeout = 1000)//Тест с ограничение времени на прохождение
    public void time() {
        AhoCorasick2 ahoCorasick2 = new AhoCorasick2(1000);
        ahoCorasick2.addString("bac");
        String s = "abacbaca";
        int node = 0;
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            node = ahoCorasick2.transition(node, s.charAt(i));
            if (ahoCorasick2.nodes[node].leaf)
                positions.add(i);
        }
        List<Integer> positionsTest = new ArrayList<>();
        positionsTest.add(3);
        positionsTest.add(6);
    }
}