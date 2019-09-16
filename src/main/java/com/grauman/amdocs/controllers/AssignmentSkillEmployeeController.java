package com.grauman.amdocs.controllers;


import com.grauman.amdocs.dao.AssignmentSkillEmployeeDAO;
import com.grauman.amdocs.models.vm.AssignmentSkillEmployeeVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/myteam")
public class AssignmentSkillEmployeeController {
    @Autowired
    private AssignmentSkillEmployeeDAO employeeDAO;

    @GetMapping("")
    public ResponseEntity<List<AssignmentSkillEmployeeVM>> getEmployeesByManagerID(@RequestParam Integer managerID, @RequestParam Integer pageNumber, @RequestParam Integer limit) throws SQLException {
        List<AssignmentSkillEmployeeVM> employees = employeeDAO.getEmployeesByManagerID(managerID, pageNumber,limit);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/getbyprojectid")
    public ResponseEntity<List<AssignmentSkillEmployeeVM>> getEmployeesByProjectID(@RequestParam Integer projectid) throws SQLException {
        List<AssignmentSkillEmployeeVM> employees = employeeDAO.getEmployeesByProjectID(projectid);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/getbyskill")
    public ResponseEntity<List<AssignmentSkillEmployeeVM>> searchEmployeesBySkillID(@RequestParam Integer skillID, @RequestParam Integer pageNumber, @RequestParam Integer limit) throws SQLException {
        List<AssignmentSkillEmployeeVM> employees = employeeDAO.searchEmployeesBySkillID(skillID, pageNumber,limit);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/getbyskillset")
    public ResponseEntity<List<AssignmentSkillEmployeeVM>> searchEmployeesBySkillSet(@RequestParam List<Integer> skillSet, @RequestParam Integer pageNumber, @RequestParam Integer limit) throws SQLException{
        List<AssignmentSkillEmployeeVM> employees = employeeDAO.searchEmployeesBySkillSet(skillSet, pageNumber,limit);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}