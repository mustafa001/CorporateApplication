package com.corporate.corporateApplication.repository;
import com.corporate.corporateApplication.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    // Custom query methods if needed
}
