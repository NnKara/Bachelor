package com.kara.bachelorpapel.statistic;


import com.kara.bachelorpapel.dto.EducationDto;
import com.kara.bachelorpapel.dto.ExperienceDto;
import com.kara.bachelorpapel.dto.StudentInfoDto;
import com.kara.bachelorpapel.dto.UserDto;
import com.kara.bachelorpapel.enums.EducationLevel;
import com.kara.bachelorpapel.repository.ExperienceRepository;
import com.kara.bachelorpapel.repository.StudentInfoRepository;
import com.kara.bachelorpapel.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentAnalytics {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private StudentInfoRepository studentInfoRepository;

    public List<UserDto> getAllStudents() {
        return userService.findAllUsers();
    }

    public Map<UserDto, List<ExperienceDto>> getAllExp() {
        Map<UserDto, List<ExperienceDto>> expMap = new HashMap<>();
        List<UserDto> users = getAllStudents();
        for (UserDto user : users) {
            List<ExperienceDto> expList = user.getExperiences();
            if (expList != null && !expList.isEmpty()) {
                expMap.put(user, expList);
            }
        }
        return expMap;
    }


    public Map<UserDto, StudentInfoDto> getAllStInfo() {
        Map<UserDto, StudentInfoDto> stInfoMap = new HashMap<>();
        List<UserDto> users = getAllStudents();
        for (UserDto user : users) {
            StudentInfoDto stInfo = user.getStudentInfo();
            if (stInfo != null) {
                stInfoMap.put(user, stInfo);
            }
        }
        return stInfoMap;
    }

    public double getAvgYearsToFindJob(List<UserDto> users) {
        List<Double> yearsToFindJobs = new ArrayList<>();
        for (UserDto user : users) {
            StudentInfoDto stInfo = user.getStudentInfo();
            if (stInfo != null && stInfo.getGraduationYear() != null) {
                LocalDate graduationYear = LocalDate.parse(stInfo.getGraduationYear(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                List<ExperienceDto> expList = user.getExperiences();
                if (expList != null) {
                    LocalDate earliestStartDate = null;
                    for (ExperienceDto exp : expList) {
                        if (exp.getStartDate() != null) {
                            LocalDate startDate = LocalDate.parse(exp.getStartDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                            if (earliestStartDate == null || startDate.isBefore(earliestStartDate)) {
                                earliestStartDate = startDate;
                            }
                        }
                    }
                    if (earliestStartDate != null) {
                        double yearsToFindJob = ChronoUnit.YEARS.between(graduationYear, earliestStartDate);
                        yearsToFindJobs.add(yearsToFindJob);
                    }
                }
            }
        }
        return formatDouble(yearsToFindJobs.stream().mapToDouble(Double::doubleValue).average().orElse(0));
    }
    public static double formatDouble(double value) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Double.parseDouble(decimalFormat.format(value));
    }
    public int getNumContinuedStudies(List<UserDto> users) {
        int count = 0;
        for (UserDto user : users) {
            List<EducationDto> educations = user.getEducations();
            if (educations != null && educations.size() >= 2) {
                EducationLevel firstLevel = educations.get(0).getEducationLevel();
                EducationLevel lastLevel = educations.get(educations.size() - 1).getEducationLevel();
                if (firstLevel == EducationLevel.UNDERGRADUATE && lastLevel != EducationLevel.UNDERGRADUATE) {
                    count++;
                }
            }
        }
        return count;
    }

}
