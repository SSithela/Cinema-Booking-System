
package za.ac.cput.service;

import za.ac.cput.domain.Coupon;

import java.util.List;
import java.util.Set;

public interface ICouponService extends IService<Coupon, Integer>{
    List<Coupon> getAll();
}
