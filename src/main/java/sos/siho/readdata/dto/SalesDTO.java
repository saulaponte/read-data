package sos.siho.readdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

@Value
public class SalesDTO implements Serializable{

    private static final long serialVersionUID = -2387594451840081752L;
    Integer productID;
    BigDecimal unitPrice;
    BigDecimal sumUnitPrice;
}
