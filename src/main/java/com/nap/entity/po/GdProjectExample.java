package com.nap.entity.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GdProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GdProjectExample() {
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

        public Criteria andProjectnameIsNull() {
            addCriterion("projectname is null");
            return (Criteria) this;
        }

        public Criteria andProjectnameIsNotNull() {
            addCriterion("projectname is not null");
            return (Criteria) this;
        }

        public Criteria andProjectnameEqualTo(String value) {
            addCriterion("projectname =", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotEqualTo(String value) {
            addCriterion("projectname <>", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameGreaterThan(String value) {
            addCriterion("projectname >", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameGreaterThanOrEqualTo(String value) {
            addCriterion("projectname >=", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLessThan(String value) {
            addCriterion("projectname <", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLessThanOrEqualTo(String value) {
            addCriterion("projectname <=", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameLike(String value) {
            addCriterion("projectname like", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotLike(String value) {
            addCriterion("projectname not like", value, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameIn(List<String> values) {
            addCriterion("projectname in", values, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotIn(List<String> values) {
            addCriterion("projectname not in", values, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameBetween(String value1, String value2) {
            addCriterion("projectname between", value1, value2, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectnameNotBetween(String value1, String value2) {
            addCriterion("projectname not between", value1, value2, "projectname");
            return (Criteria) this;
        }

        public Criteria andProjectdescIsNull() {
            addCriterion("projectdesc is null");
            return (Criteria) this;
        }

        public Criteria andProjectdescIsNotNull() {
            addCriterion("projectdesc is not null");
            return (Criteria) this;
        }

        public Criteria andProjectdescEqualTo(String value) {
            addCriterion("projectdesc =", value, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescNotEqualTo(String value) {
            addCriterion("projectdesc <>", value, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescGreaterThan(String value) {
            addCriterion("projectdesc >", value, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescGreaterThanOrEqualTo(String value) {
            addCriterion("projectdesc >=", value, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescLessThan(String value) {
            addCriterion("projectdesc <", value, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescLessThanOrEqualTo(String value) {
            addCriterion("projectdesc <=", value, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescLike(String value) {
            addCriterion("projectdesc like", value, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescNotLike(String value) {
            addCriterion("projectdesc not like", value, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescIn(List<String> values) {
            addCriterion("projectdesc in", values, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescNotIn(List<String> values) {
            addCriterion("projectdesc not in", values, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescBetween(String value1, String value2) {
            addCriterion("projectdesc between", value1, value2, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andProjectdescNotBetween(String value1, String value2) {
            addCriterion("projectdesc not between", value1, value2, "projectdesc");
            return (Criteria) this;
        }

        public Criteria andFilepathIsNull() {
            addCriterion("filepath is null");
            return (Criteria) this;
        }

        public Criteria andFilepathIsNotNull() {
            addCriterion("filepath is not null");
            return (Criteria) this;
        }

        public Criteria andFilepathEqualTo(String value) {
            addCriterion("filepath =", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotEqualTo(String value) {
            addCriterion("filepath <>", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathGreaterThan(String value) {
            addCriterion("filepath >", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathGreaterThanOrEqualTo(String value) {
            addCriterion("filepath >=", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLessThan(String value) {
            addCriterion("filepath <", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLessThanOrEqualTo(String value) {
            addCriterion("filepath <=", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLike(String value) {
            addCriterion("filepath like", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotLike(String value) {
            addCriterion("filepath not like", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathIn(List<String> values) {
            addCriterion("filepath in", values, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotIn(List<String> values) {
            addCriterion("filepath not in", values, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathBetween(String value1, String value2) {
            addCriterion("filepath between", value1, value2, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotBetween(String value1, String value2) {
            addCriterion("filepath not between", value1, value2, "filepath");
            return (Criteria) this;
        }

        public Criteria andCommittimeIsNull() {
            addCriterion("committime is null");
            return (Criteria) this;
        }

        public Criteria andCommittimeIsNotNull() {
            addCriterion("committime is not null");
            return (Criteria) this;
        }

        public Criteria andCommittimeEqualTo(Date value) {
            addCriterion("committime =", value, "committime");
            return (Criteria) this;
        }

        public Criteria andCommittimeNotEqualTo(Date value) {
            addCriterion("committime <>", value, "committime");
            return (Criteria) this;
        }

        public Criteria andCommittimeGreaterThan(Date value) {
            addCriterion("committime >", value, "committime");
            return (Criteria) this;
        }

        public Criteria andCommittimeGreaterThanOrEqualTo(Date value) {
            addCriterion("committime >=", value, "committime");
            return (Criteria) this;
        }

        public Criteria andCommittimeLessThan(Date value) {
            addCriterion("committime <", value, "committime");
            return (Criteria) this;
        }

        public Criteria andCommittimeLessThanOrEqualTo(Date value) {
            addCriterion("committime <=", value, "committime");
            return (Criteria) this;
        }

        public Criteria andCommittimeIn(List<Date> values) {
            addCriterion("committime in", values, "committime");
            return (Criteria) this;
        }

        public Criteria andCommittimeNotIn(List<Date> values) {
            addCriterion("committime not in", values, "committime");
            return (Criteria) this;
        }

        public Criteria andCommittimeBetween(Date value1, Date value2) {
            addCriterion("committime between", value1, value2, "committime");
            return (Criteria) this;
        }

        public Criteria andCommittimeNotBetween(Date value1, Date value2) {
            addCriterion("committime not between", value1, value2, "committime");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andTypecodeIsNull() {
            addCriterion("typecode is null");
            return (Criteria) this;
        }

        public Criteria andTypecodeIsNotNull() {
            addCriterion("typecode is not null");
            return (Criteria) this;
        }

        public Criteria andTypecodeEqualTo(String value) {
            addCriterion("typecode =", value, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeNotEqualTo(String value) {
            addCriterion("typecode <>", value, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeGreaterThan(String value) {
            addCriterion("typecode >", value, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeGreaterThanOrEqualTo(String value) {
            addCriterion("typecode >=", value, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeLessThan(String value) {
            addCriterion("typecode <", value, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeLessThanOrEqualTo(String value) {
            addCriterion("typecode <=", value, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeLike(String value) {
            addCriterion("typecode like", value, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeNotLike(String value) {
            addCriterion("typecode not like", value, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeIn(List<String> values) {
            addCriterion("typecode in", values, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeNotIn(List<String> values) {
            addCriterion("typecode not in", values, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeBetween(String value1, String value2) {
            addCriterion("typecode between", value1, value2, "typecode");
            return (Criteria) this;
        }

        public Criteria andTypecodeNotBetween(String value1, String value2) {
            addCriterion("typecode not between", value1, value2, "typecode");
            return (Criteria) this;
        }

        public Criteria andLancodeIsNull() {
            addCriterion("lancode is null");
            return (Criteria) this;
        }

        public Criteria andLancodeIsNotNull() {
            addCriterion("lancode is not null");
            return (Criteria) this;
        }

        public Criteria andLancodeEqualTo(String value) {
            addCriterion("lancode =", value, "lancode");
            return (Criteria) this;
        }

        public Criteria andLancodeNotEqualTo(String value) {
            addCriterion("lancode <>", value, "lancode");
            return (Criteria) this;
        }

        public Criteria andLancodeGreaterThan(String value) {
            addCriterion("lancode >", value, "lancode");
            return (Criteria) this;
        }

        public Criteria andLancodeGreaterThanOrEqualTo(String value) {
            addCriterion("lancode >=", value, "lancode");
            return (Criteria) this;
        }

        public Criteria andLancodeLessThan(String value) {
            addCriterion("lancode <", value, "lancode");
            return (Criteria) this;
        }

        public Criteria andLancodeLessThanOrEqualTo(String value) {
            addCriterion("lancode <=", value, "lancode");
            return (Criteria) this;
        }

        public Criteria andLancodeLike(String value) {
            addCriterion("lancode like", value, "lancode");
            return (Criteria) this;
        }

        public Criteria andLancodeNotLike(String value) {
            addCriterion("lancode not like", value, "lancode");
            return (Criteria) this;
        }

        public Criteria andLancodeIn(List<String> values) {
            addCriterion("lancode in", values, "lancode");
            return (Criteria) this;
        }

        public Criteria andLancodeNotIn(List<String> values) {
            addCriterion("lancode not in", values, "lancode");
            return (Criteria) this;
        }

        public Criteria andLancodeBetween(String value1, String value2) {
            addCriterion("lancode between", value1, value2, "lancode");
            return (Criteria) this;
        }

        public Criteria andLancodeNotBetween(String value1, String value2) {
            addCriterion("lancode not between", value1, value2, "lancode");
            return (Criteria) this;
        }

        public Criteria andOrdernumIsNull() {
            addCriterion("ordernum is null");
            return (Criteria) this;
        }

        public Criteria andOrdernumIsNotNull() {
            addCriterion("ordernum is not null");
            return (Criteria) this;
        }

        public Criteria andOrdernumEqualTo(String value) {
            addCriterion("ordernum =", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotEqualTo(String value) {
            addCriterion("ordernum <>", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThan(String value) {
            addCriterion("ordernum >", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumGreaterThanOrEqualTo(String value) {
            addCriterion("ordernum >=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThan(String value) {
            addCriterion("ordernum <", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLessThanOrEqualTo(String value) {
            addCriterion("ordernum <=", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumLike(String value) {
            addCriterion("ordernum like", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotLike(String value) {
            addCriterion("ordernum not like", value, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumIn(List<String> values) {
            addCriterion("ordernum in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotIn(List<String> values) {
            addCriterion("ordernum not in", values, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumBetween(String value1, String value2) {
            addCriterion("ordernum between", value1, value2, "ordernum");
            return (Criteria) this;
        }

        public Criteria andOrdernumNotBetween(String value1, String value2) {
            addCriterion("ordernum not between", value1, value2, "ordernum");
            return (Criteria) this;
        }

        public Criteria andIsanonymousIsNull() {
            addCriterion("isanonymous is null");
            return (Criteria) this;
        }

        public Criteria andIsanonymousIsNotNull() {
            addCriterion("isanonymous is not null");
            return (Criteria) this;
        }

        public Criteria andIsanonymousEqualTo(String value) {
            addCriterion("isanonymous =", value, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousNotEqualTo(String value) {
            addCriterion("isanonymous <>", value, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousGreaterThan(String value) {
            addCriterion("isanonymous >", value, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousGreaterThanOrEqualTo(String value) {
            addCriterion("isanonymous >=", value, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousLessThan(String value) {
            addCriterion("isanonymous <", value, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousLessThanOrEqualTo(String value) {
            addCriterion("isanonymous <=", value, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousLike(String value) {
            addCriterion("isanonymous like", value, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousNotLike(String value) {
            addCriterion("isanonymous not like", value, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousIn(List<String> values) {
            addCriterion("isanonymous in", values, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousNotIn(List<String> values) {
            addCriterion("isanonymous not in", values, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousBetween(String value1, String value2) {
            addCriterion("isanonymous between", value1, value2, "isanonymous");
            return (Criteria) this;
        }

        public Criteria andIsanonymousNotBetween(String value1, String value2) {
            addCriterion("isanonymous not between", value1, value2, "isanonymous");
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

        public Criteria andContactwayIsNull() {
            addCriterion("contactway is null");
            return (Criteria) this;
        }

        public Criteria andContactwayIsNotNull() {
            addCriterion("contactway is not null");
            return (Criteria) this;
        }

        public Criteria andContactwayEqualTo(String value) {
            addCriterion("contactway =", value, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayNotEqualTo(String value) {
            addCriterion("contactway <>", value, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayGreaterThan(String value) {
            addCriterion("contactway >", value, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayGreaterThanOrEqualTo(String value) {
            addCriterion("contactway >=", value, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayLessThan(String value) {
            addCriterion("contactway <", value, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayLessThanOrEqualTo(String value) {
            addCriterion("contactway <=", value, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayLike(String value) {
            addCriterion("contactway like", value, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayNotLike(String value) {
            addCriterion("contactway not like", value, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayIn(List<String> values) {
            addCriterion("contactway in", values, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayNotIn(List<String> values) {
            addCriterion("contactway not in", values, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayBetween(String value1, String value2) {
            addCriterion("contactway between", value1, value2, "contactway");
            return (Criteria) this;
        }

        public Criteria andContactwayNotBetween(String value1, String value2) {
            addCriterion("contactway not between", value1, value2, "contactway");
            return (Criteria) this;
        }

        public Criteria andIscommentIsNull() {
            addCriterion("iscomment is null");
            return (Criteria) this;
        }

        public Criteria andIscommentIsNotNull() {
            addCriterion("iscomment is not null");
            return (Criteria) this;
        }

        public Criteria andIscommentEqualTo(String value) {
            addCriterion("iscomment =", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentNotEqualTo(String value) {
            addCriterion("iscomment <>", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentGreaterThan(String value) {
            addCriterion("iscomment >", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentGreaterThanOrEqualTo(String value) {
            addCriterion("iscomment >=", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentLessThan(String value) {
            addCriterion("iscomment <", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentLessThanOrEqualTo(String value) {
            addCriterion("iscomment <=", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentLike(String value) {
            addCriterion("iscomment like", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentNotLike(String value) {
            addCriterion("iscomment not like", value, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentIn(List<String> values) {
            addCriterion("iscomment in", values, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentNotIn(List<String> values) {
            addCriterion("iscomment not in", values, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentBetween(String value1, String value2) {
            addCriterion("iscomment between", value1, value2, "iscomment");
            return (Criteria) this;
        }

        public Criteria andIscommentNotBetween(String value1, String value2) {
            addCriterion("iscomment not between", value1, value2, "iscomment");
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