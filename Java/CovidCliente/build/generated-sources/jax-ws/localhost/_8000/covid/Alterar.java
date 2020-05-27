
package localhost._8000.covid;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de alterar complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="alterar">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="covid" type="{http://localhost:8000/covid}covid19" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "alterar", propOrder = {
    "covid"
})
public class Alterar {

    protected Covid19 covid;

    /**
     * Obtém o valor da propriedade covid.
     * 
     * @return
     *     possible object is
     *     {@link Covid19 }
     *     
     */
    public Covid19 getCovid() {
        return covid;
    }

    /**
     * Define o valor da propriedade covid.
     * 
     * @param value
     *     allowed object is
     *     {@link Covid19 }
     *     
     */
    public void setCovid(Covid19 value) {
        this.covid = value;
    }

}
