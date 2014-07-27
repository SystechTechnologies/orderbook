package uk.co.cmcmarkets.orderbook.consumer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.co.cmcmarkets.orderbook.iface.Action;
import uk.co.cmcmarkets.orderbook.iface.Order;
import uk.co.cmcmarkets.orderbook.iface.OrderBook;
import uk.co.cmcmarkets.orderbook.iface.OrderConsumer;

/**
 * Created by kcai on 27/07/2014.
 */
public class OrderConsumerTest {

    private OrderConsumer orderConsumer;

    @Before
    public void setup() {
        orderConsumer = new OrderConsumerImpl();
    }

    @Test
    public void testAddingBidOrders() {
        Order orderBid = new Order(1, "TFL", false, 100, 10);
        Order orderAsk = new Order(1, "TFL", true, 110, 10);

        orderConsumer.startProcessing(null);

        orderConsumer.handleEvent(Action.ADD, orderBid);
        orderConsumer.handleEvent(Action.ADD, orderAsk);

        Assert.assertNotNull(orderConsumer.getBidOrders());
        Assert.assertNotNull(orderConsumer.getAskOrders());
        Assert.assertEquals(1, orderConsumer.getAskOrders().size());
        Assert.assertEquals(1, orderConsumer.getBidOrders().size());
    }

    @Test
    public void testOrderBookCreated() {
        Order orderBid = new Order(1, "TFL", false, 100, 10);

        orderConsumer.startProcessing(null);
        orderConsumer.handleEvent(Action.ADD, orderBid);

        OrderBook book = orderConsumer.getOrderBook("TFL");
        Assert.assertNotNull(book);
        Assert.assertEquals(1, book.getAskCount());
    }
}
