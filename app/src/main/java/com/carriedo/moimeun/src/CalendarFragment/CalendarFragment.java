package com.carriedo.moimeun.src.CalendarFragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.carriedo.moimeun.R;
import com.carriedo.moimeun.src.Main.MainActivity;

public class CalendarFragment extends Fragment {

   //  [!] 테이블 레이아웃
    ViewGroup viewGroup;
    MainActivity mainActivity;
    Spinner color_concept_spinner;

    int color_1, color_2, color_3, color_4, color_5, color_6, color_7, color_8, color_9, color_10;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainActivity =null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_calendar, container, false);

        // [! 후순위 ] 시간표 색 컨셉 _ 위에 칼러 값들 받을 것들을 세팅하는 식으로 해야 할 듯.
        color_concept_spinner = viewGroup.findViewById(R.id.calendar_fm_spinner_color);
        color_concept_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 스피너에서 선택된 색에 따른 결과 처리
                if(position==0)
                {
                    Log.d("선택된 색",parent.getItemAtPosition(position).toString());

                    color_1 = getResources().getColor(R.color.colorTimeTable_natural_1);
                    color_2 = getResources().getColor(R.color.colorTimeTable_natural_2);
                    color_3 = getResources().getColor(R.color.colorTimeTable_natural_3);
                    color_4 = getResources().getColor(R.color.colorTimeTable_natural_4);
                    color_5 = getResources().getColor(R.color.colorTimeTable_natural_5);
                    color_6 = getResources().getColor(R.color.colorTimeTable_natural_6);
                    color_7 = getResources().getColor(R.color.colorTimeTable_natural_7);
                    color_8 = getResources().getColor(R.color.colorTimeTable_natural_8);
                    color_9 = getResources().getColor(R.color.colorTimeTable_natural_9);
                    color_10 = getResources().getColor(R.color.colorTimeTable_natural_10);

                }else if(position == 1)
                {
                    Log.d("선택된 색",parent.getItemAtPosition(position).toString());

                    color_1 = getResources().getColor(R.color.colorTimeTable_dreamer_1);
                    color_2 = getResources().getColor(R.color.colorTimeTable_dreamer_2);
                    color_3 = getResources().getColor(R.color.colorTimeTable_dreamer_3);
                    color_4 = getResources().getColor(R.color.colorTimeTable_dreamer_4);
                    color_5 = getResources().getColor(R.color.colorTimeTable_dreamer_5);
                    color_6 = getResources().getColor(R.color.colorTimeTable_dreamer_6);
                    color_7 = getResources().getColor(R.color.colorTimeTable_dreamer_7);
                    color_8 = getResources().getColor(R.color.colorTimeTable_dreamer_8);
                    color_9 = getResources().getColor(R.color.colorTimeTable_dreamer_9);
                    color_10 = getResources().getColor(R.color.colorTimeTable_dreamer_10);

                }else if(position == 2)
                {
                    Log.d("선택된 색",parent.getItemAtPosition(position).toString());

                    color_1 = getResources().getColor(R.color.colorTimeTable_bright_1);
                    color_2 = getResources().getColor(R.color.colorTimeTable_bright_2);
                    color_3 = getResources().getColor(R.color.colorTimeTable_bright_3);
                    color_4 = getResources().getColor(R.color.colorTimeTable_bright_4);
                    color_5 = getResources().getColor(R.color.colorTimeTable_bright_5);
                    color_6 = getResources().getColor(R.color.colorTimeTable_bright_6);
                    color_7 = getResources().getColor(R.color.colorTimeTable_bright_7);
                    color_8 = getResources().getColor(R.color.colorTimeTable_bright_8);
                    color_9 = getResources().getColor(R.color.colorTimeTable_bright_9);
                    color_10 = getResources().getColor(R.color.colorTimeTable_bright_10);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // default 값
            }
        });

        return viewGroup;
    }
}
