package com.luer.marketingSchemeManage.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcuteHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExcuteHistoryExample() {
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

        public Criteria andExcuteResultIsNull() {
            addCriterion("excute_result is null");
            return (Criteria) this;
        }

        public Criteria andExcuteResultIsNotNull() {
            addCriterion("excute_result is not null");
            return (Criteria) this;
        }

        public Criteria andExcuteResultEqualTo(String value) {
            addCriterion("excute_result =", value, "excuteResult");
            return (Criteria) this;
        }

        public Criteria andExcuteResultNotEqualTo(String value) {
            addCriterion("excute_result <>", value, "excuteResult");
            return (Criteria) this;
        }

        public Criteria andExcuteResultGreaterThan(String value) {
            addCriterion("excute_result >", value, "excuteResult");
            return (Criteria) this;
        }

        public Criteria andExcuteResultGreaterThanOrEqualTo(String value) {
            addCriterion("excute_result >=", value, "excuteResult");
            return (Criteria) this;
        }

        public Criteria andExcuteResultLessThan(String value) {
            addCriterion("excute_result <", value, "excuteResult");
            return (Criteria) this;
        }

        public Criteria andExcuteResultLessThanOrEqualTo(String value) {
            addCriterion("excute_result <=", value, "excuteResult");
            return (Criteria) this;
        }

        public Criteria andExcuteResultLike(String value) {
            addCriterion("excute_result like", value, "excuteResult");
            return (Criteria) this;
        }

        public Criteria andExcuteResultNotLike(String value) {
            addCriterion("excute_result not like", value, "excuteResult");
            return (Criteria) this;
        }

        public Criteria andExcuteResultIn(List<String> values) {
            addCriterion("excute_result in", values, "excuteResult");
            return (Criteria) this;
        }

        public Criteria andExcuteResultNotIn(List<String> values) {
            addCriterion("excute_result not in", values, "excuteResult");
            return (Criteria) this;
        }

        public Criteria andExcuteResultBetween(String value1, String value2) {
            addCriterion("excute_result between", value1, value2, "excuteResult");
            return (Criteria) this;
        }

        public Criteria andExcuteResultNotBetween(String value1, String value2) {
            addCriterion("excute_result not between", value1, value2, "excuteResult");
            return (Criteria) this;
        }

        public Criteria andExcuteTimesIsNull() {
            addCriterion("excute_times is null");
            return (Criteria) this;
        }

        public Criteria andExcuteTimesIsNotNull() {
            addCriterion("excute_times is not null");
            return (Criteria) this;
        }

        public Criteria andExcuteTimesEqualTo(Integer value) {
            addCriterion("excute_times =", value, "excuteTimes");
            return (Criteria) this;
        }

        public Criteria andExcuteTimesNotEqualTo(Integer value) {
            addCriterion("excute_times <>", value, "excuteTimes");
            return (Criteria) this;
        }

        public Criteria andExcuteTimesGreaterThan(Integer value) {
            addCriterion("excute_times >", value, "excuteTimes");
            return (Criteria) this;
        }

        public Criteria andExcuteTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("excute_times >=", value, "excuteTimes");
            return (Criteria) this;
        }

        public Criteria andExcuteTimesLessThan(Integer value) {
            addCriterion("excute_times <", value, "excuteTimes");
            return (Criteria) this;
        }

        public Criteria andExcuteTimesLessThanOrEqualTo(Integer value) {
            addCriterion("excute_times <=", value, "excuteTimes");
            return (Criteria) this;
        }

        public Criteria andExcuteTimesIn(List<Integer> values) {
            addCriterion("excute_times in", values, "excuteTimes");
            return (Criteria) this;
        }

        public Criteria andExcuteTimesNotIn(List<Integer> values) {
            addCriterion("excute_times not in", values, "excuteTimes");
            return (Criteria) this;
        }

        public Criteria andExcuteTimesBetween(Integer value1, Integer value2) {
            addCriterion("excute_times between", value1, value2, "excuteTimes");
            return (Criteria) this;
        }

        public Criteria andExcuteTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("excute_times not between", value1, value2, "excuteTimes");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeIsNull() {
            addCriterion("excute_time is null");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeIsNotNull() {
            addCriterion("excute_time is not null");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeEqualTo(Date value) {
            addCriterion("excute_time =", value, "excuteTime");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeNotEqualTo(Date value) {
            addCriterion("excute_time <>", value, "excuteTime");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeGreaterThan(Date value) {
            addCriterion("excute_time >", value, "excuteTime");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("excute_time >=", value, "excuteTime");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeLessThan(Date value) {
            addCriterion("excute_time <", value, "excuteTime");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeLessThanOrEqualTo(Date value) {
            addCriterion("excute_time <=", value, "excuteTime");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeIn(List<Date> values) {
            addCriterion("excute_time in", values, "excuteTime");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeNotIn(List<Date> values) {
            addCriterion("excute_time not in", values, "excuteTime");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeBetween(Date value1, Date value2) {
            addCriterion("excute_time between", value1, value2, "excuteTime");
            return (Criteria) this;
        }

        public Criteria andExcuteTimeNotBetween(Date value1, Date value2) {
            addCriterion("excute_time not between", value1, value2, "excuteTime");
            return (Criteria) this;
        }

        public Criteria andExcuteUserIsNull() {
            addCriterion("excute_user is null");
            return (Criteria) this;
        }

        public Criteria andExcuteUserIsNotNull() {
            addCriterion("excute_user is not null");
            return (Criteria) this;
        }

        public Criteria andExcuteUserEqualTo(String value) {
            addCriterion("excute_user =", value, "excuteUser");
            return (Criteria) this;
        }

        public Criteria andExcuteUserNotEqualTo(String value) {
            addCriterion("excute_user <>", value, "excuteUser");
            return (Criteria) this;
        }

        public Criteria andExcuteUserGreaterThan(String value) {
            addCriterion("excute_user >", value, "excuteUser");
            return (Criteria) this;
        }

        public Criteria andExcuteUserGreaterThanOrEqualTo(String value) {
            addCriterion("excute_user >=", value, "excuteUser");
            return (Criteria) this;
        }

        public Criteria andExcuteUserLessThan(String value) {
            addCriterion("excute_user <", value, "excuteUser");
            return (Criteria) this;
        }

        public Criteria andExcuteUserLessThanOrEqualTo(String value) {
            addCriterion("excute_user <=", value, "excuteUser");
            return (Criteria) this;
        }

        public Criteria andExcuteUserLike(String value) {
            addCriterion("excute_user like", value, "excuteUser");
            return (Criteria) this;
        }

        public Criteria andExcuteUserNotLike(String value) {
            addCriterion("excute_user not like", value, "excuteUser");
            return (Criteria) this;
        }

        public Criteria andExcuteUserIn(List<String> values) {
            addCriterion("excute_user in", values, "excuteUser");
            return (Criteria) this;
        }

        public Criteria andExcuteUserNotIn(List<String> values) {
            addCriterion("excute_user not in", values, "excuteUser");
            return (Criteria) this;
        }

        public Criteria andExcuteUserBetween(String value1, String value2) {
            addCriterion("excute_user between", value1, value2, "excuteUser");
            return (Criteria) this;
        }

        public Criteria andExcuteUserNotBetween(String value1, String value2) {
            addCriterion("excute_user not between", value1, value2, "excuteUser");
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