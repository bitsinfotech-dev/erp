/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.opamg.erp.DAO.repo;

import com.opamg.erp.beans.MyRole;
import com.opamg.erp.beans.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author acer
 */
@Repository
public interface RoleRepository extends JpaRepository<MyRole, Long> {

    List<MyRole> findByName(String name);

}
