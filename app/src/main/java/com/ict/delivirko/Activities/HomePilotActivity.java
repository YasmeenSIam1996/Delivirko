package com.ict.delivirko.Activities;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build.VERSION;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
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
import com.ict.delivirko.fragment.pilot.BillPilotFragment;
import com.ict.delivirko.fragment.pilot.MyAccountFragment;
import com.ict.delivirko.fragment.pilot.PilotMapFragment;
import com.ict.delivirko.fragment.pilot.PilotOrdersFragment;
import com.special.ResideMenu.ResideMenu;
import com.special.ResideMenu.ResideMenu.OnMenuListener;
import com.squareup.picasso.Picasso;
import java.util.Locale;

public class HomePilotActivity extends AppCompatActivity implements OnClickListener {
    private AlarmManager alarmManager;
    private ImageView imgRestaurantLogo;
    boolean isLeftToRight;
    private PendingIntent pendingIntent;
    private LinearLayout pilotNavAccount;
    private LinearLayout pilotNavConditions;
    private LinearLayout pilotNavMain;
    private LinearLayout pilotNavOrders;
    private LinearLayout pilotNavSettings;
    private ResideMenu resideMenu;
    private TextView tvMenuPilotName;
    private TextView txtLogout;

    /* renamed from: com.ict.delivirko.Activities.HomePilotActivity$1 */
    class C04981 implements OnClickListener {
        C04981() {
        }

        public void onClick(View view) {
            if (HomePilotActivity.this.isLeftToRight != null) {
                HomePilotActivity.this.resideMenu.openMenu(0);
            } else {
                HomePilotActivity.this.resideMenu.openMenu(1);
            }
        }
    }

    /* renamed from: com.ict.delivirko.Activities.HomePilotActivity$2 */
    class C08962 implements OnMenuListener {
        C08962() {
        }

        public void openMenu() {
            if (VERSION.SDK_INT >= 21) {
                HomePilotActivity.this.getWindow().setStatusBarColor(ContextCompat.getColor(HomePilotActivity.this, C0519R.color.side_menu_bg));
            }
        }

        public void closeMenu() {
            if (VERSION.SDK_INT >= 21) {
                HomePilotActivity.this.getWindow().setStatusBarColor(ContextCompat.getColor(HomePilotActivity.this, C0519R.color.colorPrimaryDark));
            }
        }
    }

    protected void onCreate(android.os.Bundle r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:282)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:200)
	at jadx.api.JadxDecompiler$$Lambda$8/199449817.run(Unknown Source)
