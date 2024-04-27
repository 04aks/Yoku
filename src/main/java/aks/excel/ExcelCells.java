package aks.excel;

import java.awt.Rectangle;

public class ExcelCells {

    String transactionDate;
    String transactionCode;
    String otherParty;
    double recieved;
    double sent;
    double tax;
    double remaining;
    public boolean hovered = false;
    public Rectangle rectangle = new Rectangle();

    public ExcelCells(/*Date transactionDate, String transactionCode, String otherParty, int recieved, int sent, int tax, int remaining*/){
        // this.transactionDate = transactionDate;
        // this.transactionCode = transactionCode;
        // this.otherParty = otherParty;
        // this.recieved = recieved;
        // this.sent = sent;
        // this.tax = tax;
        // this.remaining = remaining;

    }
    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }
    public void setOtherParty(String otherParty) {
        this.otherParty = otherParty;
    }
    public void setRecieved(double recieved) {
        this.recieved = recieved;
    }
    public void setSent(double sent) {
        this.sent = sent;
    }
    public void setTax(double tax) {
        this.tax = tax;
    }
    public void setRemaining(double remaining) {
        this.remaining = remaining;
    }



    public String getTransactionDate() {
        return transactionDate;
    }
    public String getTransactionCode() {
        return transactionCode;
    }
    public String getOtherParty() {
        return otherParty;
    }
    public double getRecieved() {
        return recieved;
    }
    public double getSent() {
        return sent;
    }
    public double getTax() {
        return tax;
    }
    public double getRemaining() {
        return remaining;
    }
    
}
