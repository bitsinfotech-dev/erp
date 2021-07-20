/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Flower;

import com.opamg.erp.beans.Flower.FlowerLevel;
import com.opamg.erp.beans.Flower.FlowerLevelForm;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface FlowerLevelFormRepository extends JpaRepository<FlowerLevelForm, Long> {

  List<FlowerLevelForm> findByLevel(FlowerLevel level);

}
