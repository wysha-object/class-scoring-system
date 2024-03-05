package cn.com.wysha;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author wysha
 */
public class Student implements Serializable {
    private final String name;

    private final HashMap<String, Integer> scores = new HashMap<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void putScore(String scoreName, Integer scoreValue) {
        scores.put(scoreName, scoreValue);
    }

    public void deleteScore(String scoreName) {
        scores.remove(scoreName);
    }

    public Integer getScore(String scoreName) {
        return scores.get(scoreName);
    }

    public Integer getTotalScore() {
        int total = 0;
        for (Integer score : scores.values()) {
            total += score;
        }
        return total;
    }

    @Override
    public String toString() {
        return name;
    }
}
