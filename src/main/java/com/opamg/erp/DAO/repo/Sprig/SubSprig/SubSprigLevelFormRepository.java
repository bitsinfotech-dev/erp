/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Sprig.SubSprig;

import com.opamg.erp.DAO.repo.Root.SubRoot.*;
import com.opamg.erp.DAO.repo.Sprig.SubSprig.*;
import com.opamg.erp.beans.Sprig.SubSprig.SubSprigLevel;
import com.opamg.erp.beans.Sprig.SubSprig.SubSprigLevelForm;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SubSprigLevelFormRepository extends JpaRepository<SubSprigLevelForm, Long> {

  List<SubSprigLevelForm> findByLevel(SubSprigLevel level);

}
