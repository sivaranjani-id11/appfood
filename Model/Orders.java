package com.food.Model;

public class Orders {
    private int Userid;
    private int Restaurantid;
    private float Totalamount;
    private String Status;
    private String Paymentmode;

    public Orders() {}

    public Orders(int userid, int restaurantid, float totalamount, String status, String paymentmode) {
        this.Userid = userid;
        this.Restaurantid = restaurantid;
        this.Totalamount = totalamount;
        this.Status = status;
        this.Paymentmode = paymentmode;
    }

    public int getUserid() {
        return Userid;
    }

    public void setUserid(int userid) {
        this.Userid = userid;
    }

    public int getRestaurantid() {
        return Restaurantid;
    }

    public void setRestaurantid(int restaurantid) {
        this.Restaurantid = restaurantid;
    }

    public float getTotalamount() {
        return Totalamount;
    }

    public void setTotalamount(float totalamount) {
        this.Totalamount = totalamount;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public String getPaymentmode() {
        return Paymentmode;
    }

    public void setPaymentmode(String paymentmode) {
        this.Paymentmode = paymentmode;
    }

    @Override
    public String toString() {
        return "Orders [Userid=" + Userid + ", Restaurantid=" + Restaurantid + ", Totalamount=" + Totalamount
                + ", Status=" + Status + ", Paymentmode=" + Paymentmode + "]";
    }
}
