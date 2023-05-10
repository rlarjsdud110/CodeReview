package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bow extends Weapon{

    public Bow(String name, int attackPower) {
        super("활", 10);
    }
}
