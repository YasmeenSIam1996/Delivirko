package com.ict.delivirko.fragment.restaurant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.ict.delivirko.API.ResponseContact;
import com.ict.delivirko.API.ResponseError;
import com.ict.delivirko.API.UserAPI;
import com.ict.delivirko.C0519R;
import com.ict.delivirko.Interfaces.UniversalCallBack;
import com.ict.delivirko.Utils.Constants;
import com.ict.delivirko.adapter.restaurant.Contacts;

public class ContactsFragment extends Fragment {
    private TextView tvContactEmail;
    private TextView tvContactMobile;
    private TextView tvContactWhats;

    /* renamed from: com.ict.delivirko.fragment.restaurant.ContactsFragment$1 */
    class C05461 implements OnClickListener {
        C05461() {
        }

        public void onClick(View view) {
            Context activity;
            StringBuilder stringBuilder;
            if (VERSION.SDK_INT < 23) {
                view = ContactsFragment.this;
                activity = view.getActivity();
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(ContactsFragment.this.tvContactMobile.getText().toString());
                view.phoneCall(activity, stringBuilder.toString());
            } else if (ContextCompat.checkSelfPermission(ContactsFragment.this.getActivity(), "android.permission.CALL_PHONE") == null) {
                view = ContactsFragment.this;
                activity = view.getActivity();
                stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append(ContactsFragment.this.tvContactMobile.getText().toString());
                view.phoneCall(activity, stringBuilder.toString());
            } else {
                ActivityCompat.requestPermissions(ContactsFragment.this.getActivity(), new String[]{"android.permission.CALL_PHONE"}, 9);
            }
        }
    }

    /* renamed from: com.ict.delivirko.fragment.restaurant.ContactsFragment$2 */
    class C05472 implements OnClickListener {
        C05472() {
        }

        public void onClick(View view) {
            view = new Intent("android.intent.action.SEND");
            view.setType("plain/text");
            view.putExtra("android.intent.extra.EMAIL", new String[]{ContactsFragment.this.tvContactEmail.getText().toString()});
            view.putExtra("android.intent.extra.SUBJECT", "Subject");
            view.putExtra("android.intent.extra.TEXT", "Text");
            ContactsFragment.this.getActivity().startActivity(Intent.createChooser(view, "Send mail..."));
        }
    }

    /* renamed from: com.ict.delivirko.fragment.restaurant.ContactsFragment$3 */
    class C05483 implements OnClickListener {
        C05483() {
        }

        public void onClick(View view) {
            view = ContactsFragment.this.tvContactWhats.getText().toString();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("https://api.whatsapp.com/send?phone=");
            stringBuilder.append(view);
            view = stringBuilder.toString();
            try {
                ContactsFragment.this.getActivity().getPackageManager().getPackageInfo("com.whatsapp", 1);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(view));
                ContactsFragment.this.startActivity(intent);
            } catch (View view2) {
                Toast.makeText(ContactsFragment.this.getActivity(), "Whatsapp app not installed in your phone", 0).show();
                view2.printStackTrace();
            }
        }
    }

    /* renamed from: com.ict.delivirko.fragment.restaurant.ContactsFragment$4 */
    class C09294 implements UniversalCallBack {
        C09294() {
        }

        public void onResponse(Object obj) {
            ResponseContact responseContact = (ResponseContact) obj;
            if (responseContact == null) {
                return;
            }
            if (responseContact.isStatus()) {
                ContactsFragment.this.tvContactMobile.setText(((Contacts) responseContact.getContactsList().get(1)).getValue());
                ContactsFragment.this.tvContactEmail.setText(((Contacts) responseContact.getContactsList().get(2)).getValue());
                ContactsFragment.this.tvContactWhats.setText(((Contacts) responseContact.getContactsList().get(0)).getValue());
                return;
            }
            Constants.showDialog(ContactsFragment.this.getActivity(), responseContact.getMessage());
        }

        public void onFailure(Object obj) {
            if (obj != null) {
                Constants.showDialog(ContactsFragment.this.getActivity(), ((ResponseError) obj).getMessage());
            }
        }

        public void onFinish() {
            Constants.removeProgressDialog();
        }

        public void OnError(String str) {
            Constants.showDialog(ContactsFragment.this.getActivity(), str);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater = layoutInflater.inflate(C0519R.layout.fragment_contacts, viewGroup, false);
        this.tvContactMobile = (TextView) layoutInflater.findViewById(C0519R.id.tvContactMobile);
        this.tvContactEmail = (TextView) layoutInflater.findViewById(C0519R.id.tvContactEmail);
        this.tvContactWhats = (TextView) layoutInflater.findViewById(C0519R.id.tvContactWhats);
        Contacts();
        this.tvContactMobile.setOnClickListener(new C05461());
        this.tvContactEmail.setOnClickListener(new C05472());
        this.tvContactWhats.setOnClickListener(new C05483());
        return layoutInflater;
    }

    public void Contacts() {
        Constants.showSimpleProgressDialog(getActivity(), getResources().getString(C0519R.string.Loading));
        new UserAPI().Contact(new C09294());
    }

    private void phoneCall(Context context, String str) {
        if (ContextCompat.checkSelfPermission(context, "android.permission.CALL_PHONE") == 0) {
            Intent intent = new Intent("android.intent.action.CALL");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("tel:");
            stringBuilder.append(str);
            intent.setData(Uri.parse(stringBuilder.toString()));
            context.startActivity(intent);
            return;
        }
        Constants.showDialog((Activity) context, getResources().getString(C0519R.string.permission));
    }
}
