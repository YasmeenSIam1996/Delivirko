package com.ict.delivirko.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListPopupWindow;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import com.ict.delivirko.API.ResponseError;
import com.ict.delivirko.API.ResponseMakeOrder;
import com.ict.delivirko.API.ResponseOrderId;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Module.OrderNotification;
import com.ict.delivirko.Module.restaurant.MakeOrder;
import com.ict.delivirko.Module.restaurant.places;
import com.ict.delivirko.Utils.Constants;
import com.ict.delivirko.adapter.restaurant.ListPopupWindowAdapter;
import java.util.List;
import java.util.Vector;

public class AddOrderActivity extends AppCompatActivity implements OnClickListener, OnCheckedChangeListener {
    private String LocationName_ = "";
    private Switch PaymentSwitch;
    private int checked = 0;
    private OrderNotification orderNotification;
    private int payment = 0;
    private int placeID = 0;
    private List<places> placesList;
    private EditText price_range;
    RadioButton rbCash;
    RadioButton rbEPay;
    private Button save;
    TextView spinnerCity;
    private String toLat = "";
    private String toLng = "";
    TextView tvLocationOnMAp;
    private EditText txtBuildingNo;
    private EditText txtClientName;
    private EditText txtFlatNo;
    private EditText txtFloorNo;
    private LinearLayout txtMapAddress;
    private EditText txtMobileAddOrder;
    private EditText txtOrderValue;
    private EditText txtSpecialMark;
    private EditText txtStreet;

