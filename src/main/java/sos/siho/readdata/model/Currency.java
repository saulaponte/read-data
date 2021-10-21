package sos.siho.readdata.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import sos.siho.readdata.dto.SalesDTO;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(catalog = "Sales",name = "Currency" )

@NamedNativeQuery(
        name = "findAllSos",
        query = "select ProductID as ProductID,UnitPrice as UnitPrice, " +
                "(select sum(UnitPrice) from Sales.SalesOrderDetail as t1 where t1.ProductID=t2.ProductID) as sumUnitPrice " +
                "from Sales.SalesOrderDetail as t2",
        resultSetMapping = "sales_dto"
)
@SqlResultSetMapping(
        name = "sales_dto",
        classes = @ConstructorResult(
                targetClass = SalesDTO.class,
                columns = {
                        @ColumnResult(name = "ProductID", type = Integer.class),
                        @ColumnResult(name = "UnitPrice", type = BigDecimal.class),
                        @ColumnResult(name = "sumUnitPrice", type = BigDecimal.class)
                }
        )
)


@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Currency {

    @Column(length = 3, name = "CurrencyCode")
    @Id
    private String currencyCode ;
    @Column(name = "Name")
    private String name;
    @Column(name = "ModifiedDate")
    private LocalDateTime modifiedDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Currency currency = (Currency) o;
        return Objects.equals(currencyCode, currency.currencyCode);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}

