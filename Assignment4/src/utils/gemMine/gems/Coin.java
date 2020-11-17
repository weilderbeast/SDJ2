package utils.gemMine.gems;

public class Coin implements Gem {
    @Override
    public String getName() {
        return "coin";
    }

    @Override
    public int getValue() {
        return 1;
    }
}
