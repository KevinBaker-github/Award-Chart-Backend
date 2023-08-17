package com.rewardpricing.chart.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "RewardPricingChart")
public class RewardPricingEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(updatable = false)
  private int category;

  @Column(updatable = false)
  private String roomCategory;

  @Column(updatable = false)
  private String pricingLevel;

  @Column
  private double points;

  @UpdateTimestamp
  @Column(name = "updateDatetime", nullable = false)
  private Date updateDatetime;

  @Column(name = "updateUser")
  private String updateUser;

  public RewardPricingEntity(int category, String roomCategory, String pricingLevel, double points,
      Date updateDatetime, String updateUser) {
    super();
    this.category = category;
    this.roomCategory = roomCategory;
    this.pricingLevel = pricingLevel;
    this.points = points;
    this.updateDatetime = updateDatetime;
    this.updateUser = updateUser;
  }

}
