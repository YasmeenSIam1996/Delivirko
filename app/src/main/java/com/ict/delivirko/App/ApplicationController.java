package com.ict.delivirko.App;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import com.google.firebase.FirebaseApp;
import com.ict.delivirko.API.VolleySingleton;
import com.ict.delivirko.Module.OrderNotification;
import com.ict.delivirko.Module.UserDriver;
import com.ict.delivirko.Module.restaurant.OrderTemp;
import com.ict.delivirko.Utils.Constants;
import java.util.Locale;

public class ApplicationController extends Application {
    private static Context context;
    public static int langNum;
    private static ApplicationController mInstance;
    private Locale myLocale;

    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        mInstance = this;
        VolleySingleton.getInstance();
        FirebaseApp.initializeApp(this);
        changeLang(getSharedPreferences("CommonPrefs", 0).getString("Language", "en"));
    }

    public static synchronized ApplicationController getInstance() {
        synchronized (ApplicationController.class) {
            if (mInstance == null) {
                ApplicationController applicationController = new ApplicationController();
                mInstance = applicationController;
                return applicationController;
            }
            applicationController = mInstance;
            return applicationController;
        }
    }

    public static Context getAppContext() {
        return context;
    }

    public OrderTemp getOrderTemp() {
        SharedPreferences sharedPreferences = getAppContext().getSharedPreferences("orderTemp", 0);
        OrderTemp orderTemp = new OrderTemp();
        orderTemp.setId(sharedPreferences.getInt("OrderId", 0));
        orderTemp.setStatus(sharedPreferences.getInt("OrderStatus", 0));
        return orderTemp;
    }

    public UserDriver getUser() {
        SharedPreferences sharedPreferences = getAppContext().getSharedPreferences("access_token", 0);
        UserDriver userDriver = new UserDriver();
        userDriver.setEmail(sharedPreferences.getString("UserEmail", ""));
        userDriver.setId(sharedPreferences.getInt("UserId", 0));
        userDriver.setCar_number(sharedPreferences.getString("car_number", ""));
        userDriver.setPhone(sharedPreferences.getString("UserPhone", ""));
        userDriver.setName(sharedPreferences.getString("UserName", ""));
        userDriver.setToken(sharedPreferences.getString("UserToken", ""));
        userDriver.setDriver(sharedPreferences.getBoolean("isDriver", false));
        userDriver.setImage(sharedPreferences.getString("Image", ""));
        return userDriver;
    }

    public void loginUser(UserDriver userDriver) {
        Editor edit = getAppContext().getSharedPreferences("access_token", 0).edit();
        edit.putString("UserToken", userDriver.getToken());
        edit.putString("UserEmail", userDriver.getEmail());
        edit.putString("UserName", userDriver.getName());
        edit.putString("UserPhone", userDriver.getPhone());
        edit.putInt("UserId", userDriver.getId());
        edit.putString("car_number", userDriver.getCar_number());
        edit.putBoolean("isDriver", userDriver.isDriver());
        edit.putString("Image", userDriver.getImage());
        edit.commit();
    }

    public void SetTempOrder(OrderTemp orderTemp) {
        Editor edit = getAppContext().getSharedPreferences("orderTemp", 0).edit();
        edit.putInt("OrderId", orderTemp.getId());
        edit.putInt("OrderStatus", orderTemp.getId());
        edit.commit();
    }

    public void SetOrderNotification(OrderNotification orderNotification) {
        Editor edit = getAppContext().getSharedPreferences("OrderNotification", 0).edit();
        edit.putString("status_id", orderNotification.getStatus_id());
        edit.putString("duration", orderNotification.getDuration());
        edit.putString("driver_id", orderNotification.getDriver_id());
        edit.putString("driver_car_number", orderNotification.getDriver_car_number());
        edit.putString("driver_phone", orderNotification.getDriver_phone());
        edit.putString(Constants.DISTANCE, orderNotification.getDistance());
        edit.putString("driver_lat", orderNotification.getDriver_lat());
        edit.putString("driver_lng", orderNotification.getDriver_lng());
        edit.putString("order_id", orderNotification.getOrder_id());
        edit.putString("driver_name", orderNotification.getDriver_name());
        edit.putString("driver_rating", orderNotification.getDriver_rating());
        edit.putString("order_status_text", orderNotification.getOrder_status_text());
        edit.putString("driver_image", orderNotification.getDriver_image());
        edit.putInt("driver_rating_count", orderNotification.getDriver_rating_count());
        edit.putString("waiting_time", orderNotification.getWaiting_time());
        edit.putString("company_name", orderNotification.getCompany_name());
        edit.putString("company_address", orderNotification.getCompany_address());
        edit.putString("company_lng", orderNotification.getCompany_lng());
        edit.putString("company_lat", orderNotification.getCompany_lat());
        edit.commit();
    }

    public OrderNotification getOrderNotification() {
        SharedPreferences sharedPreferences = getAppContext().getSharedPreferences("OrderNotification", 0);
        OrderNotification orderNotification = new OrderNotification();
        orderNotification.setStatus_id(sharedPreferences.getString("status_id", ""));
        orderNotification.setDuration(sharedPreferences.getString("duration", ""));
        orderNotification.setDriver_id(sharedPreferences.getString("driver_id", ""));
        orderNotification.setDriver_car_number(sharedPreferences.getString("driver_car_number", ""));
        orderNotification.setDriver_phone(sharedPreferences.getString("driver_phone", ""));
        orderNotification.setDistance(sharedPreferences.getString(Constants.DISTANCE, ""));
        orderNotification.setDriver_lat(sharedPreferences.getString("driver_lat", ""));
        orderNotification.setDriver_lng(sharedPreferences.getString("driver_lng", ""));
        orderNotification.setOrder_id(sharedPreferences.getString("order_id", ""));
        orderNotification.setDriver_name(sharedPreferences.getString("driver_name", ""));
        orderNotification.setDriver_rating(sharedPreferences.getString("driver_rating", ""));
        orderNotification.setOrder_status_text(sharedPreferences.getString("order_status_text", ""));
        orderNotification.setDriver_image(sharedPreferences.getString("driver_image", ""));
        orderNotification.setDriver_rating_count(sharedPreferences.getInt("driver_rating_count", 0));
        orderNotification.setWaiting_time(sharedPreferences.getString("waiting_time", ""));
        orderNotification.setCompany_address(sharedPreferences.getString("company_address", ""));
        orderNotification.setCompany_name(sharedPreferences.getString("company_name", ""));
        orderNotification.setCompany_lat(sharedPreferences.getString("company_lng", ""));
        orderNotification.setCompany_lng(sharedPreferences.getString("company_lat", ""));
        return orderNotification;
    }

    public void deleteOrderNotification() {
        Editor edit = getAppContext().getSharedPreferences("OrderNotification", 0).edit();
        edit.putString("status_id", "-1");
        edit.putString("duration", "");
        edit.putString("driver_id", "");
        edit.putString("driver_car_number", "");
        edit.putString("driver_phone", "");
        edit.putString(Constants.DISTANCE, "");
        edit.putString("driver_lat", "");
        edit.putString("driver_lng", "");
        edit.putString("order_id", "");
        edit.putString("driver_name", "");
        edit.putString("driver_rating", "");
        edit.putString("order_status_text", "");
        edit.putString("driver_image", "");
        edit.putInt("driver_rating_count", 0);
        edit.putString("waiting_time", "");
        edit.putString("company_name", "");
        edit.putString("company_address", "");
        edit.putString("company_lng", "");
        edit.putString("company_lat", "");
        edit.commit();
    }

    public void deleteTempOrder() {
        Editor edit = getAppContext().getSharedPreferences("orderTemp", 0).edit();
        edit.putString("OrderId", "-1");
        edit.putString("OrderStatus", "");
        edit.commit();
    }

    public void deleteUser() {
        Editor edit = getAppContext().getSharedPreferences("access_token", 0).edit();
        edit.putString("UserToken", "");
        edit.putString("UserEmail", "");
        edit.putString("UserName", "");
        edit.putString("UserPhone", "");
        edit.putInt("UserId", 0);
        edit.putString("car_number", "");
        edit.putBoolean("isDriver", false);
        edit.putString("Image", "");
        edit.commit();
    }

    public boolean IsDriverUserLoggedIn() {
        return !getInstance().getUser().getName().trim().equals("");
    }

    public void loadLocale() {
        changeLang(getSharedPreferences("CommonPrefs", 0).getString("Language", "ar"));
    }

    public void changeLang(String str) {
        if (!str.equalsIgnoreCase("")) {
            this.myLocale = new Locale(str);
            saveLocale(str);
            Locale.setDefault(this.myLocale);
            Configuration configuration = new Configuration();
            configuration.locale = this.myLocale;
            getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
            if (str.equals("ar") != null) {
                langNum = 1;
            } else {
                langNum = null;
            }
        }
    }

    public void saveLocale(String str) {
        Editor edit = getSharedPreferences("CommonPrefs", 0).edit();
        edit.putString("Language", str);
        edit.commit();
    }
}
