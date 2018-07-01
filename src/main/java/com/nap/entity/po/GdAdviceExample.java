package com.nap.entity.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GdAdviceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GdAdviceExample() {
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

        public Criteria andAdviceIdIsNull() {
            addCriterion("advice_id is null");
            return (Criteria) this;
        }

        public Criteria andAdviceIdIsNotNull() {
            addCriterion("advice_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdviceIdEqualTo(Integer value) {
            addCriterion("advice_id =", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdNotEqualTo(Integer value) {
            addCriterion("advice_id <>", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdGreaterThan(Integer value) {
            addCriterion("advice_id >", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("advice_id >=", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdLessThan(Integer value) {
            addCriterion("advice_id <", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdLessThanOrEqualTo(Integer value) {
            addCriterion("advice_id <=", value, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdIn(List<Integer> values) {
            addCriterion("advice_id in", values, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdNotIn(List<Integer> values) {
            addCriterion("advice_id not in", values, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdBetween(Integer value1, Integer value2) {
            addCriterion("advice_id between", value1, value2, "adviceId");
            return (Criteria) this;
        }

        public Criteria andAdviceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("advice_id not between", value1, value2, "adviceId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andAdvicetimeIsNull() {
            addCriterion("advicetime is null");
            return (Criteria) this;
        }

        public Criteria andAdvicetimeIsNotNull() {
            addCriterion("advicetime is not null");
            return (Criteria) this;
        }

        public Criteria andAdvicetimeEqualTo(Date value) {
            addCriterion("advicetime =", value, "advicetime");
            return (Criteria) this;
        }

        public Criteria andAdvicetimeNotEqualTo(Date value) {
            addCriterion("advicetime <>", value, "advicetime");
            return (Criteria) this;
        }

        public Criteria andAdvicetimeGreaterThan(Date value) {
            addCriterion("advicetime >", value, "advicetime");
            return (Criteria) this;
        }

        public Criteria andAdvicetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("advicetime >=", value, "advicetime");
            return (Criteria) this;
        }

        public Criteria andAdvicetimeLessThan(Date value) {
            addCriterion("advicetime <", value, "advicetime");
            return (Criteria) this;
        }

        public Criteria andAdvicetimeLessThanOrEqualTo(Date value) {
            addCriterion("advicetime <=", value, "advicetime");
            return (Criteria) this;
        }

        public Criteria andAdvicetimeIn(List<Date> values) {
            addCriterion("advicetime in", values, "advicetime");
            return (Criteria) this;
        }

        public Criteria andAdvicetimeNotIn(List<Date> values) {
            addCriterion("advicetime not in", values, "advicetime");
            return (Criteria) this;
        }

        public Criteria andAdvicetimeBetween(Date value1, Date value2) {
            addCriterion("advicetime between", value1, value2, "advicetime");
            return (Criteria) this;
        }

        public Criteria andAdvicetimeNotBetween(Date value1, Date value2) {
            addCriterion("advicetime not between", value1, value2, "advicetime");
            return (Criteria) this;
        }

        public Criteria andAdvicedescIsNull() {
            addCriterion("advicedesc is null");
            return (Criteria) this;
        }

        public Criteria andAdvicedescIsNotNull() {
            addCriterion("advicedesc is not null");
            return (Criteria) this;
        }

        public Criteria andAdvicedescEqualTo(String value) {
            addCriterion("advicedesc =", value, "advicedesc");
            return (Criteria) this;
        }

        public Criteria andAdvicedescNotEqualTo(String value) {
            addCriterion("advicedesc <>", value, "advicedesc");
            return (Criteria) this;
        }

        public Criteria andAdvicedescGreaterThan(String value) {
            addCriterion("advicedesc >", value, "advicedesc");
            return (Criteria) this;
        }

        public Criteria andAdvicedescGreaterThanOrEqualTo(String value) {
            addCriterion("advicedesc >=", value, "advicedesc");
            return (Criteria) this;
        }

        public Criteria andAdvicedescLessThan(String value) {
            addCriterion("advicedesc <", value, "advicedesc");
            return (Criteria) this;
        }

        public Criteria andAdvicedescLessThanOrEqualTo(String value) {
            addCriterion("advicedesc <=", value, "advicedesc");
            return (Criteria) this;
        }

        public Criteria andAdvicedescLike(String value) {
            addCriterion("advicedesc like", value, "advicedesc");
            return (Criteria) this;
        }

        public Criteria andAdvicedescNotLike(String value) {
            addCriterion("advicedesc not like", value, "advicedesc");
            return (Criteria) this;
        }

        public Criteria andAdvicedescIn(List<String> values) {
            addCriterion("advicedesc in", values, "advicedesc");
            return (Criteria) this;
        }

        public Criteria andAdvicedescNotIn(List<String> values) {
            addCriterion("advicedesc not in", values, "advicedesc");
            return (Criteria) this;
        }

        public Criteria andAdvicedescBetween(String value1, String value2) {
            addCriterion("advicedesc between", value1, value2, "advicedesc");
            return (Criteria) this;
        }

        public Criteria andAdvicedescNotBetween(String value1, String value2) {
            addCriterion("advicedesc not between", value1, value2, "advicedesc");
            return (Criteria) this;
        }

        public Criteria andIsreadIsNull() {
            addCriterion("isread is null");
            return (Criteria) this;
        }

        public Criteria andIsreadIsNotNull() {
            addCriterion("isread is not null");
            return (Criteria) this;
        }

        public Criteria andIsreadEqualTo(String value) {
            addCriterion("isread =", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadNotEqualTo(String value) {
            addCriterion("isread <>", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadGreaterThan(String value) {
            addCriterion("isread >", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadGreaterThanOrEqualTo(String value) {
            addCriterion("isread >=", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadLessThan(String value) {
            addCriterion("isread <", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadLessThanOrEqualTo(String value) {
            addCriterion("isread <=", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadLike(String value) {
            addCriterion("isread like", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadNotLike(String value) {
            addCriterion("isread not like", value, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadIn(List<String> values) {
            addCriterion("isread in", values, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadNotIn(List<String> values) {
            addCriterion("isread not in", values, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadBetween(String value1, String value2) {
            addCriterion("isread between", value1, value2, "isread");
            return (Criteria) this;
        }

        public Criteria andIsreadNotBetween(String value1, String value2) {
            addCriterion("isread not between", value1, value2, "isread");
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