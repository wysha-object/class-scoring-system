package cn.com.wysha;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wysha
 */
public class Data implements Serializable {
    private final HashMap<String, Student> studentList = new HashMap<>();
    private final HashSet<String> scoreList = new HashSet<>();

    public Data() {
    }

    public void putStudent(String ID, String studentName) {
        studentList.put(ID, new Student(studentName));
    }

    public void deleteStudent(String ID) {
        studentList.remove(ID);
    }

    public void change(String ID, String scoreName, Integer changeScore) {
        if (noScore(scoreName)) {
            System.out.println("NotFoundScore");
            return;
        }
        Student student = studentList.get(ID);
        if (student == null) {
            System.out.println("NotFoundStudent");
            return;
        }
        student.putScore(scoreName, student.getScore(scoreName) + changeScore);
    }

    public void allChange(String scoreName, Integer changeScore) {
        if (noScore(scoreName)) {
            System.out.println("NotFoundScore");
            return;
        }
        for (Student student : studentList.values()) {
            student.putScore(scoreName, student.getScore(scoreName) + changeScore);
        }
    }

    public void addScore(String scoreName, Integer scoreDefaultValue) {
        scoreList.add(scoreName);
        for (Student student : studentList.values()) {
            student.putScore(scoreName, scoreDefaultValue);
        }
    }

    public void deleteScore(String scoreName) {
        scoreList.remove(scoreName);
        for (Student student : studentList.values()) {
            student.deleteScore(scoreName);
        }
    }

    private boolean noScore(String scoreName) {
        boolean b = true;
        for (String score : scoreList) {
            if (score.equals(scoreName)) {
                b = false;
                break;
            }
        }
        return b;
    }

    public void setStudentScore(String scoreName, String ID, Integer scoreValue) {
        Student student = studentList.get(ID);
        if (student == null) {
            System.out.println("NotFoundStudent");
            return;
        }
        if (noScore(scoreName)) {
            System.out.println("NotFoundScore");
            return;
        }
        student.putScore(scoreName, scoreValue);
    }

    public void view(String scoreName) {
        if (noScore(scoreName)) {
            System.out.println("NotFoundScore");
            return;
        }
        ArrayList<String[]> data = new ArrayList<>();
        int v = 0;
        for (Student student : studentList.values()) {
            String[] strings = new String[3];
            strings[1] = student.getName();
            int value = student.getScore(scoreName);
            strings[2] = String.valueOf(value);
            v += value;
            for (int i = 0; i <= data.size(); i++) {
                if (i == data.size() || Integer.parseInt(data.get(i)[2]) < value) {
                    strings[0] = String.valueOf(i);
                    data.add(i, strings);
                    break;
                }
            }
        }
        new View(scoreName, data.toArray(new String[0][3]), v / studentList.size()).setVisible(true);
    }

    public void totalScoreView() {
        ArrayList<String[]> data = new ArrayList<>();
        int v = 0;
        for (Student student : studentList.values()) {
            String[] strings = new String[3];
            strings[1] = student.getName();
            int value = student.getTotalScore();
            strings[2] = String.valueOf(value);
            v += value;
            for (int i = 0; i <= data.size(); i++) {
                if (i == data.size() || Integer.parseInt(data.get(i)[2]) < value) {
                    strings[0] = String.valueOf(i);
                    data.add(i, strings);
                    break;
                }
            }
        }
        new View("totalScore", data.toArray(new String[0][3]), v / studentList.size()).setVisible(true);
    }
}
