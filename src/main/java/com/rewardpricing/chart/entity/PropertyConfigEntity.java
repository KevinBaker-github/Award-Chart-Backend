package com.rewardpricing.chart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity
@Table(name = "PropertyConfigs")
public class PropertyConfigEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  
  @Column(updatable = false)
  private String property;
  
  @Column(updatable = false)
  private int category;
  
  @Column(updatable = false)
  private double occupancy;

  @Column(updatable = false)
  private double valuePerPoint;

}
