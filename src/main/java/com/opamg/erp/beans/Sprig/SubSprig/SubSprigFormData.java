/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.beans.Sprig.SubSprig;

import com.opamg.erp.beans.Sprig.SprigFormData;
import java.util.Date;
import java.util.LinkedHashMap;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 *
 * @author acer
 */
@Entity
public class SubSprigFormData {

   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Id
   private long id;

   @ManyToOne
   private SubSprigLevelForm levelForm;
   @ManyToOne
   @OnDelete(action = OnDeleteAction.CASCADE)
   private SprigFormData sprigFormData;

   @Column(columnDefinition = "TEXT")
   private String jsonvalue;
   private Date created_at;
   private Date updated_at;

   @PrePersist
   protected void onCreate() {
      created_at = new Date();
   }

   @PreUpdate
   protected void onUpdate() {
      updated_at = new Date();
   }
   public SubSprigFormData() {
   }

   public SubSprigFormData(SubSprigLevelForm levelForm, String jsonvalue) {
      this.levelForm = levelForm;
      this.jsonvalue = jsonvalue;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public SubSprigLevelForm getLevelForm() {
      return levelForm;
   }

   public void setLevelForm(SubSprigLevelForm levelForm) {
      this.levelForm = levelForm;
   }

   public String getJsonvalue() {
      return jsonvalue;
   }

   public void setJsonvalue(String jsonvalue) {
      this.jsonvalue = jsonvalue;
   }

   public LinkedHashMap stringTOJson(String str) {

//    str = str.replace("\"", "\\\"");
      Object object;
      try {
	LinkedHashMap hashMap = (LinkedHashMap) new JSONParser(str).parse();
	return hashMap;
      } catch (ParseException ex) {
	ex.printStackTrace();
      }
      return null;
   }

   public SprigFormData getSprigFormData() {
      return sprigFormData;
   }

   public void setSprigFormData(SprigFormData sprigFormData) {
      this.sprigFormData = sprigFormData;
   }


}
