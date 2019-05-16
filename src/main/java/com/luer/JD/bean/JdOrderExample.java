package com.luer.JD.bean;

import java.util.ArrayList;
import java.util.List;

public class JdOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JdOrderExample() {
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

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(Long value) {
            addCriterion("finish_time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(Long value) {
            addCriterion("finish_time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(Long value) {
            addCriterion("finish_time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("finish_time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(Long value) {
            addCriterion("finish_time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(Long value) {
            addCriterion("finish_time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<Long> values) {
            addCriterion("finish_time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<Long> values) {
            addCriterion("finish_time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(Long value1, Long value2) {
            addCriterion("finish_time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(Long value1, Long value2) {
            addCriterion("finish_time not between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andOrderEmtIsNull() {
            addCriterion("order_emt is null");
            return (Criteria) this;
        }

        public Criteria andOrderEmtIsNotNull() {
            addCriterion("order_emt is not null");
            return (Criteria) this;
        }

        public Criteria andOrderEmtEqualTo(Integer value) {
            addCriterion("order_emt =", value, "orderEmt");
            return (Criteria) this;
        }

        public Criteria andOrderEmtNotEqualTo(Integer value) {
            addCriterion("order_emt <>", value, "orderEmt");
            return (Criteria) this;
        }

        public Criteria andOrderEmtGreaterThan(Integer value) {
            addCriterion("order_emt >", value, "orderEmt");
            return (Criteria) this;
        }

        public Criteria andOrderEmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_emt >=", value, "orderEmt");
            return (Criteria) this;
        }

        public Criteria andOrderEmtLessThan(Integer value) {
            addCriterion("order_emt <", value, "orderEmt");
            return (Criteria) this;
        }

        public Criteria andOrderEmtLessThanOrEqualTo(Integer value) {
            addCriterion("order_emt <=", value, "orderEmt");
            return (Criteria) this;
        }

        public Criteria andOrderEmtIn(List<Integer> values) {
            addCriterion("order_emt in", values, "orderEmt");
            return (Criteria) this;
        }

        public Criteria andOrderEmtNotIn(List<Integer> values) {
            addCriterion("order_emt not in", values, "orderEmt");
            return (Criteria) this;
        }

        public Criteria andOrderEmtBetween(Integer value1, Integer value2) {
            addCriterion("order_emt between", value1, value2, "orderEmt");
            return (Criteria) this;
        }

        public Criteria andOrderEmtNotBetween(Integer value1, Integer value2) {
            addCriterion("order_emt not between", value1, value2, "orderEmt");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTimeEqualTo(Long value) {
            addCriterion("order_time =", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotEqualTo(Long value) {
            addCriterion("order_time <>", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThan(Long value) {
            addCriterion("order_time >", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("order_time >=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThan(Long value) {
            addCriterion("order_time <", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeLessThanOrEqualTo(Long value) {
            addCriterion("order_time <=", value, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeIn(List<Long> values) {
            addCriterion("order_time in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotIn(List<Long> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeBetween(Long value1, Long value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andOrderTimeNotBetween(Long value1, Long value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
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

        public Criteria andPayMonthEqualTo(String value) {
            addCriterion("pay_month =", value, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthNotEqualTo(String value) {
            addCriterion("pay_month <>", value, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthGreaterThan(String value) {
            addCriterion("pay_month >", value, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthGreaterThanOrEqualTo(String value) {
            addCriterion("pay_month >=", value, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthLessThan(String value) {
            addCriterion("pay_month <", value, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthLessThanOrEqualTo(String value) {
            addCriterion("pay_month <=", value, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthLike(String value) {
            addCriterion("pay_month like", value, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthNotLike(String value) {
            addCriterion("pay_month not like", value, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthIn(List<String> values) {
            addCriterion("pay_month in", values, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthNotIn(List<String> values) {
            addCriterion("pay_month not in", values, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthBetween(String value1, String value2) {
            addCriterion("pay_month between", value1, value2, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPayMonthNotBetween(String value1, String value2) {
            addCriterion("pay_month not between", value1, value2, "payMonth");
            return (Criteria) this;
        }

        public Criteria andPlusIsNull() {
            addCriterion("plus is null");
            return (Criteria) this;
        }

        public Criteria andPlusIsNotNull() {
            addCriterion("plus is not null");
            return (Criteria) this;
        }

        public Criteria andPlusEqualTo(Integer value) {
            addCriterion("plus =", value, "plus");
            return (Criteria) this;
        }

        public Criteria andPlusNotEqualTo(Integer value) {
            addCriterion("plus <>", value, "plus");
            return (Criteria) this;
        }

        public Criteria andPlusGreaterThan(Integer value) {
            addCriterion("plus >", value, "plus");
            return (Criteria) this;
        }

        public Criteria andPlusGreaterThanOrEqualTo(Integer value) {
            addCriterion("plus >=", value, "plus");
            return (Criteria) this;
        }

        public Criteria andPlusLessThan(Integer value) {
            addCriterion("plus <", value, "plus");
            return (Criteria) this;
        }

        public Criteria andPlusLessThanOrEqualTo(Integer value) {
            addCriterion("plus <=", value, "plus");
            return (Criteria) this;
        }

        public Criteria andPlusIn(List<Integer> values) {
            addCriterion("plus in", values, "plus");
            return (Criteria) this;
        }

        public Criteria andPlusNotIn(List<Integer> values) {
            addCriterion("plus not in", values, "plus");
            return (Criteria) this;
        }

        public Criteria andPlusBetween(Integer value1, Integer value2) {
            addCriterion("plus between", value1, value2, "plus");
            return (Criteria) this;
        }

        public Criteria andPlusNotBetween(Integer value1, Integer value2) {
            addCriterion("plus not between", value1, value2, "plus");
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

        public Criteria andUnionIdIsNull() {
            addCriterion("union_id is null");
            return (Criteria) this;
        }

        public Criteria andUnionIdIsNotNull() {
            addCriterion("union_id is not null");
            return (Criteria) this;
        }

        public Criteria andUnionIdEqualTo(Long value) {
            addCriterion("union_id =", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdNotEqualTo(Long value) {
            addCriterion("union_id <>", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdGreaterThan(Long value) {
            addCriterion("union_id >", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("union_id >=", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdLessThan(Long value) {
            addCriterion("union_id <", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdLessThanOrEqualTo(Long value) {
            addCriterion("union_id <=", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdIn(List<Long> values) {
            addCriterion("union_id in", values, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdNotIn(List<Long> values) {
            addCriterion("union_id not in", values, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdBetween(Long value1, Long value2) {
            addCriterion("union_id between", value1, value2, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdNotBetween(Long value1, Long value2) {
            addCriterion("union_id not between", value1, value2, "unionId");
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

        public Criteria andHasMoreIsNull() {
            addCriterion("has_more is null");
            return (Criteria) this;
        }

        public Criteria andHasMoreIsNotNull() {
            addCriterion("has_more is not null");
            return (Criteria) this;
        }

        public Criteria andHasMoreEqualTo(String value) {
            addCriterion("has_more =", value, "hasMore");
            return (Criteria) this;
        }

        public Criteria andHasMoreNotEqualTo(String value) {
            addCriterion("has_more <>", value, "hasMore");
            return (Criteria) this;
        }

        public Criteria andHasMoreGreaterThan(String value) {
            addCriterion("has_more >", value, "hasMore");
            return (Criteria) this;
        }

        public Criteria andHasMoreGreaterThanOrEqualTo(String value) {
            addCriterion("has_more >=", value, "hasMore");
            return (Criteria) this;
        }

        public Criteria andHasMoreLessThan(String value) {
            addCriterion("has_more <", value, "hasMore");
            return (Criteria) this;
        }

        public Criteria andHasMoreLessThanOrEqualTo(String value) {
            addCriterion("has_more <=", value, "hasMore");
            return (Criteria) this;
        }

        public Criteria andHasMoreLike(String value) {
            addCriterion("has_more like", value, "hasMore");
            return (Criteria) this;
        }

        public Criteria andHasMoreNotLike(String value) {
            addCriterion("has_more not like", value, "hasMore");
            return (Criteria) this;
        }

        public Criteria andHasMoreIn(List<String> values) {
            addCriterion("has_more in", values, "hasMore");
            return (Criteria) this;
        }

        public Criteria andHasMoreNotIn(List<String> values) {
            addCriterion("has_more not in", values, "hasMore");
            return (Criteria) this;
        }

        public Criteria andHasMoreBetween(String value1, String value2) {
            addCriterion("has_more between", value1, value2, "hasMore");
            return (Criteria) this;
        }

        public Criteria andHasMoreNotBetween(String value1, String value2) {
            addCriterion("has_more not between", value1, value2, "hasMore");
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