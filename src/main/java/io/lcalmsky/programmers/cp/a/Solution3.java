package io.lcalmsky.programmers.cp.a;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Grade {
    A_PLUS("A+", 92),
    A("A0", 91),
    A_MINUS("A-", 90),
    B_PLUS("B+", 82),
    B("B0", 81),
    B_MINUS("B-", 80),
    C_PLUS("C+", 72),
    C("C0", 71),
    C_MINUS("C-", 70),
    D_PLUS("D+", 62),
    D("D0", 61),
    D_MINUS("D-", 60),
    F("F", 59);

    private static final Map<String, Grade> GRADE_MAP = Stream.of(values()).collect(Collectors.toMap(Grade::getGrade, Function.identity()));
    private static final Map<Integer, Grade> SCORE_MAP = Stream.of(values()).collect(Collectors.toMap(Grade::getScore, Function.identity()));

    private final String grade;
    private final int score;

    Grade(String grade, int score) {
        this.grade = grade;
        this.score = score;
    }

    public static Grade of(String grade) {
        return GRADE_MAP.getOrDefault(grade, F);
    }

    public static Grade ofScore(int score) {
        return SCORE_MAP.getOrDefault(score, F);
    }

    public String getGrade() {
        return grade;
    }

    public int getScore() {
        return score;
    }

    public String getGreater(String grade) {
        int maxScore = Math.max(getScore(), Grade.of(grade).getScore());
        return Grade.ofScore(maxScore).getGrade();
    }
}

class GradeCard implements Comparable<GradeCard> {
    private final String subject;
    private final String grade;

    public GradeCard(String subject, String grade) {
        this.subject = subject;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.subject, this.grade);
    }

    public String getSubject() {
        return subject;
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public int compareTo(GradeCard o) {
        int result = Integer.compare(Grade.of(o.grade).getScore(), Grade.of(this.grade).getScore());
        return result == 0 ? o.subject.compareTo(this.subject) : result;
    }
}

public class Solution3 {

    public static void main(String[] args) {
        new Solution3().solution(new String[]{"DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-", "DS7651 B+", "AI0001 F", "DB0001 B-", "AI5543 D+", "DS7651 A+", "OS1808 B-"});
    }
    public String[] solution(String[] grades) {
        Map<String, String> gradeMap = new HashMap<>();
        for (String grade : grades) {
            String[] split = grade.split(" ");
            String subject = split[0];
            String newGrade = split[1];
            gradeMap.put(subject, Grade.of(gradeMap.getOrDefault(subject, "F")).getGreater(newGrade));
        }

        List<GradeCard> gradeCards = gradeMap.entrySet().stream()
                .map((entry) -> new GradeCard(entry.getKey(), entry.getValue()))
                .sorted()
                .collect(Collectors.toList());


        String[] answer = new String[gradeCards.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = gradeCards.get(i).toString();
        }
        return answer;
    }
}
