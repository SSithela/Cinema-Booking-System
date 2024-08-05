
package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Coupon;
import za.ac.cput.repository.CouponRepository;

import java.util.List;


@Service
public class CouponService implements ICouponService{
    private CouponRepository repository;

    @Autowired
    private CouponService(CouponRepository couponRepository){
        this.repository = couponRepository;
    }

    @Override
    public Coupon create(Coupon coupon){
        return this.repository.save(coupon);
    }

    @Override
    public Coupon read(Integer id){
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Coupon update(Coupon coupon){
        return this.repository.existsById(coupon.getCouponId()) ? this.repository.save(coupon) : null;
    }

    @Override
    public boolean delete(Integer id){
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Coupon> getAll(){
        return this.repository.findAll();
    }
}
