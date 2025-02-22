package org.example.domain_driven_dev;

import java.util.List;

// Order는 한 개 이상의 OrderLine을 가질 수 있음.
// 주문할 때 배송지 정보를 반드시 입력해야 한다.
public class Order {
    // Order는 엔티티로서 orderNumber를 식별자로 갖는다.
    // 또한 orderNumber를 구성할 때에는 String 값 보단 OrderNo value 타입으로 만든다면 실제 의미를 찾기 쉬워진다.
    private OrderNo id;
    private List<OrderLine> orderLines;
    private ShippingInfo shippingInfo;
    private Money totalAmounts;
    private OrderState state;

    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        // 배송지 정보 필수 도메인 규칙
        if (shippingInfo == null) {
            throw new IllegalArgumentException("no ShippingInfo");
        }
        this.shippingInfo = shippingInfo;
    }

    // 제약 조건을 검사한다.
    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    // OrderLine이 한 개 이상 존재하는 지 검사
    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLine");
        }
    }

    // 총 주문 금액 계산
    private void calculateTotalAmounts() {
        int sum = orderLines.stream()
                .map(OrderLine::getAmounts)
                .mapToInt(Money::getValue)
                .sum();

        this.totalAmounts = new Money(sum);
    }

    private void verifyNotYetShipped() {
        if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING) {
            throw new IllegalStateException("already shipped");
        }
    }

    public void changeShipped() {}
    public void changeShippingInfo(ShippingInfo newShipping) {
        verifyNotYetShipped();
        setShippingInfo(newShipping);
    }
    public void cancel() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }
    public void completePayment() {}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != Order.class) return false;
        Order other = (Order) obj;
        if (this.id == null) return false;
        return this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public OrderNo getId() {
        return id;
    }
}
