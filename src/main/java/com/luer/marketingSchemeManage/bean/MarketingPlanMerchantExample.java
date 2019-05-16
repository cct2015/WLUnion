package com.luer.marketingSchemeManage.bean;

import java.util.ArrayList;
import java.util.List;

public class MarketingPlanMerchantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MarketingPlanMerchantExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andMarketingPlanIdIsNull() {
            addCriterion("marketing_plan_id is null");
            return (Criteria) this;
        }

        public Criteria andMarketingPlanIdIsNotNull() {
            addCriterion("marketing_plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andMarketingPlanIdEqualTo(String value) {
            addCriterion("marketing_plan_id =", value, "marketingPlanId");
            return (Criteria) this;
        }

        public Criteria andMarketingPlanIdNotEqualTo(String value) {
            addCriterion("marketing_plan_id <>", value, "marketingPlanId");
            return (Criteria) this;
        }

        public Criteria andMarketingPlanIdGreaterThan(String value) {
            addCriterion("marketing_plan_id >", value, "marketingPlanId");
            return (Criteria) this;
        }

        public Criteria andMarketingPlanIdGreaterThanOrEqualTo(String value) {
            addCriterion("marketing_plan_id >=", value, "marketingPlanId");
            return (Criteria) this;
        }

        public Criteria andMarketingPlanIdLessThan(String value) {
            addCriterion("marketing_plan_id <", value, "marketingPlanId");
            return (Criteria) this;
        }

        public Criteria andMarketingPlanIdLessThanOrEqualTo(String value) {
            addCriterion("marketing_plan_id <=", value, "marketingPlanId");
            return (Criteria) this;
        }

        public Criteria andMarketingPlanIdLike(String value) {
            addCriterion("marketing_plan_id like", value, "marketingPlanId");
            return (Criteria) this;
        }

        public Criteria andMarketingPlanIdNotLike(String value) {
            addCriterion("marketing_plan_id not like", value, "marketingPlanId");
            return (Criteria) this;
        }

        public Criteria andMarketingPlanIdIn(List<String> values) {
            addCriterion("marketing_plan_id in", values, "marketingPlanId");
            return (Criteria) this;
        }

        public Criteria andMarketingPlanIdNotIn(List<String> values) {
            addCriterion("marketing_plan_id not in", values, "marketingPlanId");
            return (Criteria) this;
        }

        public Criteria andMarketingPlanIdBetween(String value1, String value2) {
            addCriterion("marketing_plan_id between", value1, value2, "marketingPlanId");
            return (Criteria) this;
        }

        public Criteria andMarketingPlanIdNotBetween(String value1, String value2) {
            addCriterion("marketing_plan_id not between", value1, value2, "marketingPlanId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNull() {
            addCriterion("merchant_id is null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIsNotNull() {
            addCriterion("merchant_id is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantIdEqualTo(String value) {
            addCriterion("merchant_id =", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotEqualTo(String value) {
            addCriterion("merchant_id <>", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThan(String value) {
            addCriterion("merchant_id >", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_id >=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThan(String value) {
            addCriterion("merchant_id <", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLessThanOrEqualTo(String value) {
            addCriterion("merchant_id <=", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdLike(String value) {
            addCriterion("merchant_id like", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotLike(String value) {
            addCriterion("merchant_id not like", value, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdIn(List<String> values) {
            addCriterion("merchant_id in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotIn(List<String> values) {
            addCriterion("merchant_id not in", values, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdBetween(String value1, String value2) {
            addCriterion("merchant_id between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMerchantIdNotBetween(String value1, String value2) {
            addCriterion("merchant_id not between", value1, value2, "merchantId");
            return (Criteria) this;
        }

        public Criteria andMarketingApplyMerchantIdIsNull() {
            addCriterion("marketing_apply_merchant_id is null");
            return (Criteria) this;
        }

        public Criteria andMarketingApplyMerchantIdIsNotNull() {
            addCriterion("marketing_apply_merchant_id is not null");
            return (Criteria) this;
        }

        public Criteria andMarketingApplyMerchantIdEqualTo(String value) {
            addCriterion("marketing_apply_merchant_id =", value, "marketingApplyMerchantId");
            return (Criteria) this;
        }

        public Criteria andMarketingApplyMerchantIdNotEqualTo(String value) {
            addCriterion("marketing_apply_merchant_id <>", value, "marketingApplyMerchantId");
            return (Criteria) this;
        }

        public Criteria andMarketingApplyMerchantIdGreaterThan(String value) {
            addCriterion("marketing_apply_merchant_id >", value, "marketingApplyMerchantId");
            return (Criteria) this;
        }

        public Criteria andMarketingApplyMerchantIdGreaterThanOrEqualTo(String value) {
            addCriterion("marketing_apply_merchant_id >=", value, "marketingApplyMerchantId");
            return (Criteria) this;
        }

        public Criteria andMarketingApplyMerchantIdLessThan(String value) {
            addCriterion("marketing_apply_merchant_id <", value, "marketingApplyMerchantId");
            return (Criteria) this;
        }

        public Criteria andMarketingApplyMerchantIdLessThanOrEqualTo(String value) {
            addCriterion("marketing_apply_merchant_id <=", value, "marketingApplyMerchantId");
            return (Criteria) this;
        }

        public Criteria andMarketingApplyMerchantIdLike(String value) {
            addCriterion("marketing_apply_merchant_id like", value, "marketingApplyMerchantId");
            return (Criteria) this;
        }

        public Criteria andMarketingApplyMerchantIdNotLike(String value) {
            addCriterion("marketing_apply_merchant_id not like", value, "marketingApplyMerchantId");
            return (Criteria) this;
        }

        public Criteria andMarketingApplyMerchantIdIn(List<String> values) {
            addCriterion("marketing_apply_merchant_id in", values, "marketingApplyMerchantId");
            return (Criteria) this;
        }

        public Criteria andMarketingApplyMerchantIdNotIn(List<String> values) {
            addCriterion("marketing_apply_merchant_id not in", values, "marketingApplyMerchantId");
            return (Criteria) this;
        }

        public Criteria andMarketingApplyMerchantIdBetween(String value1, String value2) {
            addCriterion("marketing_apply_merchant_id between", value1, value2, "marketingApplyMerchantId");
            return (Criteria) this;
        }

        public Criteria andMarketingApplyMerchantIdNotBetween(String value1, String value2) {
            addCriterion("marketing_apply_merchant_id not between", value1, value2, "marketingApplyMerchantId");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusIsNull() {
            addCriterion("execute_status is null");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusIsNotNull() {
            addCriterion("execute_status is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusEqualTo(String value) {
            addCriterion("execute_status =", value, "executeStatus");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusNotEqualTo(String value) {
            addCriterion("execute_status <>", value, "executeStatus");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusGreaterThan(String value) {
            addCriterion("execute_status >", value, "executeStatus");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusGreaterThanOrEqualTo(String value) {
            addCriterion("execute_status >=", value, "executeStatus");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusLessThan(String value) {
            addCriterion("execute_status <", value, "executeStatus");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusLessThanOrEqualTo(String value) {
            addCriterion("execute_status <=", value, "executeStatus");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusLike(String value) {
            addCriterion("execute_status like", value, "executeStatus");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusNotLike(String value) {
            addCriterion("execute_status not like", value, "executeStatus");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusIn(List<String> values) {
            addCriterion("execute_status in", values, "executeStatus");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusNotIn(List<String> values) {
            addCriterion("execute_status not in", values, "executeStatus");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusBetween(String value1, String value2) {
            addCriterion("execute_status between", value1, value2, "executeStatus");
            return (Criteria) this;
        }

        public Criteria andExecuteStatusNotBetween(String value1, String value2) {
            addCriterion("execute_status not between", value1, value2, "executeStatus");
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