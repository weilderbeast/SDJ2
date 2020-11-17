package utils.gemMine.workers;

import utils.arrayList.BlockingQueue;
import utils.enums.GemType;
import utils.gemMine.GemMine;
import utils.gemMine.deposit.GemDeposit;
import utils.gemMine.gems.Gem;

import java.util.ArrayList;
import java.util.Random;

public class GemWorker implements Runnable {
    private ArrayList<GemType> gems = new ArrayList<GemType>();
    private Random random = new Random();
    private GemDeposit gemDeposit;

    public GemWorker(GemDeposit gemDeposit) {
        this.gemDeposit = gemDeposit;
        gems.add(GemType.COIN);
        gems.add(GemType.DIAMOND);
        gems.add(GemType.JEWEL);
        gems.add(GemType.RUBY);
    }

    @Override
    public void run() {
        while (true) {
            GemType gemtype = gems.get(random.nextInt(4));
            gemDeposit.putGem(GemMine.getGem(gemtype));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
