package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;

import java.util.List;

public interface PromotionAdService {

    PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO);

    void updatePromotionAdStatus(int id,int status);
}
