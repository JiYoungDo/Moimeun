package com.carriedo.moimeun.src.CalendarFragment;

import android.content.Context;
import android.os.Bundle;
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
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // default 값
            }
        });

        return viewGroup;
    }
}
