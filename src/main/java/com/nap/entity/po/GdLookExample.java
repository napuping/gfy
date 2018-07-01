package com.nap.entity.po;

import java.util.ArrayList;
import java.util.List;

public class GdLookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GdLookExample() {
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

        public Criteria andLookIdIsNull() {
            addCriterion("look_id is null");
            return (Criteria) this;
        }

        public Criteria andLookIdIsNotNull() {
            addCriterion("look_id is not null");
            return (Criteria) this;
        }

        public Criteria andLookIdEqualTo(Integer value) {
            addCriterion("look_id =", value, "lookId");
            return (Criteria) this;
        }

        public Criteria andLookIdNotEqualTo(Integer value) {
            addCriterion("look_id <>", value, "lookId");
            return (Criteria) this;
        }

        public Criteria andLookIdGreaterThan(Integer value) {
            addCriterion("look_id >", value, "lookId");
            return (Criteria) this;
        }

        public Criteria andLookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("look_id >=", value, "lookId");
            return (Criteria) this;
        }

        public Criteria andLookIdLessThan(Integer value) {
            addCriterion("look_id <", value, "lookId");
            return (Criteria) this;
        }

        public Criteria andLookIdLessThanOrEqualTo(Integer value) {
            addCriterion("look_id <=", value, "lookId");
            return (Criteria) this;
        }

        public Criteria andLookIdIn(List<Integer> values) {
            addCriterion("look_id in", values, "lookId");
            return (Criteria) this;
        }

        public Criteria andLookIdNotIn(List<Integer> values) {
            addCriterion("look_id not in", values, "lookId");
            return (Criteria) this;
        }

        public Criteria andLookIdBetween(Integer value1, Integer value2) {
            addCriterion("look_id between", value1, value2, "lookId");
            return (Criteria) this;
        }

        public Criteria andLookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("look_id not between", value1, value2, "lookId");
            return (Criteria) this;
        }

        public Criteria andLookipIsNull() {
            addCriterion("lookip is null");
            return (Criteria) this;
        }

        public Criteria andLookipIsNotNull() {
            addCriterion("lookip is not null");
            return (Criteria) this;
        }

        public Criteria andLookipEqualTo(String value) {
            addCriterion("lookip =", value, "lookip");
            return (Criteria) this;
        }

        public Criteria andLookipNotEqualTo(String value) {
            addCriterion("lookip <>", value, "lookip");
            return (Criteria) this;
        }

        public Criteria andLookipGreaterThan(String value) {
            addCriterion("lookip >", value, "lookip");
            return (Criteria) this;
        }

        public Criteria andLookipGreaterThanOrEqualTo(String value) {
            addCriterion("lookip >=", value, "lookip");
            return (Criteria) this;
        }

        public Criteria andLookipLessThan(String value) {
            addCriterion("lookip <", value, "lookip");
            return (Criteria) this;
        }

        public Criteria andLookipLessThanOrEqualTo(String value) {
            addCriterion("lookip <=", value, "lookip");
            return (Criteria) this;
        }

        public Criteria andLookipLike(String value) {
            addCriterion("lookip like", value, "lookip");
            return (Criteria) this;
        }

        public Criteria andLookipNotLike(String value) {
            addCriterion("lookip not like", value, "lookip");
            return (Criteria) this;
        }

        public Criteria andLookipIn(List<String> values) {
            addCriterion("lookip in", values, "lookip");
            return (Criteria) this;
        }

        public Criteria andLookipNotIn(List<String> values) {
            addCriterion("lookip not in", values, "lookip");
            return (Criteria) this;
        }

        public Criteria andLookipBetween(String value1, String value2) {
            addCriterion("lookip between", value1, value2, "lookip");
            return (Criteria) this;
        }

        public Criteria andLookipNotBetween(String value1, String value2) {
            addCriterion("lookip not between", value1, value2, "lookip");
            return (Criteria) this;
        }

        public Criteria andLookerIsNull() {
            addCriterion("looker is null");
            return (Criteria) this;
        }

        public Criteria andLookerIsNotNull() {
            addCriterion("looker is not null");
            return (Criteria) this;
        }

        public Criteria andLookerEqualTo(String value) {
            addCriterion("looker =", value, "looker");
            return (Criteria) this;
        }

        public Criteria andLookerNotEqualTo(String value) {
            addCriterion("looker <>", value, "looker");
            return (Criteria) this;
        }

        public Criteria andLookerGreaterThan(String value) {
            addCriterion("looker >", value, "looker");
            return (Criteria) this;
        }

        public Criteria andLookerGreaterThanOrEqualTo(String value) {
            addCriterion("looker >=", value, "looker");
            return (Criteria) this;
        }

        public Criteria andLookerLessThan(String value) {
            addCriterion("looker <", value, "looker");
            return (Criteria) this;
        }

        public Criteria andLookerLessThanOrEqualTo(String value) {
            addCriterion("looker <=", value, "looker");
            return (Criteria) this;
        }

        public Criteria andLookerLike(String value) {
            addCriterion("looker like", value, "looker");
            return (Criteria) this;
        }

        public Criteria andLookerNotLike(String value) {
            addCriterion("looker not like", value, "looker");
            return (Criteria) this;
        }

        public Criteria andLookerIn(List<String> values) {
            addCriterion("looker in", values, "looker");
            return (Criteria) this;
        }

        public Criteria andLookerNotIn(List<String> values) {
            addCriterion("looker not in", values, "looker");
            return (Criteria) this;
        }

        public Criteria andLookerBetween(String value1, String value2) {
            addCriterion("looker between", value1, value2, "looker");
            return (Criteria) this;
        }

        public Criteria andLookerNotBetween(String value1, String value2) {
            addCriterion("looker not between", value1, value2, "looker");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
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