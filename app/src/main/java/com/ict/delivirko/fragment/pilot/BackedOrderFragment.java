package com.ict.delivirko.fragment.pilot;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.adapter.BackedOrdersPagerAdapter;

public class BackedOrderFragment extends Fragment implements OnClickListener {
    BackedOrdersPagerAdapter backedOrdersPagerAdapter;
    ImageButton btnNewerBackedOrders;
    ImageButton btnOlderBackedOrders;
    ViewPager pagerBackedOrders;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C0519R.layout.fragment_backed_order, viewGroup, false);
        this.pagerBackedOrders = (ViewPager) layoutInflater.findViewById(C0519R.id.pagerBackedOrders);
        this.btnNewerBackedOrders = (ImageButton) layoutInflater.findViewById(C0519R.id.btnNewerBackedOrders);
        this.btnOlderBackedOrders = (ImageButton) layoutInflater.findViewById(C0519R.id.btnOlderBackedOrders);
        this.btnNewerBackedOrders.setOnClickListener(this);
        this.btnOlderBackedOrders.setOnClickListener(this);
        this.backedOrdersPagerAdapter = new BackedOrdersPagerAdapter(getFragmentManager());
        this.pagerBackedOrders.setAdapter(this.backedOrdersPagerAdapter);
        return layoutInflater;
    }

    public void onResume() {
        super.onResume();
        this.pagerBackedOrders.setAdapter(this.backedOrdersPagerAdapter);
    }

    public void onClick(View view) {
        view = view.getId();
        if (view == C0519R.id.btnNewerBackedOrders) {
            view = this.pagerBackedOrders;
            view.setCurrentItem(view.getCurrentItem() + 1, true);
            this.btnNewerBackedOrders.startAnimation(AnimationUtils.loadAnimation(getContext(), C0519R.anim.arrows_pager_click));
        } else if (view == C0519R.id.btnOlderBackedOrders) {
            view = this.pagerBackedOrders;
            view.setCurrentItem(view.getCurrentItem() - 1, true);
            this.btnOlderBackedOrders.startAnimation(AnimationUtils.loadAnimation(getContext(), C0519R.anim.arrows_pager_click));
        }
    }
}
