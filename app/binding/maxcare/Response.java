package binding.maxcare;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Response {

    @XmlElement
    Ok ok;

    public Ok getOk() {
        return ok;
    }

    public void setOk(Ok ok) {
        this.ok = ok;
    }
}
