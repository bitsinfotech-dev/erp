/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Sprig;

import com.opamg.erp.beans.Sprig.SprigLevel;

import com.opamg.erp.beans.Sprig.SprigMain;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface SprigLevelRepository extends JpaRepository<SprigLevel, Long> {

   SprigLevel findByName(String name);

   List<SprigLevel> findByMain(SprigMain main);
}
