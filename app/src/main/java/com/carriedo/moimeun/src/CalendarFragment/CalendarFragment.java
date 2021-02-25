package com.carriedo.moimeun.src.CalendarFragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.carriedo.moimeun.R;
import com.carriedo.moimeun.src.MainActivity.MainActivity;

public class CalendarFragment extends Fragment {

   //  [!] 테이블 레이아웃
    ViewGroup viewGroup;
    MainActivity mainActivity;
    Spinner color_concept_spinner;

    int color_1, color_2, color_3, color_4, color_5, color_6, color_7, color_8, color_9, color_10;

    TextView row_1_1, row_1_2, row_1_3, row_1_4, row_1_5, row_1_6, row_1_7,
            row_2_1, row_2_2, row_2_3, row_2_4, row_2_5, row_2_6, row_2_7,
            row_3_1, row_3_2, row_3_3, row_3_4, row_3_5, row_3_6, row_3_7,
            row_4_1, row_4_2, row_4_3, row_4_4, row_4_5, row_4_6, row_4_7,
            row_5_1, row_5_2, row_5_3, row_5_4, row_5_5, row_5_6, row_5_7,
            row_6_1, row_6_2, row_6_3, row_6_4, row_6_5, row_6_6, row_6_7,
            row_7_1, row_7_2, row_7_3, row_7_4, row_7_5, row_7_6, row_7_7,
            row_8_1, row_8_2, row_8_3, row_8_4, row_8_5, row_8_6, row_8_7,
            row_9_1, row_9_2, row_9_3, row_9_4, row_9_5, row_9_6, row_9_7,
            row_10_1, row_10_2, row_10_3, row_10_4, row_10_5, row_10_6, row_10_7,
            row_11_1, row_11_2, row_11_3, row_11_4, row_11_5, row_11_6, row_11_7,
            row_12_1, row_12_2, row_12_3, row_12_4, row_12_5, row_12_6, row_12_7,
            row_13_1, row_13_2, row_13_3, row_13_4, row_13_5, row_13_6, row_13_7,
            row_14_1, row_14_2, row_14_3, row_14_4, row_14_5, row_14_6, row_14_7,
            row_15_1, row_15_2, row_15_3, row_15_4, row_15_5, row_15_6, row_15_7;

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

        row_1_1 = viewGroup.findViewById(R.id.calendar_fm_table_row_1_1);
        row_1_2 = viewGroup.findViewById(R.id.calendar_fm_table_row_1_2);
        row_1_3 = viewGroup.findViewById(R.id.calendar_fm_table_row_1_3);
        row_1_4 = viewGroup.findViewById(R.id.calendar_fm_table_row_1_4);
        row_1_5 = viewGroup.findViewById(R.id.calendar_fm_table_row_1_5);
        row_1_6 = viewGroup.findViewById(R.id.calendar_fm_table_row_1_6);
        row_1_7 = viewGroup.findViewById(R.id.calendar_fm_table_row_1_7);

        row_2_1 = viewGroup.findViewById(R.id.calendar_fm_table_row_2_1);
        row_2_2 = viewGroup.findViewById(R.id.calendar_fm_table_row_2_2);
        row_2_3 = viewGroup.findViewById(R.id.calendar_fm_table_row_2_3);
        row_2_4 = viewGroup.findViewById(R.id.calendar_fm_table_row_2_4);
        row_2_5 = viewGroup.findViewById(R.id.calendar_fm_table_row_2_5);
        row_2_6 = viewGroup.findViewById(R.id.calendar_fm_table_row_2_6);
        row_2_7 = viewGroup.findViewById(R.id.calendar_fm_table_row_2_7);

        row_3_1 = viewGroup.findViewById(R.id.calendar_fm_table_row_3_1);
        row_3_2 = viewGroup.findViewById(R.id.calendar_fm_table_row_3_2);
        row_3_3 = viewGroup.findViewById(R.id.calendar_fm_table_row_3_3);
        row_3_4 = viewGroup.findViewById(R.id.calendar_fm_table_row_3_4);
        row_3_5 = viewGroup.findViewById(R.id.calendar_fm_table_row_3_5);
        row_3_6 = viewGroup.findViewById(R.id.calendar_fm_table_row_3_6);
        row_3_7 = viewGroup.findViewById(R.id.calendar_fm_table_row_3_7);

