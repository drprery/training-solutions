package week12d01;

public class GradeRounder {
    public int[] roundGrades(int[] grades){
        int[] retGrades = new int[grades.length];

        for(int gradeIndex =0; gradeIndex<grades.length;gradeIndex++){
            if(grades[gradeIndex]>40){
                int multFive = grades[gradeIndex]%5==0 ? grades[gradeIndex] : ((grades[gradeIndex]/5)+1)*5;
                if ((multFive-grades[gradeIndex])<3){
                    retGrades[gradeIndex]=multFive;
                } else {
                    retGrades[gradeIndex]=grades[gradeIndex];
                }
            } else {
                retGrades[gradeIndex]=grades[gradeIndex];
            }
        }

        return retGrades;
    }
}
