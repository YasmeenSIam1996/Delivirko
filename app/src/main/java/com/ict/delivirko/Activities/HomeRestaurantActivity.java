package com.ict.delivirko.Activities;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ict.delivirko.App.ApplicationController;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Utils.Constants;
import com.ict.delivirko.fragment.ConditionsFragment;
import com.ict.delivirko.fragment.restaurant.BillRestFragment;
import com.ict.delivirko.fragment.restaurant.FollowOrdersFragment;
import com.ict.delivirko.fragment.restaurant.FreeOrdersFragment;
import com.ict.delivirko.fragment.restaurant.HelpFragment;
import com.ict.delivirko.fragment.restaurant.MapRestaurantFragment;
import com.ict.delivirko.fragment.restaurant.MyAccountRestFragment;
import com.ict.delivirko.fragment.restaurant.MyOrdersRestFragment;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenu.OnMenuListener;
import com.squareup.picasso.Picasso;
import java.util.Locale;

public class HomeRestaurantActivity extends AppCompatActivity implements OnClickListener {
    private ImageView imgRestaurantLogo;
    private boolean isLeftToRight;
    private ResideMenu resideMenu;
    private LinearLayout restNavAccount;
    private LinearLayout restNavConditions;
    private LinearLayout restNavFollowOrders;
    private LinearLayout restNavFreeOrders;
    private LinearLayout restNavMain;
    private LinearLayout restNavMyOrders;
    private LinearLayout restNavSettings;
    private LinearLayout restNavSupply;
    private TextView tvMenuPilotName;
    private TextView txtLogout;

    /* renamed from: com.ict.delivirko.Activities.HomeRestaurantActivity$1 */
    class C04991 implements OnClickListener {
        C04991() {
        }

        public void onClick(View view) {
            if (HomeRestaurantActivity.this.isLeftToRight != null) {
                HomeRestaurantActivity.this.resideMenu.openMenu(0);
            } else {
                HomeRestaurantActivity.this.resideMenu.openMenu(1);
            }
        }
    }

    /* renamed from: com.ict.delivirko.Activities.HomeRestaurantActivity$2 */
    class C08972 implements OnMenuListener {
        C08972() {
        }

        public void openMenu() {
            if (VERSION.SDK_INT >= 21) {
                HomeRestaurantActivity.this.getWindow().setStatusBarColor(HomeRestaurantActivity.this.getResources().getColor(C0519R.color.side_menu_bg));
            }
        }

        public void closeMenu() {
            if (VERSION.SDK_INT >= 21) {
                HomeRestaurantActivity.this.getWindow().setStatusBarColor(ContextCompat.getColor(HomeRestaurantActivity.this, C0519R.color.colorPrimaryDark));
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0519R.layout.activity_home_restaurant);
        Toolbar toolbar = (Toolbar) findViewById(C0519R.id.toolbarRest);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon((int) C0519R.drawable.ic_nav_menu);
        toolbar.setNavigationOnClickListener(new C04991());
        getSupportFragmentManager().beginTransaction().replace(C0519R.id.containerRestaurant, new MapRestaurantFragment()).commit();
        setUpMenu();
        this.resideMenu.setMenuListener(new C08972());
    }

