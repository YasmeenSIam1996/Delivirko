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

public class HelpFragment extends Fragment {
    TabLayout tabsHelp;

    /* renamed from: com.ict.delivirko.fragment.restaurant.HelpFragment$1 */
    class C10091 implements OnTabSelectedListener {
        public void onTabReselected(Tab tab) {
        }

        public void onTabUnselected(Tab tab) {
        }

        C10091() {
        }

        public void onTabSelected(Tab tab) {
            if (tab.getPosition() == null) {
                HelpFragment.this.getFragmentManager().beginTransaction().replace(C0519R.id.containerHelp, new ContactsFragment()).commit();
            } else {
                HelpFragment.this.getFragmentManager().beginTransaction().replace(C0519R.id.containerHelp, new FAQFragment()).commit();
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C0519R.layout.fragment_help, viewGroup, false);
        getFragmentManager().beginTransaction().replace(C0519R.id.containerHelp, new ContactsFragment()).commit();
        this.tabsHelp = (TabLayout) layoutInflater.findViewById(C0519R.id.tabsHelp);
        for (viewGroup = null; viewGroup < this.tabsHelp.getTabCount(); viewGroup++) {
            View childAt = ((ViewGroup) this.tabsHelp.getChildAt(0)).getChildAt(viewGroup);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) childAt.getLayoutParams();
            if (this.tabsHelp.getTabAt(viewGroup).getPosition() == 0) {
                marginLayoutParams.setMarginEnd(10);
            } else if (this.tabsHelp.getTabAt(viewGroup).getPosition() + 1 == this.tabsHelp.getTabCount()) {
                marginLayoutParams.setMarginStart(10);
            } else {
                marginLayoutParams.setMargins(10, 0, 10, 0);
            }
            childAt.requestLayout();
        }
        this.tabsHelp.addOnTabSelectedListener(new C10091());
        return layoutInflater;
    }
}
