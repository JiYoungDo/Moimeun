package com.carriedo.moimeun.src.CalendarFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.carriedo.moimeun.R;

import static android.content.Context.MODE_PRIVATE;
import static com.carriedo.moimeun.ApplicationClass.TAG;
import static com.carriedo.moimeun.ApplicationClass.sSharedPreferences;


public class AddScheduleDialog {

    private Context context;
    String get_day;
    String get_time;
    String get_on_off;

    public AddScheduleDialog(Context context) {
        this.context = context;
    }

    // 호춣할 다이얼로그 함수 정의
    public void callFunction()
    {
        final Dialog dialog_parent = new Dialog(context);

        dialog_parent.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog_parent.setContentView(R.layout.pop_up_add_calendar);

        dialog_parent.show();



        // 커스텀 다이얼로그 값들 정의
        final Spinner spinner_day = dialog_parent.findViewById(R.id.pop_add_calendar_spinner_day);
        final Spinner spinner_time = dialog_parent.findViewById(R.id.pop_add_calendar_spinner_time);
        final Spinner spinner_on_off = dialog_parent.findViewById(R.id.pop_add_calendar_spinner_on_off);
        EditText et_name = dialog_parent.findViewById(R.id.pop_add_calendar_et_schedule_name);
        TextView tv_create = dialog_parent.findViewById(R.id.pop_add_calendar_tv_create);


        spinner_day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                get_day = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });


        spinner_time.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                get_time = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_on_off.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                get_on_off = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final String get_name;
        get_name = et_name.getText().toString();

        tv_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 모든 값들을 가지고 전달 해야 함.
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("일정 생성");
                builder.setMessage("스케줄을 추가 하시겠어요?");
                builder.setPositiveButton("예",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // 값 저장하고 넘기기
                                // sharedPreference에 저장
                                sSharedPreferences = context.getSharedPreferences(TAG,MODE_PRIVATE);
                                SharedPreferences.Editor editor = sSharedPreferences.edit();
                                editor.putString("temp_schedule_day", String.valueOf(spinner_day));
                                editor.putString("temp_schedule_time", String.valueOf(spinner_time));
                                editor.putString("temp_schedule_on_off", String.valueOf(spinner_on_off));
                                editor.putString("temp_schedule_name",get_name);
                                editor.commit();
                                dialog.dismiss();
                                dialog_parent.dismiss();
                            }
                        });
                builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        dialog_parent.dismiss();
                    }
                });
                builder.show();
            }
        });

    }
}
