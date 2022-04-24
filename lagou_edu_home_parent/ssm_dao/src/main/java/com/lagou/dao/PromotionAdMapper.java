package com.lagou.dao;

import com.lagou.domain.PromotionAd;

import java.util.List;

public interface PromotionAdMapper {

    List<PromotionAd> findAllPromotionAdByPage();

    void updatePromotionAdStatus(PromotionAd promotionAd);
}
