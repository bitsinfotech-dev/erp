/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.beans.Root;

import java.util.Date;
import java.util.LinkedHashMap;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;

/**
 *
 * @author acer
 */
@Entity
public class RootFormData {

   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Id
   private long id;

   @ManyToOne
   private RootLevelForm levelForm;
   @Column(columnDefinition = "TEXT")
   private String jsonvalue;
   private Date created_at;
   private Date updated_at;

   @ManyToOne
   private RootFormData rootFormData;

   @PrePersist
   protected void onCreate() {
      created_at = new Date();
   }

   @PreUpdate
   protected void onUpdate() {
      updated_at = new Date();
   }

   public RootFormData() {
   }

   public RootFormData(RootLevelForm levelForm, String jsonvalue) {
      this.levelForm = levelForm;
      this.jsonvalue = jsonvalue;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public RootLevelForm getLevelForm() {
      return levelForm;
   }

   public void setLevelForm(RootLevelForm levelForm) {
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

   public Date getCreated_at() {
      return created_at;
   }

   public Date getUpdated_at() {
      return updated_at;
   }

   public RootFormData getRootFormData() {
      return rootFormData;
   }

   public void setRootFormData(RootFormData rootFormData) {
      this.rootFormData = rootFormData;
   }

  

}
