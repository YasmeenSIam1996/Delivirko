package com.ict.delivirko.adapter;

import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Module.pilot.CanceledOrder;
import com.ict.delivirko.Module.pilot.CanceledOrdersDetails;
import java.util.HashMap;
import java.util.List;

public class ExpandableCanceledOrdersAdapter extends BaseExpandableListAdapter {
    private Context context;
    private HashMap<CanceledOrder, List<CanceledOrdersDetails>> expandableListDetail;
    private List<CanceledOrder> expandableListTitle;

    /* renamed from: com.ict.delivirko.adapter.ExpandableCanceledOrdersAdapter$1 */
    class C05271 implements OnClickListener {
        C05271() {
        }

        public void onClick(View view) {
            ExpandableCanceledOrdersAdapter.this.showDialog();
        }
    }

    public long getChildId(int i, int i2) {
        return (long) i2;
    }

    public long getGroupId(int i) {
        return (long) i;
    }

    public boolean hasStableIds() {
        return false;
    }

    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public ExpandableCanceledOrdersAdapter(Context context, List<CanceledOrder> list, HashMap<CanceledOrder, List<CanceledOrdersDetails>> hashMap) {
        this.context = context;
        this.expandableListTitle = list;
        this.expandableListDetail = hashMap;
    }

    public Object getChild(int i, int i2) {
        return ((List) this.expandableListDetail.get(this.expandableListTitle.get(i))).get(i2);
    }

    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(C0519R.layout.item_canceled_orders_details, false);
        }
        view.setOnClickListener(new C05271());
        return view;
    }

    private void showDialog() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(this.context, C0519R.style.SheetDialog);
        bottomSheetDialog.setContentView((int) C0519R.layout.sheet_orders_details_pilot);
        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.show();
        ((ImageView) bottomSheetDialog.findViewById(C0519R.id.imgCancelDetailsPilot)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                bottomSheetDialog.dismiss();
            }
        });
    }

    public int getChildrenCount(int i) {
        return ((List) this.expandableListDetail.get(this.expandableListTitle.get(i))).size();
    }

    public Object getGroup(int i) {
        return this.expandableListTitle.get(i);
    }

    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        return view == null ? ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(true, null) : view;
    }
}
