package net.javaguides.service;

import net.javaguides.entity.Pay;
import net.javaguides.repository.PayRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayServiceImpl implements PayService{

    private PayRepository payRepository;

    public PayServiceImpl(PayRepository payRepository) {
        this.payRepository=payRepository;
    }

    @Override
    public Pay createPay(Pay pay) {
        return payRepository.save(pay);
    }

}
