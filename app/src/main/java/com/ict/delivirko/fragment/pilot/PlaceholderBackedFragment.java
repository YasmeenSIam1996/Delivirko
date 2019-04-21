package com.ict.delivirko.fragment.pilot;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageView;
import com.ict.delivirko.Activities.ExpandableCanceledOrdersData;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Module.pilot.CanceledOrder;
import com.ict.delivirko.Module.pilot.CanceledOrdersDetails;
import com.ict.delivirko.adapter.ExpandableCanceledOrdersAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlaceholderBackedFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ExpandableCanceledOrdersAdapter adapter;
    ExpandableCanceledOrdersData data;
    HashMap<CanceledOrder, List<CanceledOrdersDetails>> hashData;
    ExpandableListView listBackedOrders;
    ArrayList<CanceledOrder> objects;

    /* renamed from: com.ict.delivirko.fragment.pilot.PlaceholderBackedFragment$1 */
    class C05441 implements OnGroupClickListener {
        C05441() {
        }

        public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
            ImageView imageView = (ImageView) view.findViewById(C0519R.id.indicatorCanceled);
            if (PlaceholderBackedFragment.this.listBackedOrders.isGroupExpanded(i) != null) {
                imageView.setImageResource(C0519R.drawable.ic_expandable_closed);
            } else {
                imageView.setImageResource(C0519R.drawable.ic_expandable_open);
            }
            return null;
        }
    }

    public static PlaceholderBackedFragment newInstance(String str, String str2) {
        PlaceholderBackedFragment placeholderBackedFragment = new PlaceholderBackedFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, str);
        bundle.putString(ARG_PARAM2, str2);
        placeholderBackedFragment.setArguments(bundle);
        return placeholderBackedFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C0519R.layout.fragment_placeholder_backed, viewGroup, false);
        this.listBackedOrders = (ExpandableListView) layoutInflater.findViewById(C0519R.id.listBackedOrders);
        this.hashData = ExpandableCanceledOrdersData.getData();
        this.objects = new ArrayList(this.hashData.keySet());
        this.adapter = new ExpandableCanceledOrdersAdapter(getContext(), this.objects, this.hashData);
        this.listBackedOrders.setAdapter(this.adapter);
        this.listBackedOrders.setOnGroupClickListener(new C05441());
        return layoutInflater;
    }
}
