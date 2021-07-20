/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.beans.Fruit;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author acer
 */
@Entity
public class FruitLevel {

  @GeneratedValue(strategy = GenerationType.AUTO)
  @Id
  private long id;
  @Column(unique = true)
  private String name;

  @ManyToOne(cascade = CascadeType.DETACH)
   private FruitMain main;

 @Column(insertable = true)
  private long level_id;

   public FruitMain getChart() {
    return main;
  }

   public void setChart(FruitMain main) {
    this.main = main;
  }

   public FruitLevel() {
  }

   public FruitLevel(String name, FruitMain main) {
    this.name = name;
    this.main = main;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "RootChart{" + "id=" + id + ", name=" + name + '}';
  }

  public long getLevel_id() {
    return level_id;
  }

  public void setLevel_id(long level_id) {
    this.level_id = level_id;
  }


}
