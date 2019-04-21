package com.ict.delivirko.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Module.restaurant.Questions;
import java.util.List;

public class FAQAdapter extends Adapter<MyViewHolder> {
    Context context;
    List<Questions> objects;

    public class MyViewHolder extends ViewHolder {
        TextView tvFaqAnswer;
        TextView tvFaqQuestion;

        public MyViewHolder(@NonNull View view) {
            super(view);
            this.tvFaqQuestion = (TextView) view.findViewById(C0519R.id.tvFaqQuestion);
            this.tvFaqAnswer = (TextView) view.findViewById(C0519R.id.tvFaqAnswer);
        }
    }

    public FAQAdapter(Context context, List<Questions> list) {
        this.context = context;
        this.objects = list;
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(this.context).inflate(C0519R.layout.item_faq, viewGroup, false));
    }

    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Questions questions = (Questions) this.objects.get(i);
        myViewHolder.tvFaqQuestion.setText(questions.getQuestion());
        myViewHolder.tvFaqAnswer.setText(questions.getAnswer());
    }

    public int getItemCount() {
        return this.objects.size();
    }
}
