package utils.gemMine.deposit;

import utils.arrayList.BlockingQueue;
import utils.gemMine.gems.Gem;

public class GemDeposit {
    private BlockingQueue<Gem> gems;

    public GemDeposit(int capacity){
        gems = new BlockingQueue<>(capacity);
    }

    public synchronized void putGem(Gem gem){
        if(gem == null) throw new IllegalArgumentException("No nulls");

        if(gems.isFull()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gems.put(gem);
        if(gems.size() == 1)
        notify();
    }
    public synchronized Gem takeGem(){
        Gem gem;
        if(gems.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gem = gems.take();
        if(gems.size() == gems.capacity() - 1)
            notify();
        return gem;
    }
    public boolean isFull(){
        return gems.isFull();
    }

}
