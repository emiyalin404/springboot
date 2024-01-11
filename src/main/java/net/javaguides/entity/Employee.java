package net.javaguides.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// import javax.persistence.Temporal;
// import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

// import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;
    @Column(name = "EMPLOYEE_NAME")
    private String employeeName;
    @Column(name = "BIRTHDAY")
    private Date birthday;
    @Column(name = "JOB_TITLE")
    private String jobTitle;
    @Column(name = "ARRIVAL_DATE")
    @CreationTimestamp
    private LocalDateTime arrivalDate;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONE")
    private String phone;

}
