package us.erlang.room_rxjava_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;
import java.util.Observable;

import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SubmitActivity extends AppCompatActivity {
    private EditText userName;
    private EditText age;
    private EditText gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        userName = findViewById(R.id.user_name);
        gender = findViewById(R.id.gender);
        age = findViewById(R.id.age);

        Button submitButton = findViewById(R.id.create_user);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPerson();
            }
        });
    }

    private void createPerson() {
        Person person = new Person(userName.getText().toString(), Integer.parseInt(gender.getText().toString()), Integer.parseInt(age.getText().toString()));
        MyApplication.getInstance().getLocalDataSource().createPerson(person)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Long>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(Long aLong) {
                String msg = "succeeded to create user";
                if (Objects.isNull(aLong)) {
                    msg = "failed to create user";
                }

                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), ViewActivity.class);
                startActivity(intent);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("SubmitActivity", "failed to create user", e);
            }
        });
    }
}