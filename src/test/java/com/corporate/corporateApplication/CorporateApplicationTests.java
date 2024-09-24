package com.corporate.corporateApplication;

import com.corporate.corporateApplication.entity.Staff;
import com.corporate.corporateApplication.repository.StaffRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CorporateApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private StaffRepository staffRepository;

	@Autowired
	private ObjectMapper objectMapper;  // For serializing Java objects to JSON

	@BeforeEach
	@Transactional
	void setUp() {
		// Add a staff member before each test
		Staff staff = new Staff();
		staff.setName("John Doe");
		staff.setEmail("john.doe@example.com");
		staff.setDob(LocalDate.of(1990, 1, 1));
		staff.setAge(31);
		staffRepository.save(staff);
	}

	@Test
	void contextLoads() {
		// Ensure the application context is loading without issues
	}

	@Test
	void testGetStaffById() throws Exception {
		// Test case for getting staff by ID
		mockMvc.perform(get("/api/staff/{id}", 1L))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Mustafa bin Jalaluddin"))
				.andExpect(jsonPath("$.email").value("m001@example.com"));
	}

	@Test
	void testCreateStaff() throws Exception {
		// Test case for creating a new staff member
		Staff newStaff = new Staff();
		newStaff.setName("Jane Doe");
		newStaff.setEmail("jane.doe@example.com");
		newStaff.setDob(LocalDate.of(1992, 5, 15));
		newStaff.setAge(29);

		mockMvc.perform(post("/api/staff")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(newStaff)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Jane Doe"))
				.andExpect(jsonPath("$.email").value("jane.doe@example.com"));
	}

	@Test
	void testUpdateStaff() throws Exception {
		// Test case for updating an existing staff member
		Staff updatedStaff = new Staff();
		updatedStaff.setName("John Smith");
		updatedStaff.setEmail("john.smith@example.com");
		updatedStaff.setDob(LocalDate.of(1990, 1, 1));
		updatedStaff.setAge(31);

		mockMvc.perform(put("/api/staff/{id}", 2L)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(updatedStaff)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("John Smith"))
				.andExpect(jsonPath("$.email").value("john.smith@example.com"));
	}

	@Test
	void testGetAllStaffWithPagination() throws Exception {
		// Test case for getting all staff members with pagination
		mockMvc.perform(get("/api/staff")
						.param("page", "0")
						.param("size", "10"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.content.length()").value(10));  // Check that the size of the content is 1
	}
}
