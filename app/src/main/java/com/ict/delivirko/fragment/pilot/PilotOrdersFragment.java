package com.ict.delivirko.fragment.pilot;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.OnTabSelectedListener;
import android.support.design.widget.TabLayout.Tab;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.ict.delivirko.C0519R;

public class PilotOrdersFragment extends Fragment {
    TabLayout ordersTab;

    /* renamed from: com.ict.delivirko.fragment.pilot.PilotOrdersFragment$1 */
    class C10081 implements OnTabSelectedListener {
        public void onTabReselected(Tab tab) {
        }

        public void onTabUnselected(Tab tab) {
        }

        C10081() {
        }

        public void onTabSelected(Tab tab) {
            switch (tab.getPosition()) {
                case null:
                    PilotOrdersFragment.this.getFragmentManager().beginTransaction().replace(C0519R.id.ordersContainer, SubOrdersPilotFragment.newInstance(4)).commit();
                    return;
                case 1:
                    PilotOrdersFragment.this.getFragmentManager().beginTransaction().replace(C0519R.id.ordersContainer, SubOrdersPilotFragment.newInstance(5)).commit();
                    return;
                case 2:
                    PilotOrdersFragment.this.getFragmentManager().beginTransaction().replace(C0519R.id.ordersContainer, SubOrdersPilotFragment.newInstance(2)).commit();
                    return;
                default:
                    return;
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C0519R.layout.fragment_pilot_orders, viewGroup, false);
        this.ordersTab = (TabLayout) layoutInflater.findViewById(C0519R.id.tabsOrders);
        getFragmentManager().beginTransaction().replace(C0519R.id.ordersContainer, SubOrdersPilotFragment.newInstance(4)).commit();
        for (viewGroup = null; viewGroup < this.ordersTab.getTabCount(); viewGroup++) {
            View childAt = ((ViewGroup) this.ordersTab.getChildAt(0)).getChildAt(viewGroup);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
            if (this.ordersTab.getTabAt(viewGroup).getPosition() == 0) {
                marginLayoutParams.setMarginEnd(10);
            } else if (this.ordersTab.getTabAt(viewGroup).getPosition() + 1 == this.ordersTab.getTabCount()) {
                marginLayoutParams.setMarginStart(10);
            } else {
                marginLayoutParams.setMargins(10, 0, 10, 0);
            }
            childAt.requestLayout();
        }
        this.ordersTab.addOnTabSelectedListener(new C10081());
        return layoutInflater;
    }
}
