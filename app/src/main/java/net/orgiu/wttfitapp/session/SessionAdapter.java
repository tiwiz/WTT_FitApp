package net.orgiu.wttfitapp.session;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.result.SessionReadResult;

import net.orgiu.wttfitapp.R;

import java.util.ArrayList;
import java.util.List;


class SessionAdapter extends RecyclerView.Adapter<SessionViewHolder> {
    private List<Session> results;

    SessionAdapter() {
        results = new ArrayList<>(0);
    }

    @Override
    public SessionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.session_item_overview, parent, false);
        return new SessionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SessionViewHolder holder, int position) {
        holder.bindTo(results.get(position));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    void setResults(SessionReadResult results) {
        this.results.addAll(results.getSessions());
        notifyDataSetChanged();
    }
}
