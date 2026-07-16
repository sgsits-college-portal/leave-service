package com.leave.leave_management_system.controller;

import com.leave.leave_management_system.entity.LeaveRequest;
import com.leave.leave_management_system.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/leave")
@CrossOrigin("*")
public class LeaveController {

    @Autowired
    LeaveService service;

    @PostMapping("/apply")
    @PreAuthorize("hasAnyAuthority('ROLE_STUDENT', 'ROLE_FACULTY', 'ROLE_TEACHER', 'ROLE_STAFF', 'ROLE_HEAD')")
    public LeaveRequest apply(@RequestBody LeaveRequest leave) {
        return service.applyLeave(leave);
    }

    @GetMapping("/employee/{id}")
    @PreAuthorize("isAuthenticated()")
    public List<LeaveRequest> history(@PathVariable Long id) {
        return service.getEmployeeLeaves(id);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_HEAD', 'SUB_HEAD_OF_DEPT', 'SUB_HOD')")
    public List<LeaveRequest> getAll() {
        return service.getAllLeaves();
    }

    @PutMapping("/approve/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_HEAD', 'SUB_HEAD_OF_DEPT', 'SUB_HOD')")
    public LeaveRequest approve(@PathVariable Long id) {
        return service.approveLeave(id);
    }

    @PutMapping("/reject/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_HEAD', 'SUB_HEAD_OF_DEPT', 'SUB_HOD')")
    public LeaveRequest reject(@PathVariable Long id) {
        return service.rejectLeave(id);
    }

}