package binding.maxcare;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Customer {

    @XmlElement(name = "customerid")
    private String customerId;

    @XmlElement(name = "customerno")
    private String customerNumber;

    @XmlElement
    private String title;

    @XmlElement
    private String type;

    @XmlElement
    private String billingContactMethod;

    @XmlElement(name = "billedbalance")
    private float billedBalance;

    @XmlElement(name = "billcycle")
    private String billCycle;

    @XmlElement(name = "unbilledbalance")
    private float unbilledBalance;

    @XmlElement
    private float deposit;

    @XmlElement
    private float installment;

    @XmlElement(name = "paymentmethod")
    private String paymentMethod;

    @XmlElement
    private String status;

    @XmlElement
    private Endpoints endpoints;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBillingContactMethod() {
        return billingContactMethod;
    }

    public void setBillingContactMethod(String billingContactMethod) {
        this.billingContactMethod = billingContactMethod;
    }

    public float getBilledBalance() {
        return billedBalance;
    }

    public void setBilledBalance(float billedBalance) {
        this.billedBalance = billedBalance;
    }

    public String getBillCycle() {
        return billCycle;
    }

    public void setBillCycle(String billCycle) {
        this.billCycle = billCycle;
    }

    public float getUnbilledBalance() {
        return unbilledBalance;
    }

    public void setUnbilledBalance(float unbilledBalance) {
        this.unbilledBalance = unbilledBalance;
    }

    public float getDeposit() {
        return deposit;
    }

    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    public float getInstallment() {
        return installment;
    }

    public void setInstallment(float installment) {
        this.installment = installment;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Endpoints getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(Endpoints endpoints) {
        this.endpoints = endpoints;
    }
}