    private void setUpMenu() {
        View leftMenuView;
        this.isLeftToRight = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 0;
        if (this.isLeftToRight) {
            this.resideMenu = new ResideMenu(this, C0519R.layout.rest_side_menu, -1);
            this.resideMenu.setSwipeDirectionDisable(1);
            leftMenuView = this.resideMenu.getLeftMenuView();
        } else {
            this.resideMenu = new ResideMenu(this, -1, C0519R.layout.rest_side_menu);
            this.resideMenu.setSwipeDirectionDisable(0);
            leftMenuView = this.resideMenu.getRightMenuView();
        }
        this.resideMenu.attachToActivity(this);
        this.resideMenu.setShadowVisible(false);
        this.resideMenu.setScaleValue(0.6f);
        this.resideMenu.setBackgroundColor(ContextCompat.getColor(this, C0519R.color.side_menu_bg));
        this.restNavMain = (LinearLayout) leftMenuView.findViewById(C0519R.id.restNavMain);
        this.restNavMyOrders = (LinearLayout) leftMenuView.findViewById(C0519R.id.restNavMyOrders);
        this.restNavFollowOrders = (LinearLayout) leftMenuView.findViewById(C0519R.id.restNavFollowOrders);
        this.restNavAccount = (LinearLayout) leftMenuView.findViewById(C0519R.id.restNavAccount);
        this.restNavFreeOrders = (LinearLayout) leftMenuView.findViewById(C0519R.id.restNavFreeOrders);
        this.restNavSettings = (LinearLayout) leftMenuView.findViewById(C0519R.id.restNavSettings);
        this.restNavSupply = (LinearLayout) leftMenuView.findViewById(C0519R.id.restNavSupply);
        this.restNavConditions = (LinearLayout) leftMenuView.findViewById(C0519R.id.restNavConditions);
        this.txtLogout = (TextView) leftMenuView.findViewById(C0519R.id.txtLogout);
        this.tvMenuPilotName = (TextView) leftMenuView.findViewById(C0519R.id.tvMenuRestName);
        this.imgRestaurantLogo = (ImageView) leftMenuView.findViewById(C0519R.id.imgRestaurantLogo);
        this.restNavMain.setOnClickListener(this);
        this.restNavMyOrders.setOnClickListener(this);
        this.restNavFollowOrders.setOnClickListener(this);
        this.restNavAccount.setOnClickListener(this);
        this.restNavFreeOrders.setOnClickListener(this);
        this.restNavSettings.setOnClickListener(this);
        this.restNavSupply.setOnClickListener(this);
        this.restNavConditions.setOnClickListener(this);
        this.txtLogout.setOnClickListener(this);
        this.tvMenuPilotName.setText(ApplicationController.getInstance().getUser().getName());
        Picasso picasso = Picasso.get();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Constants.Image_URL);
        stringBuilder.append(ApplicationController.getInstance().getUser().getImage());
        picasso.load(stringBuilder.toString()).fit().into(this.imgRestaurantLogo);
    }

    public void onClick(View view) {
        view = view.getId();
        if (view != C0519R.id.txtLogout) {
            switch (view) {
                case C0519R.id.restNavAccount:
                    getSupportFragmentManager().beginTransaction().replace(C0519R.id.containerRestaurant, new BillRestFragment()).commit();
                    break;
                case C0519R.id.restNavConditions:
                    getSupportFragmentManager().beginTransaction().replace(C0519R.id.containerRestaurant, new ConditionsFragment()).commit();
                    break;
                case C0519R.id.restNavFollowOrders:
                    getSupportFragmentManager().beginTransaction().replace(C0519R.id.containerRestaurant, new FollowOrdersFragment()).commit();
                    break;
                case C0519R.id.restNavFreeOrders:
                    getSupportFragmentManager().beginTransaction().replace(C0519R.id.containerRestaurant, new FreeOrdersFragment()).commit();
                    break;
                case C0519R.id.restNavMain:
                    getSupportFragmentManager().beginTransaction().replace(C0519R.id.containerRestaurant, new MapRestaurantFragment()).commit();
                    break;
                case C0519R.id.restNavMyOrders:
                    getSupportFragmentManager().beginTransaction().replace(C0519R.id.containerRestaurant, new MyOrdersRestFragment()).commit();
                    break;
                case C0519R.id.restNavSettings:
                    getSupportFragmentManager().beginTransaction().replace(C0519R.id.containerRestaurant, new MyAccountRestFragment()).commit();
                    break;
                case C0519R.id.restNavSupply:
                    getSupportFragmentManager().beginTransaction().replace(C0519R.id.containerRestaurant, new HelpFragment()).commit();
                    break;
                default:
                    break;
            }
        }
        Constants.showCustomDialog(this);
        this.resideMenu.closeMenu();
    }

    public void onBackPressed() {
        if (this.resideMenu.isOpened()) {
            this.resideMenu.closeMenu();
        } else {
            super.onBackPressed();
        }
    }
}
