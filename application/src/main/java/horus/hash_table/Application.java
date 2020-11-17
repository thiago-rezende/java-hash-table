package horus.hash_table;

import horus.utils.Player;

public class Application {
    public static void main(String[] args) {
        HashTable<String, Player> table = new HashTable<>(10);

        for (Integer i = 0; i < 50; i++)
            table.Insert("Player " + i.toString(), new Player("Player " + i.toString()));

        table.ResizeFrames(50);

        for (Integer i = 40; i < 50; i++)
            table.Remove("Player " + i.toString());

        System.out.println(table.ToString());
        System.out.println("Size: " + table.Size());

        System.out.println(table.Get("Player 20"));
    }
}