        row_4_1 = viewGroup.findViewById(R.id.calendar_fm_table_row_4_1);
        row_4_2 = viewGroup.findViewById(R.id.calendar_fm_table_row_4_2);
        row_4_3 = viewGroup.findViewById(R.id.calendar_fm_table_row_4_3);
        row_4_4 = viewGroup.findViewById(R.id.calendar_fm_table_row_4_4);
        row_4_5 = viewGroup.findViewById(R.id.calendar_fm_table_row_4_5);
        row_4_6 = viewGroup.findViewById(R.id.calendar_fm_table_row_4_6);
        row_4_7 = viewGroup.findViewById(R.id.calendar_fm_table_row_4_7);

        row_5_1 = viewGroup.findViewById(R.id.calendar_fm_table_row_5_1);
        row_5_2 = viewGroup.findViewById(R.id.calendar_fm_table_row_5_2);
        row_5_3 = viewGroup.findViewById(R.id.calendar_fm_table_row_5_3);
        row_5_4 = viewGroup.findViewById(R.id.calendar_fm_table_row_5_4);
        row_5_5 = viewGroup.findViewById(R.id.calendar_fm_table_row_5_5);
        row_5_6 = viewGroup.findViewById(R.id.calendar_fm_table_row_5_6);
        row_5_7 = viewGroup.findViewById(R.id.calendar_fm_table_row_5_7);

        row_6_1 = viewGroup.findViewById(R.id.calendar_fm_table_row_6_1);
        row_6_2 = viewGroup.findViewById(R.id.calendar_fm_table_row_6_2);
        row_6_3 = viewGroup.findViewById(R.id.calendar_fm_table_row_6_3);
        row_6_4 = viewGroup.findViewById(R.id.calendar_fm_table_row_6_4);
        row_6_5 = viewGroup.findViewById(R.id.calendar_fm_table_row_6_5);
        row_6_6 = viewGroup.findViewById(R.id.calendar_fm_table_row_6_6);
        row_6_7 = viewGroup.findViewById(R.id.calendar_fm_table_row_6_7);

        row_7_1 = viewGroup.findViewById(R.id.calendar_fm_table_row_7_1);
        row_7_2 = viewGroup.findViewById(R.id.calendar_fm_table_row_7_2);
        row_7_3 = viewGroup.findViewById(R.id.calendar_fm_table_row_7_3);
        row_7_4 = viewGroup.findViewById(R.id.calendar_fm_table_row_7_4);
        row_7_5 = viewGroup.findViewById(R.id.calendar_fm_table_row_7_5);
        row_7_6 = viewGroup.findViewById(R.id.calendar_fm_table_row_7_6);
        row_7_7 = viewGroup.findViewById(R.id.calendar_fm_table_row_7_7);

        row_8_1 = viewGroup.findViewById(R.id.calendar_fm_table_row_8_1);
        row_8_2 = viewGroup.findViewById(R.id.calendar_fm_table_row_8_2);
        row_8_3 = viewGroup.findViewById(R.id.calendar_fm_table_row_8_3);
        row_8_4 = viewGroup.findViewById(R.id.calendar_fm_table_row_8_4);
        row_8_5 = viewGroup.findViewById(R.id.calendar_fm_table_row_8_5);
        row_8_6 = viewGroup.findViewById(R.id.calendar_fm_table_row_8_6);
        row_8_7 = viewGroup.findViewById(R.id.calendar_fm_table_row_8_7);

        row_9_1 = viewGroup.findViewById(R.id.calendar_fm_table_row_9_1);
        row_9_2 = viewGroup.findViewById(R.id.calendar_fm_table_row_9_2);
        row_9_3 = viewGroup.findViewById(R.id.calendar_fm_table_row_9_3);
        row_9_4 = viewGroup.findViewById(R.id.calendar_fm_table_row_9_4);
        row_9_5 = viewGroup.findViewById(R.id.calendar_fm_table_row_9_5);
        row_9_6 = viewGroup.findViewById(R.id.calendar_fm_table_row_9_6);
        row_9_7 = viewGroup.findViewById(R.id.calendar_fm_table_row_9_7);

