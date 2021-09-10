package com.example.demo.controller;

import com.example.demo.dto.RoleDto;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/roles")
public class RestRoleController {
    @Autowired
    private RoleRepository role;

    @Autowired
    private EntityManager manager;

    //get list role
    @GetMapping()
    public List<RoleDto> getRole() {
        String sql = "SElECT entity FROM Role entity";
        String whereClause = " WHERE (1=1)";

        String description = "1";

        whereClause += " AND entity.description LIKE :description";

        sql += whereClause;
        Query query = manager.createQuery(sql, Role.class);

        query.setParameter("description", "%" + description + "%");


        List<Role> entities = query.getResultList();
        List<RoleDto> results = entities
                .parallelStream()   //tuowng tu fori
                .map(RoleDto::new)  //
                .collect(Collectors.toList());

//        for(Role role: entities){
//            RoleDto dto = new RoleDto(role);
//        }
        return results;
    }
}
