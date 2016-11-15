package net.orgiu.wttfitapp.session;


import com.google.android.gms.fitness.request.SessionReadRequest;

import java.util.concurrent.TimeUnit;

class SessionBuilder {

    private final SessionReadRequest readRequest;

    SessionBuilder(DatesBuilder d) {
        readRequest = new SessionReadRequest.Builder()
                .setTimeInterval(d.getStartTime(), d.getEndTime(), TimeUnit.MILLISECONDS)
                .readSessionsFromAllApps()
                .enableServerQueries()
                .build();
    }

    SessionReadRequest getReadRequest() {
        return readRequest;
    }
}
