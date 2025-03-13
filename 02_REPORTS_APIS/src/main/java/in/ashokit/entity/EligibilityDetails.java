package in.ashokit.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="ELIGIBILITY_DETAILS")
public class EligibilityDetails {

	@Id
	private Integer eligId;
	private String name;
	private String email;
	private Long mobile;
	private Character gender;
	private Long ssn;
	private String planName;
	private String planStatus;
	private LocalDate planStartDate;
	private LocalDate planEndDate;
	private LocalDate createDate;
	private LocalDate updateDate;
	private String createdBy;
	private String updatedBy;
}
