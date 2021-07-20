/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.controller.MyBranch;

import MyCommon.CommonDeclaration;
import com.opamg.erp.DAO.service.MyBranch.MyBranchFormDataService;
import com.opamg.erp.DAO.service.MyBranch.MyBranchLevelFormService;
import com.opamg.erp.DAO.service.MyBranch.SubMyBranch.SubMyBranchFormDataService;
import com.opamg.erp.beans.MyBranch.MyBranchFormData;
import com.opamg.erp.beans.MyBranch.SubMyBranch.SubMyBranchFormData;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import net.minidev.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acer
 */
@Controller
@RestController
public class MyBranchFormDataController implements CommonDeclaration {

   private final String dir = file_dir + "MyBranch";
   @Autowired
   MyBranchFormDataService dataService;
   @Autowired

   SubMyBranchFormDataService dataSubService;
   @Autowired

   MyBranchLevelFormService formService;

   @PostMapping(path = "mybranch/level-form-data/create")
   JSONObject saveFormData(HttpServletRequest request) {

      JSONObject jsonObj = new JSONObject();
      String filename = "";
      try {
	for (Part part : request.getParts()) {
	   String fieldName = part.getName();
	   jsonObj.put(fieldName, request.getParameter(fieldName));
	   if (part.getSubmittedFileName() != null && !part.getContentType().equals("application/octet-stream")) {
	      filename = new Date().getTime() + "_" + part.getSubmittedFileName();
	      jsonObj.put(fieldName, filename);
	      part.write(dir + "/" + filename);
	   } else {
	   }
	}
      } catch (Exception ex) {
	ex.printStackTrace();
      }
      MyBranchFormData formdata = new MyBranchFormData();
      long l = Long.parseLong(String.valueOf(jsonObj.get("levelFormId")));
      formdata.setLevelForm(formService.getRepository().findById(l).get());
      jsonObj.remove("levelFormId");
      formdata.setJsonvalue(jsonObj.toJSONString());
      dataService.getRepository().save(formdata);
      jsonObj.put("id", formdata.getId());
      return jsonObj;

   }

   @PostMapping(path = "mybranch/level-form-data/update")
   JSONObject updateFormData(HttpServletRequest request) {
      JSONObject jsonObj = new JSONObject();
      String filename = "";

      try {
	for (Part part : request.getParts()) {
	   String fieldName = part.getName();
	   jsonObj.put(fieldName, request.getParameter(fieldName));
	   System.err.println("fle name" + fieldName);

	   if (part.getSubmittedFileName() != null && !part.getContentType().equals("application/octet-stream")) {
	      filename = new Date().getTime() + "_" + part.getSubmittedFileName();
	      System.err.println("----------------------********************" + part.getContentType() + "////////////" + fieldName);
	      jsonObj.put(fieldName, filename);
	      part.write(dir + "/" + filename);
	   } else {
	   }

	}
      } catch (Exception ex) {
	ex.printStackTrace();
      }
      MyBranchFormData formdata = dataService.getRepository().findById(Long.parseLong(String.valueOf(jsonObj.get("formDataId")))).get();
      long l = Long.parseLong(String.valueOf(jsonObj.get("levelFormId")));

      formdata.setLevelForm(formService.getRepository().findById(l).get());
      for (Iterator iterator = jsonObj.keySet().iterator(); iterator.hasNext();) {
	String key = (String) iterator.next();
	System.err.println("**************" + jsonObj.get(key));
	if (jsonObj.get(key) == null || jsonObj.get(key).equals("")) {
	   String val = formdata.stringTOJson(formdata.getJsonvalue()).get(key).toString();
	   jsonObj.put(key, val);
	}
      }
      jsonObj.remove("levelFormId");
      jsonObj.remove("formDataId");
      formdata.setJsonvalue(jsonObj.toJSONString());
      dataService.getRepository().save(formdata);
      jsonObj.put("id", formdata.getId());
      return jsonObj;
   }

   @GetMapping(value = "mybranch/level-form-data/delete/")
   ModelAndView deleteFormField(@RequestParam long id, HttpServletRequest req) {
      List li = dataSubService.getRepository().findByFormData(dataService.getRepository().findById(id).get());
      for (int i = 0; i < li.size(); i++) {
	dataSubService.getRepository().delete((SubMyBranchFormData) li.get(i));
      }

      dataService.getRepository().deleteById(id);
      return new ModelAndView("redirect:" + req.getHeader("Referer"));
   }

   @RequestMapping(value = "mybranch/{filename}", method = RequestMethod.GET, produces = MediaType.MULTIPART_FORM_DATA_VALUE)
   public void getImage(@PathVariable String filename, HttpServletResponse response) throws IOException {
      ClassPathResource file = new ClassPathResource("templates/MyBranch/" + filename);
      response.setContentType(MediaType.MULTIPART_FORM_DATA_VALUE);
      StreamUtils.copy(file.getInputStream(), response.getOutputStream());
   }
}
