package com.example.pruebalab3.Entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name="employees")
public class Employees {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeid;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phone_number")
    private String phonenumber;
    @Column(name = "hire_date")
    private Date hiredate;
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Jobs jobid;
    @Column(name = "salary")
    private BigDecimal salary;
    @Column(name = "commission_pct")
    private BigDecimal commissionpct;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employees managerid;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments departmentid;
    @Column(name = "enabled")
    private Integer enabled;

    public Integer getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public Jobs getJobid() {
        return jobid;
    }

    public void setJobid(Jobs jobid) {
        this.jobid = jobid;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCommissionpct() {
        return commissionpct;
    }

    public void setCommissionpct(BigDecimal commissionpct) {
        this.commissionpct = commissionpct;
    }

    public Employees getManagerid() {
        return managerid;
    }

    public void setManagerid(Employees managerid) {
        this.managerid = managerid;
    }

    public Departments getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(Departments departmentid) {
        this.departmentid = departmentid;
    }


    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

}
