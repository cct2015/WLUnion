package com.luer.marketingSchemeManage.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VValueabledPlansExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VValueabledPlansExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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

        public Criteria andFromMerchantIdIsNull() {
            addCriterion("from_merchant_id is null");
            return (Criteria) this;
        }

        public Criteria andFromMerchantIdIsNotNull() {
            addCriterion("from_merchant_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromMerchantIdEqualTo(String value) {
            addCriterion("from_merchant_id =", value, "fromMerchantId");
            return (Criteria) this;
        }

        public Criteria andFromMerchantIdNotEqualTo(String value) {
            addCriterion("from_merchant_id <>", value, "fromMerchantId");
            return (Criteria) this;
        }

        public Criteria andFromMerchantIdGreaterThan(String value) {
            addCriterion("from_merchant_id >", value, "fromMerchantId");
            return (Criteria) this;
        }

        public Criteria andFromMerchantIdGreaterThanOrEqualTo(String value) {
            addCriterion("from_merchant_id >=", value, "fromMerchantId");
            return (Criteria) this;
        }

        public Criteria andFromMerchantIdLessThan(String value) {
            addCriterion("from_merchant_id <", value, "fromMerchantId");
            return (Criteria) this;
        }

        public Criteria andFromMerchantIdLessThanOrEqualTo(String value) {
            addCriterion("from_merchant_id <=", value, "fromMerchantId");
            return (Criteria) this;
        }

        public Criteria andFromMerchantIdLike(String value) {
            addCriterion("from_merchant_id like", value, "fromMerchantId");
            return (Criteria) this;
        }

        public Criteria andFromMerchantIdNotLike(String value) {
            addCriterion("from_merchant_id not like", value, "fromMerchantId");
            return (Criteria) this;
        }

        public Criteria andFromMerchantIdIn(List<String> values) {
            addCriterion("from_merchant_id in", values, "fromMerchantId");
            return (Criteria) this;
        }

        public Criteria andFromMerchantIdNotIn(List<String> values) {
            addCriterion("from_merchant_id not in", values, "fromMerchantId");
            return (Criteria) this;
        }

        public Criteria andFromMerchantIdBetween(String value1, String value2) {
            addCriterion("from_merchant_id between", value1, value2, "fromMerchantId");
            return (Criteria) this;
        }

        public Criteria andFromMerchantIdNotBetween(String value1, String value2) {
            addCriterion("from_merchant_id not between", value1, value2, "fromMerchantId");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNull() {
            addCriterion("district is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNotNull() {
            addCriterion("district is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictEqualTo(String value) {
            addCriterion("district =", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotEqualTo(String value) {
            addCriterion("district <>", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThan(String value) {
            addCriterion("district >", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("district >=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThan(String value) {
            addCriterion("district <", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThanOrEqualTo(String value) {
            addCriterion("district <=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLike(String value) {
            addCriterion("district like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotLike(String value) {
            addCriterion("district not like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictIn(List<String> values) {
            addCriterion("district in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotIn(List<String> values) {
            addCriterion("district not in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictBetween(String value1, String value2) {
            addCriterion("district between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotBetween(String value1, String value2) {
            addCriterion("district not between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andDescribe1IsNull() {
            addCriterion("describe1 is null");
            return (Criteria) this;
        }

        public Criteria andDescribe1IsNotNull() {
            addCriterion("describe1 is not null");
            return (Criteria) this;
        }

        public Criteria andDescribe1EqualTo(String value) {
            addCriterion("describe1 =", value, "describe1");
            return (Criteria) this;
        }

        public Criteria andDescribe1NotEqualTo(String value) {
            addCriterion("describe1 <>", value, "describe1");
            return (Criteria) this;
        }

        public Criteria andDescribe1GreaterThan(String value) {
            addCriterion("describe1 >", value, "describe1");
            return (Criteria) this;
        }

        public Criteria andDescribe1GreaterThanOrEqualTo(String value) {
            addCriterion("describe1 >=", value, "describe1");
            return (Criteria) this;
        }

        public Criteria andDescribe1LessThan(String value) {
            addCriterion("describe1 <", value, "describe1");
            return (Criteria) this;
        }

        public Criteria andDescribe1LessThanOrEqualTo(String value) {
            addCriterion("describe1 <=", value, "describe1");
            return (Criteria) this;
        }

        public Criteria andDescribe1Like(String value) {
            addCriterion("describe1 like", value, "describe1");
            return (Criteria) this;
        }

        public Criteria andDescribe1NotLike(String value) {
            addCriterion("describe1 not like", value, "describe1");
            return (Criteria) this;
        }

        public Criteria andDescribe1In(List<String> values) {
            addCriterion("describe1 in", values, "describe1");
            return (Criteria) this;
        }

        public Criteria andDescribe1NotIn(List<String> values) {
            addCriterion("describe1 not in", values, "describe1");
            return (Criteria) this;
        }

        public Criteria andDescribe1Between(String value1, String value2) {
            addCriterion("describe1 between", value1, value2, "describe1");
            return (Criteria) this;
        }

        public Criteria andDescribe1NotBetween(String value1, String value2) {
            addCriterion("describe1 not between", value1, value2, "describe1");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andTellIsNull() {
            addCriterion("tell is null");
            return (Criteria) this;
        }

        public Criteria andTellIsNotNull() {
            addCriterion("tell is not null");
            return (Criteria) this;
        }

        public Criteria andTellEqualTo(String value) {
            addCriterion("tell =", value, "tell");
            return (Criteria) this;
        }

        public Criteria andTellNotEqualTo(String value) {
            addCriterion("tell <>", value, "tell");
            return (Criteria) this;
        }

        public Criteria andTellGreaterThan(String value) {
            addCriterion("tell >", value, "tell");
            return (Criteria) this;
        }

        public Criteria andTellGreaterThanOrEqualTo(String value) {
            addCriterion("tell >=", value, "tell");
            return (Criteria) this;
        }

        public Criteria andTellLessThan(String value) {
            addCriterion("tell <", value, "tell");
            return (Criteria) this;
        }

        public Criteria andTellLessThanOrEqualTo(String value) {
            addCriterion("tell <=", value, "tell");
            return (Criteria) this;
        }

        public Criteria andTellLike(String value) {
            addCriterion("tell like", value, "tell");
            return (Criteria) this;
        }

        public Criteria andTellNotLike(String value) {
            addCriterion("tell not like", value, "tell");
            return (Criteria) this;
        }

        public Criteria andTellIn(List<String> values) {
            addCriterion("tell in", values, "tell");
            return (Criteria) this;
        }

        public Criteria andTellNotIn(List<String> values) {
            addCriterion("tell not in", values, "tell");
            return (Criteria) this;
        }

        public Criteria andTellBetween(String value1, String value2) {
            addCriterion("tell between", value1, value2, "tell");
            return (Criteria) this;
        }

        public Criteria andTellNotBetween(String value1, String value2) {
            addCriterion("tell not between", value1, value2, "tell");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeOneIsNull() {
            addCriterion("commission_type_one is null");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeOneIsNotNull() {
            addCriterion("commission_type_one is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeOneEqualTo(String value) {
            addCriterion("commission_type_one =", value, "commissionTypeOne");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeOneNotEqualTo(String value) {
            addCriterion("commission_type_one <>", value, "commissionTypeOne");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeOneGreaterThan(String value) {
            addCriterion("commission_type_one >", value, "commissionTypeOne");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeOneGreaterThanOrEqualTo(String value) {
            addCriterion("commission_type_one >=", value, "commissionTypeOne");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeOneLessThan(String value) {
            addCriterion("commission_type_one <", value, "commissionTypeOne");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeOneLessThanOrEqualTo(String value) {
            addCriterion("commission_type_one <=", value, "commissionTypeOne");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeOneLike(String value) {
            addCriterion("commission_type_one like", value, "commissionTypeOne");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeOneNotLike(String value) {
            addCriterion("commission_type_one not like", value, "commissionTypeOne");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeOneIn(List<String> values) {
            addCriterion("commission_type_one in", values, "commissionTypeOne");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeOneNotIn(List<String> values) {
            addCriterion("commission_type_one not in", values, "commissionTypeOne");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeOneBetween(String value1, String value2) {
            addCriterion("commission_type_one between", value1, value2, "commissionTypeOne");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeOneNotBetween(String value1, String value2) {
            addCriterion("commission_type_one not between", value1, value2, "commissionTypeOne");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeTwoIsNull() {
            addCriterion("commission_type_two is null");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeTwoIsNotNull() {
            addCriterion("commission_type_two is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeTwoEqualTo(String value) {
            addCriterion("commission_type_two =", value, "commissionTypeTwo");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeTwoNotEqualTo(String value) {
            addCriterion("commission_type_two <>", value, "commissionTypeTwo");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeTwoGreaterThan(String value) {
            addCriterion("commission_type_two >", value, "commissionTypeTwo");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeTwoGreaterThanOrEqualTo(String value) {
            addCriterion("commission_type_two >=", value, "commissionTypeTwo");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeTwoLessThan(String value) {
            addCriterion("commission_type_two <", value, "commissionTypeTwo");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeTwoLessThanOrEqualTo(String value) {
            addCriterion("commission_type_two <=", value, "commissionTypeTwo");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeTwoLike(String value) {
            addCriterion("commission_type_two like", value, "commissionTypeTwo");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeTwoNotLike(String value) {
            addCriterion("commission_type_two not like", value, "commissionTypeTwo");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeTwoIn(List<String> values) {
            addCriterion("commission_type_two in", values, "commissionTypeTwo");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeTwoNotIn(List<String> values) {
            addCriterion("commission_type_two not in", values, "commissionTypeTwo");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeTwoBetween(String value1, String value2) {
            addCriterion("commission_type_two between", value1, value2, "commissionTypeTwo");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeTwoNotBetween(String value1, String value2) {
            addCriterion("commission_type_two not between", value1, value2, "commissionTypeTwo");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeThreeIsNull() {
            addCriterion("commission_type_three is null");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeThreeIsNotNull() {
            addCriterion("commission_type_three is not null");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeThreeEqualTo(String value) {
            addCriterion("commission_type_three =", value, "commissionTypeThree");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeThreeNotEqualTo(String value) {
            addCriterion("commission_type_three <>", value, "commissionTypeThree");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeThreeGreaterThan(String value) {
            addCriterion("commission_type_three >", value, "commissionTypeThree");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeThreeGreaterThanOrEqualTo(String value) {
            addCriterion("commission_type_three >=", value, "commissionTypeThree");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeThreeLessThan(String value) {
            addCriterion("commission_type_three <", value, "commissionTypeThree");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeThreeLessThanOrEqualTo(String value) {
            addCriterion("commission_type_three <=", value, "commissionTypeThree");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeThreeLike(String value) {
            addCriterion("commission_type_three like", value, "commissionTypeThree");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeThreeNotLike(String value) {
            addCriterion("commission_type_three not like", value, "commissionTypeThree");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeThreeIn(List<String> values) {
            addCriterion("commission_type_three in", values, "commissionTypeThree");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeThreeNotIn(List<String> values) {
            addCriterion("commission_type_three not in", values, "commissionTypeThree");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeThreeBetween(String value1, String value2) {
            addCriterion("commission_type_three between", value1, value2, "commissionTypeThree");
            return (Criteria) this;
        }

        public Criteria andCommissionTypeThreeNotBetween(String value1, String value2) {
            addCriterion("commission_type_three not between", value1, value2, "commissionTypeThree");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIsNull() {
            addCriterion("coupon_type is null");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIsNotNull() {
            addCriterion("coupon_type is not null");
            return (Criteria) this;
        }

        public Criteria andCouponTypeEqualTo(String value) {
            addCriterion("coupon_type =", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotEqualTo(String value) {
            addCriterion("coupon_type <>", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeGreaterThan(String value) {
            addCriterion("coupon_type >", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_type >=", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeLessThan(String value) {
            addCriterion("coupon_type <", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeLessThanOrEqualTo(String value) {
            addCriterion("coupon_type <=", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeLike(String value) {
            addCriterion("coupon_type like", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotLike(String value) {
            addCriterion("coupon_type not like", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIn(List<String> values) {
            addCriterion("coupon_type in", values, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotIn(List<String> values) {
            addCriterion("coupon_type not in", values, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeBetween(String value1, String value2) {
            addCriterion("coupon_type between", value1, value2, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotBetween(String value1, String value2) {
            addCriterion("coupon_type not between", value1, value2, "couponType");
            return (Criteria) this;
        }

        public Criteria andPreferentialWayIsNull() {
            addCriterion("preferential_way is null");
            return (Criteria) this;
        }

        public Criteria andPreferentialWayIsNotNull() {
            addCriterion("preferential_way is not null");
            return (Criteria) this;
        }

        public Criteria andPreferentialWayEqualTo(String value) {
            addCriterion("preferential_way =", value, "preferentialWay");
            return (Criteria) this;
        }

        public Criteria andPreferentialWayNotEqualTo(String value) {
            addCriterion("preferential_way <>", value, "preferentialWay");
            return (Criteria) this;
        }

        public Criteria andPreferentialWayGreaterThan(String value) {
            addCriterion("preferential_way >", value, "preferentialWay");
            return (Criteria) this;
        }

        public Criteria andPreferentialWayGreaterThanOrEqualTo(String value) {
            addCriterion("preferential_way >=", value, "preferentialWay");
            return (Criteria) this;
        }

        public Criteria andPreferentialWayLessThan(String value) {
            addCriterion("preferential_way <", value, "preferentialWay");
            return (Criteria) this;
        }

        public Criteria andPreferentialWayLessThanOrEqualTo(String value) {
            addCriterion("preferential_way <=", value, "preferentialWay");
            return (Criteria) this;
        }

        public Criteria andPreferentialWayLike(String value) {
            addCriterion("preferential_way like", value, "preferentialWay");
            return (Criteria) this;
        }

        public Criteria andPreferentialWayNotLike(String value) {
            addCriterion("preferential_way not like", value, "preferentialWay");
            return (Criteria) this;
        }

        public Criteria andPreferentialWayIn(List<String> values) {
            addCriterion("preferential_way in", values, "preferentialWay");
            return (Criteria) this;
        }

        public Criteria andPreferentialWayNotIn(List<String> values) {
            addCriterion("preferential_way not in", values, "preferentialWay");
            return (Criteria) this;
        }

        public Criteria andPreferentialWayBetween(String value1, String value2) {
            addCriterion("preferential_way between", value1, value2, "preferentialWay");
            return (Criteria) this;
        }

        public Criteria andPreferentialWayNotBetween(String value1, String value2) {
            addCriterion("preferential_way not between", value1, value2, "preferentialWay");
            return (Criteria) this;
        }

        public Criteria andValueOneIsNull() {
            addCriterion("value_one is null");
            return (Criteria) this;
        }

        public Criteria andValueOneIsNotNull() {
            addCriterion("value_one is not null");
            return (Criteria) this;
        }

        public Criteria andValueOneEqualTo(String value) {
            addCriterion("value_one =", value, "valueOne");
            return (Criteria) this;
        }

        public Criteria andValueOneNotEqualTo(String value) {
            addCriterion("value_one <>", value, "valueOne");
            return (Criteria) this;
        }

        public Criteria andValueOneGreaterThan(String value) {
            addCriterion("value_one >", value, "valueOne");
            return (Criteria) this;
        }

        public Criteria andValueOneGreaterThanOrEqualTo(String value) {
            addCriterion("value_one >=", value, "valueOne");
            return (Criteria) this;
        }

        public Criteria andValueOneLessThan(String value) {
            addCriterion("value_one <", value, "valueOne");
            return (Criteria) this;
        }

        public Criteria andValueOneLessThanOrEqualTo(String value) {
            addCriterion("value_one <=", value, "valueOne");
            return (Criteria) this;
        }

        public Criteria andValueOneLike(String value) {
            addCriterion("value_one like", value, "valueOne");
            return (Criteria) this;
        }

        public Criteria andValueOneNotLike(String value) {
            addCriterion("value_one not like", value, "valueOne");
            return (Criteria) this;
        }

        public Criteria andValueOneIn(List<String> values) {
            addCriterion("value_one in", values, "valueOne");
            return (Criteria) this;
        }

        public Criteria andValueOneNotIn(List<String> values) {
            addCriterion("value_one not in", values, "valueOne");
            return (Criteria) this;
        }

        public Criteria andValueOneBetween(String value1, String value2) {
            addCriterion("value_one between", value1, value2, "valueOne");
            return (Criteria) this;
        }

        public Criteria andValueOneNotBetween(String value1, String value2) {
            addCriterion("value_one not between", value1, value2, "valueOne");
            return (Criteria) this;
        }

        public Criteria andValueTwoIsNull() {
            addCriterion("value_two is null");
            return (Criteria) this;
        }

        public Criteria andValueTwoIsNotNull() {
            addCriterion("value_two is not null");
            return (Criteria) this;
        }

        public Criteria andValueTwoEqualTo(String value) {
            addCriterion("value_two =", value, "valueTwo");
            return (Criteria) this;
        }

        public Criteria andValueTwoNotEqualTo(String value) {
            addCriterion("value_two <>", value, "valueTwo");
            return (Criteria) this;
        }

        public Criteria andValueTwoGreaterThan(String value) {
            addCriterion("value_two >", value, "valueTwo");
            return (Criteria) this;
        }

        public Criteria andValueTwoGreaterThanOrEqualTo(String value) {
            addCriterion("value_two >=", value, "valueTwo");
            return (Criteria) this;
        }

        public Criteria andValueTwoLessThan(String value) {
            addCriterion("value_two <", value, "valueTwo");
            return (Criteria) this;
        }

        public Criteria andValueTwoLessThanOrEqualTo(String value) {
            addCriterion("value_two <=", value, "valueTwo");
            return (Criteria) this;
        }

        public Criteria andValueTwoLike(String value) {
            addCriterion("value_two like", value, "valueTwo");
            return (Criteria) this;
        }

        public Criteria andValueTwoNotLike(String value) {
            addCriterion("value_two not like", value, "valueTwo");
            return (Criteria) this;
        }

        public Criteria andValueTwoIn(List<String> values) {
            addCriterion("value_two in", values, "valueTwo");
            return (Criteria) this;
        }

        public Criteria andValueTwoNotIn(List<String> values) {
            addCriterion("value_two not in", values, "valueTwo");
            return (Criteria) this;
        }

        public Criteria andValueTwoBetween(String value1, String value2) {
            addCriterion("value_two between", value1, value2, "valueTwo");
            return (Criteria) this;
        }

        public Criteria andValueTwoNotBetween(String value1, String value2) {
            addCriterion("value_two not between", value1, value2, "valueTwo");
            return (Criteria) this;
        }

        public Criteria andValueTreeIsNull() {
            addCriterion("value_tree is null");
            return (Criteria) this;
        }

        public Criteria andValueTreeIsNotNull() {
            addCriterion("value_tree is not null");
            return (Criteria) this;
        }

        public Criteria andValueTreeEqualTo(String value) {
            addCriterion("value_tree =", value, "valueTree");
            return (Criteria) this;
        }

        public Criteria andValueTreeNotEqualTo(String value) {
            addCriterion("value_tree <>", value, "valueTree");
            return (Criteria) this;
        }

        public Criteria andValueTreeGreaterThan(String value) {
            addCriterion("value_tree >", value, "valueTree");
            return (Criteria) this;
        }

        public Criteria andValueTreeGreaterThanOrEqualTo(String value) {
            addCriterion("value_tree >=", value, "valueTree");
            return (Criteria) this;
        }

        public Criteria andValueTreeLessThan(String value) {
            addCriterion("value_tree <", value, "valueTree");
            return (Criteria) this;
        }

        public Criteria andValueTreeLessThanOrEqualTo(String value) {
            addCriterion("value_tree <=", value, "valueTree");
            return (Criteria) this;
        }

        public Criteria andValueTreeLike(String value) {
            addCriterion("value_tree like", value, "valueTree");
            return (Criteria) this;
        }

        public Criteria andValueTreeNotLike(String value) {
            addCriterion("value_tree not like", value, "valueTree");
            return (Criteria) this;
        }

        public Criteria andValueTreeIn(List<String> values) {
            addCriterion("value_tree in", values, "valueTree");
            return (Criteria) this;
        }

        public Criteria andValueTreeNotIn(List<String> values) {
            addCriterion("value_tree not in", values, "valueTree");
            return (Criteria) this;
        }

        public Criteria andValueTreeBetween(String value1, String value2) {
            addCriterion("value_tree between", value1, value2, "valueTree");
            return (Criteria) this;
        }

        public Criteria andValueTreeNotBetween(String value1, String value2) {
            addCriterion("value_tree not between", value1, value2, "valueTree");
            return (Criteria) this;
        }

        public Criteria andOtherDescripeIsNull() {
            addCriterion("other_descripe is null");
            return (Criteria) this;
        }

        public Criteria andOtherDescripeIsNotNull() {
            addCriterion("other_descripe is not null");
            return (Criteria) this;
        }

        public Criteria andOtherDescripeEqualTo(String value) {
            addCriterion("other_descripe =", value, "otherDescripe");
            return (Criteria) this;
        }

        public Criteria andOtherDescripeNotEqualTo(String value) {
            addCriterion("other_descripe <>", value, "otherDescripe");
            return (Criteria) this;
        }

        public Criteria andOtherDescripeGreaterThan(String value) {
            addCriterion("other_descripe >", value, "otherDescripe");
            return (Criteria) this;
        }

        public Criteria andOtherDescripeGreaterThanOrEqualTo(String value) {
            addCriterion("other_descripe >=", value, "otherDescripe");
            return (Criteria) this;
        }

        public Criteria andOtherDescripeLessThan(String value) {
            addCriterion("other_descripe <", value, "otherDescripe");
            return (Criteria) this;
        }

        public Criteria andOtherDescripeLessThanOrEqualTo(String value) {
            addCriterion("other_descripe <=", value, "otherDescripe");
            return (Criteria) this;
        }

        public Criteria andOtherDescripeLike(String value) {
            addCriterion("other_descripe like", value, "otherDescripe");
            return (Criteria) this;
        }

        public Criteria andOtherDescripeNotLike(String value) {
            addCriterion("other_descripe not like", value, "otherDescripe");
            return (Criteria) this;
        }

        public Criteria andOtherDescripeIn(List<String> values) {
            addCriterion("other_descripe in", values, "otherDescripe");
            return (Criteria) this;
        }

        public Criteria andOtherDescripeNotIn(List<String> values) {
            addCriterion("other_descripe not in", values, "otherDescripe");
            return (Criteria) this;
        }

        public Criteria andOtherDescripeBetween(String value1, String value2) {
            addCriterion("other_descripe between", value1, value2, "otherDescripe");
            return (Criteria) this;
        }

        public Criteria andOtherDescripeNotBetween(String value1, String value2) {
            addCriterion("other_descripe not between", value1, value2, "otherDescripe");
            return (Criteria) this;
        }

        public Criteria andUsageRuleIsNull() {
            addCriterion("usage_rule is null");
            return (Criteria) this;
        }

        public Criteria andUsageRuleIsNotNull() {
            addCriterion("usage_rule is not null");
            return (Criteria) this;
        }

        public Criteria andUsageRuleEqualTo(String value) {
            addCriterion("usage_rule =", value, "usageRule");
            return (Criteria) this;
        }

        public Criteria andUsageRuleNotEqualTo(String value) {
            addCriterion("usage_rule <>", value, "usageRule");
            return (Criteria) this;
        }

        public Criteria andUsageRuleGreaterThan(String value) {
            addCriterion("usage_rule >", value, "usageRule");
            return (Criteria) this;
        }

        public Criteria andUsageRuleGreaterThanOrEqualTo(String value) {
            addCriterion("usage_rule >=", value, "usageRule");
            return (Criteria) this;
        }

        public Criteria andUsageRuleLessThan(String value) {
            addCriterion("usage_rule <", value, "usageRule");
            return (Criteria) this;
        }

        public Criteria andUsageRuleLessThanOrEqualTo(String value) {
            addCriterion("usage_rule <=", value, "usageRule");
            return (Criteria) this;
        }

        public Criteria andUsageRuleLike(String value) {
            addCriterion("usage_rule like", value, "usageRule");
            return (Criteria) this;
        }

        public Criteria andUsageRuleNotLike(String value) {
            addCriterion("usage_rule not like", value, "usageRule");
            return (Criteria) this;
        }

        public Criteria andUsageRuleIn(List<String> values) {
            addCriterion("usage_rule in", values, "usageRule");
            return (Criteria) this;
        }

        public Criteria andUsageRuleNotIn(List<String> values) {
            addCriterion("usage_rule not in", values, "usageRule");
            return (Criteria) this;
        }

        public Criteria andUsageRuleBetween(String value1, String value2) {
            addCriterion("usage_rule between", value1, value2, "usageRule");
            return (Criteria) this;
        }

        public Criteria andUsageRuleNotBetween(String value1, String value2) {
            addCriterion("usage_rule not between", value1, value2, "usageRule");
            return (Criteria) this;
        }

        public Criteria andSupportStoreIsNull() {
            addCriterion("support_store is null");
            return (Criteria) this;
        }

        public Criteria andSupportStoreIsNotNull() {
            addCriterion("support_store is not null");
            return (Criteria) this;
        }

        public Criteria andSupportStoreEqualTo(String value) {
            addCriterion("support_store =", value, "supportStore");
            return (Criteria) this;
        }

        public Criteria andSupportStoreNotEqualTo(String value) {
            addCriterion("support_store <>", value, "supportStore");
            return (Criteria) this;
        }

        public Criteria andSupportStoreGreaterThan(String value) {
            addCriterion("support_store >", value, "supportStore");
            return (Criteria) this;
        }

        public Criteria andSupportStoreGreaterThanOrEqualTo(String value) {
            addCriterion("support_store >=", value, "supportStore");
            return (Criteria) this;
        }

        public Criteria andSupportStoreLessThan(String value) {
            addCriterion("support_store <", value, "supportStore");
            return (Criteria) this;
        }

        public Criteria andSupportStoreLessThanOrEqualTo(String value) {
            addCriterion("support_store <=", value, "supportStore");
            return (Criteria) this;
        }

        public Criteria andSupportStoreLike(String value) {
            addCriterion("support_store like", value, "supportStore");
            return (Criteria) this;
        }

        public Criteria andSupportStoreNotLike(String value) {
            addCriterion("support_store not like", value, "supportStore");
            return (Criteria) this;
        }

        public Criteria andSupportStoreIn(List<String> values) {
            addCriterion("support_store in", values, "supportStore");
            return (Criteria) this;
        }

        public Criteria andSupportStoreNotIn(List<String> values) {
            addCriterion("support_store not in", values, "supportStore");
            return (Criteria) this;
        }

        public Criteria andSupportStoreBetween(String value1, String value2) {
            addCriterion("support_store between", value1, value2, "supportStore");
            return (Criteria) this;
        }

        public Criteria andSupportStoreNotBetween(String value1, String value2) {
            addCriterion("support_store not between", value1, value2, "supportStore");
            return (Criteria) this;
        }

        public Criteria andCouponsNumberIsNull() {
            addCriterion("coupons_number is null");
            return (Criteria) this;
        }

        public Criteria andCouponsNumberIsNotNull() {
            addCriterion("coupons_number is not null");
            return (Criteria) this;
        }

        public Criteria andCouponsNumberEqualTo(Integer value) {
            addCriterion("coupons_number =", value, "couponsNumber");
            return (Criteria) this;
        }

        public Criteria andCouponsNumberNotEqualTo(Integer value) {
            addCriterion("coupons_number <>", value, "couponsNumber");
            return (Criteria) this;
        }

        public Criteria andCouponsNumberGreaterThan(Integer value) {
            addCriterion("coupons_number >", value, "couponsNumber");
            return (Criteria) this;
        }

        public Criteria andCouponsNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("coupons_number >=", value, "couponsNumber");
            return (Criteria) this;
        }

        public Criteria andCouponsNumberLessThan(Integer value) {
            addCriterion("coupons_number <", value, "couponsNumber");
            return (Criteria) this;
        }

        public Criteria andCouponsNumberLessThanOrEqualTo(Integer value) {
            addCriterion("coupons_number <=", value, "couponsNumber");
            return (Criteria) this;
        }

        public Criteria andCouponsNumberIn(List<Integer> values) {
            addCriterion("coupons_number in", values, "couponsNumber");
            return (Criteria) this;
        }

        public Criteria andCouponsNumberNotIn(List<Integer> values) {
            addCriterion("coupons_number not in", values, "couponsNumber");
            return (Criteria) this;
        }

        public Criteria andCouponsNumberBetween(Integer value1, Integer value2) {
            addCriterion("coupons_number between", value1, value2, "couponsNumber");
            return (Criteria) this;
        }

        public Criteria andCouponsNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("coupons_number not between", value1, value2, "couponsNumber");
            return (Criteria) this;
        }

        public Criteria andAcceptmerchantIsNull() {
            addCriterion("acceptmerchant is null");
            return (Criteria) this;
        }

        public Criteria andAcceptmerchantIsNotNull() {
            addCriterion("acceptmerchant is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptmerchantEqualTo(String value) {
            addCriterion("acceptmerchant =", value, "acceptmerchant");
            return (Criteria) this;
        }

        public Criteria andAcceptmerchantNotEqualTo(String value) {
            addCriterion("acceptmerchant <>", value, "acceptmerchant");
            return (Criteria) this;
        }

        public Criteria andAcceptmerchantGreaterThan(String value) {
            addCriterion("acceptmerchant >", value, "acceptmerchant");
            return (Criteria) this;
        }

        public Criteria andAcceptmerchantGreaterThanOrEqualTo(String value) {
            addCriterion("acceptmerchant >=", value, "acceptmerchant");
            return (Criteria) this;
        }

        public Criteria andAcceptmerchantLessThan(String value) {
            addCriterion("acceptmerchant <", value, "acceptmerchant");
            return (Criteria) this;
        }

        public Criteria andAcceptmerchantLessThanOrEqualTo(String value) {
            addCriterion("acceptmerchant <=", value, "acceptmerchant");
            return (Criteria) this;
        }

        public Criteria andAcceptmerchantLike(String value) {
            addCriterion("acceptmerchant like", value, "acceptmerchant");
            return (Criteria) this;
        }

        public Criteria andAcceptmerchantNotLike(String value) {
            addCriterion("acceptmerchant not like", value, "acceptmerchant");
            return (Criteria) this;
        }

        public Criteria andAcceptmerchantIn(List<String> values) {
            addCriterion("acceptmerchant in", values, "acceptmerchant");
            return (Criteria) this;
        }

        public Criteria andAcceptmerchantNotIn(List<String> values) {
            addCriterion("acceptmerchant not in", values, "acceptmerchant");
            return (Criteria) this;
        }

        public Criteria andAcceptmerchantBetween(String value1, String value2) {
            addCriterion("acceptmerchant between", value1, value2, "acceptmerchant");
            return (Criteria) this;
        }

        public Criteria andAcceptmerchantNotBetween(String value1, String value2) {
            addCriterion("acceptmerchant not between", value1, value2, "acceptmerchant");
            return (Criteria) this;
        }

        public Criteria andMerchantIsNull() {
            addCriterion("merchant is null");
            return (Criteria) this;
        }

        public Criteria andMerchantIsNotNull() {
            addCriterion("merchant is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantEqualTo(String value) {
            addCriterion("merchant =", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantNotEqualTo(String value) {
            addCriterion("merchant <>", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantGreaterThan(String value) {
            addCriterion("merchant >", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantGreaterThanOrEqualTo(String value) {
            addCriterion("merchant >=", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantLessThan(String value) {
            addCriterion("merchant <", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantLessThanOrEqualTo(String value) {
            addCriterion("merchant <=", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantLike(String value) {
            addCriterion("merchant like", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantNotLike(String value) {
            addCriterion("merchant not like", value, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantIn(List<String> values) {
            addCriterion("merchant in", values, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantNotIn(List<String> values) {
            addCriterion("merchant not in", values, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantBetween(String value1, String value2) {
            addCriterion("merchant between", value1, value2, "merchant");
            return (Criteria) this;
        }

        public Criteria andMerchantNotBetween(String value1, String value2) {
            addCriterion("merchant not between", value1, value2, "merchant");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
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