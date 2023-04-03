package com.kara.bachelorpapel.statistic;

public class TotalStudentAnalytics {

//    public double calculateAverageYearsFromGraduationToFirstJob(List<User> users) {
//        int totalYears = 0;
//        int count = 0;
//
//        for (User user : users) {
//            int years = calculateYearsFromGraduationToFirstJob(user);
//            totalYears += years;
//            count++;
//        }
//
//        if (count == 0) {
//            // Avoid division by zero
//            return 0;
//        } else {
//            return (double) totalYears / count;
//        }
//    }
//
//    private int calculateYearsFromGraduationToFirstJob(User user) {
//// Get the student's graduation year from their StudentInfo object
//        int graduationYear = Integer.parseInt(user.getStudentInfo().getGraduationYear());
//
//        // Get the list of the student's work experiences
//        List<Experience> experiences = user.getExperiences();
//
//        // Find the first job that the student had
//        Experience firstJob = experiences.stream()
//                .filter(experience -> experience.getStartDate().isAfter(LocalDate.of(Integer.parseInt(String.valueOf(graduationYear)), 12, 31)))
//                .min(Comparator.comparing(Experience::getStartDate))
//                .orElse(null);
//
//        if (firstJob == null) {
//            // The student has not had a job after graduation
//            return 0;
//        } else {
//            // Calculate the number of years between the student's graduation year and the start date of their first job
//            int years = Period.between(LocalDate.of(graduationYear, 1, 1), firstJob.getStartDate()).getYears();
//            return years;
//        }
//    }
}
