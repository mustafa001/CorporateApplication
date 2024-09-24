package com.corporate.corporateApplication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.corporate.corporateApplication.entity.Staff;
import com.corporate.corporateApplication.repository.StaffRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    private static final Logger logger = LoggerFactory.getLogger(StaffService.class);

    @Autowired
    private StaffRepository staffRepository;

    @Transactional
    public Staff createStaff(Staff staff) {
        logger.info("Request to create staff: {}", staff);
        Staff savedStaff = staffRepository.save(staff);
        logger.info("Response: {}", savedStaff);
        return savedStaff;
    }

    // Get all staff members
    public List<Staff> getAllStaff() {
        return staffRepository.findAll();
    }

    // Get a single staff member by ID
    public Optional<Staff> getStaffById(Long id) {
        return staffRepository.findById(id);
    }

    // Update a staff member by ID
    @Transactional
    public Staff updateStaff(Long id, Staff staffDetails) {
        logger.info("Request to update staff with id: {}", id);
        return staffRepository.findById(id).map(staff -> {
            staff.setName(staffDetails.getName());
            staff.setEmail(staffDetails.getEmail());
            staff.setDob(staffDetails.getDob());
            staff.setAge(staffDetails.getAge());
            Staff updatedStaff = staffRepository.save(staff);
            logger.info("Response: {}", updatedStaff);
            return updatedStaff;
        }).orElseThrow(() -> new RuntimeException("Staff not found"));
    }


    @Transactional(readOnly = true)
    public Staff getStaff(Long id) {
        logger.info("Request to get staff with id: {}", id);
        Staff staff = staffRepository.findById(id).orElseThrow(() -> new RuntimeException("Staff not found"));
        logger.info("Response: {}", staff);
        return staff;
    }

    @Transactional(readOnly = true)
    public Page<Staff> getStaffs(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        logger.info("Request to get staff list with pagination: page={}, size={}", page, size);
        Page<Staff> staffPage = staffRepository.findAll(pageable);
        logger.info("Response: {}", staffPage);
        return staffPage;
    }

    @PostConstruct
    public void initData() {
        // Check if data already exists to avoid duplicate entries
        if (staffRepository.count() == 0) {
            // Insert initial staff data
            List<Staff> initialStaff = List.of(
                    new Staff(1L,
                            "Mustafa bin Jalaluddin",
                            "m001@example.com",
                            LocalDate.of(1999, 9, 9),
                            39
                    ),
                    new Staff(2L,
                            "Aisha binti Rahman",
                            "aisha.rahman@example.com",
                            LocalDate.of(1990, 3, 14),
                            34
                    ),
                    new Staff(3L,
                            "Mohamed bin Iskandar",
                            "mohamed.iskandar@example.com",
                            LocalDate.of(1988, 7, 8),
                            36
                    ),
                    new Staff(4L,
                            "Nurul Ain binti Kamal",
                            "nurul.ain.kamal@example.com",
                            LocalDate.of(1992, 5, 22),
                            32
                    ),
                    new Staff(5L,
                            "Ahmad bin Yusuf",
                            "ahmad.yusuf@example.com",
                            LocalDate.of(1979, 1, 15),
                            45
                    ),
                    new Staff(6L,
                            "Fatimah binti Ali",
                            "fatimah.ali@example.com",
                            LocalDate.of(1985, 6, 12),
                            39
                    ),
                    new Staff(7L,
                            "Zaid bin Ibrahim",
                            "zaid.ibrahim@example.com",
                            LocalDate.of(1991, 11, 5),
                            33
                    ),
                    new Staff(8L,
                            "Syafiqah binti Sulaiman",
                            "syafiqah.sulaiman@example.com",
                            LocalDate.of(1993, 9, 14),
                            31
                    ),
                    new Staff(9L,
                            "Hafiz bin Razak",
                            "hafiz.razak@example.com",
                            LocalDate.of(1980, 4, 19),
                            44
                    ),
                    new Staff(10L,
                            "Aminah binti Osman",
                            "aminah.osman@example.com",
                            LocalDate.of(1984, 8, 27),
                            40
                    ),
                    new Staff(11L,
                            "Azman bin Noor",
                            "azman.noor@example.com",
                            LocalDate.of(1990, 10, 12),
                            34
                    ),
                    new Staff(12L,
                            "Siti Nurhaliza binti Mohamad",
                            "siti.nurhaliza@example.com",
                            LocalDate.of(1992, 3, 30),
                            32
                    ),
                    new Staff(13L,
                            "Hasan bin Mahmud",
                            "hasan.mahmud@example.com",
                            LocalDate.of(1981, 7, 1),
                            43
                    ),
                    new Staff(14L,
                            "Zulaikha binti Abdullah",
                            "zulaikha.abdullah@example.com",
                            LocalDate.of(1989, 4, 9),
                            35
                    ),
                    new Staff(15L,
                            "Farid bin Bakri",
                            "farid.bakri@example.com",
                            LocalDate.of(1987, 5, 17),
                            37
                    ),
                    new Staff(16L,
                            "Nur Izzah binti Ahmad",
                            "nur.izzah.ahmad@example.com",
                            LocalDate.of(1994, 2, 25),
                            30
                    ),
                    new Staff(17L,
                            "Shahrul bin Hamid",
                            "shahrul.hamid@example.com",
                            LocalDate.of(1983, 6, 10),
                            41
                    ),
                    new Staff(18L,
                            "Sarah binti Zainuddin",
                            "sarah.zainuddin@example.com",
                            LocalDate.of(1995, 11, 22),
                            29
                    ),
                    new Staff(19L,
                            "Yusof bin Ishak",
                            "yusof.ishak@example.com",
                            LocalDate.of(1986, 8, 13),
                            38
                    ),
                    new Staff(20L,
                            "Amani binti Rahim",
                            "amani.rahim@example.com",
                            LocalDate.of(1991, 2, 6),
                            33
                    ),
                    new Staff(21L,
                            "Hassan bin Daud",
                            "hassan.daud@example.com",
                            LocalDate.of(1984, 12, 18),
                            40
                    ),
                    new Staff(22L,
                            "Zarina binti Zulkifli",
                            "zarina.zulkifli@example.com",
                            LocalDate.of(1992, 7, 29),
                            32
                    ),
                    new Staff(23L,
                            "Ismail bin Osman",
                            "ismail.osman@example.com",
                            LocalDate.of(1987, 10, 21),
                            37
                    ),
                    new Staff(24L,
                            "Aqilah binti Ismail",
                            "aqilah.ismail@example.com",
                            LocalDate.of(1993, 12, 12),
                            31
                    ),
                    new Staff(25L,
                            "Amir bin Shahril",
                            "amir.shahril@example.com",
                            LocalDate.of(1989, 1, 4),
                            35
                    ),
                    new Staff(26L,
                            "Nurul Iman binti Faiz",
                            "nurul.iman.faiz@example.com",
                            LocalDate.of(1994, 9, 3),
                            30
                    ),
                    new Staff(27L,
                            "Roslan bin Yusof",
                            "roslan.yusof@example.com",
                            LocalDate.of(1981, 2, 15),
                            43
                    ),
                    new Staff(28L,
                            "Atiqah binti Rashid",
                            "atiqah.rashid@example.com",
                            LocalDate.of(1986, 6, 7),
                            38
                    ),
                    new Staff(29L,
                            "Imran bin Rahmat",
                            "imran.rahmat@example.com",
                            LocalDate.of(1990, 8, 19),
                            34
                    ),
                    new Staff(30L,
                            "Farah binti Shafie",
                            "farah.shafie@example.com",
                            LocalDate.of(1993, 11, 30),
                            31
                    )
            );

            staffRepository.saveAll(initialStaff);
        }
    }
}
