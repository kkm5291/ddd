package chapter1;

public class Money {
    private int value;

    public Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * Money 객체는 setter가 없음 (value를 변경할 수 있는 메서드가 없다)
     * setter 사용 대신 add 에서는 새로운 Money 객체를 반환한다.
     * 이를 불변(immutable) 이라 한다.
     * 밸류 타입은 보통 불변으로 구현하게 된다.
     * 가장 중요한 이유로는 안전한 코드를 작성할 수 있기 때문이다.
     */
    public Money add(Money money) {
        return new Money(this.value + money.value);
    }

    public Money multiply(int multiplier) {
        return new Money(this.value * multiplier);
    }
}
