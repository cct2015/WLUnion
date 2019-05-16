package com.luer.dataManage.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MarketingMerchantExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MarketingMerchantExample() {
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

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyShortIsNull() {
            addCriterion("company_short is null");
            return (Criteria) this;
        }

        public Criteria andCompanyShortIsNotNull() {
            addCriterion("company_short is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyShortEqualTo(String value) {
            addCriterion("company_short =", value, "companyShort");
            return (Criteria) this;
        }

        public Criteria andCompanyShortNotEqualTo(String value) {
            addCriterion("company_short <>", value, "companyShort");
            return (Criteria) this;
        }

        public Criteria andCompanyShortGreaterThan(String value) {
            addCriterion("company_short >", value, "companyShort");
            return (Criteria) this;
        }

        public Criteria andCompanyShortGreaterThanOrEqualTo(String value) {
            addCriterion("company_short >=", value, "companyShort");
            return (Criteria) this;
        }

        public Criteria andCompanyShortLessThan(String value) {
            addCriterion("company_short <", value, "companyShort");
            return (Criteria) this;
        }

        public Criteria andCompanyShortLessThanOrEqualTo(String value) {
            addCriterion("company_short <=", value, "companyShort");
            return (Criteria) this;
        }

        public Criteria andCompanyShortLike(String value) {
            addCriterion("company_short like", value, "companyShort");
            return (Criteria) this;
        }

        public Criteria andCompanyShortNotLike(String value) {
            addCriterion("company_short not like", value, "companyShort");
            return (Criteria) this;
        }

        public Criteria andCompanyShortIn(List<String> values) {
            addCriterion("company_short in", values, "companyShort");
            return (Criteria) this;
        }

        public Criteria andCompanyShortNotIn(List<String> values) {
            addCriterion("company_short not in", values, "companyShort");
            return (Criteria) this;
        }

        public Criteria andCompanyShortBetween(String value1, String value2) {
            addCriterion("company_short between", value1, value2, "companyShort");
            return (Criteria) this;
        }

        public Criteria andCompanyShortNotBetween(String value1, String value2) {
            addCriterion("company_short not between", value1, value2, "companyShort");
            return (Criteria) this;
        }

        public Criteria andIndustryIdIsNull() {
            addCriterion("industry_id is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIdIsNotNull() {
            addCriterion("industry_id is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryIdEqualTo(String value) {
            addCriterion("industry_id =", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdNotEqualTo(String value) {
            addCriterion("industry_id <>", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdGreaterThan(String value) {
            addCriterion("industry_id >", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdGreaterThanOrEqualTo(String value) {
            addCriterion("industry_id >=", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdLessThan(String value) {
            addCriterion("industry_id <", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdLessThanOrEqualTo(String value) {
            addCriterion("industry_id <=", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdLike(String value) {
            addCriterion("industry_id like", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdNotLike(String value) {
            addCriterion("industry_id not like", value, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdIn(List<String> values) {
            addCriterion("industry_id in", values, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdNotIn(List<String> values) {
            addCriterion("industry_id not in", values, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdBetween(String value1, String value2) {
            addCriterion("industry_id between", value1, value2, "industryId");
            return (Criteria) this;
        }

        public Criteria andIndustryIdNotBetween(String value1, String value2) {
            addCriterion("industry_id not between", value1, value2, "industryId");
            return (Criteria) this;
        }

        public Criteria andContacterIsNull() {
            addCriterion("contacter is null");
            return (Criteria) this;
        }

        public Criteria andContacterIsNotNull() {
            addCriterion("contacter is not null");
            return (Criteria) this;
        }

        public Criteria andContacterEqualTo(String value) {
            addCriterion("contacter =", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterNotEqualTo(String value) {
            addCriterion("contacter <>", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterGreaterThan(String value) {
            addCriterion("contacter >", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterGreaterThanOrEqualTo(String value) {
            addCriterion("contacter >=", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterLessThan(String value) {
            addCriterion("contacter <", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterLessThanOrEqualTo(String value) {
            addCriterion("contacter <=", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterLike(String value) {
            addCriterion("contacter like", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterNotLike(String value) {
            addCriterion("contacter not like", value, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterIn(List<String> values) {
            addCriterion("contacter in", values, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterNotIn(List<String> values) {
            addCriterion("contacter not in", values, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterBetween(String value1, String value2) {
            addCriterion("contacter between", value1, value2, "contacter");
            return (Criteria) this;
        }

        public Criteria andContacterNotBetween(String value1, String value2) {
            addCriterion("contacter not between", value1, value2, "contacter");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("tel is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("tel is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("tel =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("tel <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("tel >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("tel >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("tel <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("tel <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("tel like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("tel not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("tel in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("tel not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("tel between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("tel not between", value1, value2, "tel");
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

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andMainProductsIsNull() {
            addCriterion("main_products is null");
            return (Criteria) this;
        }

        public Criteria andMainProductsIsNotNull() {
            addCriterion("main_products is not null");
            return (Criteria) this;
        }

        public Criteria andMainProductsEqualTo(String value) {
            addCriterion("main_products =", value, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsNotEqualTo(String value) {
            addCriterion("main_products <>", value, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsGreaterThan(String value) {
            addCriterion("main_products >", value, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsGreaterThanOrEqualTo(String value) {
            addCriterion("main_products >=", value, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsLessThan(String value) {
            addCriterion("main_products <", value, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsLessThanOrEqualTo(String value) {
            addCriterion("main_products <=", value, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsLike(String value) {
            addCriterion("main_products like", value, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsNotLike(String value) {
            addCriterion("main_products not like", value, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsIn(List<String> values) {
            addCriterion("main_products in", values, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsNotIn(List<String> values) {
            addCriterion("main_products not in", values, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsBetween(String value1, String value2) {
            addCriterion("main_products between", value1, value2, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainProductsNotBetween(String value1, String value2) {
            addCriterion("main_products not between", value1, value2, "mainProducts");
            return (Criteria) this;
        }

        public Criteria andMainBrandIsNull() {
            addCriterion("main_brand is null");
            return (Criteria) this;
        }

        public Criteria andMainBrandIsNotNull() {
            addCriterion("main_brand is not null");
            return (Criteria) this;
        }

        public Criteria andMainBrandEqualTo(String value) {
            addCriterion("main_brand =", value, "mainBrand");
            return (Criteria) this;
        }

        public Criteria andMainBrandNotEqualTo(String value) {
            addCriterion("main_brand <>", value, "mainBrand");
            return (Criteria) this;
        }

        public Criteria andMainBrandGreaterThan(String value) {
            addCriterion("main_brand >", value, "mainBrand");
            return (Criteria) this;
        }

        public Criteria andMainBrandGreaterThanOrEqualTo(String value) {
            addCriterion("main_brand >=", value, "mainBrand");
            return (Criteria) this;
        }

        public Criteria andMainBrandLessThan(String value) {
            addCriterion("main_brand <", value, "mainBrand");
            return (Criteria) this;
        }

        public Criteria andMainBrandLessThanOrEqualTo(String value) {
            addCriterion("main_brand <=", value, "mainBrand");
            return (Criteria) this;
        }

        public Criteria andMainBrandLike(String value) {
            addCriterion("main_brand like", value, "mainBrand");
            return (Criteria) this;
        }

        public Criteria andMainBrandNotLike(String value) {
            addCriterion("main_brand not like", value, "mainBrand");
            return (Criteria) this;
        }

        public Criteria andMainBrandIn(List<String> values) {
            addCriterion("main_brand in", values, "mainBrand");
            return (Criteria) this;
        }

        public Criteria andMainBrandNotIn(List<String> values) {
            addCriterion("main_brand not in", values, "mainBrand");
            return (Criteria) this;
        }

        public Criteria andMainBrandBetween(String value1, String value2) {
            addCriterion("main_brand between", value1, value2, "mainBrand");
            return (Criteria) this;
        }

        public Criteria andMainBrandNotBetween(String value1, String value2) {
            addCriterion("main_brand not between", value1, value2, "mainBrand");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeIsNull() {
            addCriterion("merchant_type is null");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeIsNotNull() {
            addCriterion("merchant_type is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeEqualTo(Integer value) {
            addCriterion("merchant_type =", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotEqualTo(Integer value) {
            addCriterion("merchant_type <>", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeGreaterThan(Integer value) {
            addCriterion("merchant_type >", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("merchant_type >=", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeLessThan(Integer value) {
            addCriterion("merchant_type <", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeLessThanOrEqualTo(Integer value) {
            addCriterion("merchant_type <=", value, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeIn(List<Integer> values) {
            addCriterion("merchant_type in", values, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotIn(List<Integer> values) {
            addCriterion("merchant_type not in", values, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeBetween(Integer value1, Integer value2) {
            addCriterion("merchant_type between", value1, value2, "merchantType");
            return (Criteria) this;
        }

        public Criteria andMerchantTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("merchant_type not between", value1, value2, "merchantType");
            return (Criteria) this;
        }

        public Criteria andStepIsNull() {
            addCriterion("step is null");
            return (Criteria) this;
        }

        public Criteria andStepIsNotNull() {
            addCriterion("step is not null");
            return (Criteria) this;
        }

        public Criteria andStepEqualTo(Integer value) {
            addCriterion("step =", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotEqualTo(Integer value) {
            addCriterion("step <>", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThan(Integer value) {
            addCriterion("step >", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepGreaterThanOrEqualTo(Integer value) {
            addCriterion("step >=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThan(Integer value) {
            addCriterion("step <", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepLessThanOrEqualTo(Integer value) {
            addCriterion("step <=", value, "step");
            return (Criteria) this;
        }

        public Criteria andStepIn(List<Integer> values) {
            addCriterion("step in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotIn(List<Integer> values) {
            addCriterion("step not in", values, "step");
            return (Criteria) this;
        }

        public Criteria andStepBetween(Integer value1, Integer value2) {
            addCriterion("step between", value1, value2, "step");
            return (Criteria) this;
        }

        public Criteria andStepNotBetween(Integer value1, Integer value2) {
            addCriterion("step not between", value1, value2, "step");
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

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("parent_id like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("parent_id not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andBankNoIsNull() {
            addCriterion("bank_no is null");
            return (Criteria) this;
        }

        public Criteria andBankNoIsNotNull() {
            addCriterion("bank_no is not null");
            return (Criteria) this;
        }

        public Criteria andBankNoEqualTo(String value) {
            addCriterion("bank_no =", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotEqualTo(String value) {
            addCriterion("bank_no <>", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoGreaterThan(String value) {
            addCriterion("bank_no >", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoGreaterThanOrEqualTo(String value) {
            addCriterion("bank_no >=", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoLessThan(String value) {
            addCriterion("bank_no <", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoLessThanOrEqualTo(String value) {
            addCriterion("bank_no <=", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoLike(String value) {
            addCriterion("bank_no like", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotLike(String value) {
            addCriterion("bank_no not like", value, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoIn(List<String> values) {
            addCriterion("bank_no in", values, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotIn(List<String> values) {
            addCriterion("bank_no not in", values, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoBetween(String value1, String value2) {
            addCriterion("bank_no between", value1, value2, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankNoNotBetween(String value1, String value2) {
            addCriterion("bank_no not between", value1, value2, "bankNo");
            return (Criteria) this;
        }

        public Criteria andBankAddressIsNull() {
            addCriterion("bank_address is null");
            return (Criteria) this;
        }

        public Criteria andBankAddressIsNotNull() {
            addCriterion("bank_address is not null");
            return (Criteria) this;
        }

        public Criteria andBankAddressEqualTo(String value) {
            addCriterion("bank_address =", value, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressNotEqualTo(String value) {
            addCriterion("bank_address <>", value, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressGreaterThan(String value) {
            addCriterion("bank_address >", value, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressGreaterThanOrEqualTo(String value) {
            addCriterion("bank_address >=", value, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressLessThan(String value) {
            addCriterion("bank_address <", value, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressLessThanOrEqualTo(String value) {
            addCriterion("bank_address <=", value, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressLike(String value) {
            addCriterion("bank_address like", value, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressNotLike(String value) {
            addCriterion("bank_address not like", value, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressIn(List<String> values) {
            addCriterion("bank_address in", values, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressNotIn(List<String> values) {
            addCriterion("bank_address not in", values, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressBetween(String value1, String value2) {
            addCriterion("bank_address between", value1, value2, "bankAddress");
            return (Criteria) this;
        }

        public Criteria andBankAddressNotBetween(String value1, String value2) {
            addCriterion("bank_address not between", value1, value2, "bankAddress");
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

        public Criteria andAddUserIsNull() {
            addCriterion("add_user is null");
            return (Criteria) this;
        }

        public Criteria andAddUserIsNotNull() {
            addCriterion("add_user is not null");
            return (Criteria) this;
        }

        public Criteria andAddUserEqualTo(String value) {
            addCriterion("add_user =", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserNotEqualTo(String value) {
            addCriterion("add_user <>", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserGreaterThan(String value) {
            addCriterion("add_user >", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserGreaterThanOrEqualTo(String value) {
            addCriterion("add_user >=", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserLessThan(String value) {
            addCriterion("add_user <", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserLessThanOrEqualTo(String value) {
            addCriterion("add_user <=", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserLike(String value) {
            addCriterion("add_user like", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserNotLike(String value) {
            addCriterion("add_user not like", value, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserIn(List<String> values) {
            addCriterion("add_user in", values, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserNotIn(List<String> values) {
            addCriterion("add_user not in", values, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserBetween(String value1, String value2) {
            addCriterion("add_user between", value1, value2, "addUser");
            return (Criteria) this;
        }

        public Criteria andAddUserNotBetween(String value1, String value2) {
            addCriterion("add_user not between", value1, value2, "addUser");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIsNull() {
            addCriterion("last_update is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIsNotNull() {
            addCriterion("last_update is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateEqualTo(Date value) {
            addCriterion("last_update =", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotEqualTo(Date value) {
            addCriterion("last_update <>", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateGreaterThan(Date value) {
            addCriterion("last_update >", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_update >=", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLessThan(Date value) {
            addCriterion("last_update <", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateLessThanOrEqualTo(Date value) {
            addCriterion("last_update <=", value, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateIn(List<Date> values) {
            addCriterion("last_update in", values, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotIn(List<Date> values) {
            addCriterion("last_update not in", values, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateBetween(Date value1, Date value2) {
            addCriterion("last_update between", value1, value2, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdateNotBetween(Date value1, Date value2) {
            addCriterion("last_update not between", value1, value2, "lastUpdate");
            return (Criteria) this;
        }

        public Criteria andLastUpdaterIsNull() {
            addCriterion("last_updater is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdaterIsNotNull() {
            addCriterion("last_updater is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdaterEqualTo(String value) {
            addCriterion("last_updater =", value, "lastUpdater");
            return (Criteria) this;
        }

        public Criteria andLastUpdaterNotEqualTo(String value) {
            addCriterion("last_updater <>", value, "lastUpdater");
            return (Criteria) this;
        }

        public Criteria andLastUpdaterGreaterThan(String value) {
            addCriterion("last_updater >", value, "lastUpdater");
            return (Criteria) this;
        }

        public Criteria andLastUpdaterGreaterThanOrEqualTo(String value) {
            addCriterion("last_updater >=", value, "lastUpdater");
            return (Criteria) this;
        }

        public Criteria andLastUpdaterLessThan(String value) {
            addCriterion("last_updater <", value, "lastUpdater");
            return (Criteria) this;
        }

        public Criteria andLastUpdaterLessThanOrEqualTo(String value) {
            addCriterion("last_updater <=", value, "lastUpdater");
            return (Criteria) this;
        }

        public Criteria andLastUpdaterLike(String value) {
            addCriterion("last_updater like", value, "lastUpdater");
            return (Criteria) this;
        }

        public Criteria andLastUpdaterNotLike(String value) {
            addCriterion("last_updater not like", value, "lastUpdater");
            return (Criteria) this;
        }

        public Criteria andLastUpdaterIn(List<String> values) {
            addCriterion("last_updater in", values, "lastUpdater");
            return (Criteria) this;
        }

        public Criteria andLastUpdaterNotIn(List<String> values) {
            addCriterion("last_updater not in", values, "lastUpdater");
            return (Criteria) this;
        }

        public Criteria andLastUpdaterBetween(String value1, String value2) {
            addCriterion("last_updater between", value1, value2, "lastUpdater");
            return (Criteria) this;
        }

        public Criteria andLastUpdaterNotBetween(String value1, String value2) {
            addCriterion("last_updater not between", value1, value2, "lastUpdater");
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

        public Criteria andFaxNoIsNull() {
            addCriterion("fax_no is null");
            return (Criteria) this;
        }

        public Criteria andFaxNoIsNotNull() {
            addCriterion("fax_no is not null");
            return (Criteria) this;
        }

        public Criteria andFaxNoEqualTo(String value) {
            addCriterion("fax_no =", value, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoNotEqualTo(String value) {
            addCriterion("fax_no <>", value, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoGreaterThan(String value) {
            addCriterion("fax_no >", value, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoGreaterThanOrEqualTo(String value) {
            addCriterion("fax_no >=", value, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoLessThan(String value) {
            addCriterion("fax_no <", value, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoLessThanOrEqualTo(String value) {
            addCriterion("fax_no <=", value, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoLike(String value) {
            addCriterion("fax_no like", value, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoNotLike(String value) {
            addCriterion("fax_no not like", value, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoIn(List<String> values) {
            addCriterion("fax_no in", values, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoNotIn(List<String> values) {
            addCriterion("fax_no not in", values, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoBetween(String value1, String value2) {
            addCriterion("fax_no between", value1, value2, "faxNo");
            return (Criteria) this;
        }

        public Criteria andFaxNoNotBetween(String value1, String value2) {
            addCriterion("fax_no not between", value1, value2, "faxNo");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNull() {
            addCriterion("credit_code is null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNotNull() {
            addCriterion("credit_code is not null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeEqualTo(String value) {
            addCriterion("credit_code =", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotEqualTo(String value) {
            addCriterion("credit_code <>", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThan(String value) {
            addCriterion("credit_code >", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThanOrEqualTo(String value) {
            addCriterion("credit_code >=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThan(String value) {
            addCriterion("credit_code <", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThanOrEqualTo(String value) {
            addCriterion("credit_code <=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLike(String value) {
            addCriterion("credit_code like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotLike(String value) {
            addCriterion("credit_code not like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIn(List<String> values) {
            addCriterion("credit_code in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotIn(List<String> values) {
            addCriterion("credit_code not in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeBetween(String value1, String value2) {
            addCriterion("credit_code between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotBetween(String value1, String value2) {
            addCriterion("credit_code not between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andMarketingNoIsNull() {
            addCriterion("marketing_no is null");
            return (Criteria) this;
        }

        public Criteria andMarketingNoIsNotNull() {
            addCriterion("marketing_no is not null");
            return (Criteria) this;
        }

        public Criteria andMarketingNoEqualTo(String value) {
            addCriterion("marketing_no =", value, "marketingNo");
            return (Criteria) this;
        }

        public Criteria andMarketingNoNotEqualTo(String value) {
            addCriterion("marketing_no <>", value, "marketingNo");
            return (Criteria) this;
        }

        public Criteria andMarketingNoGreaterThan(String value) {
            addCriterion("marketing_no >", value, "marketingNo");
            return (Criteria) this;
        }

        public Criteria andMarketingNoGreaterThanOrEqualTo(String value) {
            addCriterion("marketing_no >=", value, "marketingNo");
            return (Criteria) this;
        }

        public Criteria andMarketingNoLessThan(String value) {
            addCriterion("marketing_no <", value, "marketingNo");
            return (Criteria) this;
        }

        public Criteria andMarketingNoLessThanOrEqualTo(String value) {
            addCriterion("marketing_no <=", value, "marketingNo");
            return (Criteria) this;
        }

        public Criteria andMarketingNoLike(String value) {
            addCriterion("marketing_no like", value, "marketingNo");
            return (Criteria) this;
        }

        public Criteria andMarketingNoNotLike(String value) {
            addCriterion("marketing_no not like", value, "marketingNo");
            return (Criteria) this;
        }

        public Criteria andMarketingNoIn(List<String> values) {
            addCriterion("marketing_no in", values, "marketingNo");
            return (Criteria) this;
        }

        public Criteria andMarketingNoNotIn(List<String> values) {
            addCriterion("marketing_no not in", values, "marketingNo");
            return (Criteria) this;
        }

        public Criteria andMarketingNoBetween(String value1, String value2) {
            addCriterion("marketing_no between", value1, value2, "marketingNo");
            return (Criteria) this;
        }

        public Criteria andMarketingNoNotBetween(String value1, String value2) {
            addCriterion("marketing_no not between", value1, value2, "marketingNo");
            return (Criteria) this;
        }

        public Criteria andBankUserIsNull() {
            addCriterion("bank_user is null");
            return (Criteria) this;
        }

        public Criteria andBankUserIsNotNull() {
            addCriterion("bank_user is not null");
            return (Criteria) this;
        }

        public Criteria andBankUserEqualTo(String value) {
            addCriterion("bank_user =", value, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserNotEqualTo(String value) {
            addCriterion("bank_user <>", value, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserGreaterThan(String value) {
            addCriterion("bank_user >", value, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserGreaterThanOrEqualTo(String value) {
            addCriterion("bank_user >=", value, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserLessThan(String value) {
            addCriterion("bank_user <", value, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserLessThanOrEqualTo(String value) {
            addCriterion("bank_user <=", value, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserLike(String value) {
            addCriterion("bank_user like", value, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserNotLike(String value) {
            addCriterion("bank_user not like", value, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserIn(List<String> values) {
            addCriterion("bank_user in", values, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserNotIn(List<String> values) {
            addCriterion("bank_user not in", values, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserBetween(String value1, String value2) {
            addCriterion("bank_user between", value1, value2, "bankUser");
            return (Criteria) this;
        }

        public Criteria andBankUserNotBetween(String value1, String value2) {
            addCriterion("bank_user not between", value1, value2, "bankUser");
            return (Criteria) this;
        }

        public Criteria andSystemNameIsNull() {
            addCriterion("system_name is null");
            return (Criteria) this;
        }

        public Criteria andSystemNameIsNotNull() {
            addCriterion("system_name is not null");
            return (Criteria) this;
        }

        public Criteria andSystemNameEqualTo(String value) {
            addCriterion("system_name =", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotEqualTo(String value) {
            addCriterion("system_name <>", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameGreaterThan(String value) {
            addCriterion("system_name >", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameGreaterThanOrEqualTo(String value) {
            addCriterion("system_name >=", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameLessThan(String value) {
            addCriterion("system_name <", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameLessThanOrEqualTo(String value) {
            addCriterion("system_name <=", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameLike(String value) {
            addCriterion("system_name like", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotLike(String value) {
            addCriterion("system_name not like", value, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameIn(List<String> values) {
            addCriterion("system_name in", values, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotIn(List<String> values) {
            addCriterion("system_name not in", values, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameBetween(String value1, String value2) {
            addCriterion("system_name between", value1, value2, "systemName");
            return (Criteria) this;
        }

        public Criteria andSystemNameNotBetween(String value1, String value2) {
            addCriterion("system_name not between", value1, value2, "systemName");
            return (Criteria) this;
        }

        public Criteria andAcquirerIsNull() {
            addCriterion("acquirer is null");
            return (Criteria) this;
        }

        public Criteria andAcquirerIsNotNull() {
            addCriterion("acquirer is not null");
            return (Criteria) this;
        }

        public Criteria andAcquirerEqualTo(String value) {
            addCriterion("acquirer =", value, "acquirer");
            return (Criteria) this;
        }

        public Criteria andAcquirerNotEqualTo(String value) {
            addCriterion("acquirer <>", value, "acquirer");
            return (Criteria) this;
        }

        public Criteria andAcquirerGreaterThan(String value) {
            addCriterion("acquirer >", value, "acquirer");
            return (Criteria) this;
        }

        public Criteria andAcquirerGreaterThanOrEqualTo(String value) {
            addCriterion("acquirer >=", value, "acquirer");
            return (Criteria) this;
        }

        public Criteria andAcquirerLessThan(String value) {
            addCriterion("acquirer <", value, "acquirer");
            return (Criteria) this;
        }

        public Criteria andAcquirerLessThanOrEqualTo(String value) {
            addCriterion("acquirer <=", value, "acquirer");
            return (Criteria) this;
        }

        public Criteria andAcquirerLike(String value) {
            addCriterion("acquirer like", value, "acquirer");
            return (Criteria) this;
        }

        public Criteria andAcquirerNotLike(String value) {
            addCriterion("acquirer not like", value, "acquirer");
            return (Criteria) this;
        }

        public Criteria andAcquirerIn(List<String> values) {
            addCriterion("acquirer in", values, "acquirer");
            return (Criteria) this;
        }

        public Criteria andAcquirerNotIn(List<String> values) {
            addCriterion("acquirer not in", values, "acquirer");
            return (Criteria) this;
        }

        public Criteria andAcquirerBetween(String value1, String value2) {
            addCriterion("acquirer between", value1, value2, "acquirer");
            return (Criteria) this;
        }

        public Criteria andAcquirerNotBetween(String value1, String value2) {
            addCriterion("acquirer not between", value1, value2, "acquirer");
            return (Criteria) this;
        }

        public Criteria andFansIsNull() {
            addCriterion("fans is null");
            return (Criteria) this;
        }

        public Criteria andFansIsNotNull() {
            addCriterion("fans is not null");
            return (Criteria) this;
        }

        public Criteria andFansEqualTo(Integer value) {
            addCriterion("fans =", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansNotEqualTo(Integer value) {
            addCriterion("fans <>", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansGreaterThan(Integer value) {
            addCriterion("fans >", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansGreaterThanOrEqualTo(Integer value) {
            addCriterion("fans >=", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansLessThan(Integer value) {
            addCriterion("fans <", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansLessThanOrEqualTo(Integer value) {
            addCriterion("fans <=", value, "fans");
            return (Criteria) this;
        }

        public Criteria andFansIn(List<Integer> values) {
            addCriterion("fans in", values, "fans");
            return (Criteria) this;
        }

        public Criteria andFansNotIn(List<Integer> values) {
            addCriterion("fans not in", values, "fans");
            return (Criteria) this;
        }

        public Criteria andFansBetween(Integer value1, Integer value2) {
            addCriterion("fans between", value1, value2, "fans");
            return (Criteria) this;
        }

        public Criteria andFansNotBetween(Integer value1, Integer value2) {
            addCriterion("fans not between", value1, value2, "fans");
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