package us.erlang.room_rxjava_app;

import android.app.Application;

public class MyApplication extends Application {
    private LocalDataSource localDataSource;
    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        localDataSource = new LocalDataSource(getApplicationContext());
        application = this;
    }

    public static MyApplication getInstance(){
        return application;
    }

    public LocalDataSource getLocalDataSource() {
        return localDataSource;
    }
}
