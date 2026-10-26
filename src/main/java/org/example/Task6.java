package org.example;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Task6 {
    static void main() {
        try {
            List<Visitor> visitors = new ArrayList<>(JsonReader.loadVisitors(
                    "src\\main\\resources\\book.json"));
            double averageBooks = visitors.stream()
                    .mapToInt(v -> v.getFavoriteBooks().size())
                    .average()
                    .orElse(0.0);
            Map<String, List<SmsMessage>> smsGroups = visitors.stream()
                    .filter(Visitor::isSubscribed)
                    .map(v -> {
                        int count = v.getFavoriteBooks().size();
                        String text;
                        if (count > averageBooks) {
                            text = "You are a bookworm";
                        } else if (count < averageBooks) {
                            text = "Read more";
                        } else {
                            text = "Fine";
                        }
                        return  new SmsMessage(v.getPhone(), text);
                    })
                    .collect(Collectors.groupingBy(SmsMessage::getMessage));
            smsGroups.forEach((text, messages) -> {
                for (SmsMessage message : messages) {
                    System.out.println(message.getPhoneNumber() + " " + text);
                }
            });
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        }
    }
}
