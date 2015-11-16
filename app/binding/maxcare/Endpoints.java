package binding.maxcare;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Endpoints {

    @XmlElement(name = "endpoint")
    List<Endpoint> endpointList;

    public List<Endpoint> getEndpointList() {
        return endpointList;
    }

    public void setEndpointList(List<Endpoint> endpointList) {
        this.endpointList = endpointList;
    }
}