*/
        /*
        r8 = this;
        super.onCreate(r9);
        r9 = 2131492894; // 0x7f0c001e float:1.8609253E38 double:1.0530974133E-314;
        r8.setContentView(r9);
        r9 = 2131296648; // 0x7f090188 float:1.8211219E38 double:1.053000455E-314;
        r9 = r8.findViewById(r9);
        r9 = (android.support.v7.widget.Toolbar) r9;
        r8.setSupportActionBar(r9);
        r0 = r8.alarmManager;
        if (r0 != 0) goto L_0x003f;
    L_0x0019:
        r0 = "alarm";
        r0 = r8.getSystemService(r0);
        r0 = (android.app.AlarmManager) r0;
        r8.alarmManager = r0;
        r0 = new android.content.Intent;
        r1 = com.ict.delivirko.Utils.AlarmReceive.class;
        r0.<init>(r8, r1);
        r1 = 0;
        r0 = android.app.PendingIntent.getBroadcast(r8, r1, r0, r1);
        r8.pendingIntent = r0;
        r1 = r8.alarmManager;
        r2 = 0;
        r3 = java.lang.System.currentTimeMillis();
        r5 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
        r7 = r8.pendingIntent;
        r1.setRepeating(r2, r3, r5, r7);
    L_0x003f:
        r0 = r8.getIntent();	 Catch:{ Exception -> 0x0062 }
        r1 = "Message";	 Catch:{ Exception -> 0x0062 }
        r0 = r0.getStringExtra(r1);	 Catch:{ Exception -> 0x0062 }
        r0 = r0.trim();	 Catch:{ Exception -> 0x0062 }
        r1 = "";	 Catch:{ Exception -> 0x0062 }
        r0 = r0.equals(r1);	 Catch:{ Exception -> 0x0062 }
        if (r0 != 0) goto L_0x0062;	 Catch:{ Exception -> 0x0062 }
    L_0x0055:
        r0 = r8.getIntent();	 Catch:{ Exception -> 0x0062 }
        r1 = "Message";	 Catch:{ Exception -> 0x0062 }
        r0 = r0.getStringExtra(r1);	 Catch:{ Exception -> 0x0062 }
        com.ict.delivirko.Utils.Constants.showDialog(r8, r0);	 Catch:{ Exception -> 0x0062 }
    L_0x0062:
        r0 = r8.getSupportFragmentManager();
        r0 = r0.beginTransaction();
        r1 = 2131296370; // 0x7f090072 float:1.8210655E38 double:1.0530003175E-314;
        r2 = new com.ict.delivirko.fragment.pilot.PilotMapFragment;
        r2.<init>();
        r0 = r0.replace(r1, r2);
        r0.commit();
        r8.setUpMenu();
        r0 = 2131165378; // 0x7f0700c2 float:1.7944971E38 double:1.052935599E-314;
        r9.setNavigationIcon(r0);
        r0 = new com.ict.delivirko.Activities.HomePilotActivity$1;
        r0.<init>();
        r9.setNavigationOnClickListener(r0);
        r9 = r8.resideMenu;
        r0 = new com.ict.delivirko.Activities.HomePilotActivity$2;
        r0.<init>();
        r9.setMenuListener(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.Activities.HomePilotActivity.onCreate(android.os.Bundle):void");
    }

    public void onClick(View view) {
        view = view.getId();
        if (view != C0519R.id.txtLogout) {
            switch (view) {
                case C0519R.id.pilotNavAccount:
                    getSupportFragmentManager().beginTransaction().replace(C0519R.id.containerPilot, new BillPilotFragment()).commit();
                    break;
                case C0519R.id.pilotNavConditions:
                    getSupportFragmentManager().beginTransaction().replace(C0519R.id.containerPilot, new ConditionsFragment()).commit();
                    break;
                case C0519R.id.pilotNavMain:
                    getSupportFragmentManager().beginTransaction().replace(C0519R.id.containerPilot, new PilotMapFragment()).commit();
                    break;
                case C0519R.id.pilotNavOrders:
                    getSupportFragmentManager().beginTransaction().replace(C0519R.id.containerPilot, new PilotOrdersFragment()).commit();
                    break;
                case C0519R.id.pilotNavSettings:
                    getSupportFragmentManager().beginTransaction().replace(C0519R.id.containerPilot, new MyAccountFragment()).commit();
                    break;
                default:
                    break;
            }
        }
        Constants.showCustomDialog(this);
        this.resideMenu.closeMenu();
    }

    private void setUpMenu() {
        View leftMenuView;
        this.isLeftToRight = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 0;
        if (this.isLeftToRight) {
            this.resideMenu = new ResideMenu(this, C0519R.layout.pilot_side_menu, -1);
            this.resideMenu.setSwipeDirectionDisable(1);
            leftMenuView = this.resideMenu.getLeftMenuView();
        } else {
            this.resideMenu = new ResideMenu(this, -1, C0519R.layout.pilot_side_menu);
            this.resideMenu.setSwipeDirectionDisable(0);
            leftMenuView = this.resideMenu.getRightMenuView();
        }
        this.resideMenu.attachToActivity(this);
        this.resideMenu.setShadowVisible(false);
        this.resideMenu.setScaleValue(0.6f);
        this.resideMenu.setBackgroundColor(ContextCompat.getColor(this, C0519R.color.side_menu_bg));
        this.pilotNavMain = (LinearLayout) leftMenuView.findViewById(C0519R.id.pilotNavMain);
        this.pilotNavOrders = (LinearLayout) leftMenuView.findViewById(C0519R.id.pilotNavOrders);
        this.pilotNavAccount = (LinearLayout) leftMenuView.findViewById(C0519R.id.pilotNavAccount);
        this.pilotNavSettings = (LinearLayout) leftMenuView.findViewById(C0519R.id.pilotNavSettings);
        this.pilotNavConditions = (LinearLayout) leftMenuView.findViewById(C0519R.id.pilotNavConditions);
        this.txtLogout = (TextView) leftMenuView.findViewById(C0519R.id.txtLogout);
        this.tvMenuPilotName = (TextView) leftMenuView.findViewById(C0519R.id.tvMenuPilotName);
        this.imgRestaurantLogo = (ImageView) leftMenuView.findViewById(C0519R.id.imgRestaurantLogo);
        this.pilotNavMain.setOnClickListener(this);
        this.pilotNavOrders.setOnClickListener(this);
        this.pilotNavAccount.setOnClickListener(this);
        this.pilotNavSettings.setOnClickListener(this);
        this.pilotNavConditions.setOnClickListener(this);
        this.txtLogout.setOnClickListener(this);
        this.tvMenuPilotName.setText(ApplicationController.getInstance().getUser().getName());
        Picasso picasso = Picasso.get();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Constants.Image_URL);
        stringBuilder.append(ApplicationController.getInstance().getUser().getImage());
        picasso.load(stringBuilder.toString()).fit().into(this.imgRestaurantLogo);
    }

    public void onBackPressed() {
        if (this.resideMenu.isOpened()) {
            this.resideMenu.closeMenu();
        } else {
            super.onBackPressed();
        }
    }
}
