package com.alok.aut.IpageObjects;

public interface IPurchase {
    public Boolean isBuyNowPresent();
    public Boolean clickOnBuy();
    public Boolean checkOut();
    public Boolean clickOnContinue();
    public Boolean validateOrderSummery(String value);
    public void selectpaymentmethod();
    public void fillCreditCardInfo(String cardnumber,String expiryDate,String CVV);
    public Boolean isPaymentDone();
    public void  confirmPassword();
    public Boolean isOredrCreated();
}
