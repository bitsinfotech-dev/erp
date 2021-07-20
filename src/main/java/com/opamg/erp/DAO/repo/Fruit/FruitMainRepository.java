/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Fruit;

import com.opamg.erp.beans.Fruit.FruitMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface FruitMainRepository extends JpaRepository<FruitMain, Long> {

   FruitMain findByName(String name);

   FruitMain findTopByOrderByIdAsc();
}
