
package za.ac.cput.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;
@Entity
public class Coupon {
    @Id
    private int couponId;
    @ManyToOne
    private User userId;
    private double balance;
    private Date expDate;

    public Coupon(){}

    private Coupon(Builder builder){
        this.couponId = builder.couponId;
        this.userId = builder.userId;
        this.balance = builder.balance;
        this.expDate = builder.expDate;
    }

    public int getCouponId() {
        return couponId;
    }

    public User getUserId() {
        return userId;
    }

    public double getBalance() {
        return balance;
    }

    public Date getExpDate() {
        return expDate;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "couponId='" + couponId + '\'' +
                ", userId=" + userId +
                ", balance=" + balance +
                ", expDate=" + expDate +
                '}';
    }

    public static class Builder{
        private int couponId;
        private User userId;
        private double balance;
        private Date expDate;

        public Builder setCouponId(int couponId) {
            this.couponId = couponId;
            return this;
        }

        public Builder setUserId(User userId) {
            this.userId = userId;
            return this;
        }

        public Builder setBalance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder setExpDate(Date expDate) {
            this.expDate = expDate;
            return this;
        }

        public Builder copy(Coupon coupon){
            this.couponId = coupon.couponId;
            this.userId = coupon.userId;
            this.balance = coupon.balance;
            this.expDate = coupon.expDate;
            return this;
        }

        public Coupon build(){
            return new Coupon(this);
        }
    }
}