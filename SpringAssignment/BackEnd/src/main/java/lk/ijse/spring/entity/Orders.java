package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Orders {
    @Id
    private String oid;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "CustomerID",referencedColumnName = "id",nullable = false)
    private Customer cusId;
    private LocalDate date;

    @OneToMany(mappedBy= "orders",cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;

}
