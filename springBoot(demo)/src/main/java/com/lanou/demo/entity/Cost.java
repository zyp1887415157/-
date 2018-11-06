package com.lanou.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "cost")
public class Cost  {

  @Id
  private long costId;

  private String name;
  private Long baseDuration;
  private Long baseCost;
  private Long unitCost;
  private String status;
  private String descr;
  private java.sql.Timestamp creatime;
  private java.sql.Timestamp startime;
  private String costType;


  public long getCostId() {
    return costId;
  }

  public void setCostId(long costId) {
    this.costId = costId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getBaseDuration() {
    return baseDuration;
  }

  public void setBaseDuration(long baseDuration) {
    this.baseDuration = baseDuration;
  }

  public long getBaseCost() {
    return baseCost;
  }

  public void setBaseCost(long baseCost) {
    this.baseCost = baseCost;
  }

  public long getUnitCost() {
    return unitCost;
  }

  public void setUnitCost(long unitCost) {
    this.unitCost = unitCost;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getDescr() {
    return descr;
  }

  public void setDescr(String descr) {
    this.descr = descr;
  }

  public Timestamp getCreatime() {
    return creatime;
  }

  public void setCreatime(Timestamp creatime) {
    this.creatime = creatime;
  }

  public Timestamp getStartime() {
    return startime;
  }

  public void setStartime(Timestamp startime) {
    this.startime = startime;
  }

  public String getCostType() {
    return costType;
  }

  public void setCostType(String costType) {
    this.costType = costType;
  }
}
