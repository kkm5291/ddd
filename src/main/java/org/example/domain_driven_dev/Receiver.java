package chapter1;

import java.util.Objects;

/**
 * Receiver 는 '받는 사람' 이라는 도메인 개념을 표현한다.
 */
public class Receiver {
    private String name;
    private String phoneNumber;

    public Receiver(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 두 밸류 객체를 비교할 때는 모든 속성이 같은지 비교한다.
     * @param other
     * @return
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (this == other) return true;
        if (! (other instanceof Receiver)) return false;
        Receiver that = (Receiver) other;
        return this.name.equals(that.name) && this.phoneNumber.equals(that.phoneNumber);
    }
}
