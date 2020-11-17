package horus.utils;

import java.util.Formatter;

public class Player {
    public String name;
    public Integer health_points;
    public Integer mana_points;
    public Integer level;

    public Player(String name) {
        this.name = name;
        this.health_points = 1000;
        this.mana_points = 500;
        this.level = 0;
    }

    public Player(String name, Integer health, Integer mana, Integer level) {
        this.name = name;
        this.health_points = health;
        this.mana_points = mana;
        this.level = level;
    }

    public String ToString() {
        String out;
        Object[] args = { this.name, this.health_points, this.mana_points, this.level };
        Formatter fmt = new Formatter();
        out = fmt.format("{ name: %s | hp: %d | mp: %d | lvl: %d }", args).toString();
        fmt.close();
        return out;
    }

    @Override
    public String toString() {
        return this.ToString();
    }
}
