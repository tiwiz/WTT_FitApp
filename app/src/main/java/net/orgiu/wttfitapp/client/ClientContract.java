package net.orgiu.wttfitapp.client;


public interface ClientContract {

    interface Presenter {

        void setView(View view);
        void connect();
        void onConnected();
        void onConnectionFailed();
    }

    interface View {
        void onConnected();
        void onConnectionFailed();
    }
}
