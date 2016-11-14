package net.orgiu.wttfitapp.client;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.google.android.gms.common.api.GoogleApiClient;

import net.orgiu.wttfitapp.R;


public class ClientView extends RelativeLayout implements ClientContract.View{
    private ClientContract.Presenter presenter;
    private ImageView googleFitIcon, errorIcon;

    public ClientView(Context context) {
        super(context);
    }

    public ClientView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate();
    }

    public ClientView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate();
    }

    private void inflate() {
        inflate(getContext(), R.layout.view_client, this);
        findViewById(R.id.connectToFitButton).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                connect();
            }
        });

        googleFitIcon = (ImageView) findViewById(R.id.googleFitIcon);
        errorIcon = (ImageView) findViewById(R.id.errorIcon);
    }

    private void connect() {
        resetImagesVisibility();
        presenter.connect();
    }

    private void resetImagesVisibility() {
        errorIcon.setVisibility(View.VISIBLE);
        googleFitIcon.setVisibility(View.GONE);
    }

    @Override
    public void setPresenter(ClientContract.Presenter presenter) {
        this.presenter = presenter;
        presenter.setView(this);
    }

    @Override
    public void onConnected(GoogleApiClient client) {

    }

    @Override
    public void onConnectionFailed() {
        errorIcon.setVisibility(View.VISIBLE);
        googleFitIcon.setVisibility(View.GONE);
    }
}
