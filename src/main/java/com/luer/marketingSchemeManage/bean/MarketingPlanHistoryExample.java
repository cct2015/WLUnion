package com.luer.marketingSchemeManage.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MarketingPlanHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MarketingPlanHistoryExample() {
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

        public Criteria andPlanIdIsNull() {
            addCriterion("plan_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNotNull() {
            addCriterion("plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanIdEqualTo(String value) {
            addCriterion("plan_id =", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotEqualTo(String value) {
            addCriterion("plan_id <>", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThan(String value) {
            addCriterion("plan_id >", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThanOrEqualTo(String value) {
            addCriterion("plan_id >=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThan(String value) {
            addCriterion("plan_id <", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThanOrEqualTo(String value) {
            addCriterion("plan_id <=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLike(String value) {
            addCriterion("plan_id like", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotLike(String value) {
            addCriterion("plan_id not like", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdIn(List<String> values) {
            addCriterion("plan_id in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotIn(List<String> values) {
            addCriterion("plan_id not in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdBetween(String value1, String value2) {
            addCriterion("plan_id between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotBetween(String value1, String value2) {
            addCriterion("plan_id not between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("send_time is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("send_time is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("send_time =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("send_time <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("send_time >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("send_time >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("send_time <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("send_time <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("send_time in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("send_time not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("send_time between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("send_time not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendUserIsNull() {
            addCriterion("send_user is null");
            return (Criteria) this;
        }

        public Criteria andSendUserIsNotNull() {
            addCriterion("send_user is not null");
            return (Criteria) this;
        }

        public Criteria andSendUserEqualTo(String value) {
            addCriterion("send_user =", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserNotEqualTo(String value) {
            addCriterion("send_user <>", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserGreaterThan(String value) {
            addCriterion("send_user >", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserGreaterThanOrEqualTo(String value) {
            addCriterion("send_user >=", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserLessThan(String value) {
            addCriterion("send_user <", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserLessThanOrEqualTo(String value) {
            addCriterion("send_user <=", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserLike(String value) {
            addCriterion("send_user like", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserNotLike(String value) {
            addCriterion("send_user not like", value, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserIn(List<String> values) {
            addCriterion("send_user in", values, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserNotIn(List<String> values) {
            addCriterion("send_user not in", values, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserBetween(String value1, String value2) {
            addCriterion("send_user between", value1, value2, "sendUser");
            return (Criteria) this;
        }

        public Criteria andSendUserNotBetween(String value1, String value2) {
            addCriterion("send_user not between", value1, value2, "sendUser");
            return (Criteria) this;
        }

        public Criteria andWxCountIsNull() {
            addCriterion("wx_count is null");
            return (Criteria) this;
        }

        public Criteria andWxCountIsNotNull() {
            addCriterion("wx_count is not null");
            return (Criteria) this;
        }

        public Criteria andWxCountEqualTo(Integer value) {
            addCriterion("wx_count =", value, "wxCount");
            return (Criteria) this;
        }

        public Criteria andWxCountNotEqualTo(Integer value) {
            addCriterion("wx_count <>", value, "wxCount");
            return (Criteria) this;
        }

        public Criteria andWxCountGreaterThan(Integer value) {
            addCriterion("wx_count >", value, "wxCount");
            return (Criteria) this;
        }

        public Criteria andWxCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("wx_count >=", value, "wxCount");
            return (Criteria) this;
        }

        public Criteria andWxCountLessThan(Integer value) {
            addCriterion("wx_count <", value, "wxCount");
            return (Criteria) this;
        }

        public Criteria andWxCountLessThanOrEqualTo(Integer value) {
            addCriterion("wx_count <=", value, "wxCount");
            return (Criteria) this;
        }

        public Criteria andWxCountIn(List<Integer> values) {
            addCriterion("wx_count in", values, "wxCount");
            return (Criteria) this;
        }

        public Criteria andWxCountNotIn(List<Integer> values) {
            addCriterion("wx_count not in", values, "wxCount");
            return (Criteria) this;
        }

        public Criteria andWxCountBetween(Integer value1, Integer value2) {
            addCriterion("wx_count between", value1, value2, "wxCount");
            return (Criteria) this;
        }

        public Criteria andWxCountNotBetween(Integer value1, Integer value2) {
            addCriterion("wx_count not between", value1, value2, "wxCount");
            return (Criteria) this;
        }

        public Criteria andPhoneCountIsNull() {
            addCriterion("phone_count is null");
            return (Criteria) this;
        }

        public Criteria andPhoneCountIsNotNull() {
            addCriterion("phone_count is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneCountEqualTo(Integer value) {
            addCriterion("phone_count =", value, "phoneCount");
            return (Criteria) this;
        }

        public Criteria andPhoneCountNotEqualTo(Integer value) {
            addCriterion("phone_count <>", value, "phoneCount");
            return (Criteria) this;
        }

        public Criteria andPhoneCountGreaterThan(Integer value) {
            addCriterion("phone_count >", value, "phoneCount");
            return (Criteria) this;
        }

        public Criteria andPhoneCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("phone_count >=", value, "phoneCount");
            return (Criteria) this;
        }

        public Criteria andPhoneCountLessThan(Integer value) {
            addCriterion("phone_count <", value, "phoneCount");
            return (Criteria) this;
        }

        public Criteria andPhoneCountLessThanOrEqualTo(Integer value) {
            addCriterion("phone_count <=", value, "phoneCount");
            return (Criteria) this;
        }

        public Criteria andPhoneCountIn(List<Integer> values) {
            addCriterion("phone_count in", values, "phoneCount");
            return (Criteria) this;
        }

        public Criteria andPhoneCountNotIn(List<Integer> values) {
            addCriterion("phone_count not in", values, "phoneCount");
            return (Criteria) this;
        }

        public Criteria andPhoneCountBetween(Integer value1, Integer value2) {
            addCriterion("phone_count between", value1, value2, "phoneCount");
            return (Criteria) this;
        }

        public Criteria andPhoneCountNotBetween(Integer value1, Integer value2) {
            addCriterion("phone_count not between", value1, value2, "phoneCount");
            return (Criteria) this;
        }

        public Criteria andIsDifferentIsNull() {
            addCriterion("is_different is null");
            return (Criteria) this;
        }

        public Criteria andIsDifferentIsNotNull() {
            addCriterion("is_different is not null");
            return (Criteria) this;
        }

        public Criteria andIsDifferentEqualTo(Integer value) {
            addCriterion("is_different =", value, "isDifferent");
            return (Criteria) this;
        }

        public Criteria andIsDifferentNotEqualTo(Integer value) {
            addCriterion("is_different <>", value, "isDifferent");
            return (Criteria) this;
        }

        public Criteria andIsDifferentGreaterThan(Integer value) {
            addCriterion("is_different >", value, "isDifferent");
            return (Criteria) this;
        }

        public Criteria andIsDifferentGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_different >=", value, "isDifferent");
            return (Criteria) this;
        }

        public Criteria andIsDifferentLessThan(Integer value) {
            addCriterion("is_different <", value, "isDifferent");
            return (Criteria) this;
        }

        public Criteria andIsDifferentLessThanOrEqualTo(Integer value) {
            addCriterion("is_different <=", value, "isDifferent");
            return (Criteria) this;
        }

        public Criteria andIsDifferentIn(List<Integer> values) {
            addCriterion("is_different in", values, "isDifferent");
            return (Criteria) this;
        }

        public Criteria andIsDifferentNotIn(List<Integer> values) {
            addCriterion("is_different not in", values, "isDifferent");
            return (Criteria) this;
        }

        public Criteria andIsDifferentBetween(Integer value1, Integer value2) {
            addCriterion("is_different between", value1, value2, "isDifferent");
            return (Criteria) this;
        }

        public Criteria andIsDifferentNotBetween(Integer value1, Integer value2) {
            addCriterion("is_different not between", value1, value2, "isDifferent");
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