package uk.co.cmcmarkets.orderbook.iface;

/**
 * Created by kcai on 27/07/2014.
 */
public class AskByPrice {

    private int askPrice;
    private int askSize;
    private int askCount;

    public int getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(int askPrice) {
        this.askPrice = askPrice;
    }

    public int getAskSize() {
        return askSize;
    }

    public void setAskSize(int askSize) {
        this.askSize = askSize;
    }

    public int getAskCount() {
        return askCount;
    }

    public void setAskCount(int askCount) {
        this.askCount = askCount;
    }
}
