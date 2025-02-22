package chapter1;

// 주문 항목 표현
public class OrderLine {
    private Product product; // 주문 할 상품
    private Money price; // 상품의 가격
    private int quantity; // 구매 개수
    private Money amounts; // 총합

    public OrderLine(Product product, Money price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    /**
     * Money 라는 value 타입 객체를 통해서 코드의 가독성을 향상시킬 수 있음.
     */
    private Money calculateAmounts() {
        return price.multiply(quantity);
    }

    public Money getAmounts() {
        return amounts;
    }
}
