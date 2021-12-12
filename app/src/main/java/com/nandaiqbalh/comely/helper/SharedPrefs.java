package com.nandaiqbalh.comely.helper;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.nandaiqbalh.comely.model.user.User;

public class SharedPrefs {
    String myPref = "MAIN_PREF";
    SharedPreferences sp;

    String login = "login";
    private String name = "name";
    private String username = "username";
    private String email = "email";
    private String phone = "phone";
    private String gender = "gender";
    private String birthday = "birthday";
    private String user = "user";

    Gson gson = new Gson();

    public SharedPrefs(Activity activity) {
        sp = activity.getSharedPreferences(myPref, Context.MODE_PRIVATE);
    }

    public void setStatusLogin(boolean statusLogin) {
        sp.edit().putBoolean(login, statusLogin).apply();

    }

    public boolean getStatusLogin() {
        return sp.getBoolean(login, false);
    }

    // Setter bertipe User untuk memanggil langsung semua field di dalam user, agar ga manggil satu per satu
    public void setUser(User value) {
        String data = gson.toJson(value, User.class); // ubah data dari bentuk Object Class ke dalam bentuk String
        sp.edit().putString(String.valueOf(user), data).apply();
    }

    // Getter bertipe User untuk memanggil langsung semua field di dalam user, agar ga manggil satu per satu
    public User getUser(){
        String data;
        data = sp.getString(String.valueOf(this.user), null); // ubah data dari bentuk String ke dalam bentuk Object Class

        if (data != null){
            return gson.fromJson(data, User.class);
        } else {
            return null;
        }
    }

    public void setString(String key, String value) {
        sp.edit().putString(key, value).apply();
    }

    public String getString(String key){
        return sp.getString(key, "");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
