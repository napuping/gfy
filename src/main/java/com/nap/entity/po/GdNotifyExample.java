package com.nap.entity.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GdNotifyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GdNotifyExample() {
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

        public Criteria andNotifyIdIsNull() {
            addCriterion("notify_id is null");
            return (Criteria) this;
        }

        public Criteria andNotifyIdIsNotNull() {
            addCriterion("notify_id is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyIdEqualTo(Integer value) {
            addCriterion("notify_id =", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdNotEqualTo(Integer value) {
            addCriterion("notify_id <>", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdGreaterThan(Integer value) {
            addCriterion("notify_id >", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("notify_id >=", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdLessThan(Integer value) {
            addCriterion("notify_id <", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdLessThanOrEqualTo(Integer value) {
            addCriterion("notify_id <=", value, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdIn(List<Integer> values) {
            addCriterion("notify_id in", values, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdNotIn(List<Integer> values) {
            addCriterion("notify_id not in", values, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdBetween(Integer value1, Integer value2) {
            addCriterion("notify_id between", value1, value2, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifyIdNotBetween(Integer value1, Integer value2) {
            addCriterion("notify_id not between", value1, value2, "notifyId");
            return (Criteria) this;
        }

        public Criteria andNotifytitleIsNull() {
            addCriterion("notifytitle is null");
            return (Criteria) this;
        }

        public Criteria andNotifytitleIsNotNull() {
            addCriterion("notifytitle is not null");
            return (Criteria) this;
        }

        public Criteria andNotifytitleEqualTo(String value) {
            addCriterion("notifytitle =", value, "notifytitle");
            return (Criteria) this;
        }

        public Criteria andNotifytitleNotEqualTo(String value) {
            addCriterion("notifytitle <>", value, "notifytitle");
            return (Criteria) this;
        }

        public Criteria andNotifytitleGreaterThan(String value) {
            addCriterion("notifytitle >", value, "notifytitle");
            return (Criteria) this;
        }

        public Criteria andNotifytitleGreaterThanOrEqualTo(String value) {
            addCriterion("notifytitle >=", value, "notifytitle");
            return (Criteria) this;
        }

        public Criteria andNotifytitleLessThan(String value) {
            addCriterion("notifytitle <", value, "notifytitle");
            return (Criteria) this;
        }

        public Criteria andNotifytitleLessThanOrEqualTo(String value) {
            addCriterion("notifytitle <=", value, "notifytitle");
            return (Criteria) this;
        }

        public Criteria andNotifytitleLike(String value) {
            addCriterion("notifytitle like", value, "notifytitle");
            return (Criteria) this;
        }

        public Criteria andNotifytitleNotLike(String value) {
            addCriterion("notifytitle not like", value, "notifytitle");
            return (Criteria) this;
        }

        public Criteria andNotifytitleIn(List<String> values) {
            addCriterion("notifytitle in", values, "notifytitle");
            return (Criteria) this;
        }

        public Criteria andNotifytitleNotIn(List<String> values) {
            addCriterion("notifytitle not in", values, "notifytitle");
            return (Criteria) this;
        }

        public Criteria andNotifytitleBetween(String value1, String value2) {
            addCriterion("notifytitle between", value1, value2, "notifytitle");
            return (Criteria) this;
        }

        public Criteria andNotifytitleNotBetween(String value1, String value2) {
            addCriterion("notifytitle not between", value1, value2, "notifytitle");
            return (Criteria) this;
        }

        public Criteria andPflagIsNull() {
            addCriterion("pflag is null");
            return (Criteria) this;
        }

        public Criteria andPflagIsNotNull() {
            addCriterion("pflag is not null");
            return (Criteria) this;
        }

        public Criteria andPflagEqualTo(String value) {
            addCriterion("pflag =", value, "pflag");
            return (Criteria) this;
        }

        public Criteria andPflagNotEqualTo(String value) {
            addCriterion("pflag <>", value, "pflag");
            return (Criteria) this;
        }

        public Criteria andPflagGreaterThan(String value) {
            addCriterion("pflag >", value, "pflag");
            return (Criteria) this;
        }

        public Criteria andPflagGreaterThanOrEqualTo(String value) {
            addCriterion("pflag >=", value, "pflag");
            return (Criteria) this;
        }

        public Criteria andPflagLessThan(String value) {
            addCriterion("pflag <", value, "pflag");
            return (Criteria) this;
        }

        public Criteria andPflagLessThanOrEqualTo(String value) {
            addCriterion("pflag <=", value, "pflag");
            return (Criteria) this;
        }

        public Criteria andPflagLike(String value) {
            addCriterion("pflag like", value, "pflag");
            return (Criteria) this;
        }

        public Criteria andPflagNotLike(String value) {
            addCriterion("pflag not like", value, "pflag");
            return (Criteria) this;
        }

        public Criteria andPflagIn(List<String> values) {
            addCriterion("pflag in", values, "pflag");
            return (Criteria) this;
        }

        public Criteria andPflagNotIn(List<String> values) {
            addCriterion("pflag not in", values, "pflag");
            return (Criteria) this;
        }

        public Criteria andPflagBetween(String value1, String value2) {
            addCriterion("pflag between", value1, value2, "pflag");
            return (Criteria) this;
        }

        public Criteria andPflagNotBetween(String value1, String value2) {
            addCriterion("pflag not between", value1, value2, "pflag");
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

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(Integer value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(Integer value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(Integer value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(Integer value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<Integer> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<Integer> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andNotifytimeIsNull() {
            addCriterion("notifytime is null");
            return (Criteria) this;
        }

        public Criteria andNotifytimeIsNotNull() {
            addCriterion("notifytime is not null");
            return (Criteria) this;
        }

        public Criteria andNotifytimeEqualTo(Date value) {
            addCriterion("notifytime =", value, "notifytime");
            return (Criteria) this;
        }

        public Criteria andNotifytimeNotEqualTo(Date value) {
            addCriterion("notifytime <>", value, "notifytime");
            return (Criteria) this;
        }

        public Criteria andNotifytimeGreaterThan(Date value) {
            addCriterion("notifytime >", value, "notifytime");
            return (Criteria) this;
        }

        public Criteria andNotifytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("notifytime >=", value, "notifytime");
            return (Criteria) this;
        }

        public Criteria andNotifytimeLessThan(Date value) {
            addCriterion("notifytime <", value, "notifytime");
            return (Criteria) this;
        }

        public Criteria andNotifytimeLessThanOrEqualTo(Date value) {
            addCriterion("notifytime <=", value, "notifytime");
            return (Criteria) this;
        }

        public Criteria andNotifytimeIn(List<Date> values) {
            addCriterion("notifytime in", values, "notifytime");
            return (Criteria) this;
        }

        public Criteria andNotifytimeNotIn(List<Date> values) {
            addCriterion("notifytime not in", values, "notifytime");
            return (Criteria) this;
        }

        public Criteria andNotifytimeBetween(Date value1, Date value2) {
            addCriterion("notifytime between", value1, value2, "notifytime");
            return (Criteria) this;
        }

        public Criteria andNotifytimeNotBetween(Date value1, Date value2) {
            addCriterion("notifytime not between", value1, value2, "notifytime");
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