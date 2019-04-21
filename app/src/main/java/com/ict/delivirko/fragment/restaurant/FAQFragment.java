package com.ict.delivirko.fragment.restaurant;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ict.delivirko.API.ResponseError;
import com.ict.delivirko.API.ResponseQuestions;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Module.restaurant.Questions;
import com.ict.delivirko.Utils.Constants;
import com.ict.delivirko.adapter.FAQAdapter;
import java.util.List;
import java.util.Vector;

public class FAQFragment extends Fragment {
    FAQAdapter adapter;
    List<Questions> list;
    RecyclerView rvFaq;

    /* renamed from: com.ict.delivirko.fragment.restaurant.FAQFragment$1 */
    class C09301 implements UniversalCallBack {
        C09301() {
        }

        public void onResponse(Object obj) {
            ResponseQuestions responseQuestions = (ResponseQuestions) obj;
            if (responseQuestions == null) {
                return;
            }
            if (responseQuestions.isStatus()) {
                FAQFragment.this.list.clear();
                FAQFragment.this.list.addAll(responseQuestions.getQuestions());
                FAQFragment.this.adapter.notifyDataSetChanged();
                return;
            }
            Constants.showDialog(FAQFragment.this.getActivity(), responseQuestions.getMessage());
        }

        public void onFailure(Object obj) {
            if (obj != null) {
                Constants.showDialog(FAQFragment.this.getActivity(), ((ResponseError) obj).getMessage());
            }
        }

        public void onFinish() {
            Constants.removeProgressDialog();
        }

        public void OnError(String str) {
            Constants.showDialog(FAQFragment.this.getActivity(), str);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C0519R.layout.fragment_faq, viewGroup, false);
        this.list = new Vector();
        this.rvFaq = (RecyclerView) layoutInflater.findViewById(C0519R.id.rvFaq);
        this.adapter = new FAQAdapter(getContext(), this.list);
        this.rvFaq.setAdapter(this.adapter);
        this.rvFaq.setLayoutManager(new LinearLayoutManager(getActivity()));
        Questions();
        return layoutInflater;
    }

    public void Questions() {
        Constants.showSimpleProgressDialog(getActivity(), getResources().getString(C0519R.string.Loading));
        new UserAPI().Questions(new C09301());
    }
}
