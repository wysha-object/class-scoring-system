package cn.com.wysha;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * @author wysha
 */
public class Main {
    public static void main(String[] args) {
        try {
            Logger logger = Logger.getLogger(Main.class.getName());
            Data data = new Data();
            Scanner sc = new Scanner(System.in);
            while (true) {
                String str = sc.nextLine();
                logger.info(str);
                String[] strings = str.split(" ");
                switch (strings[0]) {
                    case "exit" -> System.exit(0);
                    case "putStu" -> data.putStudent(strings[1], strings[2]);
                    case "delStu" -> data.deleteStudent(strings[1]);
                    case "change" -> data.change(strings[1], strings[2], Integer.parseInt(strings[3]));
                    case "allChange" -> data.allChange(strings[1], Integer.parseInt(strings[2]));
                    case "addSco" -> data.addScore(strings[1], Integer.parseInt(strings[2]));
                    case "setSco" -> data.setStudentScore(strings[1], strings[2], Integer.parseInt(strings[3]));
                    case "delSco" -> data.deleteScore(strings[1]);
                    case "read" -> {
                        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(strings[1]))) {
                            data = (Data) objectInputStream.readObject();
                        } catch (Exception e) {
                            logger.warning(e.getMessage());
                        }
                    }
                    case "write" -> {
                        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(strings[1]))) {
                            objectOutputStream.writeObject(data);
                        } catch (Exception e) {
                            logger.warning(e.getMessage());
                        }
                    }
                    case "view" -> data.view(strings[1]);
                    case "totalScoreView" -> data.totalScoreView();
                    case "v" -> System.out.println("1.0.0");
                    default -> logger.warning("Not a CMD");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}