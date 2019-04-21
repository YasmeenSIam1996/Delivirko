package com.ict.delivirko.adapter.restaurant;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Module.restaurant.places;
import java.util.List;

public class ListPopupWindowAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater = this.mActivity.getLayoutInflater();
    private Activity mActivity;
    private List<places> mDataSource;
    private OnClickListener onClickListener;

    public interface OnClickListener {
        void onClickButton(int i, places places);
    }

    public class ViewHolder {
        private TextView tvTitle;
    }

    public long getItemId(int i) {
        return 0;
    }

    public ListPopupWindowAdapter(Activity activity, List<places> list, @NonNull OnClickListener onClickListener) {
        this.mActivity = activity;
        this.mDataSource = list;
        this.onClickListener = onClickListener;
    }

    public int getCount() {
        return this.mDataSource.size();
    }

    public String getItem(int i) {
        return ((places) this.mDataSource.get(i)).getName();
    }

    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        final places places = (places) this.mDataSource.get(i);
        if (view == null) {
            view = new ViewHolder();
            View inflate = this.layoutInflater.inflate(C0519R.layout.item_list_popup_window, null);
            view.tvTitle = (TextView) inflate.findViewById(C0519R.id.text_title);
            inflate.setTag(view);
            View view2 = inflate;
            viewHolder = view;
            view = view2;
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        view.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View view) {
                ListPopupWindowAdapter.this.onClickListener.onClickButton(i, places);
            }
        });
        viewHolder.tvTitle.setText(getItem(i));
        return view;
    }
}
