package org.example.domain_driven_dev;

import jakarta.transaction.Transactional;

public class CancelOrderService {
    @Transactional
    public void cancelOrder(String orderId) {
        Order order = findOrderById(orderId);

        if (order == null) throw new OrderNotFoundException(orderId);
        order.cancel();
    }
}
