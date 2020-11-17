package horus.hash_table;

import org.junit.Test;

import horus.utils.Player;

import static org.junit.Assert.*;

public class HashTableTest {
    @Test
    public void testInsert() {
        HashTable<String, Player> table = new HashTable<>(10);

        table.Insert("InsertTest", new Player("InsertTestPlayer"));

        Player value = table.Get("InsertTest");

        assertNotNull("Should return the value 10", value);
        assertTrue("Size should be 1", table.Size() == 1);
    }

    @Test
    public void testGet() {
        HashTable<String, Player> table = new HashTable<>(10);

        table.Insert("InsertTest", new Player("InsertTestPlayer"));
        table.Insert("OtherInsertTest", new Player("OtherInsertTestPlayer"));

        Player value = table.Get("InsertTest");

        assertTrue("Player shold be 'InsertTestPlayer'", value.name.equals("InsertTestPlayer"));
    }

    @Test
    public void testRemove() {
        HashTable<String, Player> table = new HashTable<>(10);

        table.Insert("InsertTest", new Player("InsertTestPlayer"));
        table.Insert("OtherInsertTest", new Player("OtherInsertTestPlayer"));

        assertTrue("Size should be 2", table.Size() == 2);

        table.Remove("InsertTest");

        Player value = table.Get("InsertTest");

        assertTrue("Size should be 1", table.Size() == 1);
        assertNull(value);
    }

    @Test
    public void testResizeFrames() {
        HashTable<String, Player> table = new HashTable<>(10);
        assertTrue("Frames should be 10", table.Frames() == 10);

        for (Integer i = 0; i < 50; i++)
            table.Insert("Player " + i.toString(), new Player("Player " + i.toString()));

        table.ResizeFrames(50);

        assertTrue("Frames should be 50", table.Frames() == 50);

        for (Integer i = 40; i < 50; i++)
            table.Remove("Player " + i.toString());

        assertTrue("Size should be 2", table.Size() == 40);

        Player value = table.Get("Player 1");

        assertNotNull(value);
    }
}
