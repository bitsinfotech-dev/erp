/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Leaf;

import com.opamg.erp.beans.Leaf.LeafLevel;

import com.opamg.erp.beans.Leaf.LeafMain;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface LeafLevelRepository extends JpaRepository<LeafLevel, Long> {

  LeafLevel findByName(String name);

  List<LeafLevel> findByMain(LeafMain main);
}
