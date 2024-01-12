package net.javaguides.entity;

import java.time.LocalDateTime;

// import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long orderId;
    @Column(name = "MEMBER_ID")
    private Long memberId;
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;
    @Column(name = "ORDER_TIME")
    @CreationTimestamp
    private LocalDateTime orderTime;
    @Column(name = "LUMP_SUM")
    private String lumpSum;
    @Column(name = "PAY_ID")
    private Long payId;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID",referencedColumnName = "MEMBER_ID", insertable = false, updatable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID",referencedColumnName = "EMPLOYEE_ID", insertable = false, updatable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "PAY_ID",referencedColumnName = "PAY_ID", insertable = false, updatable = false)
    private Pay pay;
}
