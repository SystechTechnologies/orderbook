package uk.co.cmcmarkets.orderbook.iface;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by kcai on 27/07/2014.
 */
public class OrderBook {

    private String instrumentName;
    private int bidCount;
    private int askCount;

    private List<BidByPrice> bidByPrices = new LinkedList<BidByPrice>();
    private List<AskByPrice> askByPrices = new LinkedList<AskByPrice>();

    public List<BidByPrice> getBidByPrices() {
        return bidByPrices;
    }

    public List<AskByPrice> getAskByPrices() {
        return askByPrices;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public int getBidCount() {
        return bidCount;
    }

    public void setBidCount(int bidCount) {
        this.bidCount = bidCount;
    }

    public int getAskCount() {
        return askCount;
    }

    public void setAskCount(int askCount) {
        this.askCount = askCount;
    }
}
