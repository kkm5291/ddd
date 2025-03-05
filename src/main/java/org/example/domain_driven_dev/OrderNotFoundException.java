package org.example.domain_driven_dev;

public class OrderNotFoundException extends Throwable {
    public OrderNotFoundException(String orderId) {
    }
}
