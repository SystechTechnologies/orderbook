package uk.co.cmcmarkets.orderbook.consumer;

import uk.co.cmcmarkets.orderbook.iface.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class OrderConsumerImpl implements OrderConsumer
{

    private TreeSet<Order> bidOrders;
    private TreeSet<Order> askOrders;
    private Map<String, OrderBook> orderBookCollection;

    @Override
    public void startProcessing(Log log) {
        if (bidOrders == null)
            bidOrders = new TreeSet<Order>();
        if (askOrders == null)
            askOrders = new TreeSet<Order>();
        if (orderBookCollection == null) {
            orderBookCollection = new LinkedHashMap<String, OrderBook>();
        }
    }

    @Override
    public void finishProcessing()
    {

    }

    @Override
    public List<Order> getBidOrders() {
        return new ArrayList<Order>(bidOrders);
    }

    @Override
    public List<Order> getAskOrders() {
        return new ArrayList<Order>(askOrders);
    }

    @Override
    public OrderBook getOrderBook(String securityCode) {
        return orderBookCollection.get(securityCode);
    }

    @Override
    public void handleEvent(Action action, Order order)
    {

        OrderBook book = orderBookCollection.get(order.getSymbol());

        if (book == null) {
            book = new OrderBook();
        }

        if (order.isBuy()) {
            bidOrders.add(order);
            int bidCount = book.getBidCount();
            book.setBidCount(++bidCount);
        } else {
            askOrders.add(order);
            int askCount = book.getAskCount();
            book.setAskCount(++askCount);
        }

        orderBookCollection.put(order.getSymbol(), book);
    }

    private void addOrder(final Order order) {

    }

}
