package com.itn.terranode.presentation.view.broadcast;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.gson.Gson;
import com.itn.terranode.data.network.dtos.LoginSuccessResponse;
import com.itn.terranode.di.app.App;
import com.itn.terranode.domain.broadcast.ReceiverInteractor;

import java.util.Calendar;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class RefreshTokenReceiver extends BroadcastReceiver {

    private final CompositeDisposable compositeDisposable;
    @Inject
    ReceiverInteractor interactor;

    public RefreshTokenReceiver() {
        this.compositeDisposable = new CompositeDisposable();
        App.getInstance().plusReceiverComponent().inject(this);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Disposable disposable = interactor
                .refreshToken()
                .subscribe(response -> {
                            if (response.code() == 200) {
                                LoginSuccessResponse successResponse = new Gson().fromJson(response.body().toString(), LoginSuccessResponse.class);
                                saveToken(successResponse.getData().getAccessToken());
                                setAlarm(context, (int)Float.parseFloat(successResponse.getData().getExpiresIn()));
                            } else {
                                clearAll(context);
                            }
                        },
                        throwable -> clearAll(context),
                        () -> {

                        }
                );
        compositeDisposable.add(disposable);
    }

    private void clearAll(Context context) {
        cancelAlarm(context);
        interactor.clearPrefs();
    }

    private void saveToken(String accessToken) {
        compositeDisposable.add(interactor.saveToken(accessToken).subscribe(() -> {}, throwable -> {}));
    }

    public static void setAlarm(Context context, int min){
        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.MONTH,0);
        cal.set(Calendar.DATE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, min);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        long intervalInMillis = cal.getTimeInMillis();
        //получаем алармМенеджер
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(context, RefreshTokenReceiver.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
        Log.d("ase21", "установлен аларм");
    }

    public static void cancelAlarm(Context context){
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, RefreshTokenReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        alarmManager.cancel(pendingIntent);
    }
}
