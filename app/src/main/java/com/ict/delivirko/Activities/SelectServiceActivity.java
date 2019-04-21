package com.ict.delivirko.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.ict.delivirko.C0519R;

public class SelectServiceActivity extends AppCompatActivity implements OnClickListener {
    LinearLayout layoutClient;
    LinearLayout layoutPilot;
    LinearLayout layoutRest;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0519R.layout.activity_select_service);
        this.layoutClient = (LinearLayout) findViewById(C0519R.id.layoutClient);
        this.layoutRest = (LinearLayout) findViewById(C0519R.id.layoutRest);
        this.layoutPilot = (LinearLayout) findViewById(C0519R.id.layoutPilot);
        this.layoutClient.setOnClickListener(this);
        this.layoutRest.setOnClickListener(this);
        this.layoutPilot.setOnClickListener(this);
    }

    public void onClick(View view) {
        view = view.getId();
        if (view == C0519R.id.layoutClient) {
            return;
        }
        if (view == C0519R.id.layoutPilot) {
            view = new Intent(this, LoginPilotActivity.class);
            view.putExtra("LAT", getIntent().getDoubleExtra("LAT", 0.0d));
            view.putExtra("LNG", getIntent().getDoubleExtra("LNG", 0.0d));
            startActivity(view);
            finish();
        } else if (view == C0519R.id.layoutRest) {
            startActivity(new Intent(this, LoginRestActivity.class));
            finish();
        }
    }
}
