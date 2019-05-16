package com.luer.privilegeManage.bean;

import java.util.ArrayList;
import java.util.List;

public class SysPermissionResourceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysPermissionResourceExample() {
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

        public Criteria andPermnameIsNull() {
            addCriterion("permname is null");
            return (Criteria) this;
        }

        public Criteria andPermnameIsNotNull() {
            addCriterion("permname is not null");
            return (Criteria) this;
        }

        public Criteria andPermnameEqualTo(String value) {
            addCriterion("permname =", value, "permname");
            return (Criteria) this;
        }

        public Criteria andPermnameNotEqualTo(String value) {
            addCriterion("permname <>", value, "permname");
            return (Criteria) this;
        }

        public Criteria andPermnameGreaterThan(String value) {
            addCriterion("permname >", value, "permname");
            return (Criteria) this;
        }

        public Criteria andPermnameGreaterThanOrEqualTo(String value) {
            addCriterion("permname >=", value, "permname");
            return (Criteria) this;
        }

        public Criteria andPermnameLessThan(String value) {
            addCriterion("permname <", value, "permname");
            return (Criteria) this;
        }

        public Criteria andPermnameLessThanOrEqualTo(String value) {
            addCriterion("permname <=", value, "permname");
            return (Criteria) this;
        }

        public Criteria andPermnameLike(String value) {
            addCriterion("permname like", value, "permname");
            return (Criteria) this;
        }

        public Criteria andPermnameNotLike(String value) {
            addCriterion("permname not like", value, "permname");
            return (Criteria) this;
        }

        public Criteria andPermnameIn(List<String> values) {
            addCriterion("permname in", values, "permname");
            return (Criteria) this;
        }

        public Criteria andPermnameNotIn(List<String> values) {
            addCriterion("permname not in", values, "permname");
            return (Criteria) this;
        }

        public Criteria andPermnameBetween(String value1, String value2) {
            addCriterion("permname between", value1, value2, "permname");
            return (Criteria) this;
        }

        public Criteria andPermnameNotBetween(String value1, String value2) {
            addCriterion("permname not between", value1, value2, "permname");
            return (Criteria) this;
        }

        public Criteria andPermtagIsNull() {
            addCriterion("permtag is null");
            return (Criteria) this;
        }

        public Criteria andPermtagIsNotNull() {
            addCriterion("permtag is not null");
            return (Criteria) this;
        }

        public Criteria andPermtagEqualTo(String value) {
            addCriterion("permtag =", value, "permtag");
            return (Criteria) this;
        }

        public Criteria andPermtagNotEqualTo(String value) {
            addCriterion("permtag <>", value, "permtag");
            return (Criteria) this;
        }

        public Criteria andPermtagGreaterThan(String value) {
            addCriterion("permtag >", value, "permtag");
            return (Criteria) this;
        }

        public Criteria andPermtagGreaterThanOrEqualTo(String value) {
            addCriterion("permtag >=", value, "permtag");
            return (Criteria) this;
        }

        public Criteria andPermtagLessThan(String value) {
            addCriterion("permtag <", value, "permtag");
            return (Criteria) this;
        }

        public Criteria andPermtagLessThanOrEqualTo(String value) {
            addCriterion("permtag <=", value, "permtag");
            return (Criteria) this;
        }

        public Criteria andPermtagLike(String value) {
            addCriterion("permtag like", value, "permtag");
            return (Criteria) this;
        }

        public Criteria andPermtagNotLike(String value) {
            addCriterion("permtag not like", value, "permtag");
            return (Criteria) this;
        }

        public Criteria andPermtagIn(List<String> values) {
            addCriterion("permtag in", values, "permtag");
            return (Criteria) this;
        }

        public Criteria andPermtagNotIn(List<String> values) {
            addCriterion("permtag not in", values, "permtag");
            return (Criteria) this;
        }

        public Criteria andPermtagBetween(String value1, String value2) {
            addCriterion("permtag between", value1, value2, "permtag");
            return (Criteria) this;
        }

        public Criteria andPermtagNotBetween(String value1, String value2) {
            addCriterion("permtag not between", value1, value2, "permtag");
            return (Criteria) this;
        }

        public Criteria andIsMenuIsNull() {
            addCriterion("is_menu is null");
            return (Criteria) this;
        }

        public Criteria andIsMenuIsNotNull() {
            addCriterion("is_menu is not null");
            return (Criteria) this;
        }

        public Criteria andIsMenuEqualTo(Integer value) {
            addCriterion("is_menu =", value, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuNotEqualTo(Integer value) {
            addCriterion("is_menu <>", value, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuGreaterThan(Integer value) {
            addCriterion("is_menu >", value, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_menu >=", value, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuLessThan(Integer value) {
            addCriterion("is_menu <", value, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuLessThanOrEqualTo(Integer value) {
            addCriterion("is_menu <=", value, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuIn(List<Integer> values) {
            addCriterion("is_menu in", values, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuNotIn(List<Integer> values) {
            addCriterion("is_menu not in", values, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuBetween(Integer value1, Integer value2) {
            addCriterion("is_menu between", value1, value2, "isMenu");
            return (Criteria) this;
        }

        public Criteria andIsMenuNotBetween(Integer value1, Integer value2) {
            addCriterion("is_menu not between", value1, value2, "isMenu");
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