package com.ingesis.cursoJpa;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TimeTracker {
    private Map<String, TimeTrackItem> timeTrackItemMap = new HashMap<>();

    public void start(String label) {
        TimeTrackItem item;
        if (timeTrackItemMap.containsKey(label)) {
            item = timeTrackItemMap.get(label);
        } else {
            item = new TimeTrackItem(label);
            timeTrackItemMap.put(label, item);
        }
        item.start();
    }

    public void stop(String label) {
        if (timeTrackItemMap.containsKey(label)) {
            TimeTrackItem item = timeTrackItemMap.get(label);
            item.stop();
            printTimeSpent(item);
        } else {
            System.out.println(String.format(
                    "Label %s does not exists",
                    label)
            );
        }
    }

    private void printTimeSpent(TimeTrackItem timeTrackItem) {
        System.out.println(String.format(
                "** Time spent for %s: %.2f",
                timeTrackItem.getLabel(),
                timeTrackItem.getTimeSpent())
        );
    }

    @Getter
    class TimeTrackItem {
        protected String label;
        protected long startMillis;
        protected long endMillis;

        public TimeTrackItem(String label) {
            this.label = label;
            this.startMillis = 0;
            this.endMillis = 0;
        }

        public void start() {
            startMillis = System.currentTimeMillis();
            endMillis = 0;
        }

        public void stop() {
            endMillis = System.currentTimeMillis();
        }

        public double getTimeSpent() {
            return (endMillis - startMillis) / 1000.0;
        }
    }

}
