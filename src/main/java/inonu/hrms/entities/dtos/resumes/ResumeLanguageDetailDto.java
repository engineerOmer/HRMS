package inonu.hrms.entities.dtos.resumes;

import java.math.BigDecimal;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeLanguageDetailDto {
    private int id;
    @JsonProperty("languageId")
    private int languageid;
    private Instant createdDate;
    private String languageName;
    private BigDecimal grade;
}