package com.practice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EMP_TABLE")
public class Employee {
    @Id
    @GeneratedValue
    private int empId;
    private String empName;
    private int deptId;
    private String status;
    private  double salary;

}
