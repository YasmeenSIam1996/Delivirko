package com.ict.delivirko.fragment.restaurant;

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

public class MyOrdersRestFragment extends Fragment {
    TabLayout tabsMyOrdersRest;

    /* renamed from: com.ict.delivirko.fragment.restaurant.MyOrdersRestFragment$1 */
    class C10101 implements OnTabSelectedListener {
        public void onTabReselected(Tab tab) {
        }

        public void onTabUnselected(Tab tab) {
        }

        C10101() {
        }

        public void onTabSelected(Tab tab) {
            Fragment subOrdersRestFragment = new SubOrdersRestFragment();
            Bundle bundle = new Bundle();
            if (tab.getPosition() == 0) {
                bundle.putInt(SubOrdersRestFragment.ARG_PARAM1, 4);
            } else if (tab.getPosition() == 1) {
                bundle.putInt(SubOrdersRestFragment.ARG_PARAM1, 5);
            } else if (tab.getPosition() == 2) {
                bundle.putInt(SubOrdersRestFragment.ARG_PARAM1, 2);
            }
            subOrdersRestFragment.setArguments(bundle);
            MyOrdersRestFragment.this.getFragmentManager().beginTransaction().replace(C0519R.id.containerSubOrdersRest, subOrdersRestFragment).commit();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C0519R.layout.fragment_my_orders_rest, viewGroup, false);
        viewGroup = new SubOrdersRestFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putInt(SubOrdersRestFragment.ARG_PARAM1, 4);
        viewGroup.setArguments(bundle2);
        getFragmentManager().beginTransaction().replace(C0519R.id.containerSubOrdersRest, viewGroup).commit();
        this.tabsMyOrdersRest = (TabLayout) layoutInflater.findViewById(C0519R.id.tabsMyOrdersRest);
        for (viewGroup = null; viewGroup < this.tabsMyOrdersRest.getTabCount(); viewGroup++) {
            View childAt = ((ViewGroup) this.tabsMyOrdersRest.getChildAt(0)).getChildAt(viewGroup);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
            if (this.tabsMyOrdersRest.getTabAt(viewGroup).getPosition() == 0) {
                marginLayoutParams.setMarginEnd(10);
            } else if (this.tabsMyOrdersRest.getTabAt(viewGroup).getPosition() + 1 == this.tabsMyOrdersRest.getTabCount()) {
                marginLayoutParams.setMarginStart(10);
            } else {
                marginLayoutParams.setMargins(10, 0, 10, 0);
            }
            childAt.requestLayout();
        }
        this.tabsMyOrdersRest.addOnTabSelectedListener(new C10101());
        return layoutInflater;
    }
}
