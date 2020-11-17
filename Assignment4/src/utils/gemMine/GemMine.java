package utils.gemMine;

import utils.enums.GemType;
import utils.gemMine.gems.*;

import java.util.HashMap;
import java.util.Map;

public class GemMine {
    private static Map<GemType, Gem> gems = new HashMap<>();

    private GemMine(){}

    public static Gem getGem(GemType gemType){
        Gem gem = gems.get(gemType);
        if(gem != null) return gem;
        else {
            synchronized (gems) {
                if(gems.get(gemType) == null) {
                    switch (gemType) {
                        case COIN:
                            gem = new Coin();
                            break;
                        case RUBY:
                            gem = new Ruby();
                            break;
                        case JEWEL:
                            gem = new Jewel();
                            break;
                        case DIAMOND:
                            gem = new Diamond();
                            break;
                    }
                    gems.put(gemType, gem);
                }
            }
        }
        return gem;
    }
}