    /* renamed from: com.ict.delivirko.Activities.AddOrderActivity$1 */
    class C04961 implements OnCheckedChangeListener {
        C04961() {
        }

        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z) {
                AddOrderActivity.this.checked = true;
            } else {
                AddOrderActivity.this.checked = false;
            }
        }
    }

    /* renamed from: com.ict.delivirko.Activities.AddOrderActivity$2 */
    class C04972 implements OnClickListener {
        C04972() {
        }

        public void onClick(View view) {
            AddOrderActivity.this.isValidation();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0519R.layout.activity_add_order);
        findViews();
        setActions();
    }

    private void setActions() {
        this.PaymentSwitch.setOnCheckedChangeListener(new C04961());
        this.save.setOnClickListener(new C04972());
    }

    private void findViews() {
        this.placesList = new Vector();
        this.rbCash = (RadioButton) findViewById(C0519R.id.rbCash);
        this.rbCash = (RadioButton) findViewById(C0519R.id.rbEPay);
        this.price_range = (EditText) findViewById(C0519R.id.price_range);
        this.spinnerCity = (TextView) findViewById(C0519R.id.spinnerCity);
        this.txtStreet = (EditText) findViewById(C0519R.id.txtStreet);
        this.txtSpecialMark = (EditText) findViewById(C0519R.id.txtSpecialMark);
        this.txtBuildingNo = (EditText) findViewById(C0519R.id.txtBuildingNo);
        this.txtFloorNo = (EditText) findViewById(C0519R.id.txtFloorNo);
        this.txtFlatNo = (EditText) findViewById(C0519R.id.txtFlatNo);
        this.txtClientName = (EditText) findViewById(C0519R.id.txtClientName);
        this.txtMobileAddOrder = (EditText) findViewById(C0519R.id.txtMobileAddOrder);
        this.txtOrderValue = (EditText) findViewById(C0519R.id.txtOrderValue);
        this.tvLocationOnMAp = (TextView) findViewById(C0519R.id.tvLocationOnMAp);
        this.txtMapAddress = (LinearLayout) findViewById(C0519R.id.txtMapAddress);
        this.PaymentSwitch = (Switch) findViewById(C0519R.id.PaymentSwitch);
        this.save = (Button) findViewById(C0519R.id.save);
        this.orderNotification = (OrderNotification) getIntent().getSerializableExtra("orderNotification");
        getOrderData(this);
        this.spinnerCity.setOnClickListener(this);
        this.txtMapAddress.setOnClickListener(this);
    }

    public void onClick(View view) {
        view = view.getId();
        if (view == C0519R.id.spinnerCity) {
            showSizeListPopupWindow(this.spinnerCity);
        } else if (view == C0519R.id.txtMapAddress) {
            startActivityForResult(new Intent(this, LocationMapsActivity.class), 1);
        }
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (compoundButton.getId()) {
            case C0519R.id.rbCash:
                if (z) {
                    this.payment = 0;
                    this.rbEPay.setChecked(false);
                    return;
                }
                return;
            case C0519R.id.rbEPay:
                if (z) {
                    this.payment = 1;
                    this.rbCash.setChecked(false);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void getOrderData(final Context context) {
        new UserAPI().getOrderData(new UniversalCallBack() {
            public void onFinish() {
            }

            public void onResponse(Object obj) {
                ResponseMakeOrder responseMakeOrder = (ResponseMakeOrder) obj;
                if (responseMakeOrder.isStatus()) {
                    AddOrderActivity.this.placesList.clear();
                    AddOrderActivity.this.placesList.addAll(responseMakeOrder.getMakeOrderData().getPlacesList());
                    return;
                }
                Constants.showDialog((Activity) context, responseMakeOrder.getMessage());
            }

            public void onFailure(Object obj) {
                if (obj != null) {
                    Constants.showDialog((Activity) context, ((ResponseError) obj).getMessage());
                }
            }

            public void OnError(String str) {
                Constants.showDialog((Activity) context, str);
            }
        });
    }

    private void showSizeListPopupWindow(View view) {
        final ListPopupWindow listPopupWindow = new ListPopupWindow(this);
        if (VERSION.SDK_INT >= 19) {
            listPopupWindow.setDropDownGravity(5);
        }
        listPopupWindow.setHeight(-2);
        listPopupWindow.setWidth(950);
        listPopupWindow.setAnchorView(view);
        listPopupWindow.setAdapter(new ListPopupWindowAdapter(this, this.placesList, new ListPopupWindowAdapter.OnClickListener() {
            public void onClickButton(int i, places places) {
                listPopupWindow.dismiss();
                i = AddOrderActivity.this.price_range;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(places.getPrice_from());
                stringBuilder.append(" - ");
                stringBuilder.append(places.getPrice_to());
                i.setHint(stringBuilder.toString());
                AddOrderActivity.this.placeID = places.getId();
            }
        }));
        listPopupWindow.show();
    }

    private boolean isValidation() {
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
        r38 = this;
        r0 = r38;
        r1 = r0.txtStreet;
        r1 = com.ict.delivirko.Utils.Constants.ValidationEmptyInput(r1);
        r2 = 2131689595; // 0x7f0f007b float:1.900821E38 double:1.0531945965E-314;
        r3 = 0;
        if (r1 != 0) goto L_0x001a;
    L_0x000e:
        r1 = r38.getResources();
        r1 = r1.getString(r2);
        com.ict.delivirko.Utils.Constants.showDialog(r0, r1);
        return r3;
    L_0x001a:
        r1 = r0.txtSpecialMark;
        r1 = com.ict.delivirko.Utils.Constants.ValidationEmptyInput(r1);
        if (r1 != 0) goto L_0x002e;
    L_0x0022:
        r1 = r38.getResources();
        r1 = r1.getString(r2);
        com.ict.delivirko.Utils.Constants.showDialog(r0, r1);
        return r3;
    L_0x002e:
        r1 = r0.txtBuildingNo;
        r1 = com.ict.delivirko.Utils.Constants.ValidationEmptyInput(r1);
        if (r1 != 0) goto L_0x0042;
    L_0x0036:
        r1 = r38.getResources();
        r1 = r1.getString(r2);
        com.ict.delivirko.Utils.Constants.showDialog(r0, r1);
        return r3;
    L_0x0042:
        r1 = r0.txtFloorNo;
        r1 = com.ict.delivirko.Utils.Constants.ValidationEmptyInput(r1);
        if (r1 != 0) goto L_0x0056;
    L_0x004a:
        r1 = r38.getResources();
        r1 = r1.getString(r2);
        com.ict.delivirko.Utils.Constants.showDialog(r0, r1);
        return r3;
    L_0x0056:
        r1 = r0.txtFlatNo;
        r1 = com.ict.delivirko.Utils.Constants.ValidationEmptyInput(r1);
        if (r1 != 0) goto L_0x006a;
    L_0x005e:
        r1 = r38.getResources();
        r1 = r1.getString(r2);
        com.ict.delivirko.Utils.Constants.showDialog(r0, r1);
        return r3;
    L_0x006a:
        r1 = r0.txtClientName;
        r1 = com.ict.delivirko.Utils.Constants.ValidationEmptyInput(r1);
        if (r1 != 0) goto L_0x007e;
    L_0x0072:
        r1 = r38.getResources();
        r1 = r1.getString(r2);
        com.ict.delivirko.Utils.Constants.showDialog(r0, r1);
        return r3;
    L_0x007e:
        r1 = r0.txtMobileAddOrder;
        r1 = com.ict.delivirko.Utils.Constants.ValidationEmptyInput(r1);
        if (r1 != 0) goto L_0x0092;
    L_0x0086:
        r1 = r38.getResources();
        r1 = r1.getString(r2);
        com.ict.delivirko.Utils.Constants.showDialog(r0, r1);
        return r3;
    L_0x0092:
        r1 = r0.txtOrderValue;
        r1 = com.ict.delivirko.Utils.Constants.ValidationEmptyInput(r1);
        if (r1 != 0) goto L_0x00a6;
    L_0x009a:
        r1 = r38.getResources();
        r1 = r1.getString(r2);
        com.ict.delivirko.Utils.Constants.showDialog(r0, r1);
        return r3;
    L_0x00a6:
        r1 = r0.LocationName_;
        r4 = "";
        r1 = r1.equals(r4);
        if (r1 == 0) goto L_0x00bc;
    L_0x00b0:
        r1 = r38.getResources();
        r1 = r1.getString(r2);
        com.ict.delivirko.Utils.Constants.showDialog(r0, r1);
        return r3;
    L_0x00bc:
        r1 = new com.ict.delivirko.Module.restaurant.MakeOrder;	 Catch:{ Exception -> 0x017c }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x017c }
        r2.<init>();	 Catch:{ Exception -> 0x017c }
        r4 = r0.orderNotification;	 Catch:{ Exception -> 0x017c }
        r4 = r4.getOrder_id();	 Catch:{ Exception -> 0x017c }
        r2.append(r4);	 Catch:{ Exception -> 0x017c }
        r4 = "";	 Catch:{ Exception -> 0x017c }
        r2.append(r4);	 Catch:{ Exception -> 0x017c }
        r5 = r2.toString();	 Catch:{ Exception -> 0x017c }
        r2 = r0.txtClientName;	 Catch:{ Exception -> 0x017c }
        r2 = r2.getText();	 Catch:{ Exception -> 0x017c }
        r6 = r2.toString();	 Catch:{ Exception -> 0x017c }
        r2 = r0.txtMobileAddOrder;	 Catch:{ Exception -> 0x017c }
        r2 = r2.getText();	 Catch:{ Exception -> 0x017c }
        r7 = r2.toString();	 Catch:{ Exception -> 0x017c }
        r2 = r0.tvLocationOnMAp;	 Catch:{ Exception -> 0x017c }
        r2 = r2.getText();	 Catch:{ Exception -> 0x017c }
        r8 = r2.toString();	 Catch:{ Exception -> 0x017c }
        r2 = r0.txtStreet;	 Catch:{ Exception -> 0x017c }
        r2 = r2.getText();	 Catch:{ Exception -> 0x017c }
        r9 = r2.toString();	 Catch:{ Exception -> 0x017c }
        r2 = r0.txtBuildingNo;	 Catch:{ Exception -> 0x017c }
        r2 = r2.getText();	 Catch:{ Exception -> 0x017c }
        r10 = r2.toString();	 Catch:{ Exception -> 0x017c }
        r2 = r0.txtFlatNo;	 Catch:{ Exception -> 0x017c }
        r2 = r2.getText();	 Catch:{ Exception -> 0x017c }
        r11 = r2.toString();	 Catch:{ Exception -> 0x017c }
        r2 = r0.txtFloorNo;	 Catch:{ Exception -> 0x017c }
        r2 = r2.getText();	 Catch:{ Exception -> 0x017c }
        r12 = r2.toString();	 Catch:{ Exception -> 0x017c }
        r2 = r0.txtSpecialMark;	 Catch:{ Exception -> 0x017c }
        r2 = r2.getText();	 Catch:{ Exception -> 0x017c }
        r13 = r2.toString();	 Catch:{ Exception -> 0x017c }
        r14 = r0.toLat;	 Catch:{ Exception -> 0x017c }
        r15 = r0.toLng;	 Catch:{ Exception -> 0x017c }
        r2 = r0.txtOrderValue;	 Catch:{ Exception -> 0x017c }
        r2 = r2.getText();	 Catch:{ Exception -> 0x017c }
        r16 = r2.toString();	 Catch:{ Exception -> 0x017c }
        r2 = r0.price_range;	 Catch:{ Exception -> 0x017c }
        r2 = r2.getText();	 Catch:{ Exception -> 0x017c }
        r17 = r2.toString();	 Catch:{ Exception -> 0x017c }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x017c }
        r2.<init>();	 Catch:{ Exception -> 0x017c }
        r4 = r0.payment;	 Catch:{ Exception -> 0x017c }
        r2.append(r4);	 Catch:{ Exception -> 0x017c }
        r4 = "";	 Catch:{ Exception -> 0x017c }
        r2.append(r4);	 Catch:{ Exception -> 0x017c }
        r18 = r2.toString();	 Catch:{ Exception -> 0x017c }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x017c }
        r2.<init>();	 Catch:{ Exception -> 0x017c }
        r4 = r0.checked;	 Catch:{ Exception -> 0x017c }
        r2.append(r4);	 Catch:{ Exception -> 0x017c }
        r4 = "";	 Catch:{ Exception -> 0x017c }
        r2.append(r4);	 Catch:{ Exception -> 0x017c }
        r19 = r2.toString();	 Catch:{ Exception -> 0x017c }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x017c }
        r2.<init>();	 Catch:{ Exception -> 0x017c }
        r4 = r0.placeID;	 Catch:{ Exception -> 0x017c }
        r2.append(r4);	 Catch:{ Exception -> 0x017c }
        r4 = "";	 Catch:{ Exception -> 0x017c }
        r2.append(r4);	 Catch:{ Exception -> 0x017c }
        r20 = r2.toString();	 Catch:{ Exception -> 0x017c }
        r4 = r1;	 Catch:{ Exception -> 0x017c }
        r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);	 Catch:{ Exception -> 0x017c }
        goto L_0x0243;
    L_0x017c:
        r1 = new com.ict.delivirko.Module.restaurant.MakeOrder;
        r21 = r1;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = r38.getIntent();
        r5 = "orderId";
        r3 = r4.getIntExtra(r5, r3);
        r2.append(r3);
        r3 = "";
        r2.append(r3);
        r22 = r2.toString();
        r2 = r0.txtClientName;
        r2 = r2.getText();
        r23 = r2.toString();
        r2 = r0.txtMobileAddOrder;
        r2 = r2.getText();
        r24 = r2.toString();
        r2 = r0.tvLocationOnMAp;
        r2 = r2.getText();
        r25 = r2.toString();
        r2 = r0.txtStreet;
        r2 = r2.getText();
        r26 = r2.toString();
        r2 = r0.txtBuildingNo;
        r2 = r2.getText();
        r27 = r2.toString();
        r2 = r0.txtFlatNo;
        r2 = r2.getText();
        r28 = r2.toString();
        r2 = r0.txtFloorNo;
        r2 = r2.getText();
        r29 = r2.toString();
        r2 = r0.txtSpecialMark;
        r2 = r2.getText();
        r30 = r2.toString();
        r2 = r0.toLat;
        r31 = r2;
        r2 = r0.toLng;
        r32 = r2;
        r2 = r0.txtOrderValue;
        r2 = r2.getText();
        r33 = r2.toString();
        r2 = r0.price_range;
        r2 = r2.getText();
        r34 = r2.toString();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r0.payment;
        r2.append(r3);
        r3 = "";
        r2.append(r3);
        r35 = r2.toString();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r0.checked;
        r2.append(r3);
        r3 = "";
        r2.append(r3);
        r36 = r2.toString();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r0.placeID;
        r2.append(r3);
        r3 = "";
        r2.append(r3);
        r37 = r2.toString();
        r21.<init>(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37);
    L_0x0243:
        r0.makeOrder(r0, r1);
        r1 = 1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ict.delivirko.Activities.AddOrderActivity.isValidation():boolean");
    }

    public void makeOrder(final Context context, MakeOrder makeOrder) {
        new UserAPI().makeOrder(makeOrder, new UniversalCallBack() {
            public void onFinish() {
            }

            public void onResponse(Object obj) {
                ResponseOrderId responseOrderId = (ResponseOrderId) obj;
                if (responseOrderId.isStatus()) {
                    Intent intent = new Intent(AddOrderActivity.this, TravelMapsActivity.class);
                    intent.putExtra("message", responseOrderId.getMessage());
                    intent.putExtra("orderNo", responseOrderId.getOrderId().getOrder_id());
                    intent.putExtra("Status_id", 3);
                    AddOrderActivity.this.startActivity(intent);
                    AddOrderActivity.this.finish();
                    return;
                }
                Constants.showDialog((Activity) context, responseOrderId.getMessage());
            }

            public void onFailure(Object obj) {
                if (obj != null) {
                    Constants.showDialog((Activity) context, ((ResponseError) obj).getMessage());
                }
            }

            public void OnError(String str) {
                Constants.showDialog((Activity) context, str);
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            i = intent.getStringExtra("name");
            i2 = intent.getStringExtra("lat");
            intent = intent.getStringExtra("lng");
            this.LocationName_ = i;
            TextView textView = this.tvLocationOnMAp;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i);
            stringBuilder.append("");
            textView.setText(stringBuilder.toString());
            this.toLat = i2;
            this.toLng = intent;
        }
    }
}
