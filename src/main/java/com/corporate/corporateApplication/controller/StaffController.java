package com.corporate.corporateApplication.controller;

import com.corporate.corporateApplication.entity.Staff;
import com.corporate.corporateApplication.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping(path = "api/staff")
public class StaffController {

    @Autowired
    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping
    public ResponseEntity<Staff> createStaff(@RequestBody Staff staff) {
        return ResponseEntity.ok(staffService.createStaff(staff));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id, @RequestBody Staff staffDetails) {
        return ResponseEntity.ok(staffService.updateStaff(id, staffDetails));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable Long id) {
        return ResponseEntity.ok(staffService.getStaff(id));
    }

    @GetMapping
    public ResponseEntity<Page<Staff>> getAllStaffs(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(staffService.getStaffs(page, size));
    }
}
