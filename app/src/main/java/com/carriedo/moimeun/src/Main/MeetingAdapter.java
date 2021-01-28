package com.carriedo.moimeun.src.Main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.carriedo.moimeun.R;

import java.util.ArrayList;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.MeetingViewHolder> {

    private ArrayList<MeetingItem> mList;
    Context context;

    // 리스너 인터페이스 정의하기
    public interface OnItemClickListener
    {
        void onItemClick(View v, int pos);
    }
    //전달된 객체 저장할 변수
    private MeetingAdapter.OnItemClickListener mListener = null;
    // 리스너 객체 전달 메서드
    public void setOnItemClickListener(OnItemClickListener listener)
    {
        this.mListener = listener;
    }


    @Override
    public int getItemCount() {
        // mList 비어 있으면 0리턴, 아니면 mList 사이즈 리턴
        return (null != mList ? mList.size():0);
    }



    public class MeetingViewHolder extends RecyclerView.ViewHolder {

        TextView meeting_title;
        TextView meeting_person_count;
        ImageView meeting_chat_img;

        public MeetingViewHolder(@NonNull View itemView) {
            super(itemView);

            this.meeting_title = itemView.findViewById(R.id.meeting_item_tv_title);
            this.meeting_person_count = itemView.findViewById(R.id.meeting_item_tv_person_count);
            this.meeting_chat_img = itemView.findViewById(R.id.meeting_item_iv_chat);


            // 뷰홀더가 만들어지는 시점에 클릭 이벤트 처리리
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION)
                    {
                        mListener.onItemClick(v,pos);
                    }
                }
            });

            meeting_chat_img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // [!!!] Intent 로 대화 방으로 넘겨 줘야 함.
                }
            });
        }
    }



    // 생성자에서 List 객체를 전달
    public MeetingAdapter(ArrayList<MeetingItem> mList) { this.mList = mList; }



    // 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴
    @Override
    public MeetingAdapter.MeetingViewHolder  onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.meeting_item,viewGroup,false);
        MeetingAdapter. MeetingViewHolder viewHolder = new MeetingAdapter.MeetingViewHolder(view);
        this.context =viewGroup.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MeetingViewHolder holder, int position) {

        holder.meeting_title.setText(mList.get(position).getMeeting_title());
        holder.meeting_person_count.setText(mList.get(position).getMeeting_person_count());
    }


}
