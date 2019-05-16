package com.luer.JD.bean;

import java.util.ArrayList;
import java.util.List;

public class JdSkuListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JdSkuListExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNull() {
            addCriterion("sku_id is null");
            return (Criteria) this;
        }

        public Criteria andSkuIdIsNotNull() {
            addCriterion("sku_id is not null");
            return (Criteria) this;
        }

        public Criteria andSkuIdEqualTo(Long value) {
            addCriterion("sku_id =", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotEqualTo(Long value) {
            addCriterion("sku_id <>", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThan(Long value) {
            addCriterion("sku_id >", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sku_id >=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThan(Long value) {
            addCriterion("sku_id <", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdLessThanOrEqualTo(Long value) {
            addCriterion("sku_id <=", value, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdIn(List<Long> values) {
            addCriterion("sku_id in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotIn(List<Long> values) {
            addCriterion("sku_id not in", values, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdBetween(Long value1, Long value2) {
            addCriterion("sku_id between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andSkuIdNotBetween(Long value1, Long value2) {
            addCriterion("sku_id not between", value1, value2, "skuId");
            return (Criteria) this;
        }

        public Criteria andActualCosPriceIsNull() {
            addCriterion("actual_cos_price is null");
            return (Criteria) this;
        }

        public Criteria andActualCosPriceIsNotNull() {
            addCriterion("actual_cos_price is not null");
            return (Criteria) this;
        }

        public Criteria andActualCosPriceEqualTo(Double value) {
            addCriterion("actual_cos_price =", value, "actualCosPrice");
            return (Criteria) this;
        }

        public Criteria andActualCosPriceNotEqualTo(Double value) {
            addCriterion("actual_cos_price <>", value, "actualCosPrice");
            return (Criteria) this;
        }

        public Criteria andActualCosPriceGreaterThan(Double value) {
            addCriterion("actual_cos_price >", value, "actualCosPrice");
            return (Criteria) this;
        }

        public Criteria andActualCosPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("actual_cos_price >=", value, "actualCosPrice");
            return (Criteria) this;
        }

        public Criteria andActualCosPriceLessThan(Double value) {
            addCriterion("actual_cos_price <", value, "actualCosPrice");
            return (Criteria) this;
        }

        public Criteria andActualCosPriceLessThanOrEqualTo(Double value) {
            addCriterion("actual_cos_price <=", value, "actualCosPrice");
            return (Criteria) this;
        }

        public Criteria andActualCosPriceIn(List<Double> values) {
            addCriterion("actual_cos_price in", values, "actualCosPrice");
            return (Criteria) this;
        }

        public Criteria andActualCosPriceNotIn(List<Double> values) {
            addCriterion("actual_cos_price not in", values, "actualCosPrice");
            return (Criteria) this;
        }

        public Criteria andActualCosPriceBetween(Double value1, Double value2) {
            addCriterion("actual_cos_price between", value1, value2, "actualCosPrice");
            return (Criteria) this;
        }

        public Criteria andActualCosPriceNotBetween(Double value1, Double value2) {
            addCriterion("actual_cos_price not between", value1, value2, "actualCosPrice");
            return (Criteria) this;
        }

        public Criteria andActualFeeIsNull() {
            addCriterion("actual_fee is null");
            return (Criteria) this;
        }

        public Criteria andActualFeeIsNotNull() {
            addCriterion("actual_fee is not null");
            return (Criteria) this;
        }

        public Criteria andActualFeeEqualTo(Double value) {
            addCriterion("actual_fee =", value, "actualFee");
            return (Criteria) this;
        }

        public Criteria andActualFeeNotEqualTo(Double value) {
            addCriterion("actual_fee <>", value, "actualFee");
            return (Criteria) this;
        }

        public Criteria andActualFeeGreaterThan(Double value) {
            addCriterion("actual_fee >", value, "actualFee");
            return (Criteria) this;
        }

        public Criteria andActualFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("actual_fee >=", value, "actualFee");
            return (Criteria) this;
        }

        public Criteria andActualFeeLessThan(Double value) {
            addCriterion("actual_fee <", value, "actualFee");
            return (Criteria) this;
        }

        public Criteria andActualFeeLessThanOrEqualTo(Double value) {
            addCriterion("actual_fee <=", value, "actualFee");
            return (Criteria) this;
        }

        public Criteria andActualFeeIn(List<Double> values) {
            addCriterion("actual_fee in", values, "actualFee");
            return (Criteria) this;
        }

        public Criteria andActualFeeNotIn(List<Double> values) {
            addCriterion("actual_fee not in", values, "actualFee");
            return (Criteria) this;
        }

        public Criteria andActualFeeBetween(Double value1, Double value2) {
            addCriterion("actual_fee between", value1, value2, "actualFee");
            return (Criteria) this;
        }

        public Criteria andActualFeeNotBetween(Double value1, Double value2) {
            addCriterion("actual_fee not between", value1, value2, "actualFee");
            return (Criteria) this;
        }

        public Criteria andCommissionRateIsNull() {
            addCriterion("commission_rate is null");
            return (Criteria) this;
        }

        public Criteria andCommissionRateIsNotNull() {
            addCriterion("commission_rate is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionRateEqualTo(Double value) {
            addCriterion("commission_rate =", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateNotEqualTo(Double value) {
            addCriterion("commission_rate <>", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateGreaterThan(Double value) {
            addCriterion("commission_rate >", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateGreaterThanOrEqualTo(Double value) {
            addCriterion("commission_rate >=", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateLessThan(Double value) {
            addCriterion("commission_rate <", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateLessThanOrEqualTo(Double value) {
            addCriterion("commission_rate <=", value, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateIn(List<Double> values) {
            addCriterion("commission_rate in", values, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateNotIn(List<Double> values) {
            addCriterion("commission_rate not in", values, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateBetween(Double value1, Double value2) {
            addCriterion("commission_rate between", value1, value2, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andCommissionRateNotBetween(Double value1, Double value2) {
            addCriterion("commission_rate not between", value1, value2, "commissionRate");
            return (Criteria) this;
        }

        public Criteria andEstimateCosPriceIsNull() {
            addCriterion("estimate_cos_price is null");
            return (Criteria) this;
        }

        public Criteria andEstimateCosPriceIsNotNull() {
            addCriterion("estimate_cos_price is not null");
            return (Criteria) this;
        }

        public Criteria andEstimateCosPriceEqualTo(Double value) {
            addCriterion("estimate_cos_price =", value, "estimateCosPrice");
            return (Criteria) this;
        }

        public Criteria andEstimateCosPriceNotEqualTo(Double value) {
            addCriterion("estimate_cos_price <>", value, "estimateCosPrice");
            return (Criteria) this;
        }

        public Criteria andEstimateCosPriceGreaterThan(Double value) {
            addCriterion("estimate_cos_price >", value, "estimateCosPrice");
            return (Criteria) this;
        }

        public Criteria andEstimateCosPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("estimate_cos_price >=", value, "estimateCosPrice");
            return (Criteria) this;
        }

        public Criteria andEstimateCosPriceLessThan(Double value) {
            addCriterion("estimate_cos_price <", value, "estimateCosPrice");
            return (Criteria) this;
        }

        public Criteria andEstimateCosPriceLessThanOrEqualTo(Double value) {
            addCriterion("estimate_cos_price <=", value, "estimateCosPrice");
            return (Criteria) this;
        }

        public Criteria andEstimateCosPriceIn(List<Double> values) {
            addCriterion("estimate_cos_price in", values, "estimateCosPrice");
            return (Criteria) this;
        }

        public Criteria andEstimateCosPriceNotIn(List<Double> values) {
            addCriterion("estimate_cos_price not in", values, "estimateCosPrice");
            return (Criteria) this;
        }

        public Criteria andEstimateCosPriceBetween(Double value1, Double value2) {
            addCriterion("estimate_cos_price between", value1, value2, "estimateCosPrice");
            return (Criteria) this;
        }

        public Criteria andEstimateCosPriceNotBetween(Double value1, Double value2) {
            addCriterion("estimate_cos_price not between", value1, value2, "estimateCosPrice");
            return (Criteria) this;
        }

        public Criteria andEstimateFeeIsNull() {
            addCriterion("estimate_fee is null");
            return (Criteria) this;
        }

        public Criteria andEstimateFeeIsNotNull() {
            addCriterion("estimate_fee is not null");
            return (Criteria) this;
        }

        public Criteria andEstimateFeeEqualTo(Double value) {
            addCriterion("estimate_fee =", value, "estimateFee");
            return (Criteria) this;
        }

        public Criteria andEstimateFeeNotEqualTo(Double value) {
            addCriterion("estimate_fee <>", value, "estimateFee");
            return (Criteria) this;
        }

        public Criteria andEstimateFeeGreaterThan(Double value) {
            addCriterion("estimate_fee >", value, "estimateFee");
            return (Criteria) this;
        }

        public Criteria andEstimateFeeGreaterThanOrEqualTo(Double value) {
            addCriterion("estimate_fee >=", value, "estimateFee");
            return (Criteria) this;
        }

        public Criteria andEstimateFeeLessThan(Double value) {
            addCriterion("estimate_fee <", value, "estimateFee");
            return (Criteria) this;
        }

        public Criteria andEstimateFeeLessThanOrEqualTo(Double value) {
            addCriterion("estimate_fee <=", value, "estimateFee");
            return (Criteria) this;
        }

        public Criteria andEstimateFeeIn(List<Double> values) {
            addCriterion("estimate_fee in", values, "estimateFee");
            return (Criteria) this;
        }

        public Criteria andEstimateFeeNotIn(List<Double> values) {
            addCriterion("estimate_fee not in", values, "estimateFee");
            return (Criteria) this;
        }

        public Criteria andEstimateFeeBetween(Double value1, Double value2) {
            addCriterion("estimate_fee between", value1, value2, "estimateFee");
            return (Criteria) this;
        }

        public Criteria andEstimateFeeNotBetween(Double value1, Double value2) {
            addCriterion("estimate_fee not between", value1, value2, "estimateFee");
            return (Criteria) this;
        }

        public Criteria andFinalRateIsNull() {
            addCriterion("final_rate is null");
            return (Criteria) this;
        }

        public Criteria andFinalRateIsNotNull() {
            addCriterion("final_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFinalRateEqualTo(Double value) {
            addCriterion("final_rate =", value, "finalRate");
            return (Criteria) this;
        }

        public Criteria andFinalRateNotEqualTo(Double value) {
            addCriterion("final_rate <>", value, "finalRate");
            return (Criteria) this;
        }

        public Criteria andFinalRateGreaterThan(Double value) {
            addCriterion("final_rate >", value, "finalRate");
            return (Criteria) this;
        }

        public Criteria andFinalRateGreaterThanOrEqualTo(Double value) {
            addCriterion("final_rate >=", value, "finalRate");
            return (Criteria) this;
        }

        public Criteria andFinalRateLessThan(Double value) {
            addCriterion("final_rate <", value, "finalRate");
            return (Criteria) this;
        }

        public Criteria andFinalRateLessThanOrEqualTo(Double value) {
            addCriterion("final_rate <=", value, "finalRate");
            return (Criteria) this;
        }

        public Criteria andFinalRateIn(List<Double> values) {
            addCriterion("final_rate in", values, "finalRate");
            return (Criteria) this;
        }

        public Criteria andFinalRateNotIn(List<Double> values) {
            addCriterion("final_rate not in", values, "finalRate");
            return (Criteria) this;
        }

        public Criteria andFinalRateBetween(Double value1, Double value2) {
            addCriterion("final_rate between", value1, value2, "finalRate");
            return (Criteria) this;
        }

        public Criteria andFinalRateNotBetween(Double value1, Double value2) {
            addCriterion("final_rate not between", value1, value2, "finalRate");
            return (Criteria) this;
        }

        public Criteria andCid1IsNull() {
            addCriterion("cid1 is null");
            return (Criteria) this;
        }

        public Criteria andCid1IsNotNull() {
            addCriterion("cid1 is not null");
            return (Criteria) this;
        }

        public Criteria andCid1EqualTo(Long value) {
            addCriterion("cid1 =", value, "cid1");
            return (Criteria) this;
        }

        public Criteria andCid1NotEqualTo(Long value) {
            addCriterion("cid1 <>", value, "cid1");
            return (Criteria) this;
        }

        public Criteria andCid1GreaterThan(Long value) {
            addCriterion("cid1 >", value, "cid1");
            return (Criteria) this;
        }

        public Criteria andCid1GreaterThanOrEqualTo(Long value) {
            addCriterion("cid1 >=", value, "cid1");
            return (Criteria) this;
        }

        public Criteria andCid1LessThan(Long value) {
            addCriterion("cid1 <", value, "cid1");
            return (Criteria) this;
        }

        public Criteria andCid1LessThanOrEqualTo(Long value) {
            addCriterion("cid1 <=", value, "cid1");
            return (Criteria) this;
        }

        public Criteria andCid1In(List<Long> values) {
            addCriterion("cid1 in", values, "cid1");
            return (Criteria) this;
        }

        public Criteria andCid1NotIn(List<Long> values) {
            addCriterion("cid1 not in", values, "cid1");
            return (Criteria) this;
        }

        public Criteria andCid1Between(Long value1, Long value2) {
            addCriterion("cid1 between", value1, value2, "cid1");
            return (Criteria) this;
        }

        public Criteria andCid1NotBetween(Long value1, Long value2) {
            addCriterion("cid1 not between", value1, value2, "cid1");
            return (Criteria) this;
        }

        public Criteria andFrozenSkuNumIsNull() {
            addCriterion("frozen_sku_num is null");
            return (Criteria) this;
        }

        public Criteria andFrozenSkuNumIsNotNull() {
            addCriterion("frozen_sku_num is not null");
            return (Criteria) this;
        }

        public Criteria andFrozenSkuNumEqualTo(Long value) {
            addCriterion("frozen_sku_num =", value, "frozenSkuNum");
            return (Criteria) this;
        }

        public Criteria andFrozenSkuNumNotEqualTo(Long value) {
            addCriterion("frozen_sku_num <>", value, "frozenSkuNum");
            return (Criteria) this;
        }

        public Criteria andFrozenSkuNumGreaterThan(Long value) {
            addCriterion("frozen_sku_num >", value, "frozenSkuNum");
            return (Criteria) this;
        }

        public Criteria andFrozenSkuNumGreaterThanOrEqualTo(Long value) {
            addCriterion("frozen_sku_num >=", value, "frozenSkuNum");
            return (Criteria) this;
        }

        public Criteria andFrozenSkuNumLessThan(Long value) {
            addCriterion("frozen_sku_num <", value, "frozenSkuNum");
            return (Criteria) this;
        }

        public Criteria andFrozenSkuNumLessThanOrEqualTo(Long value) {
            addCriterion("frozen_sku_num <=", value, "frozenSkuNum");
            return (Criteria) this;
        }

        public Criteria andFrozenSkuNumIn(List<Long> values) {
            addCriterion("frozen_sku_num in", values, "frozenSkuNum");
            return (Criteria) this;
        }

        public Criteria andFrozenSkuNumNotIn(List<Long> values) {
            addCriterion("frozen_sku_num not in", values, "frozenSkuNum");
            return (Criteria) this;
        }

        public Criteria andFrozenSkuNumBetween(Long value1, Long value2) {
            addCriterion("frozen_sku_num between", value1, value2, "frozenSkuNum");
            return (Criteria) this;
        }

        public Criteria andFrozenSkuNumNotBetween(Long value1, Long value2) {
            addCriterion("frozen_sku_num not between", value1, value2, "frozenSkuNum");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("pid like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("pid not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNull() {
            addCriterion("position_id is null");
            return (Criteria) this;
        }

        public Criteria andPositionIdIsNotNull() {
            addCriterion("position_id is not null");
            return (Criteria) this;
        }

        public Criteria andPositionIdEqualTo(Long value) {
            addCriterion("position_id =", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotEqualTo(Long value) {
            addCriterion("position_id <>", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThan(Long value) {
            addCriterion("position_id >", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("position_id >=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThan(Long value) {
            addCriterion("position_id <", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdLessThanOrEqualTo(Long value) {
            addCriterion("position_id <=", value, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdIn(List<Long> values) {
            addCriterion("position_id in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotIn(List<Long> values) {
            addCriterion("position_id not in", values, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdBetween(Long value1, Long value2) {
            addCriterion("position_id between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPositionIdNotBetween(Long value1, Long value2) {
            addCriterion("position_id not between", value1, value2, "positionId");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andCid2IsNull() {
            addCriterion("cid2 is null");
            return (Criteria) this;
        }

        public Criteria andCid2IsNotNull() {
            addCriterion("cid2 is not null");
            return (Criteria) this;
        }

        public Criteria andCid2EqualTo(Long value) {
            addCriterion("cid2 =", value, "cid2");
            return (Criteria) this;
        }

        public Criteria andCid2NotEqualTo(Long value) {
            addCriterion("cid2 <>", value, "cid2");
            return (Criteria) this;
        }

        public Criteria andCid2GreaterThan(Long value) {
            addCriterion("cid2 >", value, "cid2");
            return (Criteria) this;
        }

        public Criteria andCid2GreaterThanOrEqualTo(Long value) {
            addCriterion("cid2 >=", value, "cid2");
            return (Criteria) this;
        }

        public Criteria andCid2LessThan(Long value) {
            addCriterion("cid2 <", value, "cid2");
            return (Criteria) this;
        }

        public Criteria andCid2LessThanOrEqualTo(Long value) {
            addCriterion("cid2 <=", value, "cid2");
            return (Criteria) this;
        }

        public Criteria andCid2In(List<Long> values) {
            addCriterion("cid2 in", values, "cid2");
            return (Criteria) this;
        }

        public Criteria andCid2NotIn(List<Long> values) {
            addCriterion("cid2 not in", values, "cid2");
            return (Criteria) this;
        }

        public Criteria andCid2Between(Long value1, Long value2) {
            addCriterion("cid2 between", value1, value2, "cid2");
            return (Criteria) this;
        }

        public Criteria andCid2NotBetween(Long value1, Long value2) {
            addCriterion("cid2 not between", value1, value2, "cid2");
            return (Criteria) this;
        }

        public Criteria andSiteIdIsNull() {
            addCriterion("site_id is null");
            return (Criteria) this;
        }

        public Criteria andSiteIdIsNotNull() {
            addCriterion("site_id is not null");
            return (Criteria) this;
        }

        public Criteria andSiteIdEqualTo(Long value) {
            addCriterion("site_id =", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotEqualTo(Long value) {
            addCriterion("site_id <>", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdGreaterThan(Long value) {
            addCriterion("site_id >", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdGreaterThanOrEqualTo(Long value) {
            addCriterion("site_id >=", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLessThan(Long value) {
            addCriterion("site_id <", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLessThanOrEqualTo(Long value) {
            addCriterion("site_id <=", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdIn(List<Long> values) {
            addCriterion("site_id in", values, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotIn(List<Long> values) {
            addCriterion("site_id not in", values, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdBetween(Long value1, Long value2) {
            addCriterion("site_id between", value1, value2, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotBetween(Long value1, Long value2) {
            addCriterion("site_id not between", value1, value2, "siteId");
            return (Criteria) this;
        }

        public Criteria andSkuNameIsNull() {
            addCriterion("sku_name is null");
            return (Criteria) this;
        }

        public Criteria andSkuNameIsNotNull() {
            addCriterion("sku_name is not null");
            return (Criteria) this;
        }

        public Criteria andSkuNameEqualTo(String value) {
            addCriterion("sku_name =", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameNotEqualTo(String value) {
            addCriterion("sku_name <>", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameGreaterThan(String value) {
            addCriterion("sku_name >", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameGreaterThanOrEqualTo(String value) {
            addCriterion("sku_name >=", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameLessThan(String value) {
            addCriterion("sku_name <", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameLessThanOrEqualTo(String value) {
            addCriterion("sku_name <=", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameLike(String value) {
            addCriterion("sku_name like", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameNotLike(String value) {
            addCriterion("sku_name not like", value, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameIn(List<String> values) {
            addCriterion("sku_name in", values, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameNotIn(List<String> values) {
            addCriterion("sku_name not in", values, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameBetween(String value1, String value2) {
            addCriterion("sku_name between", value1, value2, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNameNotBetween(String value1, String value2) {
            addCriterion("sku_name not between", value1, value2, "skuName");
            return (Criteria) this;
        }

        public Criteria andSkuNumIsNull() {
            addCriterion("sku_num is null");
            return (Criteria) this;
        }

        public Criteria andSkuNumIsNotNull() {
            addCriterion("sku_num is not null");
            return (Criteria) this;
        }

        public Criteria andSkuNumEqualTo(Long value) {
            addCriterion("sku_num =", value, "skuNum");
            return (Criteria) this;
        }

        public Criteria andSkuNumNotEqualTo(Long value) {
            addCriterion("sku_num <>", value, "skuNum");
            return (Criteria) this;
        }

        public Criteria andSkuNumGreaterThan(Long value) {
            addCriterion("sku_num >", value, "skuNum");
            return (Criteria) this;
        }

        public Criteria andSkuNumGreaterThanOrEqualTo(Long value) {
            addCriterion("sku_num >=", value, "skuNum");
            return (Criteria) this;
        }

        public Criteria andSkuNumLessThan(Long value) {
            addCriterion("sku_num <", value, "skuNum");
            return (Criteria) this;
        }

        public Criteria andSkuNumLessThanOrEqualTo(Long value) {
            addCriterion("sku_num <=", value, "skuNum");
            return (Criteria) this;
        }

        public Criteria andSkuNumIn(List<Long> values) {
            addCriterion("sku_num in", values, "skuNum");
            return (Criteria) this;
        }

        public Criteria andSkuNumNotIn(List<Long> values) {
            addCriterion("sku_num not in", values, "skuNum");
            return (Criteria) this;
        }

        public Criteria andSkuNumBetween(Long value1, Long value2) {
            addCriterion("sku_num between", value1, value2, "skuNum");
            return (Criteria) this;
        }

        public Criteria andSkuNumNotBetween(Long value1, Long value2) {
            addCriterion("sku_num not between", value1, value2, "skuNum");
            return (Criteria) this;
        }

        public Criteria andSkuReturnNumIsNull() {
            addCriterion("sku_return_num is null");
            return (Criteria) this;
        }

        public Criteria andSkuReturnNumIsNotNull() {
            addCriterion("sku_return_num is not null");
            return (Criteria) this;
        }

        public Criteria andSkuReturnNumEqualTo(Long value) {
            addCriterion("sku_return_num =", value, "skuReturnNum");
            return (Criteria) this;
        }

        public Criteria andSkuReturnNumNotEqualTo(Long value) {
            addCriterion("sku_return_num <>", value, "skuReturnNum");
            return (Criteria) this;
        }

        public Criteria andSkuReturnNumGreaterThan(Long value) {
            addCriterion("sku_return_num >", value, "skuReturnNum");
            return (Criteria) this;
        }

        public Criteria andSkuReturnNumGreaterThanOrEqualTo(Long value) {
            addCriterion("sku_return_num >=", value, "skuReturnNum");
            return (Criteria) this;
        }

        public Criteria andSkuReturnNumLessThan(Long value) {
            addCriterion("sku_return_num <", value, "skuReturnNum");
            return (Criteria) this;
        }

        public Criteria andSkuReturnNumLessThanOrEqualTo(Long value) {
            addCriterion("sku_return_num <=", value, "skuReturnNum");
            return (Criteria) this;
        }

        public Criteria andSkuReturnNumIn(List<Long> values) {
            addCriterion("sku_return_num in", values, "skuReturnNum");
            return (Criteria) this;
        }

        public Criteria andSkuReturnNumNotIn(List<Long> values) {
            addCriterion("sku_return_num not in", values, "skuReturnNum");
            return (Criteria) this;
        }

        public Criteria andSkuReturnNumBetween(Long value1, Long value2) {
            addCriterion("sku_return_num between", value1, value2, "skuReturnNum");
            return (Criteria) this;
        }

        public Criteria andSkuReturnNumNotBetween(Long value1, Long value2) {
            addCriterion("sku_return_num not between", value1, value2, "skuReturnNum");
            return (Criteria) this;
        }

        public Criteria andSubSideRateIsNull() {
            addCriterion("sub_side_rate is null");
            return (Criteria) this;
        }

        public Criteria andSubSideRateIsNotNull() {
            addCriterion("sub_side_rate is not null");
            return (Criteria) this;
        }

        public Criteria andSubSideRateEqualTo(Double value) {
            addCriterion("sub_side_rate =", value, "subSideRate");
            return (Criteria) this;
        }

        public Criteria andSubSideRateNotEqualTo(Double value) {
            addCriterion("sub_side_rate <>", value, "subSideRate");
            return (Criteria) this;
        }

        public Criteria andSubSideRateGreaterThan(Double value) {
            addCriterion("sub_side_rate >", value, "subSideRate");
            return (Criteria) this;
        }

        public Criteria andSubSideRateGreaterThanOrEqualTo(Double value) {
            addCriterion("sub_side_rate >=", value, "subSideRate");
            return (Criteria) this;
        }

        public Criteria andSubSideRateLessThan(Double value) {
            addCriterion("sub_side_rate <", value, "subSideRate");
            return (Criteria) this;
        }

        public Criteria andSubSideRateLessThanOrEqualTo(Double value) {
            addCriterion("sub_side_rate <=", value, "subSideRate");
            return (Criteria) this;
        }

        public Criteria andSubSideRateIn(List<Double> values) {
            addCriterion("sub_side_rate in", values, "subSideRate");
            return (Criteria) this;
        }

        public Criteria andSubSideRateNotIn(List<Double> values) {
            addCriterion("sub_side_rate not in", values, "subSideRate");
            return (Criteria) this;
        }

        public Criteria andSubSideRateBetween(Double value1, Double value2) {
            addCriterion("sub_side_rate between", value1, value2, "subSideRate");
            return (Criteria) this;
        }

        public Criteria andSubSideRateNotBetween(Double value1, Double value2) {
            addCriterion("sub_side_rate not between", value1, value2, "subSideRate");
            return (Criteria) this;
        }

        public Criteria andSubsidyRateIsNull() {
            addCriterion("subsidy_rate is null");
            return (Criteria) this;
        }

        public Criteria andSubsidyRateIsNotNull() {
            addCriterion("subsidy_rate is not null");
            return (Criteria) this;
        }

        public Criteria andSubsidyRateEqualTo(Double value) {
            addCriterion("subsidy_rate =", value, "subsidyRate");
            return (Criteria) this;
        }

        public Criteria andSubsidyRateNotEqualTo(Double value) {
            addCriterion("subsidy_rate <>", value, "subsidyRate");
            return (Criteria) this;
        }

        public Criteria andSubsidyRateGreaterThan(Double value) {
            addCriterion("subsidy_rate >", value, "subsidyRate");
            return (Criteria) this;
        }

        public Criteria andSubsidyRateGreaterThanOrEqualTo(Double value) {
            addCriterion("subsidy_rate >=", value, "subsidyRate");
            return (Criteria) this;
        }

        public Criteria andSubsidyRateLessThan(Double value) {
            addCriterion("subsidy_rate <", value, "subsidyRate");
            return (Criteria) this;
        }

        public Criteria andSubsidyRateLessThanOrEqualTo(Double value) {
            addCriterion("subsidy_rate <=", value, "subsidyRate");
            return (Criteria) this;
        }

        public Criteria andSubsidyRateIn(List<Double> values) {
            addCriterion("subsidy_rate in", values, "subsidyRate");
            return (Criteria) this;
        }

        public Criteria andSubsidyRateNotIn(List<Double> values) {
            addCriterion("subsidy_rate not in", values, "subsidyRate");
            return (Criteria) this;
        }

        public Criteria andSubsidyRateBetween(Double value1, Double value2) {
            addCriterion("subsidy_rate between", value1, value2, "subsidyRate");
            return (Criteria) this;
        }

        public Criteria andSubsidyRateNotBetween(Double value1, Double value2) {
            addCriterion("subsidy_rate not between", value1, value2, "subsidyRate");
            return (Criteria) this;
        }

        public Criteria andCid3IsNull() {
            addCriterion("cid3 is null");
            return (Criteria) this;
        }

        public Criteria andCid3IsNotNull() {
            addCriterion("cid3 is not null");
            return (Criteria) this;
        }

        public Criteria andCid3EqualTo(Long value) {
            addCriterion("cid3 =", value, "cid3");
            return (Criteria) this;
        }

        public Criteria andCid3NotEqualTo(Long value) {
            addCriterion("cid3 <>", value, "cid3");
            return (Criteria) this;
        }

        public Criteria andCid3GreaterThan(Long value) {
            addCriterion("cid3 >", value, "cid3");
            return (Criteria) this;
        }

        public Criteria andCid3GreaterThanOrEqualTo(Long value) {
            addCriterion("cid3 >=", value, "cid3");
            return (Criteria) this;
        }

        public Criteria andCid3LessThan(Long value) {
            addCriterion("cid3 <", value, "cid3");
            return (Criteria) this;
        }

        public Criteria andCid3LessThanOrEqualTo(Long value) {
            addCriterion("cid3 <=", value, "cid3");
            return (Criteria) this;
        }

        public Criteria andCid3In(List<Long> values) {
            addCriterion("cid3 in", values, "cid3");
            return (Criteria) this;
        }

        public Criteria andCid3NotIn(List<Long> values) {
            addCriterion("cid3 not in", values, "cid3");
            return (Criteria) this;
        }

        public Criteria andCid3Between(Long value1, Long value2) {
            addCriterion("cid3 between", value1, value2, "cid3");
            return (Criteria) this;
        }

        public Criteria andCid3NotBetween(Long value1, Long value2) {
            addCriterion("cid3 not between", value1, value2, "cid3");
            return (Criteria) this;
        }

        public Criteria andUnionAliasIsNull() {
            addCriterion("union_alias is null");
            return (Criteria) this;
        }

        public Criteria andUnionAliasIsNotNull() {
            addCriterion("union_alias is not null");
            return (Criteria) this;
        }

        public Criteria andUnionAliasEqualTo(String value) {
            addCriterion("union_alias =", value, "unionAlias");
            return (Criteria) this;
        }

        public Criteria andUnionAliasNotEqualTo(String value) {
            addCriterion("union_alias <>", value, "unionAlias");
            return (Criteria) this;
        }

        public Criteria andUnionAliasGreaterThan(String value) {
            addCriterion("union_alias >", value, "unionAlias");
            return (Criteria) this;
        }

        public Criteria andUnionAliasGreaterThanOrEqualTo(String value) {
            addCriterion("union_alias >=", value, "unionAlias");
            return (Criteria) this;
        }

        public Criteria andUnionAliasLessThan(String value) {
            addCriterion("union_alias <", value, "unionAlias");
            return (Criteria) this;
        }

        public Criteria andUnionAliasLessThanOrEqualTo(String value) {
            addCriterion("union_alias <=", value, "unionAlias");
            return (Criteria) this;
        }

        public Criteria andUnionAliasLike(String value) {
            addCriterion("union_alias like", value, "unionAlias");
            return (Criteria) this;
        }

        public Criteria andUnionAliasNotLike(String value) {
            addCriterion("union_alias not like", value, "unionAlias");
            return (Criteria) this;
        }

        public Criteria andUnionAliasIn(List<String> values) {
            addCriterion("union_alias in", values, "unionAlias");
            return (Criteria) this;
        }

        public Criteria andUnionAliasNotIn(List<String> values) {
            addCriterion("union_alias not in", values, "unionAlias");
            return (Criteria) this;
        }

        public Criteria andUnionAliasBetween(String value1, String value2) {
            addCriterion("union_alias between", value1, value2, "unionAlias");
            return (Criteria) this;
        }

        public Criteria andUnionAliasNotBetween(String value1, String value2) {
            addCriterion("union_alias not between", value1, value2, "unionAlias");
            return (Criteria) this;
        }

        public Criteria andUnionTagIsNull() {
            addCriterion("union_tag is null");
            return (Criteria) this;
        }

        public Criteria andUnionTagIsNotNull() {
            addCriterion("union_tag is not null");
            return (Criteria) this;
        }

        public Criteria andUnionTagEqualTo(String value) {
            addCriterion("union_tag =", value, "unionTag");
            return (Criteria) this;
        }

        public Criteria andUnionTagNotEqualTo(String value) {
            addCriterion("union_tag <>", value, "unionTag");
            return (Criteria) this;
        }

        public Criteria andUnionTagGreaterThan(String value) {
            addCriterion("union_tag >", value, "unionTag");
            return (Criteria) this;
        }

        public Criteria andUnionTagGreaterThanOrEqualTo(String value) {
            addCriterion("union_tag >=", value, "unionTag");
            return (Criteria) this;
        }

        public Criteria andUnionTagLessThan(String value) {
            addCriterion("union_tag <", value, "unionTag");
            return (Criteria) this;
        }

        public Criteria andUnionTagLessThanOrEqualTo(String value) {
            addCriterion("union_tag <=", value, "unionTag");
            return (Criteria) this;
        }

        public Criteria andUnionTagLike(String value) {
            addCriterion("union_tag like", value, "unionTag");
            return (Criteria) this;
        }

        public Criteria andUnionTagNotLike(String value) {
            addCriterion("union_tag not like", value, "unionTag");
            return (Criteria) this;
        }

        public Criteria andUnionTagIn(List<String> values) {
            addCriterion("union_tag in", values, "unionTag");
            return (Criteria) this;
        }

        public Criteria andUnionTagNotIn(List<String> values) {
            addCriterion("union_tag not in", values, "unionTag");
            return (Criteria) this;
        }

        public Criteria andUnionTagBetween(String value1, String value2) {
            addCriterion("union_tag between", value1, value2, "unionTag");
            return (Criteria) this;
        }

        public Criteria andUnionTagNotBetween(String value1, String value2) {
            addCriterion("union_tag not between", value1, value2, "unionTag");
            return (Criteria) this;
        }

        public Criteria andUnionTrafficGroupIsNull() {
            addCriterion("union_traffic_group is null");
            return (Criteria) this;
        }

        public Criteria andUnionTrafficGroupIsNotNull() {
            addCriterion("union_traffic_group is not null");
            return (Criteria) this;
        }

        public Criteria andUnionTrafficGroupEqualTo(Integer value) {
            addCriterion("union_traffic_group =", value, "unionTrafficGroup");
            return (Criteria) this;
        }

        public Criteria andUnionTrafficGroupNotEqualTo(Integer value) {
            addCriterion("union_traffic_group <>", value, "unionTrafficGroup");
            return (Criteria) this;
        }

        public Criteria andUnionTrafficGroupGreaterThan(Integer value) {
            addCriterion("union_traffic_group >", value, "unionTrafficGroup");
            return (Criteria) this;
        }

        public Criteria andUnionTrafficGroupGreaterThanOrEqualTo(Integer value) {
            addCriterion("union_traffic_group >=", value, "unionTrafficGroup");
            return (Criteria) this;
        }

        public Criteria andUnionTrafficGroupLessThan(Integer value) {
            addCriterion("union_traffic_group <", value, "unionTrafficGroup");
            return (Criteria) this;
        }

        public Criteria andUnionTrafficGroupLessThanOrEqualTo(Integer value) {
            addCriterion("union_traffic_group <=", value, "unionTrafficGroup");
            return (Criteria) this;
        }

        public Criteria andUnionTrafficGroupIn(List<Integer> values) {
            addCriterion("union_traffic_group in", values, "unionTrafficGroup");
            return (Criteria) this;
        }

        public Criteria andUnionTrafficGroupNotIn(List<Integer> values) {
            addCriterion("union_traffic_group not in", values, "unionTrafficGroup");
            return (Criteria) this;
        }

        public Criteria andUnionTrafficGroupBetween(Integer value1, Integer value2) {
            addCriterion("union_traffic_group between", value1, value2, "unionTrafficGroup");
            return (Criteria) this;
        }

        public Criteria andUnionTrafficGroupNotBetween(Integer value1, Integer value2) {
            addCriterion("union_traffic_group not between", value1, value2, "unionTrafficGroup");
            return (Criteria) this;
        }

        public Criteria andValidCodeIsNull() {
            addCriterion("valid_code is null");
            return (Criteria) this;
        }

        public Criteria andValidCodeIsNotNull() {
            addCriterion("valid_code is not null");
            return (Criteria) this;
        }

        public Criteria andValidCodeEqualTo(Integer value) {
            addCriterion("valid_code =", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeNotEqualTo(Integer value) {
            addCriterion("valid_code <>", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeGreaterThan(Integer value) {
            addCriterion("valid_code >", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("valid_code >=", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeLessThan(Integer value) {
            addCriterion("valid_code <", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeLessThanOrEqualTo(Integer value) {
            addCriterion("valid_code <=", value, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeIn(List<Integer> values) {
            addCriterion("valid_code in", values, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeNotIn(List<Integer> values) {
            addCriterion("valid_code not in", values, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeBetween(Integer value1, Integer value2) {
            addCriterion("valid_code between", value1, value2, "validCode");
            return (Criteria) this;
        }

        public Criteria andValidCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("valid_code not between", value1, value2, "validCode");
            return (Criteria) this;
        }

        public Criteria andSubUnionIdIsNull() {
            addCriterion("sub_union_id is null");
            return (Criteria) this;
        }

        public Criteria andSubUnionIdIsNotNull() {
            addCriterion("sub_union_id is not null");
            return (Criteria) this;
        }

        public Criteria andSubUnionIdEqualTo(String value) {
            addCriterion("sub_union_id =", value, "subUnionId");
            return (Criteria) this;
        }

        public Criteria andSubUnionIdNotEqualTo(String value) {
            addCriterion("sub_union_id <>", value, "subUnionId");
            return (Criteria) this;
        }

        public Criteria andSubUnionIdGreaterThan(String value) {
            addCriterion("sub_union_id >", value, "subUnionId");
            return (Criteria) this;
        }

        public Criteria andSubUnionIdGreaterThanOrEqualTo(String value) {
            addCriterion("sub_union_id >=", value, "subUnionId");
            return (Criteria) this;
        }

        public Criteria andSubUnionIdLessThan(String value) {
            addCriterion("sub_union_id <", value, "subUnionId");
            return (Criteria) this;
        }

        public Criteria andSubUnionIdLessThanOrEqualTo(String value) {
            addCriterion("sub_union_id <=", value, "subUnionId");
            return (Criteria) this;
        }

        public Criteria andSubUnionIdLike(String value) {
            addCriterion("sub_union_id like", value, "subUnionId");
            return (Criteria) this;
        }

        public Criteria andSubUnionIdNotLike(String value) {
            addCriterion("sub_union_id not like", value, "subUnionId");
            return (Criteria) this;
        }

        public Criteria andSubUnionIdIn(List<String> values) {
            addCriterion("sub_union_id in", values, "subUnionId");
            return (Criteria) this;
        }

        public Criteria andSubUnionIdNotIn(List<String> values) {
            addCriterion("sub_union_id not in", values, "subUnionId");
            return (Criteria) this;
        }

        public Criteria andSubUnionIdBetween(String value1, String value2) {
            addCriterion("sub_union_id between", value1, value2, "subUnionId");
            return (Criteria) this;
        }

        public Criteria andSubUnionIdNotBetween(String value1, String value2) {
            addCriterion("sub_union_id not between", value1, value2, "subUnionId");
            return (Criteria) this;
        }

        public Criteria andTraceTypeIsNull() {
            addCriterion("trace_type is null");
            return (Criteria) this;
        }

        public Criteria andTraceTypeIsNotNull() {
            addCriterion("trace_type is not null");
            return (Criteria) this;
        }

        public Criteria andTraceTypeEqualTo(Integer value) {
            addCriterion("trace_type =", value, "traceType");
            return (Criteria) this;
        }

        public Criteria andTraceTypeNotEqualTo(Integer value) {
            addCriterion("trace_type <>", value, "traceType");
            return (Criteria) this;
        }

        public Criteria andTraceTypeGreaterThan(Integer value) {
            addCriterion("trace_type >", value, "traceType");
            return (Criteria) this;
        }

        public Criteria andTraceTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("trace_type >=", value, "traceType");
            return (Criteria) this;
        }

        public Criteria andTraceTypeLessThan(Integer value) {
            addCriterion("trace_type <", value, "traceType");
            return (Criteria) this;
        }

        public Criteria andTraceTypeLessThanOrEqualTo(Integer value) {
            addCriterion("trace_type <=", value, "traceType");
            return (Criteria) this;
        }

        public Criteria andTraceTypeIn(List<Integer> values) {
            addCriterion("trace_type in", values, "traceType");
            return (Criteria) this;
        }

        public Criteria andTraceTypeNotIn(List<Integer> values) {
            addCriterion("trace_type not in", values, "traceType");
            return (Criteria) this;
        }

        public Criteria andTraceTypeBetween(Integer value1, Integer value2) {
            addCriterion("trace_type between", value1, value2, "traceType");
            return (Criteria) this;
        }

        public Criteria andTraceTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("trace_type not between", value1, value2, "traceType");
            return (Criteria) this;
        }

        public Criteria andPayMonthIsNull() {
            addCriterion("pay_month is null");
            return (Criteria) this;
        }

        public Criteria andPayMonthIsNotNull() {
            addCriterion("pay_month is not null");
            return (Criteria) this;
        }

        public Criteria andPayMonthEqualTo(Integer value) {
            addCriterion("pay_month =", value, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthNotEqualTo(Integer value) {
            addCriterion("pay_month <>", value, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthGreaterThan(Integer value) {
            addCriterion("pay_month >", value, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_month >=", value, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthLessThan(Integer value) {
            addCriterion("pay_month <", value, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthLessThanOrEqualTo(Integer value) {
            addCriterion("pay_month <=", value, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthIn(List<Integer> values) {
            addCriterion("pay_month in", values, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthNotIn(List<Integer> values) {
            addCriterion("pay_month not in", values, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthBetween(Integer value1, Integer value2) {
            addCriterion("pay_month between", value1, value2, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_month not between", value1, value2, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPopIdIsNull() {
            addCriterion("pop_id is null");
            return (Criteria) this;
        }

        public Criteria andPopIdIsNotNull() {
            addCriterion("pop_id is not null");
            return (Criteria) this;
        }

        public Criteria andPopIdEqualTo(Long value) {
            addCriterion("pop_id =", value, "popId");
            return (Criteria) this;
        }

        public Criteria andPopIdNotEqualTo(Long value) {
            addCriterion("pop_id <>", value, "popId");
            return (Criteria) this;
        }

        public Criteria andPopIdGreaterThan(Long value) {
            addCriterion("pop_id >", value, "popId");
            return (Criteria) this;
        }

        public Criteria andPopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pop_id >=", value, "popId");
            return (Criteria) this;
        }

        public Criteria andPopIdLessThan(Long value) {
            addCriterion("pop_id <", value, "popId");
            return (Criteria) this;
        }

        public Criteria andPopIdLessThanOrEqualTo(Long value) {
            addCriterion("pop_id <=", value, "popId");
            return (Criteria) this;
        }

        public Criteria andPopIdIn(List<Long> values) {
            addCriterion("pop_id in", values, "popId");
            return (Criteria) this;
        }

        public Criteria andPopIdNotIn(List<Long> values) {
            addCriterion("pop_id not in", values, "popId");
            return (Criteria) this;
        }

        public Criteria andPopIdBetween(Long value1, Long value2) {
            addCriterion("pop_id between", value1, value2, "popId");
            return (Criteria) this;
        }

        public Criteria andPopIdNotBetween(Long value1, Long value2) {
            addCriterion("pop_id not between", value1, value2, "popId");
            return (Criteria) this;
        }

        public Criteria andExt1IsNull() {
            addCriterion("ext1 is null");
            return (Criteria) this;
        }

        public Criteria andExt1IsNotNull() {
            addCriterion("ext1 is not null");
            return (Criteria) this;
        }

        public Criteria andExt1EqualTo(String value) {
            addCriterion("ext1 =", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotEqualTo(String value) {
            addCriterion("ext1 <>", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThan(String value) {
            addCriterion("ext1 >", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1GreaterThanOrEqualTo(String value) {
            addCriterion("ext1 >=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThan(String value) {
            addCriterion("ext1 <", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1LessThanOrEqualTo(String value) {
            addCriterion("ext1 <=", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Like(String value) {
            addCriterion("ext1 like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotLike(String value) {
            addCriterion("ext1 not like", value, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1In(List<String> values) {
            addCriterion("ext1 in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotIn(List<String> values) {
            addCriterion("ext1 not in", values, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1Between(String value1, String value2) {
            addCriterion("ext1 between", value1, value2, "ext1");
            return (Criteria) this;
        }

        public Criteria andExt1NotBetween(String value1, String value2) {
            addCriterion("ext1 not between", value1, value2, "ext1");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}