        row_10_1 = viewGroup.findViewById(R.id.calendar_fm_table_row_10_1);
        row_10_2 = viewGroup.findViewById(R.id.calendar_fm_table_row_10_2);
        row_10_3 = viewGroup.findViewById(R.id.calendar_fm_table_row_10_3);
        row_10_4 = viewGroup.findViewById(R.id.calendar_fm_table_row_10_4);
        row_10_5 = viewGroup.findViewById(R.id.calendar_fm_table_row_10_5);
        row_10_6 = viewGroup.findViewById(R.id.calendar_fm_table_row_10_6);
        row_10_7 = viewGroup.findViewById(R.id.calendar_fm_table_row_10_7);

        row_11_1 = viewGroup.findViewById(R.id.calendar_fm_table_row_11_1);
        row_11_2 = viewGroup.findViewById(R.id.calendar_fm_table_row_11_2);
        row_11_3 = viewGroup.findViewById(R.id.calendar_fm_table_row_11_3);
        row_11_4 = viewGroup.findViewById(R.id.calendar_fm_table_row_11_4);
        row_11_5 = viewGroup.findViewById(R.id.calendar_fm_table_row_11_5);
        row_11_6 = viewGroup.findViewById(R.id.calendar_fm_table_row_11_6);
        row_11_7 = viewGroup.findViewById(R.id.calendar_fm_table_row_11_7);

        row_12_1 = viewGroup.findViewById(R.id.calendar_fm_table_row_12_1);
        row_12_2 = viewGroup.findViewById(R.id.calendar_fm_table_row_12_2);
        row_12_3 = viewGroup.findViewById(R.id.calendar_fm_table_row_12_3);
        row_12_4 = viewGroup.findViewById(R.id.calendar_fm_table_row_12_4);
        row_12_5 = viewGroup.findViewById(R.id.calendar_fm_table_row_12_5);
        row_12_6 = viewGroup.findViewById(R.id.calendar_fm_table_row_12_6);
        row_12_7 = viewGroup.findViewById(R.id.calendar_fm_table_row_12_7);

        row_13_1 = viewGroup.findViewById(R.id.calendar_fm_table_row_13_1);
        row_13_2 = viewGroup.findViewById(R.id.calendar_fm_table_row_13_2);
        row_13_3 = viewGroup.findViewById(R.id.calendar_fm_table_row_13_3);
        row_13_4 = viewGroup.findViewById(R.id.calendar_fm_table_row_13_4);
        row_13_5 = viewGroup.findViewById(R.id.calendar_fm_table_row_13_5);
        row_13_6 = viewGroup.findViewById(R.id.calendar_fm_table_row_13_6);
        row_13_7 = viewGroup.findViewById(R.id.calendar_fm_table_row_13_7);

        row_14_1 = viewGroup.findViewById(R.id.calendar_fm_table_row_14_1);
        row_14_2 = viewGroup.findViewById(R.id.calendar_fm_table_row_14_2);
        row_14_3 = viewGroup.findViewById(R.id.calendar_fm_table_row_14_3);
        row_14_4 = viewGroup.findViewById(R.id.calendar_fm_table_row_14_4);
        row_14_5 = viewGroup.findViewById(R.id.calendar_fm_table_row_14_5);
        row_14_6 = viewGroup.findViewById(R.id.calendar_fm_table_row_14_6);
        row_14_7 = viewGroup.findViewById(R.id.calendar_fm_table_row_14_7);

        row_15_1 = viewGroup.findViewById(R.id.calendar_fm_table_row_15_1);
        row_15_2 = viewGroup.findViewById(R.id.calendar_fm_table_row_15_2);
        row_15_3 = viewGroup.findViewById(R.id.calendar_fm_table_row_15_3);
        row_15_4 = viewGroup.findViewById(R.id.calendar_fm_table_row_15_4);
        row_15_5 = viewGroup.findViewById(R.id.calendar_fm_table_row_15_5);
        row_15_6 = viewGroup.findViewById(R.id.calendar_fm_table_row_15_6);
        row_15_7 = viewGroup.findViewById(R.id.calendar_fm_table_row_15_7);


        row_1_1.setBackgroundColor(color_1);
        row_1_2.setBackgroundColor(color_1);

        row_3_1.setBackgroundColor(color_2);
        row_3_2.setBackgroundColor(color_2);
        row_3_2.setBackgroundColor(color_2);




        return viewGroup;
    }
}
