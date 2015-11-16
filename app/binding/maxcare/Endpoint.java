package binding.maxcare;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Endpoint {

    @XmlElement
    private String type;

    @XmlElement(name = "serial_value")
    private String serialValue;

    @XmlElement(name = "is_active")
    private boolean isActive;

    @XmlElement(name = "enddate")
    private String endDate;

    @XmlElement(name = "startdate")
    private String startDate;

    @XmlElement(name = "energization_status")
    private int energizationStatus;

    @XmlElement(name = "disconnection_status")
    private int disconnectionStatus;

    @XmlElement(name = "endpoints")
    private Endpoints endpoints;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSerialValue() {
        return serialValue;
    }

    public void setSerialValue(String serialValue) {
        this.serialValue = serialValue;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getEnergizationStatus() {
        return energizationStatus;
    }

    public void setEnergizationStatus(int energizationStatus) {
        this.energizationStatus = energizationStatus;
    }

    public int getDisconnectionStatus() {
        return disconnectionStatus;
    }

    public void setDisconnectionStatus(int disconnectionStatus) {
        this.disconnectionStatus = disconnectionStatus;
    }

    public Endpoints getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(Endpoints endpoints) {
        this.endpoints = endpoints;
    }
}