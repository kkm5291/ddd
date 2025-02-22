package org.example.domain_driven_dev;

public class ShippingInfo {
    private String receiverName; // 받는 사람 이름
    private String receiverPhoneNumber; // 받는 사람 전화번호

    // 주소
    private String shippingAddress1;
    private String shippingAddress2;
    private String shippingZipcode;

    public ShippingInfo(String receiverName, String receiverPhoneNumber, String shippingAddress1, String shippingAddress2, String shippingZipcode) {
        this.receiverName = receiverName;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.shippingAddress1 = shippingAddress1;
        this.shippingAddress2 = shippingAddress2;
        this.shippingZipcode = shippingZipcode;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public String getShippingAddress1() {
        return shippingAddress1;
    }

    public String getShippingAddress2() {
        return shippingAddress2;
    }

    public String getShippingZipcode() {
        return shippingZipcode;
    }
}
