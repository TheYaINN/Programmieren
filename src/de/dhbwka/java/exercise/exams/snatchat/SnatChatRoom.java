package de.dhbwka.java.exercise.exams.snatchat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class SnatChatRoom {


    private String roomName;
    private List<SnatChatFrontend> frontEnds = new ArrayList<>();

    SnatChatRoom(String roomName) {
        this.roomName = roomName;
    }


    public String getRoomName() {
        return roomName;
    }

    public void register(SnatChatFrontend sfe) {
        Path pathToFile = Paths.get("src/de/dhbwka/java/exercise/exams/snatchat/" + roomName + ".txt");
        frontEnds.add(sfe);
        if (pathToFile.toFile().exists()) {
            try {
                List<String> lines = Files.readAllLines(pathToFile);
                if (lines.size() > 10) {
                    lines = lines.subList(lines.size() - 10, lines.size());
                }
                lines.forEach(le -> sfe.receiveMessage(le));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void unregister(SnatChatFrontend sfe) {
        frontEnds.remove(sfe);
    }

    public void sendMessage(Message msg) {
        frontEnds.forEach(fe -> fe.receiveMessage(msg));
        saveMessage(msg.getMessage());
    }

    public void sendMessage(String text) {
        frontEnds.forEach(fe -> fe.receiveMessage(text));
        saveMessage(text);
    }

    private void saveMessage(final String text) {
        Path pathToFile = Paths.get("src/de/dhbwka/java/exercise/exams/snatchat/" + roomName + ".txt");
        if (!pathToFile.toFile().exists()) {
            try {
                pathToFile.toFile().createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                String saveText = text + "\n";
                Files.write(pathToFile, saveText.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
