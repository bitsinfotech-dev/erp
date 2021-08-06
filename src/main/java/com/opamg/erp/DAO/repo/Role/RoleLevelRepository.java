/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo.Role;

import com.opamg.erp.beans.Role.RoleLevel;

import com.opamg.erp.beans.Role.RoleMain;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface RoleLevelRepository extends JpaRepository<RoleLevel, Long> {

  RoleLevel findByName(String name);

  List<RoleLevel> findByMain(RoleMain main);
}
