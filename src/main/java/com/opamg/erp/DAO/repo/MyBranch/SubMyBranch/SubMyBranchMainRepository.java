/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.MyBranch.SubMyBranch;

import com.opamg.erp.beans.MyBranch.MyBranchLevelForm;
import com.opamg.erp.beans.MyBranch.SubMyBranch.SubMyBranchMain;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SubMyBranchMainRepository extends JpaRepository<SubMyBranchMain, Long> {

   SubMyBranchMain findByName(String name);

   List findByPLevelForm(MyBranchLevelForm PLevelForm);

   SubMyBranchMain findTopByOrderByIdAsc();
}
