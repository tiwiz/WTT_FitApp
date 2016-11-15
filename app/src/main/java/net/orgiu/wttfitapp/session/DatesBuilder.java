package net.orgiu.wttfitapp.session;


import java.util.Calendar;
import java.util.Date;

class DatesBuilder {

    private final long startTime;
    private final long endTime;

    static DatesBuilder getInstance() {
        return new Builder()
                .createEndingTime()
                .createStartingTime()
                .build();
    }

    private DatesBuilder(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    long getStartTime() {
        return startTime;
    }

    long getEndTime() {
        return endTime;
    }

    private static class Builder {
        private long startTime = 0L;
        private long endTime = 0L;
        private final Calendar calendar;

        Builder() {
            calendar = Calendar.getInstance();
        }

        private Builder createEndingTime() {
            calendar.setTime(new Date());
            endTime = calendar.getTimeInMillis();
            return this;
        }

        private Builder createStartingTime() {
            calendar.add(Calendar.YEAR, -1);
            startTime = calendar.getTimeInMillis();
            return this;
        }

        DatesBuilder build() {
            return new DatesBuilder(startTime, endTime);
        }
    }
}
