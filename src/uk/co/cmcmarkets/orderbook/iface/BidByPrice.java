package uk.co.cmcmarkets.orderbook.iface;

/**
 * Created by kcai on 27/07/2014.
 */
public class BidByPrice {

    private int bidPrice;
    private int bidSize;
    private int bidCount;

    public int getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(int bidPrice) {
        this.bidPrice = bidPrice;
    }

    public int getBidSize() {
        return bidSize;
    }

    public void setBidSize(int bidSize) {
        this.bidSize = bidSize;
    }

    public int getBidCount() {
        return bidCount;
    }

    public void setBidCount(int bidCount) {
        this.bidCount = bidCount;
    }
}
