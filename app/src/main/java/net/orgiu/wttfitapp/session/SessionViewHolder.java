package net.orgiu.wttfitapp.session;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.fitness.data.Session;

import net.orgiu.wttfitapp.R;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

class SessionViewHolder extends RecyclerView.ViewHolder{
    private final TextView sessionType;
    private final TextView sessionSource;
    private Session session;

    SessionViewHolder(View itemView) {
        super(itemView);
        sessionType = (TextView) itemView.findViewById(R.id.sessionTypeView);
        sessionSource = (TextView) itemView.findViewById(R.id.sessionSourceView);
    }

    void bindTo(Session session) {
        this.session = session;
        updateUi();
    }

    private void updateUi() {
        sessionType.setText(session.getActivity());
        sessionSource.setText(parseTimeFrom(session));
    }

    private String parseTimeFrom(Session session) {
        long timeInSeconds = session.getActiveTime(TimeUnit.SECONDS);
        long hours = TimeUnit.SECONDS.toHours(timeInSeconds);
        timeInSeconds -= TimeUnit.HOURS.toSeconds(hours);
        long minutes = TimeUnit.SECONDS.toMinutes(timeInSeconds);
        timeInSeconds -= TimeUnit.MINUTES.toSeconds(minutes);
        return String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, timeInSeconds);
    }
}
