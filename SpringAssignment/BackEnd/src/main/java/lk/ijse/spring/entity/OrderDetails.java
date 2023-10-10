package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@IdClass(OrderItem_PK.class)
public class OrderDetails {
    @Id
    private String orderId;

    @Id
    private String itemCode;
    private int qty;
    private BigDecimal unitPrice;

    @ManyToOne
    @JoinColumn(name="oid",referencedColumnName = "oid", insertable = false,updatable = false)
    private Orders orders;

    @ManyToOne
    @JoinColumn(name="itemCode",referencedColumnName = "code",insertable = false,updatable = false)
    private Item item;
}
